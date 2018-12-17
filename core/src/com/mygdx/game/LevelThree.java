/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Level Three of the Fireboy and Watergirl game.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class LevelThree extends ApplicationAdapter {

    private OrthographicCamera camera;
    private FitViewport viewport;
    private ShapeRenderer shapeBatch;
    private SpriteBatch batch;
    // creates a new Level
    private Level level;
    // Characters
    private Fireboy fireboy;
    private Watergirl watergirl;
    // an array to store all of the Platforms
    private Platform[] platforms;
    // Obstacles
    private Water[] water;
    private Fire[] fire;
    private Mud[] mud;
    private Button[] buttons;
    // arrays to store all of the Gems
    private FireGem[] fireGems;
    private WaterGem[] waterGems;
    // Doors
    private FireDoor fireDoor;
    private WaterDoor waterDoor;
    // landing variable
    private float newHeight;
    // variable to determine whether or not if Fireboy and Watergirl passed the level
    private boolean levelWon;

    @Override
    public void create() {
        // create a new Level of Fireboy and Watergirl
        this.level = new Level();

        // initializes SpriteBatch, ShapeRenderer, Camera, Viewport, the winning variable, and the jumping variable
        this.level.initialize(this.batch, this.shapeBatch, this.camera, this.viewport, this.levelWon, this.newHeight);

        // initialize the Characters
        this.fireboy = new Fireboy(616, 32);
        this.watergirl = new Watergirl(32, 32);

        // initialize the Platforms
        // initialize the Obstacles
        // initialize the Gems
    }

    @Override
    public void render() {
        // clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        // start drawing
        this.level.startDrawing(this.batch, this.shapeBatch, this.camera);
        // draw the background
        this.level.drawBackground(this.shapeBatch);
        // draw the Characters
        this.level.drawCharacters(this.shapeBatch, this.fireboy, this.watergirl);
        // end drawing
        this.level.endDrawing(this.batch, this.shapeBatch, this.camera);
    }
}
