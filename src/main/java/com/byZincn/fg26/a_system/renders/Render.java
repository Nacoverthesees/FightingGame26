package com.byZincn.fg26.a_system.renders;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;

import com.byZincn.fg26.m_system.functional_unit.Window;

public class Render {

    //self initializing
    public static void init(){
        //init openGL
        GL.createCapabilities();
        //set clear up color
        glClearColor(.01f, .01f, .01f, .01f);
        //init specific renders
        RenderScheduler.init();
    }

    //update each frame
    public static void update(){
        //clear color buffer and depth buffer
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        //update specific renders
        RenderScheduler.render();
        //upload things to window
        GLFW.glfwSwapBuffers(Window.window);
    }

    //cleaning up
    public static void cleanup() {
        RenderScheduler.cleanup();
    }
}
