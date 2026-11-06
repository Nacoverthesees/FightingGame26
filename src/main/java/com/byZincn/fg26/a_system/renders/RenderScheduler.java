package com.byZincn.fg26.a_system.renders;

import com.byZincn.fg26.a_system.renders.spc_renders.ButtonRender;

import java.util.List;

public class RenderScheduler {

    //create a list managed by Render
    private static final List<RenderModule> modules =
            List.of(
                    new ButtonRender()
            );

    //traverse the list, run init() to each
    public static void init(){
        for (RenderModule module : modules) {
            module.init();
        }
    }

    //traverse the list, run render() to each
    public static void render(){
        for (RenderModule module : modules) {
            module.render();
        }
    }

    // Release rendering resources
    public static void cleanup(){
        for (int i = modules.size() - 1; i >= 0; i--) {
            modules.get(i).cleanup();
        }
    }
}
