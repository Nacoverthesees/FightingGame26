package com.byZincn.fg26.s_system.scenes;

import com.byZincn.fg26.s_system.functional_unit.logic.ButtonMelTransmitter;

public class SceneManager {

    //define current scene
    public static Scene currentScene;

    //start a scene
    public static void start(Scene scene) {
        CrossSceneFunctions.init();

        currentScene = scene;
        currentScene.init();

        ButtonMelTransmitter.transmit(currentScene.getButtons());
    }

    //operate switch scene
    public static void switchScene(Scene scene) {
        if (currentScene != null) {
            currentScene.shutdown();
        }

        currentScene = scene;
        currentScene.init();

        ButtonMelTransmitter.transmit(currentScene.getButtons());
    }

    //maintain functions
    public static void maintain() {
        CrossSceneFunctions.maintain();

        if (currentScene != null) {
            currentScene.maintain();
        }
    }

    //shut down functions
    public static void shutdown() {
        if (currentScene != null) {
            currentScene.shutdown();
        }

        CrossSceneFunctions.shutdown();
    }
}