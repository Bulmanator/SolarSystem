package com.bulmanator.solar.Util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Renderer {

    // The SolarSystem used for Rendering
	private SolarSystem system;

    // The angle at which Earth is drawn around the Sun
    private double angle;
    // The Speed at which Earth revolves around the Sun at
    private double speed;
    // Used to exit
    private boolean exiting;

    /**
     * Creates a new Renderer which draws Earth orbiting around the Sun
     */
    public Renderer() {
        system = new SolarSystem(1280, 720);
        system.setTitle("The Solar System - Part 1");

        angle = 0;
        speed = 5;

        exiting = false;
        system.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) { if(e.getKeyCode() == KeyEvent.VK_ESCAPE) dispose(); }
        });
    }

    /**
     * Updates the Earth rotating it by the speed around the Sun
     */
	public void update() {
        angle = angle + speed >= 360 ? 0 : angle + speed;
    }

    /**
     * Draws the Earth rotating around the Sun
     */
    public void render() {
        system.drawSolarObject(0, 0, 100, "YELLOW");
        system.drawSolarObjectAbout(100, angle, 10, "BLUE", 0, 0);

        system.finishedDrawing();
    }

    public boolean isExiting() { return exiting; }

    public void dispose() {
        exiting = true;
        system.dispose();
    }
}
