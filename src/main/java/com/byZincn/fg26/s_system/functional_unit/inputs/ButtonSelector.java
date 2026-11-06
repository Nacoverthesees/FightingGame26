package com.byZincn.fg26.s_system.functional_unit.inputs;

import com.byZincn.fg26.a_system.loaders.data_rel.ButtonDataLoader;
import com.byZincn.fg26.s_system.functional_unit.reception.Button;

import java.util.ArrayList;
import java.util.List;

public class ButtonSelector {

    public static List<Button> select(String... buttonIds){

        //create result list
        List<Button> selectedButtons = new ArrayList<>();
        //get full button data
        List<Button> allButtons = ButtonDataLoader.getButtons();

        //read target ID one by one
        for (String buttonId : buttonIds) {
            boolean found = false;

            //check full button data
            for (Button button : allButtons) {
                //if ID matches
                if (button.button_id.equals(buttonId)) {
                    selectedButtons.add(button);
                    found = true;
                    break;
                }
            }

            //not found exception
            if (!found) {
                throw new IllegalArgumentException(
                        "Button ID not found: " + buttonId
                );
            }
        }

        return selectedButtons;
    }
}