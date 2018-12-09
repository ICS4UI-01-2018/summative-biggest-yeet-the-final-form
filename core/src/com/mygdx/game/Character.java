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
    private float x, y, gravity, ySpeed, height, width, speed, floorHeight;
    boolean isFalling, isDead, jump, isColliding, hitBottom;
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
        this.gravity = 1.25f; //tweak
        //  this.maxYSpeed = 5; //tweak
        this.x = x;
        this.y = y;
        this.isColliding = false;
        this.jump = false;
        this.floorHeight = 32;
        this.hitBottom = false;
        // create a Rectangle to represent the Character
        this.character = new Rectangle(this.x, this.y, this.width, this.height);
    }

    /**
     * Gives the Character gravity throughout the game.
     *
     * @param p platform that will be hit (may need to be removed) //
     */
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
        if (this.x < 632) {
            // make the Character move towards the right of the screen
            this.x = this.x + this.speed;
        }
    }

    /**
     * Allows the Character to jump. needs to be fixed so that character returns
     * to top of platform when done
     */
    public void jump() {
        if (!this.jump) {
            this.isFalling = false;
            ySpeed = -17;//height of jump
            this.jump = true;
            this.speed = 2;
        }
    }

    public void jumpAction(float fHeight) {
        if (this.hitBottom) {
            ySpeed = 0;
            this.hitBottom = false;
            this.isFalling = true;
            System.out.println("h");
        }
        if (this.jump) {
            System.out.println(this.ySpeed);
            if (this.ySpeed > 0) {
                this.isFalling = true;
            }
            this.speed = 2.8f;
            ySpeed += gravity;
            this.y -= ySpeed;
            if (this.y < fHeight) {
                this.y = fHeight;
                ySpeed = 0;
                this.speed = 2;
                this.jump = false;
                this.isFalling = false;
            }
        }
    }

    public void Falling(float fHeight) {
        if (!this.jump && !this.isColliding) {
            ySpeed = 0;
            this.isFalling = true;
            ySpeed += gravity;
            this.y -= ySpeed;
        
          if (this.y < fHeight) {
                this.y = fHeight;
                ySpeed = 0;
                this.speed = 2;
                this.jump = false;
                this.isFalling = false;
            }
          }
    }

    /**
     * Returns the x position of the Character.
     *
     * @return a float representing the x position of the Character
     */
    public float getX() {
        return this.x;
    }

    public float getNextHeight() {
        return this.ySpeed;
    }

    public void hitBottom(boolean b, Platform p) {
        this.hitBottom = b;
        if (b == true) {
            this.y = p.getY() - this.height;
        }
    }

    public float getTop() {
        return this.y + this.height;
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
    public boolean isJumping() {
        return this.jump;
    }

    public boolean getIsFalling() {
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

    public Platform setCollistion(boolean b, Platform P) {
        this.isColliding = b;
        if (b = true) {
            return P;
        } else {
            return null;
        }
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
