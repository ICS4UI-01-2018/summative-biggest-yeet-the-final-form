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
 * help each other win the Levels.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Button extends Obstacle {

    private final MovingPlatform movingPlatform;
    private final float speed, maximumY, minimumY;

    /**
     * Initializes a Button to use in a game of Fireboy and Watergirl using it's
     * x and y position on the screen, and the Platform the Button controls.
     *
     * @param x a float representing the x coordinate of the Button
     * @param y a float representing the y coordinate of the Button
     * @param platform a Platform representing the Platform that the Button controls
     */
    public Button(float x, float y, MovingPlatform platform) {
        // initialize the x and y position, and the width and height of the Button
        super(x, y, 1, 0.5f);
        
        this.movingPlatform = platform;
        this.speed = 0.1f;
        
        // Button cannot move higher than this y position
        this.maximumY = y;
        
        // Button cannot move lower than this y position
        this.minimumY = y - super.height;
    }

    /**
     * Draws the Button on the screen using a ShapeRenderer.
     *
     * @param shapeBatch a ShapeRenderer used to draw the Button on the screen
     */
    @Override
    public void draw(ShapeRenderer shapeBatch) {
        // make the Buttons purple
        shapeBatch.setColor(Color.PURPLE);
        
        // draw the Button
        shapeBatch.rect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }

    /**
     * Allows for the Button to move down.
     */
    public void moveDown() {
         if (super.y > this.minimumY) {
            super.y -= this.speed;
        }
    }

    /**
     * Allows for the Button to move up.
     */
    public void moveUp() {
        if (super.y < this.maximumY) {
            super.y += this.speed;
        }
    }

    /**
     * Updates the position of the Button as it is moving up and down.
     */
    public void updatePositions() {
        super.obstacle.y = super.y;
    }

    /**
     * Returns the maximum y position that the Button can reach.
     *
     * @return a float representing the maximum y position that the Button can
     * reach
     */
    public float getMaximumY() {
        return this.maximumY;
    }

    /**
     * Returns the minimum y position that the Button can be.
     *
     * @return a float representing the minimum y position that the Button can
     * be
     */
    public float getMinimumY() {
        return this.minimumY;
    }
    
    public MovingPlatform getMovingPlatform() {
        return this.movingPlatform;
    }
}
