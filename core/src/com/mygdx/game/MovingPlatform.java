/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

/**
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class MovingPlatform extends Platform {

    private float speed, maximumY, minimumY;

    public MovingPlatform(float x, float y, float width, float minimumY) {
        super(x, y, width, 0.5f);

        this.maximumY = y;
        this.minimumY = minimumY;
        this.speed = 0.5f;
    }

    /**
     * Moves the Platform downwards.
     */
    public void moveDown() {
        super.y = super.y - this.speed;
    }

    /**
     * Moves the Platform upwards.
     */
    public void moveUp() {
        super.y = super.y + this.speed;
    }

    /**
     * Returns the maximum y position of the MovingPlatform.
     *
     * @return a float representing the maximum y position of the MovingPlatform
     */
    public float getMaximumY() {
        return maximumY;
    }

    /**
     * Returns the minimum y position of the MovingPlatform.
     *
     * @return a float representing the minimum y position of the MovingPlatform
     */
    public float getMinimumY() {
        return minimumY;
    }
}
