package com.bulmanator.solar.Util;

import com.bulmanator.solar.Space.Moon;
import com.bulmanator.solar.Space.Planet;
import com.bulmanator.solar.Space.SpaceBody;
import com.bulmanator.solar.Space.Star;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Base64;
import java.util.Random;
import java.util.Vector;

public class Renderer {

	private SolarSystem system;
    private Vector<SpaceBody> spaceBodies;

    private boolean exiting;

	public Renderer() {
		system = new SolarSystem(1280, 800);
        system.setTitle("The Solar System - Part 3");

        exiting = false;
        system.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) { if(e.getKeyCode() == KeyEvent.VK_ESCAPE) dispose(); }
        });

        spaceBodies = new Vector<>();
        generatePlanets();
    }

	public void update() { spaceBodies.forEach(SpaceBody::move); }
    public void render() {
        for(SpaceBody b : spaceBodies) { b.render(system); }
        system.finishedDrawing();
    }

    private void generatePlanets() {
        SpaceData data = new SpaceData();
        Planet current;
        Star sun;

        // Sun
        data.name = "Sun";
        data.colour = "YELLOW";
        data.diameter = 100;
        data.position.set(0, 0);
        spaceBodies.add(sun = new Star(data));

        int planetNo = 1;
        double transVal = 25;

        // Mercury
        data.name = "Mercury";
        data.colour = "ORANGE";
        data.position.set(10, 0);
        data.diameter = 5;
        data.speed = 10.09;
        spaceBodies.add(new Planet(data, sun));

        // Venus
        data.name = "Venus";
        data.colour = "GREEN";
        data.position.set(13.59 + (transVal * planetNo++), 0);
        data.diameter = 10;
        data.speed = 7.45;
        spaceBodies.add(new Planet(data, sun));

        // Earth
        data.name = "Earth";
        data.colour = "BLUE";
        data.position.set(18.83 + (transVal * planetNo++), 0);
        data.diameter = 10;
        data.speed = 6.34;
        spaceBodies.add(current = new Planet(data, sun));

        // Earth's Moon
        data.name = "Moon";
        data.colour = "WHITE";
        data.position.set(2, 0);
        data.diameter = 3;
        data.speed = 13.06;
        spaceBodies.add(new Moon(data, current));

        // Mars
        data.name = "Mars";
        data.colour = "RED";
        data.position.set(22.96 + (transVal * planetNo++), 0);
        data.diameter = 5.5;
        data.speed = 5.13;
        spaceBodies.add(current = new Planet(data, sun));

        // Phobos
        data.name = "Phobos";
        data.colour = "WHITE";
        data.position.set(10, 0);
        data.diameter = 3;
        data.speed = 12;
        spaceBodies.add(new Moon(data, current));

        // Deimos
        data.name = "Deimos";
        data.colour = "WHITE";
        data.position.set(4, 0);
        data.diameter = 3;
        data.speed = 8;
        spaceBodies.add(new Moon(data, current));

        generateAsteroids(sun);

        // Jupiter
        data.name = "Jupiter";
        data.colour = "ORANGE";
        data.position.set(140.56 + (transVal * planetNo++), 0);
        data.diameter = 60.33;
        data.speed = 2.79;
        spaceBodies.add(current = new Planet(data, sun));

        // Europa
        data.name = "Europa";
        data.colour = "WHITE";
        data.position.set(7, 0);
        data.diameter = 3;
        data.speed = 2.92;
        spaceBodies.add(new Moon(data, current));

        // Io
        data.name = "Io";
        data.colour = "YELLOW";
        data.position.set(15, 0);
        data.diameter = 3.6;
        data.speed = 3.68;
        spaceBodies.add(new Moon(data, current));

        // Generating the rest of Jupiter's Moons (67 in total)
        for(int i = 0; i < 65; i++) {
            data.name = Base64.getEncoder().encodeToString(("Jupiter Moon " + i).getBytes());
            data.colour = i > 15 ? i > 45 ? "YELLOW" : "WHITE" : "GREEN";
            data.position.set((Math.random() * 16), (Math.random() * 361));
            data.diameter = 1 + (Math.random() * 5);
            data.speed = 0.5 + (Math.random() * ((4 - 0.5) + 1));
            spaceBodies.add(new Moon(data, current));
        }


        System.out.println("No of Objects: " + spaceBodies.size());
    }

    private void generateAsteroids(Star s) {
        SpaceData data = new SpaceData();
        double minDist = 120;
        double maxDist = 180;

        for(int i = 0; i < 200; i++) {
            data.name = Base64.getEncoder().encodeToString(("Asteroid " + i).getBytes());
            data.colour = i > 100 ? "YELLOW" : "WHITE";
            data.diameter = 1 + (Math.random() * 5);
            data.position.set(minDist + (Math.random() * (maxDist - minDist)), Math.random() * 360);
            data.speed = 0.5 + (Math.random() * ((5 - 0.5) + 1));

            spaceBodies.add(new Planet(data, s));
        }
    }

    public boolean isExiting() { return exiting; }
    public void dispose() {
        exiting = true;
        system.dispose();
    }
}
