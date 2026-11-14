package com.byZincn.fg26.s_system.functional_unit.data_control;


import com.byZincn.fg26.s_system.functional_unit.inputs.MouseEveListener;
import com.byZincn.fg26.s_system.functional_unit.logic.ButtonStateManager;
import com.byZincn.fg26.s_system.functional_unit.reception.Button;

import java.util.List;
import java.util.Map;

public class ButtonDataTransmitter {
    public static void transmit(List<Button> buttons) {

        Map<String, Button> buttonMap =
                ButtonMapConverter.convert(buttons);

        MouseEveListener.setButtons(buttons);
        ButtonStateManager.setButtons(buttonMap);
    }
}
