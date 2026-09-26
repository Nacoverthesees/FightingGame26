package com.byZincn.fg26.m_system;

import com.byZincn.fg26.m_system.functional_unit.Window;

import org.lwjgl.glfw.GLFW;

public class ShuttingDown {
    public static void stop(){
        GLFW.glfwDestroyWindow(Window.window);
        GLFW.glfwTerminate();
    }
}
