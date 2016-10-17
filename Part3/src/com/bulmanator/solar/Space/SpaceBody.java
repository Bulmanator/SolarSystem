package com.bulmanator.solar.Space;

import com.bulmanator.solar.Util.PointInSpace;
import com.bulmanator.solar.Util.SolarSystem;
import com.bulmanator.solar.Util.SpaceData;

public abstract class SpaceBody {

    public enum Type {
        STAR, PLANET, MOON;
    }

    protected String name;

    protected PointInSpace position;
    protected double diameter;

    protected String colour;

    public SpaceBody(SpaceData data) {
        name = data.name;
        position = new PointInSpace(data.position);
        diameter = data.diameter;
        colour = data.colour;
    }

    public abstract void render(SolarSystem s);

    public abstract Type getType();
    public String getName() { return name; }

    public PointInSpace getPosition() { return position; }
    public double getDiameter() { return diameter; }

    public String getColour() { return colour; }
}
