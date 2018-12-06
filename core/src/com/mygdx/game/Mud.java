/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

/**
 * Creates mud as a subclass of Obstacle to use in a game of Fireboy and
 * Watergirl. The Mud kills both the Fireboy and Watergirl.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Mud extends Obstacle {

    /**
     * Initializes Mud as a subclass of Obstacle using the x and y coordinates,
     * and it's width and height.
     *
     * @param x a float representing the x coordinate of the Obstacle
     * @param y a float representing the y coordinate of the Obstacle
     * @param width an integer representing the width of the Obstacle
     * @param height an integer representing the height of the Obstacle
     */
    public Mud(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    /**
     * Determines whether if a Character falls into the mud.
     *
     * @param character a Character being played in the game
     * @return a boolean representing whether if a Character has fallen into the
     * mud
     */
    public boolean collision(Character character) {
        return super.obstacle.overlaps(character.getBounds());
    }
}
