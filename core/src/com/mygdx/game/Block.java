/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

/**
 * A Block in a game of Fireboy and Watergirl that inherits from the class
 * Platform. This acts as an obstacle that the Fireboy and Watergirl will have
 * to work around through the Levels of the game.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Block extends Platform {

    /**
     * Initializes a Block in a game of Fireboy and Watergirl using its x and y
     * position, and its width and height.
     *
     * @param x a float representing the x position of the Block
     * @param y a float representing the y position of the Block
     * @param width a float representing the width of the Block
     * @param height a float representing the height of the Block
     */
    public Block(float x, float y, float width, float height) {
        super(x, y, width, height);
    }
}
