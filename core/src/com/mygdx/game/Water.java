/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Creates Water to use in a Fireboy and Watergirl game. The water kills the
 * Fireboy when he comes into contact with it.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Water extends Obstacle {

    /**
     * Initializes the Water as a subclass of Obstacle using it's x and y
     * coordinates, and it's width and height.
     *
     * @param x a float representing the x coordinate of the Water
     * @param y a float representing the y coordinate of the Water
     * @param width an integer representing the width of the Water
     * @param height an integer representing the height of the Water
     */
    public Water(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    /**
     * Draws a pool of blue Water on the screen using a ShapeRenderer.
     *
     * @param shapeBatch a ShapeRenderer to draw the Water with
     */
    @Override
    public void draw(ShapeRenderer shapeBatch) {
        shapeBatch.setColor(Color.CYAN);
        super.draw(shapeBatch);
    }
}
