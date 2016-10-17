package com.bulmanator.solar.Space;

import com.bulmanator.solar.Util.SolarSystem;
import com.bulmanator.solar.Util.SpaceData;

public class Star extends SpaceBody {

    public Star(SpaceData data) {
        super(data);
    }

    @Override
    public void render(SolarSystem s) {
        s.drawSolarObject(position.getR(), position.getTheta(), diameter, colour);
    }

    @Override
    public Type getType() { return Type.STAR; }
}
