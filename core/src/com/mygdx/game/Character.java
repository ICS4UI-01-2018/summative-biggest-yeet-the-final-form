/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Creates a Character to use in a game of Fireboy and Watergirl. Allows for the
 * creation of either of Fireboy or a Watergirl.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public abstract class Character {

    private int gemsCollected, maxYSpeed;
    private float x, y, speed, gravity, ySpeed, height, width;
    private boolean isFalling, isDead, jump, isColliding;
    private Rectangle character;
  
    /**
     * Create a Character by determining if it's a Fireboy or a Watergirl, and
     * it's x and y position on the screen.
     *
     * @param x a float representing it's x position on the screen
     * @param y a float representing it's y position on the screen
     */
    public Character(float x, float y) {
        this.height = 30;
        this.width = 24;
        this.gemsCollected = 0;
        this.speed = 2;
        this.isFalling = false;
        this.isDead = false;
        this.ySpeed = 0;
        this.gravity = 1; //tweak
        this.maxYSpeed = 5; //tweak
        this.x = x;
        this.y = y;
        this.isColliding = false;

        // create a Rectangle to represent the Character
        this.character = new Rectangle(this.x, this.y, this.width, this.height);
    }

    /**
     * Gives the Character gravity throughout the game.
     *
     * @param p platform that will be hit (may need to be removed)
     */
    public void falling(Platform p) {//not acclerating --> fix
        if (this.isFalling) {
            this.ySpeed = this.ySpeed + this.gravity;
            if (this.ySpeed > maxYSpeed) {
                this.ySpeed = maxYSpeed;
            }
            this.y = this.y - this.ySpeed;
            p.collision(this);
        } else {
            // this.y = 122;
            this.ySpeed = 0;
        }
    }

    /**
     * Allows the Character to move towards the left-side of the screen without
     * it going off of the screen.
     */
    public void moveLeft() {
        // do not let the Character move off of the left-side of the screen
        if (this.x > 16) {
            // make the Character move towards the left of the screen
            this.x = this.x - this.speed;
        }
    }

    /**
     * Allows the Character to move towards the right-side of the screen without
     * it going off of the screen.
     */
    public void moveRight() {
        // do not let the Character move off of the right-side of the screen
        if (this.x < 584) {
            // make the Character move towards the right of the screen
            this.x = this.x + this.speed;
        }
    }

    /**
     * Allows the Character to jump. needs to be fixed so that character returns
     * to top of platform when done
     */
    public void jump() {
        if (this.isColliding) {
            this.y += 40;
            this.jump = true;
            this.isFalling = true;
        }
//        // make sure the Character is on the ground before jumping
//        if (this.isFalling) {
//            this.ySpeed = 0;
//            this.jump = true;
//        }else{
//            this.jump = false;
//        }

//       
//          this.ySpeed += gravity;
//        this.y += 40;
//        // make sure the Character is on the ground before jumping
//        if (this.jump && !this.isFalling) {
//            //this.velocity = -15;
//            this.isFalling = true;
    }
    

    /**
     * Returns the x position of the Character.
     *
     * @return a float representing the x position of the Character
     */
    public float getX() {
        return this.x;
    }

    /**
     * Returns the y position of the Character.
     *
     * @return a float representing the y position of the Character
     */
    public float getY() {
        return this.y;
    }

    /**
     * Returns whether the Character is falling or not.
     *
     * @return a boolean representing whether if the Character is falling or not
     */
    public boolean isFalling() {
        return this.isFalling;
    }

    /**
     * Returns whether if the Character has died or not.
     *
     * @return a boolean representing whether the Character has died or not
     */
    public boolean isDead() {
        return this.isDead;
    }

    /**
     * Returns the amount of Gems the Character has collected.
     *
     * @return an integer representing the amount of Gems a Character has
     * collected
     */
    public int getGemsCollected() {
        return this.gemsCollected;
    }

    /**
     * Adds a Gem to the Gem count.
     */
    public void addGem() {
        this.gemsCollected++;
    }

    /**
     * Returns the Rectangle representing the Character.
     *
     * @return a Rectangle representing the Character.
     */
    public Rectangle getBounds() {
        return this.character;
    }

    /**
     * Returns the height of the character
     *
     * @return an integer representing the height of the character
     */
    public float getHeight() {
        return this.height;
    }

    /**
     * Returns the width of the character
     *
     * @return an integer representing the width of the character
     */
    public float getWidth() {
        return this.width;
    }

    /**
     * Sets the Character to fall if it's not falling, and to not fall if it's
     * falling.
     */
    public void setFalling(boolean b) {

        this.isFalling = b;

    }

    public void setCollistion(boolean b) {
        this.isColliding = b;
    }

    /**
     * Draws the Character on the screen using a ShapeRenderer.
     *
     * @param shapeBatch a ShapeRenderer used to draw the Character on the
     * screen
     */
    public void draw(ShapeRenderer shapeBatch) {
        shapeBatch.rect(character.x, character.y, character.width, character.height);
    }

 
        /**
         * Stores the current position of the Character on the screen into the
         * Character class.
         */
    public void updatePostions() {
        this.character.x = this.x;
        this.character.y = this.y;
    }

    /**
     * Sets the Character to be dead.
     */
    public void died() {
        this.isDead = true;
    }
}
