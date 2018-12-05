/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

/**
 *
 * @author emily
 */
public class WaterDoor extends Door {

    /**
     * Create a Door using an x and y position, that only lets Watergirls pass
     * through.
     *
     * @param x a float representing the x position of the WaterDoor
     * @param y a float representing the y position of the WaterDoor
     */
    public WaterDoor(float x, float y) {
        super(x, y);
    }

    /**
     * Determines whether the Watergirl is standing in front of the Waterdoor.
     *
     * @param watergirl a Watergirl which represents the Watergirl on the screen
     * @return a boolean representing whether the Watergirl is in front of the
     * WaterDoor
     */
    public boolean collision(Watergirl watergirl) {
        // check if the Watergirl is standing in front of the WaterDoor
        return super.door.overlaps(watergirl.getBounds());   
    }
}
