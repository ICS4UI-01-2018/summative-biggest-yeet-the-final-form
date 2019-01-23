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
 * Create the Main Menu screen as a subclass of Screen.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class MainMenu extends Screen {

    boolean x;
    private Texture mainMenuScreen;

    /**
     * Create the MainMenu of the game and allow it to be displayed first.
     */
    @Override
    public void create() {
        // initialize the SpriteBatch, ShapeRenderer, Camera, and FitViewport
        super.create();

        // set the MainMenu screen to be on first
        super.setDisplay(true);

        // initialize the main menu screen
        this.mainMenuScreen = new Texture("MainMenu.jpg");
    }

    public boolean goNext() {

        // determine if the screen is being displayed
        if (super.getDisplay()) {
            System.out.println("her");
            // determine if the space bar is pressed
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {

                // set the display to be off
                System.out.println("gdd");
                super.setDisplay(false);
                return true;
            }
        }
        return false;
    }
//    @Override

    public void render() {
        // clear the background
        super.render();

        // allow the drawing of the main menu screen
        super.getSpriteBatch().begin();
        // draw the main menu screen
        super.getSpriteBatch().draw(this.mainMenuScreen, 0, 0, 672, 544);
        // end of Texture drawing
        super.getSpriteBatch().end();
    }
}
