/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Creates a Fireboy as a subclass of Character to use in a game of Fireboy and
 * Watergirl.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Fireboy extends Character {

    /**
     * Creates a Fireboy using it's x and y position on the screen.
     */
    public Fireboy(float x, float y) {
        super(x, y);
    }

    /**
     * Draws a red rectangle on the screen using a ShapeRenderer to represent a
     * Fireboy.
     *
     * @param shapeBatch a ShapeRenderer used to draw with
     */
    @Override
    public void draw(ShapeRenderer shapeBatch) {
        // set the Fireboy to be red
        shapeBatch.setColor(Color.RED);
        // draw the Fireboy on the screen
        super.draw(shapeBatch);
    }
}
