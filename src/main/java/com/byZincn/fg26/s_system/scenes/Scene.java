package com.byZincn.fg26.s_system.scenes;

public interface Scene {
    //init necessary elements
    void init();
    //keep updating the scene
    void maintain();
    //close scene
    void shutdown();
}
