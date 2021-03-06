/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * Creates a WaterGem as a subclass of Gem to use in a game of Fireboy and
 * Watergirl. Only the Watergirl can collect WaterGems.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class WaterGem extends Gem {

    /**
     * Initializes WaterGem using its Texture, and its x and y positions.
     *
     * @param x a float representing the x coordinate of the WaterGem
     * @param y a float representing the y coordinate of the WaterGem
     */
    public WaterGem(float x, float y) {
        super(new Texture("WaterGem.jpg"), x, y);
    }

    /**
     * Determines if the Watergirl collected the WaterGem.
     *
     * @param watergirl a Character representing a Watergirl
     * @return a boolean representing if the Watergirl collected the WaterGem or
     * not
     */
    public boolean collision(Watergirl watergirl) {
        return super.getBounds().overlaps(watergirl.getBounds());
    }
}
