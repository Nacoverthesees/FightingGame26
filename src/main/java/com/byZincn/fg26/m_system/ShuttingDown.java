package com.byZincn.fg26.m_system;

import com.byZincn.fg26.a_system.loaders.img_rel.ImageLoader;
import com.byZincn.fg26.m_system.functional_unit.Window;

import org.lwjgl.glfw.GLFW;

public class ShuttingDown {
    public static void stop(){
        ImageLoader.cleanup();
        GLFW.glfwDestroyWindow(Window.window);
        GLFW.glfwTerminate();
    }
}
