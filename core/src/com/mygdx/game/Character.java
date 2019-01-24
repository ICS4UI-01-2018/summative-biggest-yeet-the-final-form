/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;

/**
 * Creates a Character to use in a game of Fireboy and Watergirl. Allows for the
 * creation of either of Fireboy or a Watergirl.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public abstract class Character {

    private int gemsCollected;
    private float x, y, gravity, ySpeed, height, width, xSpeed;
    boolean isDead, jump, onGround, isOnTopMP;
    private Rectangle character;
    private final Texture straightPic, leftPic, rightPic;

    /**
     * Create a Character by determining if it's a Fireboy or a Watergirl, and
     * it's x and y position on the screen.
     *
     * @param straightPic a Texture used to represent the front side of the
     * Character
     * @param leftPic a Texture used to represent the left side of the Character
     * @param rightPic a Texture used to represent the right side of the
     * Character
     * @param x a float representing the x position of the Character
     * @param y a float representing the y position of the Character
     */
    public Character(Texture straightPic, Texture leftPic, Texture rightPic, float x, float y) {
        // initialize the Textures to represent the Character throughout the game
        this.straightPic = straightPic;
        this.leftPic = leftPic;
        this.rightPic = rightPic;

        this.x = x * 16;
        this.y = y * 16;
        this.width = 24;
        this.height = 30;

        this.gemsCollected = 0;
        this.xSpeed = 3;
        this.isDead = false;
        this.ySpeed = 0;
        this.gravity = 0.5f; //tweak
        this.x = x * 16;
        this.y = y * 16;
        this.onGround = true;
        this.jump = false;
        this.isOnTopMP = false;
        // create a Rectangle to represent the Character
        this.character = new Rectangle(this.x, this.y, this.width, this.height);
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
     * Sets the x position of the Character to the specified float.
     *
     * @param x a float representing the new x position of the Character
     */
    public void setX(float x) {
        this.x = x;
        // update the position of the Character
        updatePositions();
    }

    /**
     * Sets the y position of the Character to the specified float.
     *
     * @param y a float representing the new y position of the Character
     */
    public void setY(float y) {
        this.y = y;
        // update the position of the Character
        updatePositions();
    }

    /**
     * Returns x position of the right side of the Character.
     *
     * @return a float representing the x position of the right side of the
     * Character
     */
    public float getFarX() {
        return (this.x + this.width);
    }

    /**
     * Returns the y position of the top of the Character.
     *
     * @return a float representing the y position of the top of the Character
     */
    public float getTop() {
        return (this.y + this.height);
    }

    /**
     * Returns the y speed of the Character.
     *
     * @return a float representing the y speed of the Character
     */
    public float getYSpeed() {
        return this.ySpeed;
    }

    /**
     * Sets the x position of the Character using the specified float.
     *
     * @param x a float to use to calculate the new x position of the Character
     */
    public void setFarX(float x) {
        this.x = x - this.width;
        // update the position of the Character
        updatePositions();
    }

    /**
     * Sets the x coordinate to specified float
     *
     * @param y a float representing new coordinate
     */
    public void setTop(float y) {
        this.y = y - this.height;
        // update the position of the Character
        updatePositions();
    }

    /**
     * Sets the y speed of the Character to the specified float.
     *
     * @param ySpeed a float representing the new y speed of the Character
     */
    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    /**
     * Sets the Character to be on or off of a Platform.
     *
     * @param onGround a boolean representing whether or not the Character is on
     * the platform
     */
    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    /**
     * Sets the jumping variable of the Character.
     *
     * @param jump a boolean representing whether or not the Character is
     * jumping or not
     */
    public void setJumping(boolean jump) {
        this.jump = jump;
    }

    /**
     * Returns the Rectangle representing the Character.
     *
     * @return a Rectangle representing the Character
     */
    public Rectangle getBounds() {
        return this.character;
    }

    /**
     * Returns the height of the Character.
     *
     * @return a float representing the height of the Character
     */
    public float getHeight() {
        return this.height;
    }

    /**
     * Returns the width of the Character.
     *
     * @return a float representing the width of the Character
     */
    public float getWidth() {
        return this.width;
    }

    /**
     * Allows the Character to move towards the left-side of the screen without
     * it going off of the screen.
     */
    public void moveLeft() {
        // do not let the Character move off of the left-side of the screen
        if (this.x > 16) {
            // make the Character move towards the left of the screen
            this.x -= this.xSpeed;
            // update the position of the Character
            updatePositions();
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
            this.x += this.xSpeed;
            // update the position of the Character
            updatePositions();
        }
    }

    /**
     * Sets the Character to a jumping state.
     */
    public void jump() {
        if (this.onGround) {
            ySpeed = -7;//height of jump
            this.jump = true;
            // Character will not be on the ground
            this.onGround = false;
        }
    }

    /**
     * Allows the Character to jump and fall.
     */
    public void jumpAction() {
        // determine if the Character ins't on the ground
        if (!this.onGround) {
            //sets the y coordinate to a gradually increasing/decreasing new value
            ySpeed += gravity;
            //move player up or down according to this y speed
            this.y -= ySpeed;
            this.updatePositions();
        }
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
    public void addGem(Gem g) {
        System.out.println(gemsCollected);
        if (!g.isCollected()){
        this.gemsCollected++;
        }
    }

    /**
     * Returns a Platform that the Character is standing on top of.
     *
     * @param p the platform being checked
     * @return whether or not the character is on top of this platform
     */
    public boolean isOnTop(Platform p) {
        boolean onTop = false;
        if (this.y == p.getTop()) {
            //player is somewhere in the middle of the platform
            if ((this.x >= p.getX()
                    && this.getFarX() <= p.getFarX())) {
                p.timer();
                onTop = true;
            }//character is on edge of platform
            else if (this.x < p.getX()
                    && this.getFarX() >= p.getX()) {
                p.timer();
                onTop = true;
            } else if (this.getFarX() > p.getFarX()
                    && this.x <= p.getFarX()) {
                p.timer();
                onTop = true;
            }
        }
        return onTop;
    }

    /**
     * Sets the character to be standing on the ground/tied to a moving platform 
     *
     * @param platforms array of platforms being checked
     * @param mP array of moving platforms being checked
     * @return the platform or moving platform the character is standing on; null means the character is not on any (moving)platform
     */
    public Object needsToBeRenamed(ArrayList<Platform> platforms, ArrayList<MovingPlatform> mP) {
        Object current = null;
        boolean b = false;
        for (Platform p : platforms) {
            if (isOnTop(p)) {
                b = true;
                current = p;
            }
        }
        for (MovingPlatform mp : mP) {
            if (isOnTop(mp)) {
                this.isOnTopMP = true;
                b = true;
                current = mp;
            } else {
                this.isOnTopMP = false;
            }
        }
        this.onGround = b;

        return current;
    }
    
    /**
     * Sets the character's y to the y of the moving platform
     * @param mp the moving platform the character is on top of
     */
       public void tieTo(MovingPlatform mp) {
           // only tie to platform if you're on top and not jumping
        if (this.isOnTopMP && !this.jump) {
            this.y = mp.getTop();
            this.onGround = true;
        } else {
            this.isOnTopMP = false;
        }
    }

    /**
     * Updates the current position of the Character on the screen in the
     * Character class.
     */
    public void updatePositions() {
        this.character.x = this.x;
        this.character.y = this.y;
    }

    /**
     * Sets the state of life of the Character to be the specified boolean.
     *
     * @param isDead a boolean representing whether the Character is alive or
     * not
     */
    public void setDead(boolean isDead) {
        this.isDead = isDead;
    }

    /**
     * Returns the Texture representing the front side of the Character.
     *
     * @return a Texture representing the front side of the Character
     */
    public Texture getStraightPic() {
        return this.straightPic;
    }

    /**
     * Returns the Texture representing the left side of the Character.
     *
     * @return a Texture representing the left side of the Character
     */
    public Texture getLeftPic() {
        return this.leftPic;
    }

    /**
     * Returns the Texture representing the right side of the Character
     *
     * @return a Texture representing the right side of the Character
     */
    public Texture getRightPic() {
        return this.rightPic;
    }

    /**
     * Draws the Character using a SpriteBatch.
     *
     * @param batch a SpriteBatch used to draw the Character
     */
    public void draw(SpriteBatch batch) {
        batch.draw(this.straightPic, this.x, this.y, this.width, this.height);
    }

    /**
     * Draws the left side of Character using a SpriteBatch.
     *
     * @param batch a SpriteBatch used to draw the left side of the Character
     */
    public void drawLeft(SpriteBatch batch) {
        batch.draw(this.leftPic, this.x, this.y, this.width, this.height);
    }

    /**
     * Draws the right side of Character using a SpriteBatch.
     *
     * @param batch a SpriteBatch used to draw the right side of Character
     */
    public void drawRight(SpriteBatch batch) {
        batch.draw(this.rightPic, this.x, this.y, this.width, this.height);
    }
}
