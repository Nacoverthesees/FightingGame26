package com.byZincn.fg26.a_system.loaders.img_rel;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;

public class ImageLoader {

    //texture buffer
    private static final Map<String, Texture> textures =
            new HashMap<>();

    public record Texture(int id, int width, int height) {}

    //load picture
    public static Texture loadTexture(String path) {
        String resourcePath = normalizePath(path);

        Texture cached = textures.get(resourcePath);

        if (cached != null) {
            return cached;
        }

        byte[] fileBytes;


        try (InputStream input =
                     ImageLoader.class.getResourceAsStream(resourcePath)) {

            if (input == null) {
                throw new IllegalStateException(
                        "Cannot find image: " + resourcePath
                );
            }

            fileBytes = input.readAllBytes();

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Failed to read image: " + resourcePath, e
            );
        }

        ByteBuffer encoded = MemoryUtil.memAlloc(fileBytes.length);
        ByteBuffer pixels = null;
        int textureId = 0;
        boolean success = false;

        try {
            encoded.put(fileBytes).flip();

            int width;
            int height;

            try (MemoryStack stack = MemoryStack.stackPush()) {
                IntBuffer imageWidth = stack.mallocInt(1);
                IntBuffer imageHeight = stack.mallocInt(1);
                IntBuffer channels = stack.mallocInt(1);

                pixels = STBImage.stbi_load_from_memory(
                        encoded,
                        imageWidth,
                        imageHeight,
                        channels,
                        4
                );

                if (pixels == null) {
                    throw new IllegalStateException(
                            "Failed to decode image: " + resourcePath
                                    + ". Reason: "
                                    + STBImage.stbi_failure_reason()
                    );
                }

                width = imageWidth.get(0);
                height = imageHeight.get(0);
            }

            textureId = GL11.glGenTextures();

            GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureId);

            GL11.glTexParameteri(
                    GL11.GL_TEXTURE_2D,
                    GL11.GL_TEXTURE_MIN_FILTER,
                    GL11.GL_LINEAR
            );

            GL11.glTexParameteri(
                    GL11.GL_TEXTURE_2D,
                    GL11.GL_TEXTURE_MAG_FILTER,
                    GL11.GL_LINEAR
            );

            GL11.glTexParameteri(
                    GL11.GL_TEXTURE_2D,
                    GL11.GL_TEXTURE_WRAP_S,
                    GL12.GL_CLAMP_TO_EDGE
            );

            GL11.glTexParameteri(
                    GL11.GL_TEXTURE_2D,
                    GL11.GL_TEXTURE_WRAP_T,
                    GL12.GL_CLAMP_TO_EDGE
            );

            GL11.glTexImage2D(
                    GL11.GL_TEXTURE_2D,
                    0,
                    GL11.GL_RGBA8,
                    width,
                    height,
                    0,
                    GL11.GL_RGBA,
                    GL11.GL_UNSIGNED_BYTE,
                    pixels
            );

            Texture texture = new Texture(
                    textureId, width, height
            );

            textures.put(resourcePath, texture);
            success = true;

            return texture;

        }

        //clear temp resources
        finally {
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);

            if (pixels != null) {
                STBImage.stbi_image_free(pixels);
            }

            MemoryUtil.memFree(encoded);

            if (!success && textureId != 0) {
                GL11.glDeleteTextures(textureId);
            }
        }
    }

    //accessing loaded texture
    public static Texture getTexture(String path) {
        String resourcePath = normalizePath(path);
        Texture texture = textures.get(resourcePath);

        if (texture == null) {
            throw new IllegalStateException(
                    "Texture has not been loaded: " + resourcePath
            );
        }

        return texture;
    }

    //unifying paths
    private static String normalizePath(String path) {
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException(
                    "Image path cannot be null or blank."
            );
        }

        return path.startsWith("/") ? path : "/" + path;
    }

    //release all textures
    public static void cleanup() {
        for (Texture texture : textures.values()) {
            GL11.glDeleteTextures(texture.id());
        }

        textures.clear();
    }
}
