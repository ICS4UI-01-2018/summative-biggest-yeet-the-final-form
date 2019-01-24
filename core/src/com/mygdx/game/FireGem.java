/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * Creates a FireGem as a subclass of Gem to use in a Fireboy and Watergirl
 * game.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class FireGem extends Gem {

    /**
     * Initializes a FireGem as subclass of Gem using its Texture, and its x and
     * y position.
     *
     * @param x a float representing the x coordinate of the FireGem
     * @param y a float representing the y coordinate of the FireGem
     */
    public FireGem(float x, float y) {
        super(new Texture("FireGem.jpg"), x, y);
    }

    /**
     * Determines whether a Fireboy has collected the FireGem.
     *
     * @param fireboy a Character representing a Fireboy
     * @return a boolean representing whether if a Fireboy has collected the
     * FireGem yet
     */
    public boolean collision(Fireboy fireboy) {
        return super.getBounds().overlaps(fireboy.getBounds());
    }
}
