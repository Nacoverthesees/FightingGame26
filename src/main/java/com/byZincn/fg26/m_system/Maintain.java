package com.byZincn.fg26.m_system;

import com.byZincn.fg26.a_system.renders.Render;
import com.byZincn.fg26.m_system.functional_unit.Window;
import com.byZincn.fg26.m_system.functional_unit.Clock;


import org.lwjgl.glfw.GLFW;

public class Maintain {
    public static void run() {
        while (!GLFW.glfwWindowShouldClose(Window.window)) {

            //dispose with window events
            GLFW.glfwPollEvents();

            //update clock
            Clock.time = GLFW.glfwGetTime();

            //update render
            Render.update();
        }
    }
}
