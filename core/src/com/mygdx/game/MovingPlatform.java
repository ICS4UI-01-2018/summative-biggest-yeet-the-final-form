/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

/**
 * Creates a MovingPlatform that can be used in a game of Fireboy and Watergirl
 * as an obstacle as a subclass of Platform. MovingPlatforms can be controlled
 * by Buttons within each Level to help the Fireboy and Watergirl complete the
 * Level. The MovingPlatforms can only move up.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class MovingPlatform extends Platform {

    private final float speed, maximumY, minimumY;
     boolean isMovingUp, isMovingDown, wasOnTop;

    /**
     * Initializes a MovingPlatform using its x and y position, its width, and
     * it's minimum y position.
     *
     * @param x a float representing the x position of the MovingPlatform
     * @param y a float representing the y position of the MovingPlatform
     * @param width a float representing the width of the MovingPlatform
     * @param height a float representing the height of the MovingPlatform
     * @param minimumY a float representing the minimum y position that the
     * MovingPlatform can be
     */
    public MovingPlatform(float x, float y, float width, float height, float minimumY) {
        super(x, y, width, height);

        this.maximumY = y * 16;
        this.minimumY = minimumY * 16;
        this.speed = 0.5f;
        this.isMovingUp = false;
        this.isMovingDown = false;
        this.wasOnTop = false;
    }

    /**
     * Moves the MovingPlatform down if it can.
     */
    public void moveDown() {
        if (super.y > this.minimumY) {
            super.y -= this.speed;
            this.isMovingDown = true;
            this.isMovingUp = false;
        }
    }

    /**
     * Moves the MovingPlatform up it it can.
     */
    public void moveUp() {
        if (super.y < this.maximumY) {
            super.y += this.speed;
            this.isMovingDown = false;
            this.isMovingUp = true;
        }
    }

    /**
     * Returns the maximum y position of the MovingPlatform.
     *
     * @return a float representing the maximum y position of the MovingPlatform
     */
    public float getMaximumY() {
        return this.maximumY;
    }

    /**
     * Returns the minimum y position of the MovingPlatform.
     *
     * @return a float representing the minimum y position of the MovingPlatform
     */
    public float getMinimumY() {
        return this.minimumY;
    }

    /**
     * Updates the y position of the MovingPlatform as it can move up and down.
     */
    public void updatePositions() {
        super.platform.y = super.y;
    }

    public boolean getIsMovingUp() {
        return this.isMovingUp;
    }

    public boolean getIsMovingDown() {
        return this.isMovingDown;
    }

    public void tieTo(Character c) {
   
            c.setY(super.getTop());
        
    }

    @Override
    public int onTop(Character c) {
        int counter = 0;
        if (c.getY() == this.getTop()) {
            //player is somewhere in the middle of the platform
            if ((c.getX() >= this.getX() && c.getFarX() <= this.getFarX())) {
                c.onGround = true;
                counter++;
            }//character is on edge of platform
            else if (c.getX() < this.getX() && c.getFarX() >= this.getX()) {
                c.onGround = true;
                counter++;
            } else if (c.getFarX() > this.getFarX() && c.getX() <= this.getFarX()) {
                c.onGround = true;
                counter++;
            }
        }

        return counter;
    }

}