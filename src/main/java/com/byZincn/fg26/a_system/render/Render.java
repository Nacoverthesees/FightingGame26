package com.byZincn.fg26.a_system.render;

import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;

public class Render {

    //self initializing
    public static void init(){
        //init openGL
        GL.createCapabilities();
        //set clear up color
        glClearColor(1.0f, .01f, .01f, .01f);
    }

    //update each frame
    public static void update(){
        //clear color buffer and depth buffer
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BITS);

        //TODO: actural drawing happens here

        //upload things to window
        GL.createCapabilities();
    }
}
