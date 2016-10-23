package com.bulmanator.solar.Util;

import com.bulmanator.solar.Space.Moon;
import com.bulmanator.solar.Space.Planet;
import com.bulmanator.solar.Space.Star;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Vector;

public class Renderer {

    public static final Random random = new Random();

	private SolarSystem system;
    private Star sun;
    private Vector<Planet> planets;
    private Vector<Moon> moons;

    private boolean exiting;

	public Renderer() {
		system = new SolarSystem(1280, 720);
        system.setTitle("The Solar System - Part 2");

        exiting = false;
        system.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) { if(e.getKeyCode() == KeyEvent.VK_ESCAPE) dispose(); }
        });

        planets = new Vector<>();
        moons = new Vector<>();
        generatePlanets();
    }

	public void update() {
        for(Planet p : planets) { p.move(); }
        for(Moon m : moons) { m.move(); }
    }
    public void render() {
        sun.render(system);
        for(Planet p : planets) { p.render(system); }
        for(Moon m : moons) { m.render(system); }

        system.finishedDrawing();
    }

    private void generatePlanets() {
        SpaceData data = new SpaceData();
        Planet current;

        // Sun
        data.name = "Sun";
        data.colour = "YELLOW";
        data.diameter = 100;
        data.position.set(0, 0);
        sun = new Star(data);

        int planetNo = 1;
        double transVal = 25;

        // Mercury
        data.name = "Mercury";
        data.colour = "ORANGE";
        data.position.set(10, 0);
        data.diameter = 6.5;
        data.speed = 10.09;
        planets.add(new Planet(data, sun));

        // Venus
        data.name = "Venus";
        data.colour = "GREEN";
        data.position.set(13.59 + (transVal * planetNo++), 0);
        data.diameter = 10;
        data.speed = 7.45;
        planets.add(new Planet(data, sun));

        // Earth

        data.name = "Earth";
        data.colour = "BLUE";
        data.position.set(18.83 + (transVal * planetNo++), 0);
        data.diameter = 10;
        data.speed = 6.34;
        planets.add(current = new Planet(data, sun));

        // The Moon
        data.name = "Moon";
        data.colour = "WHITE";
        data.position.set(2, 0);
        data.diameter = 3;
        data.speed = 13.06;
        moons.add(new Moon(data, current));

        // Mars
        data.name = "Mars";
        data.colour = "RED";
        data.position.set(22.96 + (transVal * planetNo++), 0);
        data.diameter = 7;
        data.speed = 5.13;
        planets.add(current = new Planet(data, sun));

        // Phobos
        data.name = "Phobos";
        data.colour = "RED";
        data.position.set(10, 0);
        data.diameter = 3;
        data.speed = 12;
        moons.add(new Moon(data, current));

        // Deimos
        data.name = "Deimos";
        data.colour = "WHITE";
        data.position.set(4, 0);
        data.diameter = 3;
        data.speed = 8;
        moons.add(new Moon(data, current));

      /*  // Jupiter
        Planet jupiter;

        data.name = "Jupiter";
        data.colour = "ORANGE";
        data.position.set(54.56 + (transVal * planetNo++), 0);
        data.diameter = 60.33;
        data.speed = 2.79;
        planets.add(jupiter = new Planet(data, sun));

        // Europa
        data.name = "Eurpoa";
        data.colour = "WHITE";
        data.position.set(7, 0);
        data.diameter = 3;
        data.speed = 2.92;
        moons.add(new Moon(data, jupiter));

        // Io
        data.name = "Io";
        data.colour = "YELLOW";
        data.position.set(15, 0);
        data.diameter = 3.6;
        data.speed = 3.68;
        moons.add(new Moon(data, jupiter));

        // Saturn
        Planet saturn;

        data.name = "Saturn";
        data.colour = "YELLOW";
        data.position.set(110.15 + (transVal * planetNo++), 0);
        data.diameter = 50.86;
        data.speed = 2.06;
        planets.add(saturn = new Planet(data, sun));

        // Titan
        data.name = "Titan";
        data.colour = "WHITE";
        data.position.set(8, 0);
        data.diameter = 4.2;
        data.speed = 1.5;
        moons.add(new Moon(data, saturn));

        // Uranus
        data.name = "Uranus";
        data.colour = "BLUE";
        data.position.set(146.37 + (transVal * planetNo++), 0);
        data.diameter = 21.57;
        data.speed = 1.45;
        planets.add(new Planet(data, sun));

        // Neptune
        data.name = "Neptune";
        data.colour = "CYAN";
        data.position.set(167.6 + (transVal * planetNo++), 0);
        data.diameter = 20.90;
        data.speed = 1.15;
        planets.add(new Planet(data, sun));

        // Pluto
        data.name = "Pluto";
        data.colour = "GRAY";
        data.position.set(178.55 + (transVal * planetNo), 0);
        data.diameter = 1;
        data.speed = 1;
        planets.add(new Planet(data, sun));*/
    }

    public boolean isExiting() { return exiting; }
    private void dispose() {
        exiting = true;
        system.dispose();
    }
}
