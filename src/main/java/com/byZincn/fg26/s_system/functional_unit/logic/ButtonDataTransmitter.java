package com.byZincn.fg26.s_system.functional_unit.logic;


import com.byZincn.fg26.s_system.functional_unit.inputs.MouseEveListener;
import com.byZincn.fg26.s_system.functional_unit.reception.Button;

import java.util.List;

public class ButtonDataTransmitter {
    public static void transmit(List<Button> buttons) {
        MouseEveListener.setButtons(buttons);
        ButtonStateManager.setButtons(buttons);
    }
}
