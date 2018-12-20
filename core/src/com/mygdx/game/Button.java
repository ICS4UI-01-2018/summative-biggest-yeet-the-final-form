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

    private float speed, starting, ending, maximumY, minimumY;
;
    private Platform controlledPlatform;

    /**
     * Initializes a Button to use in a game of Fireboy and Watergirl using it's
     * x and y position on the screen.
     *
     * @param x a float representing the x coordinate of the Button
     * @param y a float representing the y coordinate of the Button
     * @param p the platform the button controls
     */
    public Button(float x, float y, Platform p) {
        super(x, y, 1, 0.5f);
        this.controlledPlatform = p;
       this.speed = 0.1f;
        // Button cannot move higher than this y position
        this.maximumY = y;
        // Button cannot move lower than this y position
        this.minimumY = y - super.height;
    }

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
        super.y += this.speed;
    }

    /**
     * Allows for the Button to move up.
     */
    public void moveUp() {
        super.y -= this.speed;
    }
    /**
     * Moves platform down
     * @param ending the ending pos. of the platform
     */
    public void movePlatformDown(float ending){
       if (this.controlledPlatform.getY() > ending){
        this.y = this.y - this.speed;
    }
    }
    
     public void movePlatformUp(float starting){
       if (this.controlledPlatform.getY() < starting- this.controlledPlatform.getWidth() ){
        this.y = this.y + this.speed;
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
    
    
}
