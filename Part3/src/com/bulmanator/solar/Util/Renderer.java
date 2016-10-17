package com.bulmanator.solar.Util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Vector;

public class Renderer {

    public static final Random random = new Random();

	private SolarSystem system;

    private boolean exiting;

	public Renderer() {
		system = new SolarSystem(1280, 720);
        system.setTitle("The Solar System - Part 3");

        exiting = false;
        system.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) { if(e.getKeyCode() == KeyEvent.VK_ESCAPE) dispose(); }
        });

        generatePlanets();
    }

	public void update() { /* TODO */ }
    public void render() { /* TODO */ }

    private void generatePlanets() {
        SpaceData data = new SpaceData();

        // Sun
        data.name = "Sun";
        data.colour = "YELLOW";
        data.diameter = 100;
        data.position.set(0, 0);

        int planetNo = 1;
        double transVal = 10;

        // Mercury
        data.name = "Mercury";
        data.colour = "ORANGE";
        data.position.set(10, 0);
        data.diameter = 2.06;
        data.speed = 10.09;

        // Venus
        data.name = "Venus";
        data.colour = "GREEN";
        data.position.set(13.59 + (transVal * planetNo++), 0);
        data.diameter = 5.11;
        data.speed = 7.45;

        // Earth
        data.name = "Earth";
        data.colour = "BLUE";
        data.position.set(18.83 + (transVal * planetNo++), 0);
        data.diameter = 5.38;
        data.speed = 6.34;

        // Earth's Moon
        data.name = "Moon";
        data.colour = "WHITE";
        data.position.set(2, 0);
        data.diameter = 1;
        data.speed = 13.06;

        // Mars
        data.name = "Mars";
        data.colour = "RED";
        data.position.set(22.96 + (transVal * planetNo++), 0);
        data.diameter = 2.87;
        data.speed = 5.13;

        // Jupiter
        data.name = "Jupiter";
        data.colour = "ORANGE";
        data.position.set(54.56 + (transVal * planetNo++), 0);
        data.diameter = 60.33;
        data.speed = 2.79;

        // Europa
        data.name = "Eurpoa";
        data.colour = "WHITE";
        data.position.set(7, 0);
        data.diameter = 3;
        data.speed = 2.92;

        // Io
        data.name = "Io";
        data.colour = "YELLOW";
        data.position.set(15, 0);
        data.diameter = 3.6;
        data.speed = 3.68;

        // Saturn
        data.name = "Saturn";
        data.colour = "YELLOW";
        data.position.set(110.15 + (transVal * planetNo++), 0);
        data.diameter = 50.86;
        data.speed = 2.06;

        // Titan
        data.name = "Titan";
        data.colour = "WHITE";
        data.position.set(8, 0);
        data.diameter = 4.2;
        data.speed = 1.5;

        // Uranus
        data.name = "Uranus";
        data.colour = "BLUE";
        data.position.set(146.37 + (transVal * planetNo++), 0);
        data.diameter = 21.57;
        data.speed = 1.45;

        // Neptune
        data.name = "Neptune";
        data.colour = "CYAN";
        data.position.set(167.6 + (transVal * planetNo++), 0);
        data.diameter = 20.90;
        data.speed = 1.15;

        // Pluto
        data.name = "Pluto";
        data.colour = "GRAY";
        data.position.set(178.55 + (transVal * planetNo), 0);
        data.diameter = 1;
        data.speed = 1;
    }


    public boolean isExiting() { return exiting; }
    public void dispose() {
        exiting = true;
        system.dispose();
    }
}
