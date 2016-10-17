package com.bulmanator.solar;

import com.bulmanator.solar.Util.Renderer;

public class Main {
	
	public static void main(String[] args) {
        Renderer r = new Renderer();
        while(!r.isExiting()) {
            r.update();
            r.render();
        }
	}

}
