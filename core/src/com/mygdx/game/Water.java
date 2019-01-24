/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Creates Water to use in a Fireboy and Watergirl game. The water kills the
 * Fireboy when he comes into contact with it.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Water extends Obstacle {

    /**
     * Initializes the Water using its Texture, its x and y positions, and its
     * width and height.
     *
     * @param x a float representing the x position of the Water
     * @param y a float representing the y position of the Water
     * @param width a float representing the width of the Water
     * @param height a float representing the height of the Water
     */
    public Water(float x, float y, float width, float height) {
        super(new Texture("Water.jpg"), x, y, width, height);
    }

    /**
     * Draws the Water on the screen using a SpriteBatch.
     *
     * @param batch a SpriteBatch used to draw the Water on the screen
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

            // determine where to place the Texture next
            textureX += 16;

            copy -= 1;
        }
    }
}
