/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Obstacle {

    private Rectangle obstacle;
    private int width;
    private int height;
    private float x;
    private float y;

    /**
     * initialize obstacle data
     * @param width width of the obstacle
     * @param height height of the obstacle
     * @param x the x position of the obstacle
     * @param y the y position of the obstacle
     */
    public Obstacle(int width, int height, float x, float y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    /**
     * check if obstacle overlaps with a character
     * @param c the character
     * @return if the character is touching the obstacle
     */
    public boolean Collision(Character c) {
        return obstacle.overlaps(c.getBounds());
    }

    /**
     * checks x coordinate
     * @return the x coordinate of the obstacle
     */
    public float getX() {
        return obstacle.x;
    }

    /**
     * checks y coordinate
     * @return the y coordinate of the obstacle
     */
    public float getY() {
        return obstacle.y;
    }

    /**
     * checks where the obstacle is
     * @return the obstacle
     */
    public Rectangle getBounds() {
        return obstacle;
    }

}
