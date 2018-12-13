/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Creates a Button as a subclass of Obstacle to use in a game of Fireboy and
 * Watergirl. The Fireboy and Watergirl can push the button to move Platforms to
 * help each other win the level.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Button extends Obstacle {

    Platform p;
    float startHeight;
    float endHeight;

    /**
     * Initializes a Button to use in a game of Fireboy and Watergirl using it's
     * x and y position on the screen.
     *
     * @param x a float representing the x coordinate of the Button
     * @param y a float representing the y coordinate of the Button
     * @param p the platform the button controls
     * @param startHeight the height the platform will return to
     * @param endHeight the lowest height the platform can go
     */
    public Button(float x, float y, Platform p, float startHeight, float endHeight) {
        super(x, y, 16, 8);
        this.p = p;
        this.startHeight = startHeight;
        this.endHeight = endHeight;
    }

    /**
     * Returns the platform associated with button
     *
     * @return
     */
    public Platform getPlatform() {
        return this.p;
    }

    /**
     * Returns starting height of platform
     *
     * @return starting height of platform
     */
    public float getStartingHeight() {
        return this.startHeight;
    }

    /**
     * Returns ending height of platform
     *
     * @return ending height of platform
     */
    public float getEndingHeight() {
        return this.endHeight;
    }

    @Override
    public void draw(ShapeRenderer shapeBatch) {
        // make the Buttons purple
        shapeBatch.setColor(Color.PURPLE);
        // draw the Button
        shapeBatch.rect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
}
