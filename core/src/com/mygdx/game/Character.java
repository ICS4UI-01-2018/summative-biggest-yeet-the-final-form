/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 * Creates a Character to use in a game of Fireboy and Watergirl. Allows for the
 * creation of either of Fireboy or a Watergirl.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public abstract class Character {

    private int gemsCollected, counter;
    private float x, y, gravity, ySpeed, height, width, speed, newHeight;
    boolean isFalling, isDead, jump, isColliding, hitBottom, hitSide, onIce;
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
        this.speed = 1;
        this.isFalling = false;
        this.isDead = false;
        this.ySpeed = 0;
        this.gravity = 1f; //tweak
        //  this.maxYSpeed = 5; //tweak
        this.x = x;
        this.y = y;

        this.isColliding = true;
        this.jump = false;
        this.newHeight = 32;
        this.hitBottom = false;
        this.hitSide = false;
        this.counter = 0;
        
        // create a Rectangle to represent the Character
        this.character = new Rectangle(this.x, this.y, this.width, this.height);
    }

    /**
     * Allows the Character to move towards the left-side of the screen without
     * it going off of the screen.
     */
    public void moveLeft() {
        if (!hitSide) {
            // do not let the Character move off of the left-side of the screen
            if (this.x > 16) {
                // make the Character move towards the left of the screen
                this.x = this.x - this.speed;
            }
        }
    }

    /**
     * Allows the Character to move towards the right-side of the screen without
     * it going off of the screen.
     */
    public void moveRight() {
        if (!hitSide) {
            // do not let the Character move off of the right-side of the screen
            if (this.x < 632) {
                // make the Character move towards the right of the screen
                this.x = this.x + this.speed;
            }
        }
    }

    /**
     * Sets the Character to a jumping state.*buggy
     */
    public void jump() {
        if (!this.jump && !this.onIce) {
            this.isFalling = false;
            ySpeed = -12;//height of jump
            this.jump = true;
            this.speed = 2;
            this.isColliding = false;
        }
    }

    /**
     * Allows the character to jump *real buggy
     *
     * @param fHeight the height of the platform to return to
     */
    public void jumpAction(float fHeight) {
        if (this.hitBottom) {
            ySpeed = 0;
            this.hitBottom = false;
            this.isFalling = true;
        }
        if (this.jump) {
            if (this.ySpeed > 0) {
                this.isFalling = true;
            }
            // this.speed = 2.1f;
            ySpeed += gravity;
            this.y -= ySpeed;
            if (this.y < fHeight) {
                float c = this.y;
                this.y = fHeight;
                ySpeed = 0;
                this.speed = 2;
                this.jump = false;
                this.isFalling = false;
                this.isColliding = true;
            }
        }
    }

    public void falling(float fHeight, boolean b) {
        if (!this.jump && !b) {
            // System.out.println("FALL");
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
     * Finds the platform the character is landing on
     *
     * @param p Array of platforms
     * @return the platform the character is landing on
     */
    public float newGround(Platform[] p) {
        this.counter = 0;
        for (Platform x : p) {
            if (x.collideWithBottom(this)) {
                this.hitBottom(true, x);
            }
            if (x.land(this) != 0) {
                newHeight = x.land(this);
            }
            if (x.land(this) == 0) {
                this.counter++;
            }
            if (this.counter >= p.length) {
                newHeight = 32;
                this.counter = 0;
            }
        }
        return newHeight;
    }

    /**
     * Returns whether the character is on the ground
     *
     * @param p Array of Platforms
     * @return
     */
    public boolean standing(Platform[] p) {
        this.counter = 0;
        for (Platform x : p) {
            if (this.getX() >= x.getX() && (this.getX() + this.width) <= x.getLength() && this.getY() >= x.getY() && this.getY() <= x.getTop()) {
                this.counter++;
            }
        }
        if (this.counter == 1) {
            return true;
        } else {
            return false;
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

    /**
     * Sets whether
     *
     * @param b
     * @param p
     */
    public void hitBottom(boolean b, Platform p) {
        this.hitBottom = b;
        if (b == true) {
            this.y = p.getY() - this.height;
        }
    }

    public float getTop() {
        return this.y + this.height;
    }

    public float getLeft() {
        return this.x;
    }

    public float getBottom() {
        return this.y;
    }

    public float getRight() {
        return this.x + this.width;
    }

    public void hitRight() {
        x = x - (this.speed + 1);
    }

    public void hitLeft() {
        x = x - (this.speed + 1);
    }

    /**
     * Returns the y position of the Character.
     *
     * @return a float representing the y position of the Character
     */
    public float getY() {
        return this.y;
    }

    public boolean getCollide() {
        return this.isColliding;
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
    public void updatePositions() {
        this.character.x = this.x;
        this.character.y = this.y;
    }

    /**
     * Sets the Character to be dead.
     */
    public void died() {
        this.isDead = true;
    }

    public void Move() {
        this.x = this.x + 10;
    }

    public void hitSide(boolean b, Platform p) {
        this.hitSide = b;
        if (b == true) {
            this.x = p.getX();
            this.width = p.getX();
        }
    }

    public void isOnIce(boolean b) {
        this.onIce = b;
    }
}
