package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

/**
 * Level One of the Fireboy and Watergirl game.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class LevelOne extends Level {

    @Override
    public void create() {
        // initialize the SpriteBatch, ShapeRenderer, Camera, FitViewport, and a boolean to determine whether the game has been won
        super.create();

        // initialize the Characters
        int[] coordinates = {2, 30};
        super.fireboy(super.multiplesOf20(coordinates));
        
        // initialize the Platforms
        // initialize the MovingPlatforms
        
        // initialize Fire
        // initialize Water
        // initialize Mud
        // initialize Buttons
        
        // initialize FireGems
        // initialize WaterGems
        
        // initialize the FireDoor
        // initialize the WaterDoor
    }
}
