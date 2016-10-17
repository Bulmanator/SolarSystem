package com.bulmanator.solar.Space;

import com.bulmanator.solar.Util.PointInSpace;
import com.bulmanator.solar.Util.SolarSystem;
import com.bulmanator.solar.Util.SpaceData;

public class Planet {

    private Star orbit;

    private PointInSpace position;
    private double diameter;
    private String name;
    private String colour;

    private double angle;
    private double speed;

    public Planet(SpaceData data, Star orbit) {
        this.name = data.name;
        position = new PointInSpace(data.position);
        position.set((orbit.getDiameter() / 2) + position.getR(), position.getTheta());
        this.diameter = data.diameter;
        this.colour = data.colour;

        this.speed = data.speed;

        this.orbit = orbit;
    }

    public void move() { position.rotate(speed); }
    public void render(SolarSystem s) {
        s.drawSolarObjectAbout(position.getR(), position.getTheta(),
                diameter, colour, orbit.getPosition().getR(), orbit.getPosition().getTheta());
    }

    public PointInSpace getPosition() { return position; }
    public double getDiameter() { return diameter; }
    public String getColour() { return colour; }
    public String getName() { return name; }
    public double getAngle() { return angle; }

    public void setPosition(double r, double theta) {
        position.setR(r);
        position.setTheta(theta);
    }
    public void setAngle(double angle) { this.angle = angle; }
    public void setDiameter(double diameter) { this.diameter = diameter; }
    public void setColour(String colour) { this.colour = colour; }
}
