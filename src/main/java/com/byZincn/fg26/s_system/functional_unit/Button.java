package com.byZincn.fg26.s_system.functional_unit;

public class Button {

    // Identity
    public String id;

    // Geometry
    public double relX;
    public double relY;
    public double width;
    public double height;

    // Visibility and interaction
    public boolean visible = true;
    public boolean enabled = true;
    public boolean hovered = false;
    public boolean pressed = false;

    // Visual resources
    public String src;
    public String hoverSrc;
    public String pressedSrc;
    public String disabledSrc;

}