/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

/**
 * Creates Mud as a subclass of Obstacle to use in a game of Fireboy and
 * Watergirl. The Mud kills both the Fireboy and Watergirl.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Mud extends Obstacle {

    /**
     * Initializes Mud as a subclass of Obstacle using the Mud's x and y
     * coordinates, and it's width and height.
     *
     * @param x a float representing the x coordinate of the Mud
     * @param y a float representing the y coordinate of the Mud
     * @param width an integer representing the width of the Mud
     * @param height an integer representing the height of the Mud
     */
    public Mud(float x, float y, int width, int height) {
        super(x, y, width, height);
    }
}
