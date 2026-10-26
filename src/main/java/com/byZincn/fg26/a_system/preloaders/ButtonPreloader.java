package com.byZincn.fg26.a_system.preloaders;

import com.byZincn.fg26.a_system.loaders.data_rel.ButtonDataLoader;
import com.byZincn.fg26.a_system.loaders.img_rel.ImageLoader;
import com.byZincn.fg26.s_system.functional_unit.reception.Button;

public class ButtonPreloader {

    public static void preload() {
        //transverse button list
        for (Button button : ButtonDataLoader.getButtons()) {
            //load images
            loadIfPresent(button.src);
            loadIfPresent(button.hoverSrc);
            loadIfPresent(button.pressedSrc);
            loadIfPresent(button.disabledSrc);
        }
    }

    //skipping empty roots
    private static void loadIfPresent(String path) {
        if (path != null && !path.isBlank()) {
            ImageLoader.loadTexture(path);
        }
    }
}
