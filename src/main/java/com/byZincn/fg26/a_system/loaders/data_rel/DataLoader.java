package com.byZincn.fg26.a_system.loaders.data_rel;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

public class DataLoader {

    private static final Gson GSON = new Gson();

    // Parse JSON into the requested Java type
    public static <T> T load(String path, Type type) {
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException(
                    "Resource path cannot be null or blank."
            );
        }

        if (!path.startsWith("/")) {
            path = "/" + path;
        }

        try (InputStream input =
                     DataLoader.class.getResourceAsStream(path)) {

            if (input == null) {
                throw new IllegalStateException(
                        "Cannot find resource: " + path
                );
            }

            try (InputStreamReader reader =
                         new InputStreamReader(
                                 input, StandardCharsets.UTF_8
                         )) {

                return GSON.fromJson(reader, type);
            }

        }
        catch (IOException e) {
            throw new IllegalStateException(
                    "Failed to load resource: " + path, e
            );
        }
    }
}