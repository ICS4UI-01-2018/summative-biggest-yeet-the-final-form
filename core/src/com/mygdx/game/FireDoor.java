/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

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
        super(x, y);
    }

    /**
     * Determines whether the Fireboy is standing in front of the FireDoor.
     *
     * @param fireboy the Fireboy in the game
     * @return a boolean representing whether if the Fireboy is standing in
     * front of the Firedoor
     */
    public boolean collision(Fireboy fireboy) {
        return super.door.overlaps(fireboy.getBounds());
    }

    /**
     * Draws the FireDoor using a ShapeRenderer.
     *
     * @param shapeBatch a ShapeRenderer used to draw the FireDoor
     */
    @Override
    public void draw(ShapeRenderer shapeBatch) {
        // set the FireDoor to be magenta
        shapeBatch.setColor(Color.MAGENTA);

        // draw the FireDoor
        shapeBatch.rect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
}
