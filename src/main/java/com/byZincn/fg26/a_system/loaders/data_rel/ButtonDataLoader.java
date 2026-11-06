package com.byZincn.fg26.a_system.loaders.data_rel;

import com.byZincn.fg26.s_system.functional_unit.reception.Button;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ButtonDataLoader {

    private static final String BUTTONS_PATH =
            "/constants/Buttons.json";

    private static List<Button> buttons;

    // Load button configuration
    public static void load() {
        Type type = new TypeToken<List<Button>>() {}.getType();

        buttons = DataLoader.load(BUTTONS_PATH, type);

        if (buttons == null) {
            throw new IllegalStateException(
                    "Invalid button data: " + BUTTONS_PATH
            );
        }
    }

    // Access loaded button configuration
    public static List<Button> getButtons() {
        if (buttons == null) {
            throw new IllegalStateException(
                    "ButtonDataLoader has not been initialized."
            );
        }
        return buttons;
    }
}