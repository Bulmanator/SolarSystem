package com.bulmanator.solar.Space;

import com.bulmanator.solar.Util.PointInSpace;
import com.bulmanator.solar.Util.SolarSystem;
import com.bulmanator.solar.Util.SpaceData;

public class Star {

	private String name;

	private PointInSpace position;
	private double diameter;

	private String colour;
	
	public Star(SpaceData data) {
		this.name = data.name;

		position = new PointInSpace(data.position);
		this.diameter = data.diameter;

		this.colour = data.colour;
	}

	public void render(SolarSystem s) {
		s.drawSolarObject(position.getR(), position.getTheta(), diameter, colour);
	}

	// ** Getters **

    public String getName() { return name; }

	public PointInSpace getPosition() { return position; }
	public double getDiameter() { return diameter; }

	public String getColour() { return colour; }

    // ** Setters **

	public void setPosition(double r, double theta) { position.set(r, theta); }
	public void setDiameter(double diameter) { this.diameter = diameter; }

    public void setColour(String colour) { this.colour = colour; }
}
