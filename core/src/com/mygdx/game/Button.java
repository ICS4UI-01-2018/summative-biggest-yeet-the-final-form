/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Creates a Button as a subclass of Obstacle to use in a game of Fireboy and
 * Watergirl. The Fireboy and Watergirl can push the button to move Platforms to
 * help each other win the level.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Button extends Obstacle {

    private float speed;
    
    /**
     * Initializes a Button to use in a game of Fireboy and Watergirl using it's
     * x and y position on the screen.
     *
     * @param x a float representing the x coordinate of the Button
     * @param y a float representing the y coordinate of the Button
     */
    public Button(float x, float y) {
        super(x, y, 1, 0.5f);
        
        this.speed = 0.1f;
    }
    
    @Override
    public void draw(ShapeRenderer shapeBatch) {
        // make the Buttons purple
        shapeBatch.setColor(Color.PURPLE);
        // draw the Button
        shapeBatch.rect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
    
    /**
     * Allows for the Button to move down.
     */
    public void moveDown() {
        super.y -= this.speed;
    }
    
    /**
     * Allows for the Button to move up.
     */
    public void moveUp() {
        super.y += this.speed;
    }
}
