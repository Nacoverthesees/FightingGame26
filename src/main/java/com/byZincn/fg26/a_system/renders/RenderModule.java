package com.byZincn.fg26.a_system.renders;

public interface RenderModule {
    // Initialize this rendering module
    void init();

    // Draw this frame
    void render();

    // Release this module's resources, if necessary
    void cleanup();
}
