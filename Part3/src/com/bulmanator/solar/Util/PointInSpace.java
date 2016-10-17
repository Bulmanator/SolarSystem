package com.bulmanator.solar.Util;

public class PointInSpace {

	private double r;
	private double theta;

    public PointInSpace() { this(0, 0); }
    public PointInSpace(PointInSpace p) { this(p.getR(), p.getTheta()); }
    public PointInSpace(double r, double theta) {
        this.r = r;
        this.theta = theta;
    }

    public double getR() { return r; }
    public double getTheta() { return theta; }

    public void set(double r, double theta) {
        this.r = r;
        this.theta = theta;
    }

    public void rotate(double degrees) { theta += degrees; }

    public void setR(double r) { this.r = r; }
    public void setTheta(double theta) { this.theta = theta; }

    public static PointInSpace createFromCatesian(double x, double y) {
        double r = Math.sqrt((x * x) + (y * y));
        double theta = Math.atan(y / x);
        theta = Math.toDegrees(theta);

        return new PointInSpace(r, theta);
    }
}
