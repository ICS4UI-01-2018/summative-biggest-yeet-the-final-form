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

    /**
     * Initializes a MovingPlatform using its x and y position, its width, and
     * it's minimum y position.
     *
     * @param x a float representing the x position of the MovingPlatform
     * @param y a float representing the y position of the MovingPlatform
     * @param width a float representing the width of the MovingPlatform
     * @param minimumY a float representing the minimum y position that the
     * MovingPlatform can be
     */
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
        super.setY(super.getY() - this.speed);
    }

    /**
     * Moves the Platform upwards.
     */
    public void moveUp() {
        super.setY(super.getY() + this.speed);
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
    
    public void whereIsPlayer (Character c){
        super.whereIsPlayer(c);
    }
}
