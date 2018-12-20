/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 * Creates an Obstacle to use in a game of Fireboy and Watergirl.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public abstract class Obstacle {

    Rectangle obstacle;
    float height;
    private float width;
    float x, y;

    /**
     * Initializes an Obstacle using it's width and height, and it's x and y
     * coordinates on the screen.
     *
     * @param x a float representing the x position of the Obstacle
     * @param y a float representing the y position of the Obstacle
     * @param width an integer representing the width of the Obstacle
     * @param height an integer representing the height of the Obstacle
     */
    public Obstacle(float x, float y, float width, float height) {
        this.x = x * 16;
        this.y = y * 16;
        this.width = width * 16;
        this.height = height * 16;

        this.obstacle = new Rectangle(this.x, this.y, this.width, this.height);
    }

    /**
     * Returns whether or not the Obstacle collides with a Character.
     *
     * @param character a Character that's being played in a game of Fireboy and
     * Watergirl
     * @return a boolean representing whether the Obstacle has collided with a
     * Character
     */
    public boolean collidesWith(Character character) {
        return this.obstacle.overlaps(character.getBounds());
    }

    /**
     * Returns the x coordinate of the Obstacle.
     *
     * @return a float representing the x coordinate of an Obstacle
     */
    public float getX() {
        return this.x;
    }

    /**
     * Returns the y coordinate of the Obstacle.
     *
     * @return a float representing the y coordinate of an Obstacle
     */
    public float getY() {
        return this.y;
    }

    /**
     * Returns the Rectangle that represents the Obstacle.
     *
     * @return a Rectangle that represents the Obstacle
     */
    public Rectangle getBounds() {
        return obstacle;
    }
    

    /**
     * Draws the Obstacle on the screen.
     *
     * @param shapeBatch a ShapeRenderer which draws the Obstacle on the screen
     */
    public void draw(ShapeRenderer shapeBatch) {
        shapeBatch.rect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
    }

    /**
     * Returns the width of the Obstacle.
     *
     * @return an integer representing the width of the Obstacle
     */
    public float getWidth() {
        return this.width;  
    }

    /**
     * Returns the height of the Obstacle
     *
     * @return an integer representing the height of the Obstacle
     */
    public float getHeight() {
        return this.height;
    }
}
