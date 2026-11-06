package com.byZincn.fg26.s_system.functional_unit.logic;

import com.byZincn.fg26.s_system.functional_unit.reception.Button;
import com.byZincn.fg26.s_system.functional_unit.reception.ActualJudgeZone;
import com.byZincn.fg26.s_system.functional_unit.reception.JudgeZone;

public class JudgeZoneCalculator {

    // Calculate actual judge zone position
    public void calculate(
            Button button,
            double windowWidth,
            double windowHeight
    ) {
        if (button == null || button.judgeZone == null) {
            throw new IllegalArgumentException(
                    "Button or JudgeZone cannot be null."
            );
        }

        JudgeZone zone = button.judgeZone;

        if (button.actualJudgeZone == null) {
            button.actualJudgeZone = new ActualJudgeZone();
        }

        button.actualJudgeZone.x =
                button.relX * windowWidth + zone.offsetX;
        button.actualJudgeZone.y =
                button.relY * windowHeight + zone.offsetY;
        button.actualJudgeZone.width = zone.width;
        button.actualJudgeZone.height = zone.height;
    }
}