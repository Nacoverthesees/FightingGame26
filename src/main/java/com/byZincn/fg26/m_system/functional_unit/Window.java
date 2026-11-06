package com.byZincn.fg26.m_system.functional_unit;

import org.lwjgl.glfw.GLFW;

public class Window {
    public static long window;
    public static int width;
    public static int height;

    public static void create(){

        width = 1280;
        height = 720;

        Window.window = GLFW.glfwCreateWindow(
                width,
                height,
                "FG26",
                0,
                0
        );
        if (Window.window == 0) {
            GLFW.glfwTerminate();
            throw new IllegalStateException("Unable to create window");
        }
    }
}
