/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Intersector;

/**
 * Creates a Platform to use in a game of Fireboy and Watergirl. The Characters
 * can move along the Platforms to complete each Level of the game.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Platform {

    private final Rectangle platform, overlap;
    private float width, height, timer;
    private float x, y;
    private final Texture platformPic;
    private boolean broken;

    /**
     * Creates a Platform using the xRect, y, width, and height.
     *
     * @param x an integer representing the xRect-coordinate of the platform
     * @param y an integer representing the y-coordinate of the platform
     * @param width an integer representing the width of the platform
     * @param height an integer representing the height of the platform
     */
    public Platform(float x, float y, float width, float height) {
        this.x = x * 16;
        this.y = y * 16;
        this.width = width * 16;
        this.height = height * 16;
        this.timer = 0;
        // initialize an new Rectangle to be used for collisions
        this.overlap = new Rectangle(0, 0, 0, 0);

        // initialize a new Rectangle to represent the Platform
        this.platform = new Rectangle(this.x, this.y, this.width, this.height);

        // initialize the Texture for the Platform
        this.platformPic = new Texture("Block.jpg");
        
        this.broken = false;
    }
    
    public boolean getBroken(){
        return this.broken;
    }

    /**
     * Gets the xRect-coordinate of the Platform.
     *
     * @return a float representing the xRect-coordinate of the Platform
     */
    public float getX() {
        return this.x;
    }

    /**
     * Returns the y-coordinate of the Platform.
     *
     * @return a float representing the y-coordinate of the Platform
     */
    public float getY() {
        return this.y;
    }

    /**
     * Sets the y position of the Platform to the float that's passed in.
     *
     * @param y a float representing the new y position of the Platform
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Sets the xRect-coordinate to the specified float
     *
     * @param f a float representing the new xRect-coordinate
     */
    public void setX(float f) {
        this.x = f;
    }

    /**
     * Sets the far xRect-coordinate to the specified float
     *
     * @param f a float representing the new far xRect-coordinate
     */
    public void setFarX(float f) {
        this.x = f - this.width;
    }

    /**
     * Returns the top y-coordinate of the platform.
     *
     * @return a float representing the top y-coordinate of the platform.
     */
    public float getTop() {
        return (this.height + this.y);
    }

    /**
     * Returns the X-coordinate of the edge of the platform
     *
     * @return the X-coordinate of the edge of the platform
     */
    public float getFarX() {
        return (this.width + this.x);
    }

    /**
     * Returns the width of the Platform.
     *
     * @return a float representing the width of the Platform
     */
    public float getWidth() {
        return this.width;
    }

    /**
     * Returns the height of the Platform.
     *
     * @return a float representing the height of the Platform
     */
    public float getHeight() {
        return this.height;
    }

    /**
     * Returns the Rectangle that represents the Platform.
     *
     * @return a Rectangle that represents the Platform
     */
    public Rectangle getBounds() {
        return this.platform;
    }

    public float timer() {
        this.timer = this.timer + 1;
        return this.timer;
    }
    
    public void breakBlock(){
        System.out.println();
        System.out.println(this.timer);
        System.out.println();
    if (this.timer >= 10){
        System.out.println("here");
        this.broken = true;
    }
}

    /**
     * Stops character from jumping if on platform
     *
     * @param c Character being checked
     */
    public int whereIsPlayer(Character c) {//square? also need to be implented for obstacles
        //create a rectangle representing the overlap
        Intersector.intersectRectangles(c.getBounds(), this.getBounds(), this.overlap);
        int x = 0;
        //if height is less than width then player is at top or bottom
        if (this.overlap.height < this.overlap.width) {
            //if player is falling and their top is equal to/below the platforms top then player is hitting BOTTOM of platform
            if (c.getYSpeed() < 0 && c.getTop() <= this.getTop()) {
                // stop moving up
                c.setYSpeed(0);
                // correct the position
                c.setTop(this.y);
                x = 1;
            }
            //if player is jumping and their top is (equal to/above the platforms top(subject to change)) then player is hitting TOP of platform
            if (c.getYSpeed() > 0 && c.getY() >= this.y) {
                //put player on top of platform
                c.setY(this.getTop());
                //set player to be on the ground and no longer jumping
                c.setOnGround(true);
                c.setJumping(false);
                x = 2;
            }
        } else {//if overlap height is greater than its width player is hitting a side
            //if players x is lesser then player is hitting LEFT side of PLATFORM
            if (c.getX() < this.getX()) {
                //set player to be beside platform
                c.setFarX(this.getX());
                x = 3;
            } else {//if players x is greater then player is hitting RIGHT side of PLATFORM
                //set player to be beside platform
                c.setX(this.getFarX());
                x = 4;
            }
        }

        //update player position
        c.updatePositions();
        return x;
    }

    /**
     * Draws the Platform using a Texture.
     *
     * @param batch a SpriteBatch that will draw the Texture representing the
     * Platform
     */
    public void draw(SpriteBatch batch) {
        // determine how many columns of Textures you need to draw
        float column = this.width / 16;
        // determine how many rows of Textures you need to draw
        float row = this.height / 16;

        // determine the starting x and y positions to draw the Texture
        float xDraw = this.x;
        float yDraw = this.y;

        // determine if you can draw a new column of Textures
        while (column - 1 >= 0) {
            // draw a Texture
            batch.draw(platformPic, xDraw, yDraw, 16, 16);

            // determine if more Textures need to be drawn vertically
            while (row - 1 > 0) {
                // adjust the yDraw variable
                yDraw += 16;

                // draw the Texture
                batch.draw(platformPic, xDraw, yDraw, 16, 16);

                row--;
            }

            // reset the variables
            column--;
            row = this.height / 16;
            xDraw += 16;
            yDraw = this.y;
        }
    }

    /**
     * Returns the y position of the Platform.
     *
     * @return a float representing the y position of the Platform
     */
    public float getPlatformY() {
        return this.platform.y;
    }

    /**
     * Sets the y position of the Platform to be the specified float.
     *
     * @param platformY a float representing the new y position of the Platform
     */
    public void setPlatformY(float platformY) {
        this.platform.y = platformY;
    }
}
