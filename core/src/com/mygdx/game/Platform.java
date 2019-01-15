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

    private Rectangle platform, overlap;
    private int height;
    private int width;
    private float x;
    private float y;
    private float overlapWidth, overlapFarX, overlapX, overlapHeight, overlapTopY, overlapY;
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
    public Platform(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = 1;
         this.overlapWidth = 0;
        this.overlapFarX = 0;
        this.overlapX = 0;
        this.overlapHeight = 0;
        this.overlapTopY = 0;
        this.overlapY = 0;
        overlap = new Rectangle(this.overlapX, this.overlapY, this.overlapWidth, this.overlapHeight);
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

    public boolean collision(Character c) {
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

    public Rectangle overlapRectangle(Character c) {
        if (this.getBounds().overlaps(c.getBounds())) {
            if (c.getY() + c.getHeight() > this.getTop()) {
                this.overlapY = c.getY();
                this.overlapTopY = this.getTop();
            } else {
                this.overlapY = this.getY();
                this.overlapTopY = c.getTop();
            }
            if (c.getX() < this.getX()) {
                this.overlapX = this.getX();
                this.overlapFarX = c.length();
            } else {
                this.overlapX = c.getX();
                this.overlapFarX = this.getLength();
            }
            // this.onGround = true;

        }
        this.overlapWidth = this.overlapFarX - this.overlapX;
        this.overlapHeight = this.overlapTopY - this.overlapY;
        this.overlap = this.overlap.set(this.overlapX, this.overlapY, this.overlapWidth, this.overlapHeight);
        return this.overlap;
    }

    public void stopJumpings(Character c) {
        this.overlap = this.overlapRectangle(c);
        
        //    Rectangle overlap = p.collision(this);
        if (this.overlap.height < this.overlap.width) {
            if (c.getYSpeed() < 0 && c.getTop() <= this.getTop()) {
                // stop moving up/down
                c.setYSpeed( 0);
                // correct the position
                c.setY( this.getY() - this.height);
                //   System.out.println("on bottom");
                // set on ground
            }
            if (c.getYSpeed() > 0) {
              c.setY(this.getTop());
                //   System.out.println(this.y);
                c.setOnGround(true); 
                c.setJumping(false); 
                
            }
        } else {
            // player is on the right
            if (c.getX() < this.getX()) {
                c.setX(c.getX() - this.overlap.width);
                //  System.out.println("on side");
            } else {
                   c.setX(c.getX() + this.overlap.width);
                //  System.out.println("on side");
            }
        }
    }
    
        public void onTop(Character c) {
            if (c.getY() == this.getTop()) 
                System.out.println("hm");
                if ((c.getX() >= this.getX() && c.length() <= this.getLength())) {
                    System.out.println("b");
                    c.setOnGround(true);
                } else if (c.getX() < this.getX() && c.length() >= this.getX()) {
                    c.setOnGround(true);
                } else if (c.length() > this.getLength() && c.getX() <= this.getLength()) {
                    c.setOnGround(true);
                }
            
        
        else{
            c.onGround = false;

        }

    }
}
