package com.bulmanator.solar.Space;

import com.bulmanator.solar.Util.SolarSystem;
import com.bulmanator.solar.Util.SpaceData;

public class Moon extends SpaceBody {

    private Planet orbit;
    private double speed;

    public Moon(SpaceData data, Planet orbit) {
        super(data);
        this.orbit = orbit;
        position.set(position.getR() + orbit.getDiameter() / 2, position.getTheta());

        speed = data.speed;
    }

    @Override
    public void render(SolarSystem s) {

    }

    public Type getType() { return Type.MOON; }
}
