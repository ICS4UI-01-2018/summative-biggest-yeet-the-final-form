/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public abstract class Obstacle {

    Rectangle obstacle;
    private int width;
    private int height;
    private float x;
    private float y;

    /**
     * Initializes an Obstacle using it's width and height, and it's x and y
     * coordinates on the screen.
     *
     * @param width width of the obstacle
     * @param height height of the obstacle
     * @param x the x position of the obstacle
     * @param y the y position of the obstacle
     */
    public Obstacle(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.obstacle = new Rectangle(this.x, this.y, this.width, this.height);
    }

    /**
     * check if obstacle overlaps with a character
     *
     * @param c the character
     * @return if the character is touching the obstacle
     */
    public boolean Collision(Character c) {
        return obstacle.overlaps(c.getBounds());
    }

    /**
     * checks x coordinate
     *
     * @return the x coordinate of the obstacle
     */
    public float getX() {
        return obstacle.x;
    }

    /**
     * checks y coordinate
     *
     * @return the y coordinate of the obstacle
     */
    public float getY() {
        return obstacle.y;
    }

    /**
     * checks where the obstacle is
     *
     * @return the obstacle
     */
    public Rectangle getBounds() {
        return obstacle;
    }
    
    /**
     * allows the obstacles to be drawn
     * @param shapeBatch draws the obstacles 
     */
    public void draw(ShapeRenderer shapeBatch) {
        shapeBatch.rect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
    }

}
