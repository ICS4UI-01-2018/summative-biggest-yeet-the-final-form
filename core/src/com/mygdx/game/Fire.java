/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

/**     
 * Creates Fire as a subclass of Obstacle to use in a game of Fireboy and
 * Watergirl. Allows for the creation of a pool of fire which will kill a
 * Watergirl.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Fire extends Obstacle {

    /**
     * Initializes a Fire using it's x and y coordinates on the screen, and it's
     * width and height.
     *
     * @param x a float representing the Fire's x coordinate on the screen
     * @param y a float representing the Fire's y coordinate on the screen
     * @param width an integer representing the width of the Fire
     * @param height an integer representing the height of the Fire
     */
    public Fire(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    /**
     * Determines whether if a Watergirl has fallen into the Fire.
     *
     * @param watergirl a Watergirl used in a game of Fireboy and Watergirl
     * @return a boolean representing whether if the Watergirl has fallen into
     * the Fire or not
     */
    public boolean Collision(Watergirl watergirl) {
        return super.obstacle.overlaps(watergirl.getBounds());
    }
}
