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
    private int width;
    private int height;
    private float x;
    private float y;

    /**
     * Initializes an Obstacle using it's width and height, and it's x and y
     * coordinates on the screen.
     *
     * @param x a float representing the x position of the Obstacle
     * @param y a float representing the y position of the Obstacle
     * @param width an integer representing the width of the Obstacle
     * @param height an integer representing the height of the Obstacle
     */
    public Obstacle(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

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
    public boolean collision(Character character) {
        if (this.x >=character.getX() && this.getFarX() <= character.getFarX() 
                && this.y >= character.getY() && this.getTop() <= character.getTop()){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Returns the right x of the character
     * @return  the right x of the character
     */
    public float getFarX(){
        return this.x + this.width;
    }
    
    /**
     * Returns the top y of the character
     * @return  the top y of the character
     */
    public float getTop(){
        return this.y + this.height;
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
    public int getWidth() {
        return this.width;  
    }

    /**
     * Returns the height of the Obstacle
     *
     * @return an integer representing the height of the Obstacle
     */
    public int getHeight() {
        return this.height;
    }
}
