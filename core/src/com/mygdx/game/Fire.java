/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Creates Fire as a subclass of Obstacle to use in a game of Fireboy and
 * Watergirl. Allows for the creation of a pool of fire which will kill a
 * Watergirl.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Fire extends Obstacle {

    /**
     * Initializes a Fire using it's x and y coordinates on the screen, and it's
     * width and height.
     *
     * @param x a float representing the Fire's x coordinate on the screen
     * @param y a float representing the Fire's y coordinate on the screen
     * @param width an integer representing the width of the Fire
     * @param height an integer representing the height of the Fire
     */
    public Fire(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    /**
     * Draws the Fire on the screen using a ShapeRenderer.
     *
     * @param shapeBatch a ShapeRenderer to draw the Fire with
     */
    @Override
    public void draw(ShapeRenderer shapeBatch) {
        shapeBatch.setColor(Color.MAGENTA);
        super.draw(shapeBatch);
    }
}
