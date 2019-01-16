/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Draws the objects of the games on the screen.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public abstract class Level extends ApplicationAdapter {

    private OrthographicCamera camera;
    private FitViewport viewport;
    private ShapeRenderer shapeBatch;
    private SpriteBatch batch;
    private boolean levelWon;
    Fireboy fireboy;
    Watergirl watergirl;
    Platform[] platforms;
    MovingPlatform[] movingPlatforms;
    Fire[] fire;
    Water[] water;
    Mud[] mud;
    Button[] buttons;
    FireGem[] fireGems;
    WaterGem[] waterGems;
    FireDoor fireDoor;
    WaterDoor waterDoor;

    /**
     * Initializes the SpriteBatch, ShapeRenderer, OrthographicCamera,
     * FitViewport, a variable for height for jumping, and a variable to
     * determine whether if the Fireboy and Watergirl have beat the Level.
     */
    @Override
    public void create() {
        // initialize the SpriteBatch and the ShapeRenderer
        this.batch = new SpriteBatch();
        this.shapeBatch = new ShapeRenderer();

        // initialize the Camera and the Viewport
        this.camera = new OrthographicCamera();
        this.viewport = new FitViewport(840, 680, this.camera);
        this.viewport.apply();
        this.camera.position.x = 420;
        this.camera.position.y = 340;
        this.camera.update();

        // Fireboy and Watergirl haven't won the level yet
        this.levelWon = false;
    }

    /**
     * Implements the basic game logic for Fireboy and Watergirl.
     */
    @Override
    public void render() {
        // clear the background
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // draw the game elements on the screen
        draw();

        // constantly update x and y positions of Characters, MovingPlatforms, and Buttons
        this.fireboy.updatePositions();
        this.watergirl.updatePositions();
        for (Platform platform : this.movingPlatforms) {
            platform.updatePositions();
        }
        for (Button button : this.buttons) {
            button.updatePositions();
        }

        // Fireboy keyboard listeners
        // Fireboy can only move if he hasn't died
        // Watergirl keyboard listeners
        // Watergirl can only move if he hasn't died
        // Characters will die if they come into contact with Mud
        // Fireboy will die if they come into contact with Water
        // Watergirl will die if they come into contact with Fire
        // Buttons will move down if a Character comes into contact with it
        // Buttons will back up if a Character comes into contact with it
        // Level will be completed once the Characters are in front of their respective Doors
        if (this.fireDoor.collision(this.fireboy)
                && this.waterDoor.collision(this.watergirl)) {
            this.levelWon = true;
        }
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

    /**
     * Allows for the drawing of the game objects.
     */
    public void draw() {
        // allows for the drawing of game objects to begin
        this.batch.begin();
        this.shapeBatch.setProjectionMatrix(camera.combined);
        this.shapeBatch.begin(ShapeRenderer.ShapeType.Filled);

        // draws a black background
        this.shapeBatch.setColor(Color.BLACK);
        this.shapeBatch.rect(0, 0, 840, 680);

        // draws the stationary Platforms
        this.shapeBatch.setColor(Color.WHITE);
        for (Platform platform : this.platforms) {
            platform.draw(this.shapeBatch);
        }

        // draws the moving Platforms
        this.shapeBatch.setColor(Color.PURPLE);
        for (MovingPlatform movingPlatform : this.movingPlatforms) {
            movingPlatform.draw(this.shapeBatch);
        }

        // set the FireGems to be red
        this.shapeBatch.setColor(Color.RED);
        // go through the array and draw each FireGem
        for (FireGem fireGem : this.fireGems) {
            // only draw the FireGem if it hasn't been collected by a Fireboy yet
            if (!fireGem.isCollected()) {
                fireGem.draw(this.shapeBatch);
            }
        }

        // set the WaterGems to be blue
        this.shapeBatch.setColor(Color.BLUE);
        // go through the array and draw each WaterGem
        for (WaterGem waterGem : this.waterGems) {
            // only draw the WaterGem if it hasn't been collected by a Watergirl yet
            if (!waterGem.isCollected()) {
                waterGem.draw(this.shapeBatch);
            }
        }

        // set the FireDoor to be magneta
        this.shapeBatch.setColor(Color.MAGENTA);
        this.fireDoor.draw(this.shapeBatch);
        // set the WaterDoor to be cyan
        this.shapeBatch.setColor(Color.CYAN);
        this.waterDoor.draw(this.shapeBatch);

        // go through the array and draw each Fire
        for (Fire fire : this.fire) {
            fire.draw(this.shapeBatch);
        }

        // go through the array and draw each Water
        for (Water water : this.water) {
            water.draw(this.shapeBatch);
        }

        // go through the array and draw each Mud
        for (Mud mud : this.mud) {
            mud.draw(this.shapeBatch);
        }

        // do not draw the Fireboy on the screen if the Fireboy has died
        if (!this.fireboy.isDead()) {
            // set the color of the Fireboy to be red
            this.shapeBatch.setColor(Color.RED);
            this.fireboy.draw(this.shapeBatch);
        }
        // do not draw the Watergirl on the screen if the Watergirl has died
        if (!this.watergirl.isDead()) {
            // set the color of the Watergirl to be blue
            this.shapeBatch.setColor(Color.BLUE);
            this.watergirl.draw(this.shapeBatch);
        }

        // go through the array and draw each Button
        for (Button button : this.buttons) {
            button.draw(this.shapeBatch);
        }

        // draws a level complete screen when the Level has been won using a ShapeRenderer
        if (this.levelWon) {
            this.shapeBatch.setColor(Color.LIME);
            this.shapeBatch.rect(0, 0, 672, 544);
        }

        // allows for the drawing of the game objects to end
        this.shapeBatch.end();
        this.batch.end();
        this.batch.setProjectionMatrix(this.camera.combined);
    }

    /**
     * Multiplies each spot of an integer array by 20.
     *
     * @param integers an array of integers that store all numbers that must be
     * multiplied by 20
     * @return an array of integers that have been multiplied by 20
     */
    public int[] multiplesOf20(int[] integers) {
        // go through the array of integers and multiply each spot by 20
        for (int i = 0; i < integers.length; i++) {
            integers[i] *= 20;
        }
        return integers;
    }

    /**
     * Returns whether if the Level has been won or not.
     *
     * @return a boolean representing whether if the Level has been won or not
     */
    public boolean isLevelWon() {
        return this.levelWon;
    }
}
