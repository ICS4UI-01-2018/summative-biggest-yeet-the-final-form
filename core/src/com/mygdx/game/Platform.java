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
public class Platform {

    private final Rectangle platform;
    private final float width, height;
    private float x, y;
    private boolean gravity;
    private int speed;

    /**
     * Creates a Platform using the x, y, width, and height.
     *
     * @param x an integer representing the x-coordinate of the platform
     * @param y an integer representing the y-coordinate of the platform
     * @param width an integer representing the width of the platform
     * @param height an integer representing the height of the platform
     */
    public Platform(float x, float y, float width, float height) {
        this.x = x * 16;
        this.y = y * 16;
        this.width = width * 16;
        this.height = height * 16;
        this.speed = 0.5f;

        // initialize a new Rectangle to represent the Platform
        this.platform = new Rectangle(this.x, this.y, this.width, this.height);
    }

    /**
     * Gets the x-coordinate of the Platform.
     *
     * @return a float representing the x-coordinate of the Platform
     */
    public float getX() {
        return this.x;
    }

    public float getTop() {
        return (this.height + this.y);
    }

    /**
     * Returns the X-coordinate of the edge of the platform
     *
     * @return the X-coordinate of the edge of the platform
     */
    public float getLength() {
        return (this.width + this.x);
    }

  

    /**
     * Returns the y-coordinate of the Platform.
     *
     * @return a float representing the y-coordinate of the Platform
     */
    public float getY() {
        return this.y;
    }

  public boolean collision(Character c){
      return this.getBounds().overlaps(c.getBounds());
  }
 
   
 

    /**
     * Draws the Platform on the screen.
     *
     * @param shapeBatch a ShapeRenderer that will draw the Platform on the
     * screenF
     */
    public void draw(ShapeRenderer shapeBatch) {
        shapeBatch.rect(platform.x, platform.y, platform.width, platform.height);
    }

    /**
     * Moves the Platform downwards.
     */
    public void moveDown() {
        this.y = this.y - this.speed;
    }

    /**
     * Moves the Platform upwards.
     */
    public void moveUp() {
        this.y = this.y + this.speed;
    }
    
       public Rectangle getBounds() {
        return this.platform;
    }
    /**
     * Updates the x and y positions of the Platform.
     */
    public void updatePositions() {
        this.platform.x = this.x;
        this.platform.y = this.y;
    }
}
