/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

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
    private static final boolean UP = true;
    private static final boolean DOWN = false;

    /**
     * Initializes a MovingPlatform using its x and y position, its width, and
     * it's minimum y position.
     *
     * @param b a boolean representing whether if the MovingPlatform will move
     * up or down
     * @param x a float representing the x position of the MovingPlatform
     * @param y a float representing the y position of the MovingPlatform
     * @param width a float representing the width of the MovingPlatform
     * @param height a float representing the height of the MovingPlatform
     * @param movingY a float representing the maximum/minimum y position that
     * the MovingPlatform will be when it moves
     */
    public MovingPlatform(boolean b, float x, float y, float width, float height, float movingY) {
        super(x, y, width, height);

        this.speed = 0.5f;
        this.isMovingUp = false;
        this.isMovingDown = false;
        this.wasOnTop = false;

        // set the minimum and maximum y variables based on whether if the MovingPlatform will move up or down
        if (!b) {
            this.maximumY = y * 16;
            this.minimumY = movingY * 16;
        } else {
            this.maximumY = movingY * 16;
            this.minimumY = y * 16;
        }
    }

    /**
     * Moves the MovingPlatform down if it can.
     */
    public void moveDown() {
        // determine if the MovingPlatform can move down
        if (super.getY() > this.minimumY) {
            // move the MovingPlatform down
            super.setY(super.getY() - this.speed);
            this.isMovingDown = true;
            this.isMovingUp = false;
        } else {
            this.isMovingDown = false;
        }
    }

    /**
     * Moves the MovingPlatform up it it can.
     */
    public void moveUp() {
        // determine if the MovingPlatform can move up
        if (super.getY() < this.maximumY) {
            // move the MovingPlatform up
            super.setY(super.getY() + this.speed);
            this.isMovingDown = false;
            this.isMovingUp = true;
        } else {
            this.isMovingUp = false;
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
        super.setPlatformY(super.getY());
    }

    /**
     * Returns whether if the MovingPlatform is moving up or not.
     *
     * @return a boolean representing whether if the MovingPlatform is moving up
     * or not
     */
    public boolean getIsMovingUp() {
        return this.isMovingUp;
    }

    /**
     * Returns whether if the MovingPlatform is moving down or not.
     *
     * @return a boolean representing whether if the MovingPlatform is moving
     * down or not
     */
    public boolean getIsMovingDown() {
        return this.isMovingDown;
    }

    public void tieTo(Character character) {
        if (this.wasOnTop) {
          //  character.setY(super.getTop());
          //  character.canJump = true;
        }
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

    /**
     * Draws a MovingPlatform using a ShapeRenderer.
     *
     * @param shapeBatch a ShapeRenderer used to draw the MovingPlatform
     */
    public void draw(ShapeRenderer shapeBatch) {
        // set the MovingPlatforms to be purple
        shapeBatch.setColor(Color.PURPLE);

        // draw the MovingPlatform
        shapeBatch.rect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
}
