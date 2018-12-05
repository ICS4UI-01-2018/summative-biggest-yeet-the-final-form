/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author emily
 */
public class Gem {

    private float x;
    private float y;
    private int width;
    private int height;
    private String typeAllowed;
    private boolean collected;
    private Rectangle gem;

    /**
     * Initalizes gem as a rectangle
     *
     * @param x the x coordinate of the gem
     * @param y the y coordinate of the gem
     * @param width the width of the gem
     * @param height the height of the gem
     * @param typeAllowed the character allowed to collect the gem
     */
    public Gem(float x, float y, int width, int height, String typeAllowed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gem = new Rectangle(x, y, width, height);
        this.typeAllowed = typeAllowed;
        this.collected = false;
    }

    /**
     * return x coordinate or gem
     *
     * @return x coordinate
     */
    public float getX() {
        return this.x;
    }

    /**
     * return y coordinate or gem
     *
     * @return y coordinate
     */
    public float getY() {
        return this.y;
    }

    /**
     * return width coordinate or gem
     *
     * @return width
     */
    public float getWidth() {
        return this.width;
    }

    /**
     * return height of gem
     * @return height coordinate
     */
    public float getHeight() {
        return this.height;
    }

    /**
     *returns whether or not the gem is being collected
     * @param c the character touching it
     * @return
     */
    public boolean collision(Character c) {
//        if (c.type.equals(typeAllowed)) {
//            return gem.overlaps(c.getBounds());
//        }
    return false;
    }

    /**
     * checks whether the gem has been collected
     *
     * @return if the gem is collected
     */
    public boolean isCollected() {
        return this.collected;
    }

}
