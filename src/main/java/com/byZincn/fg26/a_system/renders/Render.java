package com.byZincn.fg26.a_system.renders;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;

import java.util.List;

import com.byZincn.fg26.m_system.functional_unit.Window;


public class Render {
    //create a list managed by Render
    private static final List<RenderModule> modules =
            List.of(
                    new ButtonRender()
            );

    //self initializing
    public static void init(){
        //init openGL
        GL.createCapabilities();
        //set clear up color
        glClearColor(1.0f, .01f, .01f, .01f);
        //traverse the list, run init() to each
        for (RenderModule module : modules) {
            module.init();
        }
    }

    //update each frame
    public static void update(){
        //clear color buffer and depth buffer
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BITS);
        //traverse the list, run render() to each
        for (RenderModule module : modules) {
            module.render();
        }
        //upload things to window
        GLFW.glfwSwapBuffers(Window.window);
    }

    // Release rendering resources
    public static void cleanup() {
        for (int i = modules.size() - 1; i >= 0; i--) {
            modules.get(i).cleanup();
        }
    }
}
