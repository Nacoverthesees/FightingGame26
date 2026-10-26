package com.byZincn.fg26.s_system.functional_unit.reception;

public class Button {

    // Identity
    public String button_id;

    // Geometry
    public double relX;
    public double relY;
    public double width;
    public double height;

    // Visual resources
    public String src;
    public String hoverSrc;
    public String pressedSrc;
    public String disabledSrc;

    // Visibility and interaction
    public boolean visible = true;
    public boolean enabled = true;
    public boolean hovered = false;
    public boolean pressed = false;

}