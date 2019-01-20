/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
        super(new Texture("Fire.jpg"), x, y, width, height);
    }
    
    /**
     * Draws the Fire on the screen using a SpriteBatch.
     *
     * @param batch a SpriteBatch used to draw the Fire on the screen
     */
    @Override
    public void draw(SpriteBatch batch) {
        // determine how many times you have to copy the Texture
        float copy = super.getWidth() / 16;
        // a variable used to determine where to place each Texture
        float textureX = super.getX();

        // determine if you can draw the whole Texture
        while (copy - 1 >= 0) {
            // draw the Texture
            batch.draw(super.getTexture(), textureX, super.getY(), 16, 16);
            copy -= 1;
            // determine where to place the Texture next
            textureX += 16;
        }
    }
}
