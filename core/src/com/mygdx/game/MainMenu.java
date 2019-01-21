/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Create the Main Menu screen as a subclass of Screen.
 * 
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class MainMenu extends Screen {

    private Texture mainMenuScreen;

    @Override
    public void create() {
        // initialize the SpriteBatch, ShapeRenderer, Camera, and FitViewport
        super.create();

        // initialize the main menu screen
        // this.mainMenuScreen = new Texture("");
    }

    @Override
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
