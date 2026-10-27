package com.byZincn.fg26.m_system;

import com.byZincn.fg26.a_system.loaders.data_rel.ButtonDataLoader;
import com.byZincn.fg26.a_system.preloaders.ButtonPreloader;
import com.byZincn.fg26.m_system.functional_unit.Window;
import com.byZincn.fg26.a_system.renders.Render;

import org.lwjgl.glfw.GLFW;


public class StartingUp {
    public static void start(){

        //initialize GLFW
        if(!GLFW.glfwInit()){
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        //create window
        Window.window = GLFW.glfwCreateWindow(
                1280,
                720,
                "FG26",
                0,
                0
        );
        if (Window.window == 0) {
            GLFW.glfwTerminate();
            throw new IllegalStateException("Unable to create window");
        }

        //bind openGL context with current thread
        GLFW.glfwMakeContextCurrent(Window.window);

        //activate VSync
        GLFW.glfwSwapInterval(1);

        //init render
        Render.init();

        //TODO:temp data loader
        ButtonDataLoader.init();

        //TODO: temp preloader
        ButtonPreloader.preload();

        //TODO: start LoginScene
    }
}
