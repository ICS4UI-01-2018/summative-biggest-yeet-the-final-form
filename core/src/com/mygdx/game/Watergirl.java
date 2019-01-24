/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * Creates a Watergirl as a subclass of Character to use in a game of Fireboy
 * and Watergirl.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Watergirl extends Character {

    /**
     * Creates a Watergirl using its front-side Texture, its left-side Texture,
     * its right-side Texture, and its x and y position.
     *
     * @param x a float representing the x position of the Watergirl
     * @param y a float representing the y position of the Watergirl
     */
    public Watergirl(float x, float y) {
        super(new Texture("WaterGirlStanding.jpg"), new Texture("WaterGirlWalkingLeft.jpg"), new Texture("WaterGirlWalkingRight.jpg"), x, y);
    }
}
