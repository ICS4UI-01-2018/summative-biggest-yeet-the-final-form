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

    private int gemsCollected;
    private float x, y, speed, velocity, gravity, height, width;
    private boolean isFalling, isDead, jump;
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
        this.speed = 5;
        this.isFalling = false;
        this.isDead = false;
        this.velocity = 0;
        this.gravity = 1;

        // create a Rectangle to represent the Character
        this.character = new Rectangle(this.x, this.y, this.width, this.height);
    }

    public void gravity(Platform p) {
        while (this.y != p.getY()) {
            switchFalling();
        }
        if (this.isFalling) {
            this.y--;
        }
    }

    /**
     * Allows the Character to move towards the left-side of the screen without
     * it going off of the screen.
     */
    public void moveLeft() {
        // do not let the Character move off of the left-side of the screen
        if (character.x > 16) {
            // make the Character move towards the left of the screen
            character.x = character.x - this.speed;
        }
    }

    /**
     * Allows the Character to move towards the right-side of the screen without
     * it going off of the screen.
     */
    public void moveRight() {
        // do not let the Character move off of the right-side of the screen
        if (character.x < 584) {
            // make the Character move towards the right of the screen
            character.x = character.x + this.speed;
        }
    }

    /**
     * Allows the Character to jump.
     */
    public void jump() {
        this.velocity = this.velocity + this.gravity;
character.y += this.velocity;
        // make sure the Character is on the ground before jumping
        if (this.jump && !this.isFalling) {
            this.velocity = -15;
            this.isFalling = true;
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
    public void switchFalling() {
        if (this.isFalling) {
            this.isFalling = false;
        } else {
            this.isFalling = true;
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
        this.x = this.character.x;
        this.y = this.character.y;
    }
    
    public void Move(){
        this.x = this.x + 10;
    }
}
