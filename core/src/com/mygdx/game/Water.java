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
public class Water extends Obstacle { 
    private Rectangle water; 
    
    /**
     * initialize water data
     * @param width width of the water
     * @param height height of the water
     * @param x x coordinate
     * @param y y coordinate
     */
    public Water (int width, int height, float x, float y){
         super (width, height, x, y);
        
    }
    
    /**
     * check if the fire boy is in the water
     * @param f the fire boy
     * @return if the fire boy is in the water or not
     */
    public boolean Collision(Fireboy f) {
        return water.overlaps(f.getBounds());
      
    }
    
    /**
     * checks x coordinate
     * @return the x coordinate of the water
     */
    @Override
    public float getX() {
        return water.x;
    }

    /**
     * checks y coordinate
     * @return the y coordinate of the water
     */
    @Override
    public float getY() {
        return water.y;
    }

    /**
     * checks where the water is
     * @return the water
     */
    @Override
    public Rectangle getBounds() {
        return water;
    }
    
    
   
    
        
}
