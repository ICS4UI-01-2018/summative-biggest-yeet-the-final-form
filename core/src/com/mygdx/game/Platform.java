/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Platform {

    //Creates a Rectangle that can be used to create platforms
    private Rectangle platform;
    //Create integers for the platform to function
    private int height;
    private int width;
    private float x;
    private float y;

    /**
     * Creates a platform using the x, y, width, and height
     *
     * @param x an integer representing the x-coordinate of the platform
     * @param y an integer representing the y-coordinate of the platform
     * @param width an integer representing the width of the platform
     * @param height an integer representing the height of the platform
     */
    public Platform(float x, float y, int width, int height) {
        this.platform = new Rectangle(x, y, width, height);
    }

    /**
     * Gets the x-coordinate of the Platform
     *
     * @return a float representing the x-coordinate of the Platform
     */
    public float getX() {
        return this.x;
    }

    /**
     * Returns the y-coordinate of the Platform
     *
     * @return a float representing the y-coordinate of the Platform
     */
    public float getY() {
        return this.y;
    }

    /**
     * Determines whether if the Character is on the Platform
     *
     * @param character a Character in the game
     * @return a boolean representing whether if the Character is on the
     * Platform
     */
    public boolean collision(Character character) {
        while (character.getY() + character.getHeight() == this.y) {
            character.switchFalling();
        }
        return true;
    }

    /**
     * Draws the Platform on the screen
     *
     * @param shapeBatch a ShapeRenderer that will draw the Platform on the screenF
     */
    public void draw(ShapeRenderer shapeBatch) {
        shapeBatch.rect(platform.x, platform.y, platform.width, platform.height);
    }
}
