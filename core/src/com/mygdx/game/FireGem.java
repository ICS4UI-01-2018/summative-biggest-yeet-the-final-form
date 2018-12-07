/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

/**
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class FireGem extends Gem{
    /**
     * initalizes fire gem as subclass of gem with "fireboy" as char allowed
     * @param x the x coordinate
     * @param y the y coordinate
     * @param width the width
     * @param height the height
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
        return super.gem.overlaps(fireboy.getBounds());
    }
}
