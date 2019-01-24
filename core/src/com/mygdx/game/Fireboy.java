/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * Creates a Fireboy as a subclass of Character to use in a game of Fireboy and
 * Watergirl.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Fireboy extends Character {

    /**
     * Creates a Fireboy using its front-side Texture, its left-side Texture,
     * its right-side Texture, and its x and y position on the screen.
     *
     * @param x an integer representing the x position of the Fireboy
     * @param y an integer representing the y position of the Fireboy
     */
    public Fireboy(float x, float y) {
        super(new Texture("FireBoyStanding.jpg"), new Texture("FireBoyWalkingLeft.jpg"), new Texture("FireBoyWalkingRight.jpg"), x, y);
    }
}
