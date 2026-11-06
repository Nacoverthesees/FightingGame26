package com.byZincn.fg26.m_system;

import com.byZincn.fg26.m_system.functional_unit.Window;
import com.byZincn.fg26.a_system.renders.Render;
import com.byZincn.fg26.s_system.scenes.SceneManager;
import com.byZincn.fg26.s_system.scenes.spc_scenes.LoginScene;

import org.lwjgl.glfw.GLFW;


public class StartingUp {
    public static void start(){

        //initialize GLFW
        if(!GLFW.glfwInit()){
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        //create window
        Window.create();

        //bind openGL context with current thread
        GLFW.glfwMakeContextCurrent(Window.window);

        //activate VSync
        GLFW.glfwSwapInterval(1);

        //init render
        Render.init();

        //init login scene through scene manager
        SceneManager.start(new LoginScene());
    }
}
