package com.byZincn.fg26.s_system.functional_unit.logic;

import com.byZincn.fg26.s_system.functional_unit.reception.Button;

import java.util.List;
import java.util.Map;

public class ButtonStateManager {

    public static Map<String, Button> buttons;

    public static void setButtons(Map<String, Button> buttons) {
        ButtonStateManager.buttons = buttons;
    }

    public static void init(){

    }
    public static void maintain(){

    }
    public static void shutdown(){

    }
}
