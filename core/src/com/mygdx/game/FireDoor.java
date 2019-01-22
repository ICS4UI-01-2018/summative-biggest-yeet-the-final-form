/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * Creates a FireDoor as a subclass of Door to use in the Fireboy and Watergirl
 * game.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
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
        super(new Texture("FireDoor.jpg"), x, y);
    }

    /**
     * Determines whether the Fireboy is standing in front of the FireDoor.
     *
     * @param fireboy the Fireboy in the game
     * @return a boolean representing whether if the Fireboy is standing in
     * front of the FireDoor
     */
    public boolean collision(Fireboy fireboy) {
        return super.getBounds().overlaps(fireboy.getBounds());
    }
}
