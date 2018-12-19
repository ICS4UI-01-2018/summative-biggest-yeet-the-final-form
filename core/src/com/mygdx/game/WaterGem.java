/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

/**
 * Creates a WaterGem as a subclass of Gem to use in a game of Fireboy and
 * Watergirl. Only the Watergirl can collect WaterGems.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class WaterGem extends Gem {

    /**
     * Initializes WaterGem as subclass of Gem using the x and y coordinates of
     * the WaterGem.
     *
     * @param x a float representing the x coordinate of the WaterGem
     * @param y a float representing the y coordinate of the WaterGem
     */
    public WaterGem(float x, float y) {
        super(x, y);
    }

    /**
     * Determines if the Watergirl collected the WaterGem.
     *
     * @param watergirl a Watergirl in the game
     * @return a boolean representing if the Watergirl collected the WaterGem
     */
    public boolean collision(Watergirl watergirl) {
        return super.gem.overlaps(watergirl.getBounds());
    }
}
