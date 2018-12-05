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
public class FireDoor extends Door {

    /**
     * Creates a FireDoor using the x and y position, which only lets Fireboys
     * pass through.
     *
     * @param x a float representing the x position of the FireDoor
     * @param y a float representing the y position of the FireDoor
     */
    public FireDoor(float x, float y) {
        super(x, y);
    }

    /**
     * Determines whether 
     * @param fireboy
     * @return 
     */
    public boolean collision(Fireboy fireboy) {
        // check if the Fireboy collides with the FireDoor
        if (super.door.overlaps(fireboy.getBounds())) {
            return true;
        } else {
            return false;
        }
    }
}
