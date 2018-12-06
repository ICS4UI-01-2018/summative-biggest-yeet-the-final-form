/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

/**
 * Creates Water to use in a Fireboy and Watergirl game. The water kills the
 * Fireboy when he comes into contact with it.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Water extends Obstacle {

    /**
     * Initializes the Water as a subclass of Obstacle using it's x and y
     * coordinates, and it's width and height.
     *
     * @param x a float representing the x coordinate of the Water
     * @param y a float representing the y coordinate of the Water
     * @param width an integer representing the width of the Water
     * @param height an integer representing the height of the Water
     */
    public Water (int width, int height, float x, float y){
         super (x, y, width, height);
        
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
     * Determine if the Fireboy has touched the Water.
     *
     * @param fireboy the Fireboy in the game
     * @return a boolean representing whether if the Fireboy has touched the
     * Water or not
     */
    public boolean Collision(Fireboy fireboy) {
        return super.obstacle.overlaps(fireboy.getBounds());
    }
}
