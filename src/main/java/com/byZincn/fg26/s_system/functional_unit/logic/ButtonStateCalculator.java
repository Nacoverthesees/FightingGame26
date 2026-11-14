package com.byZincn.fg26.s_system.functional_unit.logic;

import com.byZincn.fg26.s_system.functional_unit.inputs.MouseEveListener;
import com.byZincn.fg26.s_system.functional_unit.reception.Button;

import java.util.Map;

public class ButtonStateCalculator {
    public static void calculate(Map<String, Button> buttons) {
        // Clear instantaneous trigger state
        for (Button button : buttons.values()) {
            button.trigger = false;
        }
        // Update hovered state
        for (Button button : buttons.values()) {
            button.hovered = MouseEveListener.hoveredEvent
                    && button.button_id.equals(MouseEveListener.hoveredID);
        }
        // Handle mouse press
        if (MouseEveListener.leftButtonPressedEvent) {

            Button button = buttons.get(MouseEveListener.pressedButtonID);

            if (button != null) {
                button.pressed = true;
            }

            MouseEveListener.leftButtonPressedEvent = false;
        }
        // Handle mouse release
        if (MouseEveListener.leftButtonReleasedEvent) {

            Button pressedButton = buttons.get(MouseEveListener.pressedButtonID);

            if (pressedButton != null) {
                pressedButton.pressed = false;
            }

            if (MouseEveListener.pressedButtonID != null
                    && MouseEveListener.pressedButtonID.equals(MouseEveListener.releasedButtonID)) {

                Button releasedButton = buttons.get(MouseEveListener.releasedButtonID);

                if (releasedButton != null) {
                    releasedButton.trigger = true;
                }
            }

            MouseEveListener.leftButtonReleasedEvent = false;
        }
    }
}
