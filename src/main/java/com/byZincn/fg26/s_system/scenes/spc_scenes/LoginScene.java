package com.byZincn.fg26.s_system.scenes.spc_scenes;

import com.byZincn.fg26.m_system.functional_unit.Window;
import com.byZincn.fg26.s_system.functional_unit.inputs.ButtonSelector;
import com.byZincn.fg26.s_system.functional_unit.logic.JudgeZoneCalculator;
import com.byZincn.fg26.s_system.functional_unit.reception.Button;
import com.byZincn.fg26.s_system.scenes.Scene;

import java.util.List;

public class LoginScene implements Scene {

    private List<Button> buttons;

    private final JudgeZoneCalculator judgeZoneCalculator =
            new JudgeZoneCalculator();


    @Override
    public void init(){
        buttons = ButtonSelector.select(
                "start_game"
        );

        for (Button button : buttons){
            judgeZoneCalculator.calculate(
                    button,
                    Window.width,
                    Window.height
            );
        }
    }

    @Override
    public void maintain(){

    }

    @Override
    public void shutdown(){

    }
}
