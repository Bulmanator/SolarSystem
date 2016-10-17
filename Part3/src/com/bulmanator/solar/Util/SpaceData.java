package com.bulmanator.solar.Util;

import com.bulmanator.solar.Space.SpaceBody;

/**
 * Container class for {@link SpaceBody} initialisation
 * Allows for cleaner constructions
 */
public class SpaceData {

    /** The Position of the {@link SpaceBody} in Polar form.<br>Default = (R: 0, Theta: 0) */
    public PointInSpace position = new PointInSpace();
    /** The Diameter of the {@link SpaceBody}.<br>Default = 5 */
    public double diameter = 5;
    /** The Rotational Speed of the {@link SpaceBody}.<br>Default = 0, Unused within Stars */
    public double speed = 0;

    /** The name of the {@link SpaceBody}.<br>Default = "" */
    public String name = "";
    /** The Colour of the {@link SpaceBody}.<br>Default = "WHITE" */
    public String colour = "WHITE";

}
