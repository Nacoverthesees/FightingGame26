package com.byZincn.fg26.s_system.functional_unit.inputs;

import com.byZincn.fg26.m_system.functional_unit.Window;
import com.byZincn.fg26.s_system.functional_unit.reception.ActualJudgeZone;
import com.byZincn.fg26.s_system.functional_unit.reception.Button;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import java.util.List;


public class MouseEveListener {
    //call back reference
    private static GLFWCursorPosCallback cursorPosCallback;
    private static GLFWMouseButtonCallback mouseButtonCallback;
    //mouse position
    public static double cursorX;
    public static double cursorY;
    //mouse button state
    public static boolean leftButtonDown;
    public static boolean leftButtonReleased;

    //current scene buttons
    private static List<Button> buttons;
    //current button
    public static String buttonID;
    //pressed button at mouse down
    public static String pressedButtonID;


    //accept data for button list
    public static void setButtons(List<Button> buttons) {
        MouseEveListener.buttons = buttons;
        updateButtonID();
    }

    public static void init(){

        //listen to mouse movement
        cursorPosCallback = GLFWCursorPosCallback.create(
                (window, xpos, ypos) -> {
                    cursorX = xpos;
                    cursorY = ypos;
                    updateButtonID();
                }
        );
        //register mouse movement call back
        GLFW.glfwSetCursorPosCallback(
                Window.window,
                cursorPosCallback
        );

        // Listen to mouse button events
        mouseButtonCallback = GLFWMouseButtonCallback.create(
                (window, button, action, mods) -> {
                    if (button == GLFW.GLFW_MOUSE_BUTTON_LEFT) {
                        if(action == GLFW.GLFW_PRESS){
                            updateButtonID();
                            leftButtonDown = true;
                            pressedButtonID = buttonID;
                        }
                        if (button == GLFW.GLFW_RELEASE){
                            updateButtonID();
                            leftButtonDown = false;
                            leftButtonReleased = true;
                        }
                        leftButtonDown = action == GLFW.GLFW_PRESS;
                    }
                }
        );
        //register mouse button call back
        GLFW.glfwSetMouseButtonCallback(
                Window.window,
                mouseButtonCallback
        );
    }

    private static void updateButtonID() {
        buttonID = null;

        //traverse button list
        for (Button button : buttons) {
            //button usability
            if (!button.visible || !button.enabled) {
                continue;
            }
            //get judge zone info
            ActualJudgeZone zone = button.actualJudgeZone;
            //existence of judge zome
            if (zone == null) {
                continue;
            }

            //estimate mouse locating in judge zone
            boolean inside =
                    cursorX >= zone.x &&
                            cursorX <= zone.x + zone.width &&
                            cursorY >= zone.y &&
                            cursorY <= zone.y + zone.height;

            if (inside) {
                buttonID = button.button_id;
                break;
            }
        }
    }

    public static void shutdown(){
        GLFW.glfwSetCursorPosCallback(Window.window, null);
        GLFW.glfwSetMouseButtonCallback(Window.window, null);

        cursorPosCallback.free();
        mouseButtonCallback.free();

        leftButtonDown = false;
        leftButtonReleased = false;
        pressedButtonID = null;
        buttonID = null;
    }
}
