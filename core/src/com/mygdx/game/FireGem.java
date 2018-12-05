/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

/**
 * Creates a FireGem as a subclass of Gem to use in a Fireboy and Watergirl
 * game.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class FireGem extends Gem {

    /**
     * Initializes FireGem as a subclass of Gem, using the FireGem's x and y
     * coordinates on the screen.
     *
     * @param x a float representing the x coordinate of the FireGem
     * @param y a float representing the y coordinate of the FireGem
     */
    public FireGem(float x, float y) {
        super(x, y);
    }

    /**
     * Determines whether a Fireboy has collected the FireGem.
     *
     * @param fireboy a Fireboy used in a game of Fireboy and Watergirl
     * @return a boolean representing whether if a Fireboy has collected a
     * FireGem yet
     */
    public boolean collision(Fireboy fireboy) {
        // determines whether if the Fireboy has collected the FireGem yet
        return super.gem.overlaps(fireboy.getBounds());
    }
}
