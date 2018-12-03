/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 *
 * @author camet2651
 */
public class TestGame {
    
    private SpriteBatch batch;
    private Character player1;
    private OrthographicCamera cam;
    private ShapeRenderer shapeBatch;
    private FitViewport viewport;
    private Texture ballPic;

    public void create() {
        batch = new SpriteBatch();
        shapeBatch = new ShapeRenderer();
        player1 = new Character("null", 250, 25);
       cam = new OrthographicCamera(800, 600);
        viewport = new FitViewport(800,600,cam);
        viewport.apply();
        cam.position.x = 400;
        cam.position.y = 300;
        cam.update();
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            player1.jump();
        }
            
        shapeBatch.setProjectionMatrix(cam.combined);
        shapeBatch.begin(ShapeRenderer.ShapeType.Filled);
        shapeBatch.setColor(Color.SLATE);
        player1.draw(shapeBatch);
        shapeBatch.end();          
    }

    public void dispose() {
        batch.dispose();
    }
    
    public void resize (int width, int height){
        viewport.update(width, height);
    }
}
