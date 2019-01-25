/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

/**
 * Creates a GameComplete Screen when Fireboy and Watergirl have been won.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class GameComplete extends Screen {

    private Texture gameCompleteScreen;

    /**
     * Create the GameComplete Screen.
     */
    @Override
    public void create() {
        // initialize the SpriteBatch, ShapeRenderer, Camera, and FitViewport
        super.create();

        // initialize the Screen Texture
        this.gameCompleteScreen = new Texture("GameComplete.jpg");
    }

    /**
     * Clear the background of the Screen, and draw the game complete Screen.
     */
    @Override
    public void render() {
        // clear the background
        super.render();

        // allow the drawing of the main menu screen
        super.getSpriteBatch().begin();
        // draw the main menu screen
        super.getSpriteBatch().draw(this.gameCompleteScreen, 0, 0, 672, 544);
        // end of Texture drawing
        super.getSpriteBatch().end();
    }
    
    /**
     * Determine if the next Screen can be displayed.
     *
     * @return a boolean representing whether if the next Screen can be
     * displayed
     */
    public boolean goNext() {
        // determine if the screen is being displayed
        if (super.getDisplay()) {
            // determine if the space bar is pressed
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                // set the display to be off
                super.setDisplay(false);
                return true;
            }
        }
        return false;
    }
}
