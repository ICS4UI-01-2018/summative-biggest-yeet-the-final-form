/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Creates a Gem to use in a game of Fireboy and Watergirl.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public abstract class Gem {

    private final float x, y;
    private final int width, height;
    private boolean collected;
    private final Rectangle gem;
    private final Texture texture;

    /**
     * Initializes a Gem using its Texture, and its x and y position.
     *
     * @param texture a Texture representing the Gem
     * @param x a float representing the x coordinate of the Gem
     * @param y a float representing the y coordinate of the Gem
     */
    public Gem(Texture texture, float x, float y) {
        this.x = x * 16;
        this.y = y * 16;
        this.width = 16;
        this.height = 16;
        this.collected = false;
        this.texture = texture;
        this.gem = new Rectangle(this.x, this.y, this.width, this.height);
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
     * Used to draw the Gems on the screen if they haven't been collected by
     * their corresponding Characters yet.
     *
     * @param batch a SpriteBatch used to draw the Gems on the screen if they
     * haven't been collected yet
     */
    public void draw(SpriteBatch batch) {
        // determine if the Gem has been collected by their corresponding Character yet
        if (!this.collected) {
            batch.draw(this.texture, this.x, this.y, this.width, this.height);
        }
    }

    /**
     * Sets the Gem to be collected, or not collected based on the specified
     * boolean.
     *
     * @param collected a boolean representing whether the Gem has been
     * collected or not
     */
    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    /**
     * Returns the Texture of the Gem.
     *
     * @return a Texture representing the Gem
     */
    public Texture getTexture() {
        return this.texture;
    }

    /**
     * Returns the Rectangle representing the Gem.
     *
     * @return a Rectangle representing the Gem
     */
    public Rectangle getBounds() {
        return this.gem;
    }
}
