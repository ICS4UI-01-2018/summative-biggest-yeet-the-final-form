/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * Creates a WaterDoor as a subclass of Door in a game of Fireboy and Watergirl.
 * The WaterDoor allows the Watergirl access to get to the next level.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
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
        super(new Texture("WaterDoor.jpg"), x, y);
    }

    /**
     * Determines whether if the Watergirl is standing in front of the
     * Waterdoor.
     *
     * @param watergirl a Character representing the Watergirl
     * @return a boolean representing whether the Watergirl is in front of the
     * WaterDoor or not
     */
    public boolean collision(Watergirl watergirl) {
        return super.getBounds().overlaps(watergirl.getBounds());
    }
}
