package com.byZincn.fg26.m_system;

import com.byZincn.fg26.a_system.loaders.img_rel.ImageLoader;
import com.byZincn.fg26.a_system.renders.Render;
import com.byZincn.fg26.m_system.functional_unit.Window;

import com.byZincn.fg26.s_system.scenes.SceneManager;
import org.lwjgl.glfw.GLFW;

public class ShuttingDown {
    public static void stop(){
        SceneManager.shutdown();
        ImageLoader.cleanup();
        Render.cleanup();

        GLFW.glfwDestroyWindow(Window.window);
        GLFW.glfwTerminate();
    }
}
