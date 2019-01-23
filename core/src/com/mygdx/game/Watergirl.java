/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Creates a Watergirl as a subclass of Character to use in a game of Fireboy
 * and Watergirl.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Watergirl extends Character {

    /**
     * Creates a Watergirl using it's x and y position on the screen.
     *
     * @param x an integer representing the x position of the Watergirl
     * @param y an integer representing the y position of the Watergirl
     */
    public Watergirl(float x, float y) {
        super(new Texture("WaterGirlStanding.jpg"), new Texture("WaterGirlWalkingLeft.jpg"), new Texture("WaterGirlWalkingRight.jpg"), x, y);
    }
}
