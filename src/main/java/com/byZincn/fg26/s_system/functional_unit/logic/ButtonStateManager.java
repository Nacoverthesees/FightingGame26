package com.byZincn.fg26.s_system.functional_unit.logic;

import com.byZincn.fg26.s_system.functional_unit.reception.Button;

import java.util.Map;

public class ButtonStateManager {

    public static Map<String, Button> buttons;

    public static void setButtons(Map<String, Button> buttons) {
        ButtonStateManager.buttons = buttons;

    }

    public static void update(){
        ButtonStateCalculator.calculate(buttons);

    }
    public static void shutdown(){
        buttons = null;
    }
}
