/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

/**
 * Ice is an obstacle made as a subclass of Platform in a game of Fireboy and
 * Watergirl. When the Fireboy is on ice, his speed will increase. When the
 * Watergirl is on ice, her speed will decrease.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Ice extends Platform {

    /**
     * Initialize a new piece of Ice using it's x and y positions, and its width
     * and height.
     *
     * @param x a float representing the x position of the Ice
     * @param y a float representing the y position of the Ice
     * @param width a float representing the width of the Ice
     * @param height a float representing the height of the Ice
     */
    public Ice(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    /**
     *
     * @param character
     * @return
     */
    public boolean onIce(Character character) {
        if (character.getBounds().overlaps(this.getBounds())) {
            character.isOnIce(true);
            return true;
        } else {
            character.isOnIce(false);
            return false;
        }
    }
}
