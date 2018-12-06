/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

/**
 * Creates mud as a subclass of Obstacle to use in a game of Fireboy and
 * Watergirl. The Mud kills both the Fireboy and Watergirl.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Mud extends Obstacle {

    private Rectangle mud;

    public Mud(int width, int height, float x, float y) {
        super(x, y, width, height);
    }

    /**
     * Determines whether if a Character falls into the mud.
     *
     * @param character a Character being played in the game
     * @return a boolean representing whether if a Character has fallen into the
     * mud
     */
    public boolean collision(Character character) {
        return super.obstacle.overlaps(character.getBounds());
    }
}
