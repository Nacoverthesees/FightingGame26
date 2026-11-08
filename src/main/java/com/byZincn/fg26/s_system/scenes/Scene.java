package com.byZincn.fg26.s_system.scenes;

import com.byZincn.fg26.s_system.functional_unit.reception.Button;

import java.util.List;

public interface Scene {
    //init necessary elements
    void init();
    //access button list
    List<Button> getButtons();
    //keep updating the scene
    void maintain();
    //close scene
    void shutdown();
}
