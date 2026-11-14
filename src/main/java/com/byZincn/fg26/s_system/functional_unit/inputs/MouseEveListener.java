package com.byZincn.fg26.s_system.functional_unit.inputs;

import com.byZincn.fg26.m_system.functional_unit.Window;
import com.byZincn.fg26.s_system.functional_unit.reception.ActualJudgeZone;
import com.byZincn.fg26.s_system.functional_unit.reception.Button;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import java.util.List;

public class MouseEveListener {
    // current scene buttons
    private static List<Button> buttons;
    // callback references
    private static GLFWCursorPosCallback cursorPosCallback;
    private static GLFWMouseButtonCallback mouseButtonCallback;
    //event record
    public static boolean leftButtonPressedEvent;
    public static boolean leftButtonReleasedEvent;
    public static boolean hoveredEvent;
    // mouse position
    public static double cursorX;
    public static double cursorY;
    // mouse button state
    public static boolean leftButtonDown = false;
    public static boolean leftButtonUp = true;
    // button IDs
    public static String hoveredID;
    public static String pressedButtonID;
    public static String releasedButtonID;

    //accept data for button list
    public static void setButtons(List<Button> buttons) {
        MouseEveListener.buttons = buttons;
    }

    public static void start() {
        //listen to mouse movement
        cursorPosCallback = GLFWCursorPosCallback.create(
                (window, xpos, ypos) -> {
                    cursorX = xpos;
                    cursorY = ypos;

                    updateHoveredID();
                }
        );
        //actual movement call back
        GLFW.glfwSetCursorPosCallback(
                Window.window,
                cursorPosCallback
        );

        // listen to mouse button events
        mouseButtonCallback = GLFWMouseButtonCallback.create(
                (window, button, action, mods) -> {

                    if (button != GLFW.GLFW_MOUSE_BUTTON_LEFT) {
                        return;
                    }
                    if (action == GLFW.GLFW_PRESS) {
                        updateHoveredID();
                        leftButtonDown = true;
                        leftButtonUp = false;
                        pressedButtonID = hoveredID;
                        leftButtonPressedEvent = true;
                    }
                    if (action == GLFW.GLFW_RELEASE) {
                        updateHoveredID();
                        leftButtonDown = false;
                        leftButtonUp = true;
                        releasedButtonID = hoveredID;
                        leftButtonReleasedEvent = true;
                    }
                }
        );
        //actual button call back
        GLFW.glfwSetMouseButtonCallback(
                Window.window,
                mouseButtonCallback
        );
    }

    public static void updateHoveredID(){
        hoveredID = null;
        hoveredEvent = false;

        // traverse button list
        for (Button button : buttons) {
            // button usability
            if (!button.visible || !button.enabled) {
                continue;
            }
            // get judge zone info
            ActualJudgeZone zone = button.actualJudgeZone;
            // check whether mouse is inside judge zone
            boolean inside =
                    cursorX >= zone.x &&
                            cursorX <= zone.x + zone.width &&
                            cursorY >= zone.y &&
                            cursorY <= zone.y + zone.height;
            if (inside) {
                hoveredID = button.button_id;
                hoveredEvent = true;
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
        leftButtonUp = true;
        pressedButtonID = null;
        releasedButtonID = null;
        leftButtonPressedEvent = false;
        leftButtonReleasedEvent = false;
        hoveredEvent = false;
        hoveredID = null;
    }
}