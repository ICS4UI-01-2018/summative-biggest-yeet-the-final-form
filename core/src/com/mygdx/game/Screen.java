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
 * Creates a new Screen for game entities to be displayed on.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public abstract class Screen extends ApplicationAdapter {

    private boolean display;
    private OrthographicCamera camera;
    private FitViewport viewport;
    private ShapeRenderer shapeBatch;
    private SpriteBatch batch;

    @Override
    public void create() {
        // initialize the SpriteBatch and the ShapeRenderer
        this.batch = new SpriteBatch();
        this.shapeBatch = new ShapeRenderer();

        // initialize the Camera and the Viewport
        this.camera = new OrthographicCamera();
        this.viewport = new FitViewport(672, 544, this.camera);
        this.viewport.apply();
        this.camera.position.x = 336;
        this.camera.position.y = 272;
        this.camera.update();

        // variable to determine if screen should be displayed to user
        this.display = false;
    }

    @Override
    public void render() {
        // clear the background
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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

    @Override
    public void dispose() {
        this.batch.dispose();
    }

    /**
     * Returns whether if the Screen should be displayed to the user.
     *
     * @return a boolean representing whether if the Screen should be displayed
     * to the user
     */
    public boolean getDisplay() {
        return this.display;
    }

    /**
     * Sets the display to the specified boolean.
     *
     * @param display a boolean representing whether if the Screen should be
     * displayed to the user
     */
    public void setDisplay(boolean display) {
        this.display = display;
    }

    /**
     * Returns the OrthographicCamera.
     *
     * @return an OrthographicCamera
     */
    public OrthographicCamera getCamera() {
        return this.camera;
    }

    /**
     * Returns the FitViewport.
     *
     * @return a FitViewport
     */
    public FitViewport getViewport() {
        return this.viewport;
    }

    /**
     * Returns the ShapeRenderer.
     *
     * @return a ShapeRenderer
     */
    public ShapeRenderer getShapeRenderer() {
        return this.shapeBatch;
    }

    /**
     * Returns the SpriteBatch.
     *
     * @return a SpriteBatch
     */
    public SpriteBatch getSpriteBatch() {
        return this.batch;
    }
}
