/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 * Creates a Gem to use in a game of Fireboy and Watergirl.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public abstract class Gem {

    private float x, y;
    private int width, height;
    private boolean collected;
    Rectangle gem;

    /**
     * Initializes a Gem using the x and y coordinates of it on the screen.
     *
     * @param x a float representing the x coordinate of the Gem
     * @param y a float representing the y coordinate of the Gem
     */
    public Gem(float x, float y) {
        this.x = x;
        this.y = y;
        this.width = 16;
        this.height = 16;
        this.collected = false;
        this.gem = new Rectangle(x, y, this.width, this.height);
    }

    /**
     * Returns the x coordinate of the Gem.
     *
     * @return a float representing the Gem's x position on the screen
     */
    public float getX() {
        return this.x;
    }

    /**
     * Returns the y coordinate of the Gem.
     *
     * @return a float representing the Gem's y position on the screen
     */
    public float getY() {
        return this.y;
    }

    /**
     * Returns the width of the Gem.
     *
     * @return a float representing the width of the Gem.
     */
    public float getWidth() {
        return this.width;
    }

    /**
     * Returns the height of the Gem.
     *
     * @return a float representing the height of the Gem.
     */
    public float getHeight() {
        return this.height;
    }

    /**
     * Returns whether if the Gem has been collected yet.
     *
     * @return a boolean representing whether if the Gem has been collected yet
     */
    public boolean isCollected() {
        return this.collected;
    }

    /**
     * Draws the Gem on the screen.
     *
     * @param shapeBatch a ShapeRenderer that will draw the Gem on the screen
     */
    public void draw(ShapeRenderer shapeBatch) {
        shapeBatch.rect(gem.x, gem.y, gem.width, gem.height);
    }
}
