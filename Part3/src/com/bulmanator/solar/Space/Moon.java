package com.bulmanator.solar.Space;

import com.bulmanator.solar.Util.SolarSystem;
import com.bulmanator.solar.Util.SpaceData;

public class Moon extends SpaceBody {

    /** The Space Body which this Moon orbits around. */
    private SpaceBody orbit;
    /** The Speed at which this Moon orbits. */
    private double speed;

    public Moon(SpaceData data, Planet orbit) {
        super(data);
        this.orbit = orbit;
        position.set(position.getR() + orbit.getDiameter() / 2, position.getTheta());

        speed = data.speed;
    }

    @Override
    public void move() { position.rotate(speed); }

    @Override
    public void render(SolarSystem s) {
        s.drawSolarObjectAbout(position.getR(), position.getTheta(),
                diameter, colour, orbit.getPosition().getR(), orbit.getPosition().getTheta());
    }

    public Type getType() { return Type.MOON; }
}
