/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Creates Mud as a subclass of Obstacle to use in a game of Fireboy and
 * Watergirl. The Mud kills both the Fireboy and Watergirl.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Mud extends Obstacle {

    /**
     * Initializes Mud as a subclass of Obstacle using the Mud's x and y
     * coordinates, and it's width and height.
     *
     * @param x a float representing the x coordinate of the Mud
     * @param y a float representing the y coordinate of the Mud
     * @param width an integer representing the width of the Mud
     * @param height an integer representing the height of the Mud
     */
    public Mud(float x, float y, int width, int height) {
        super(new Texture("Mud.jpg"), x, y, width, height);
    }

    /**
     * Draws the Mud on the screen using a SpriteBatch.
     *
     * @param batch a SpriteBatch used to draw the Mud on the screen
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
