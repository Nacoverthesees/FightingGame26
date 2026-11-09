package com.byZincn.fg26.s_system.scenes;

import com.byZincn.fg26.a_system.loaders.data_rel.ButtonDataLoader;
import com.byZincn.fg26.a_system.preloaders.ButtonPreloader;
import com.byZincn.fg26.s_system.functional_unit.inputs.MouseEveListener;
import com.byZincn.fg26.s_system.functional_unit.logic.ButtonStateManager;

//TODO: temp structure

public class CrossSceneFunctions {
    public static void init(){
        ButtonDataLoader.load();
        ButtonPreloader.preload();
        MouseEveListener.start();
        ButtonStateManager.init();
    }

    public static void maintain(){
        ButtonStateManager.maintain();
    }

    public static void shutdown(){
        MouseEveListener.shutdown();
        ButtonStateManager.shutdown();
    }
}
