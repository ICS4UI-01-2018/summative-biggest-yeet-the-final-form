/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Creates a Watergirl as a subclass of Character to use in a game of Fireboy
 * and Watergirl.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Watergirl extends Character {

    /**
     * Creates a Watergirl using it's x and y position on the screen.
     *
     * @param x a float representing the Watergirl's x position on the screen
     * @param y a float representing the Watergirl's y position on the screen
     */
    public Watergirl(int x, int y) {
        super(x, y);
    }

    /**
     * Draws a blue rectangle on the screen using a ShapeRenderer to represent a
     * Watergirl.
     *
     * @param shapeBatch a ShapeRenderer used to draw the Watergirl with
     */
    @Override
    public void draw(ShapeRenderer shapeBatch) {
        // set the Watergirl to be blue
        shapeBatch.setColor(Color.BLUE);
        super.draw(shapeBatch);
    }
}
