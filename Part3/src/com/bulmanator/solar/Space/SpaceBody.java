package com.bulmanator.solar.Space;

import com.bulmanator.solar.Util.PointInSpace;
import com.bulmanator.solar.Util.SolarSystem;
import com.bulmanator.solar.Util.SpaceData;

/**
 * The base class of an object within Space (Star, Planet or Moon)
 * This entire coursework piece really didn't need inheritance?
 */
public abstract class SpaceBody {

    /** An enumeration which contains the possible types of a {@link SpaceBody} */
    public enum Type { STAR, PLANET, MOON }

    /** The name of the Space Body */
    protected String name;
    /** The position of the Space Body in polar form */
    protected PointInSpace position;
    /** The diameter of the Space Body */
    protected double diameter;
    /** The Colour (in string format) of the Space Body */
    protected String colour;

    /**
     * This constructs a new Space Body with the data provided
     * @param data The base data to create the Space Body <br>
     *             Contains name, position, diameter, colour and speed if needed.
     *
     * @see SpaceData
     */
    public SpaceBody(SpaceData data) {
        name = data.name;
        position = new PointInSpace(data.position);
        diameter = data.diameter;
        colour = data.colour;
    }

    /** Rotates the Space Body around its orbit */
    public void move() {}

    /**
     * Draws the Space Body on the screen
     * @param s The {@link SolarSystem} used for drawing
     */
    public abstract void render(SolarSystem s);

    /**
     * Gets the {@link Type} of the Space Body
     * @return One of three: {@link Type#STAR}, {@link Type#PLANET}, {@link Type#MOON}
     */
    public abstract Type getType();

    /**
     * Gets the name of the Space Body
     * @return The name
     */
    public String getName() { return name; }

    /**
     * Gets the position of the Space Body
     * @return The position, in polar form
     */
    public PointInSpace getPosition() { return position; }

    /**
     * Gets the diameter of the Space Body
     * @return The diameter
     */
    public double getDiameter() { return diameter; }

    /**
     * Gets the Colour of the Space Body
     * @return The name of the Colour
     */
    public String getColour() { return colour; }
}
