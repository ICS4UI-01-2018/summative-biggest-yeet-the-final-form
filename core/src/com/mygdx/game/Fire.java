/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author powea5594
 */
public class Fire extends Obstacle {
    
    private Rectangle fire; 
    
    /**
     * initialize fire data
     * @param width width of the fire
     * @param height height of the fire
     * @param x x coordinate
     * @param y y coordinate
     */
    public Fire (int width, int height, float x, float y){
         super (width, height, x, y);
        
    }
    
    
    
    /**
     * checks x coordinate
     * @return the x coordinate of the fire
     */
    @Override
    public float getX() {
        return fire.x;
    }

    /**
     * checks y coordinate
     * @return the y coordinate of the fire
     */
    @Override
    public float getY() {
        return fire.y;
    }

    /**
     * checks where the fire is
     * @return the fire
     */
    @Override
    public Rectangle getBounds() {
        return fire;
    }
    
    
}
