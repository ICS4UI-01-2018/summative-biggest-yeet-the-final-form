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
    // create a new Level
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
        // initialize the Level
        this.level = new Level();
        // initialize the SpriteBatch and the ShapeRenderer
        this.batch = new SpriteBatch();
        this.shapeBatch = new ShapeRenderer();
        // initialize the OrthographicCamera and the FitViewport
        this.camera = new OrthographicCamera();
        this.viewport = new FitViewport(672, 544, this.camera);
        this.viewport.apply();
        this.camera.position.x = 336;
        this.camera.position.y = 272;
        this.camera.update();
        // initialize the variable for the height
        this.newHeight = 32;
        // Fireboy and Watergirl haven't won the level yet
        this.levelWon = false;

        // initialize the Characters
        this.fireboy = new Fireboy(616, 32);
        this.watergirl = new Watergirl(32, 32);

        // initialize the Platforms
        
        // initialize the Obstacles
        this.fire = new Fire[3];
        this.fire[0] = new Fire(544, 160, 48, 16);
        this.fire[1] = new Fire(584, 464, 72, 16);
        this.fire[2] = new Fire(352, 272, 112, 16);
        this.water = new Water[3];
        this.water[0] = new Water(80, 160, 48, 16);
        this.water[1] = new Water(32, 464, 72, 16);
        this.water[2] = new Water(208, 272, 112, 16);
        this.mud = new Mud[4];
        this.mud[0] = new Mud(144, 16, 112, 16);
        this.mud[1] = new Mud(272, 16, 48, 16);
        this.mud[2] = new Mud(352, 16, 48, 16);
        this.mud[3] = new Mud(416, 16, 112, 16);
        this.buttons = new Button[1];
        this.buttons[0] = new Button(328, 128);

//        // initialize the Gems
//        this.fireGems = new FireGem[8];
//        this.fireGems[0] = new FireGem();
//        this.fireGems[1] = new FireGem();
//        this.fireGems[2] = new FireGem();
//        this.fireGems[3] = new FireGem();
//        this.fireGems[4] = new FireGem();
//        this.fireGems[5] = new FireGem();
//        this.fireGems[6] = new FireGem();
//        this.fireGems[7] = new FireGem();
//        this.waterGems = new WaterGem[8];
//        this.waterGems[0] = new WaterGem();
//        this.waterGems[1] = new WaterGem();
//        this.waterGems[2] = new WaterGem();
//        this.waterGems[3] = new WaterGem();
//        this.waterGems[4] = new WaterGem();
//        this.waterGems[5] = new WaterGem();
//        this.waterGems[6] = new WaterGem();
//        this.waterGems[7] = new WaterGem();
        
        // initialize the Doors
        this.fireDoor = new FireDoor(24, 144);
        this.waterDoor = new WaterDoor(616, 144);
    }

    @Override
    public void render() {
        // clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // begin drawing
        this.level.beginDraw(this.batch, this.shapeBatch, this.camera);
        // draw the background
        this.level.drawBackground(this.shapeBatch);
        // draw the Obstacles
        this.level.drawObstacles(this.shapeBatch, this.fire, this.water, this.mud, this.buttons);
        // draw the Doors
        this.level.drawDoors(this.shapeBatch, this.fireDoor, this.waterDoor);
        // draw the Characters
        this.level.drawCharacters(this.shapeBatch, this.fireboy, this.watergirl);
        // end drawing
        this.level.endDraw(this.batch, this.shapeBatch, this.camera);
    }

    @Override
    public void dispose() {
        this.batch.dispose();
    }

    /**
     * Resizes the screen so that the game doesn't look distorted.
     *
     * @param width an integer representing the width of the original screen
     * @param height an integer representing the height of the original screen
     */
    @Override
    public void resize(int width, int height) {
        this.viewport.update(width, height);
    }
}
