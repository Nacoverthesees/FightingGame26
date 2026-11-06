package com.byZincn.fg26.s_system.scenes;

import com.byZincn.fg26.a_system.loaders.data_rel.ButtonDataLoader;
import com.byZincn.fg26.a_system.preloaders.ButtonPreloader;
import com.byZincn.fg26.s_system.functional_unit.inputs.MouseEveListener;

//TODO: temp structure

public class CrossSceneFunctions {
    public static void init(){
        ButtonDataLoader.load();
        ButtonPreloader.preload();
        MouseEveListener.init();

    }

    public static void maintain(){
    }

    public static void shutdown(){

    }
}
