/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import java.awt.Rectangle;

/**
 * Creates a Character to use in a game of Fireboy and Watergirl. Allows for the
 * creation of either of Fireboy or a Watergirl.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public abstract class Character {

    private int gemsCollected, counter;
    private int x, y, gravity, ySpeed, height, width, speed, newHeight;
    boolean isFalling, isDead, jump, onGround, hitBottom, hitSide, onIce, ahh;
    private Rectangle character, overlap;

    /**
     * Create a Character by determining if it's a Fireboy or a Watergirl, and
     * it's x and y position on the screen.
     *
     * @param x a float representing it's x position on the screen
     * @param y a float representing it's y position on the screen
     */
    public Character(int x, int y) {
        this.height = 30;
        this.width = 24;
        this.gemsCollected = 0;
        this.speed = 1;
        this.isFalling = false;
        this.isDead = false;
        this.ySpeed = 0;
        this.gravity = 1; //tweak
        //  this.maxYSpeed = 5; //tweak
        this.x = x;
        this.y = y;

        this.onGround = true;
        this.jump = false;
        this.newHeight = 32;
        this.hitBottom = false;
        this.hitSide = false;
        this.counter = 0;
        overlap = new Rectangle(0, 0, 0, 0);
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
        if (this.onGround) {
            this.isFalling = false;
            ySpeed = -16;//height of jump
            this.jump = true;
            this.speed = 2;
            this.onGround = false;
        }
    }

    /**
     * Allows the character to jump *real buggy
     *
     * @param fHeight the height of the platform to return to
     */
    public void jumpAction() {
        if (this.jump) {
            System.out.println("heg");
            ySpeed += gravity;
            this.y -= ySpeed;
        }
    }

    public void stopJumping() {
        this.ySpeed = 0;
        this.onGround = true;
        //this.jump = false;
        this.y = 32;
    }

    public void stopJumpings(Platform p) {
        overlap = character.intersection(p.getBounds());
        //    Rectangle overlap = p.collision(this);
        if (overlap.height < overlap.width ) {
            if (ySpeed < 0){
            // stop moving up/down
            this.ySpeed = 0;
            // correct the position
            this.y = p.getY() - this.height;
            
            // set on ground
            }
            if (ySpeed > 0){
                 System.out.println("on platform");
            this.y = p.getY() + this.height;
                System.out.println(this.y);
            this.onGround = true; 
            this.jump = false;
            }                 
        } else if (!this.onGround) {
            System.out.println("hm");
            // player is on the right
            if (this.x < p.getX()) {
                this.x = this.x - overlap.width;
            } else {
                this.x = this.x + overlap.width;
            }
        }

    }

    /**
     * Returns the x position of the Character.
     *
     * @return a float representing the x position of the Character
     */
    public int getX() {
        return this.x;
    }

    public float getTop() {
        return this.y + this.height;
    }
      public boolean onGroubnd() {
        return this.onGround;
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

    public boolean hitRight(Platform p) {

        if (x + width > p.getX()) {
            this.x = p.getX();
            this.width = p.getX();
            return true;
        }
        return false;
    }

    public boolean hitLeft(Platform p) {
        if (x < p.getX() + p.getLength()) {
            this.x = this.x - (this.speed + 1);
            return true;
        }
        return false;
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

    public void Move() {
        this.x = this.x + 10;
    }

    public void isOnIce(boolean b) {
        this.onIce = b;
    }
}
