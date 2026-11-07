package com.byZincn.fg26.s_system.functional_unit.inputs;

import com.byZincn.fg26.m_system.functional_unit.Window;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;


public class MouseEveListener {
    //call back reference
    private static GLFWCursorPosCallback cursorPosCallback;
    private static GLFWMouseButtonCallback mouseButtonCallback;
    //mouse position
    public static double cursorX;
    public static double cursorY;
    //mouse button state
    public static boolean leftButtonDown;

    public static void init(){

        //listen to mouse movement
        cursorPosCallback = GLFWCursorPosCallback.create(
                (window, xpos, ypos) -> {
                    cursorX = xpos;
                    cursorY = ypos;
                }
        );
        GLFW.glfwSetCursorPosCallback(
                Window.window,
                cursorPosCallback
        );

        // Listen to mouse button events
        mouseButtonCallback = GLFWMouseButtonCallback.create(
                (window, button, action, mods) -> {
                    if (button == GLFW.GLFW_MOUSE_BUTTON_LEFT) {
                        leftButtonDown = action == GLFW.GLFW_PRESS;
                    }
                }
        );

        GLFW.glfwSetMouseButtonCallback(
                Window.window,
                mouseButtonCallback
        );
    }

    public static void shutdown(){
        GLFW.glfwSetCursorPosCallback(Window.window, null);
        GLFW.glfwSetMouseButtonCallback(Window.window, null);

        cursorPosCallback.free();
        mouseButtonCallback.free();

    }
}
