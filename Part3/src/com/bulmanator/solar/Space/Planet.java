package com.bulmanator.solar.Space;

import com.bulmanator.solar.Util.SolarSystem;
import com.bulmanator.solar.Util.SpaceData;

public class Planet extends SpaceBody {

    private Star orbit;
    private double speed;

    public Planet(SpaceData data, Star orbit) {
        super(data);
        this.orbit = orbit;
        position.set(position.getR() + orbit.getDiameter() / 2, position.getTheta());

        speed = data.speed;
    }

    @Override
    public void render(SolarSystem s) {
        s.drawSolarObjectAbout(position.getR(), position.getTheta(), diameter,
                colour, orbit.getPosition().getR(), orbit.getPosition().getTheta());
    }

    @Override
    public Type getType() { return Type.PLANET; }

    public Star getOrbit() { return orbit; }
}
