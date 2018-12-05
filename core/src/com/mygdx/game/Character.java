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
public class Character {

    private String type;
    private int height, width, gemsCollected;
    private float x, y, speed, velocity, gravity;
    private boolean isFalling, isDead, jump;
    private Rectangle character;

    /**
     * Create a Character by determining if it's a Fireboy or a Watergirl, and
     * it's x and y position on the screen.
     *
     * @param type a String representing if it's a Fireboy or a Watergirl
     * @param x a float representing it's x position on the screen
     * @param y a float representing it's y position on the screen
     */
    public Character(String type, float x, float y) {
        type = this.type;
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

    public void gravity() {
        
        while ()
        this.y = this.y + this.velocity;

        while () {
            
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
        if (this.x < 656) {
            // make the Character move towards the right of the screen
            this.x = this.x + this.speed;
        }
    }

    public void jump() {
        this.velocity = this.velocity + this.gravity;

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
     * Returns whether the Character is a Fireboy or a Watergirl.
     *
     * @return a String representing what type of Character the Character is
     */
    public String getType() {
        return this.type;
    }

    /**
     * Returns the height of the character
     *
     * @return an integer representing the height of the character
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Returns the width of the character
     *
     * @return an integer representing the width of the character
     */
    public int getWidth() {
        return this.width;
    }
    
    /**
     * Returns that the character is falling
     */
    public void falling() {
        if (this.isFalling) {
            this.isFalling = false;
        } else {
            this.isFalling = true;
        }
    }
    
    /**
     * allows the characters to be drawn 
     * @param shapeBatch draws characters 
     */
    public void draw(ShapeRenderer shapeBatch) {
        shapeBatch.rect(character.x, character.y, character.width, character.height);
    }

}
