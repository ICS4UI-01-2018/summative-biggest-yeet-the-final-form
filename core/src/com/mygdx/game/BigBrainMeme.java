/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * The final screen in the greatest Walmart version of Fireboy and Watergirl out
 * there. Since we started with a meme, we thought we'd end on a wholesome meme.
 * On behalf of the biGgEsT yEeT: tHe fiNaL fOrM, thank you :)
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class BigBrainMeme extends Screen {

    private Texture bigBrainMeme;
    
    /**
     * Initialize the super class, and the big brain meme.
     */
    @Override
    public void create() {
        // initialize the super class
        super.create();
        
        // initialize the BigBrain meme Texture
        this.bigBrainMeme = new Texture("BigBrain.jpg");
    }
    
    /**
     * Draw the big brain meme on the Screen.
     */
    @Override
    public void render() {
        // clear the background
        super.render();

        // allow the drawing of the main menu screen
        super.getSpriteBatch().begin();
        // draw the BigBrainMeme Screen
        super.getSpriteBatch().draw(this.bigBrainMeme, 200, 0, 250, 490);
        // end of Texture drawing
        super.getSpriteBatch().end();
    }
}
