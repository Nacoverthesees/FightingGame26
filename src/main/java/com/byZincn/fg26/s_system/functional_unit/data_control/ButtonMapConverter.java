package com.byZincn.fg26.s_system.functional_unit.data_control;

import com.byZincn.fg26.s_system.functional_unit.reception.Button;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ButtonMapConverter {
    public static Map<String, Button> convert(List<Button> buttons){
        Map<String, Button> buttonMap = new HashMap<>();

        for (Button button : buttons) {
            if (buttonMap.put(button.button_id, button) != null) {
                throw new IllegalStateException(
                        "Duplicate button ID: " + button.button_id
                );
            }
        }

        return buttonMap;
    }
}
