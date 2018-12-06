package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MyGdxGame extends ApplicationAdapter {

    SpriteBatch batch;
    private ShapeRenderer shapeBatch;
    Texture img;
    private Fireboy fireboy;
    private Watergirl watergirl;
    private Platform test;
    private OrthographicCamera cam;
    private FitViewport viewport;
    
   
    

    @Override
    public void create() {
        batch = new SpriteBatch();
        shapeBatch = new ShapeRenderer();
        
        cam = new OrthographicCamera();
        viewport = new FitViewport(672, 544, cam);
        viewport.apply();
        
        
        cam.position.x = 336;
        cam.position.y = 272;
        cam.update();
        
        this.fireboy = new Fireboy(32,32);
        this.watergirl = new Watergirl(32,112);
        this.test = new Platform (50,10,30,24);
        
        
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            fireboy.jump();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            fireboy.moveRight();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            fireboy.moveLeft();
        }
        
        batch.begin();
        shapeBatch.setProjectionMatrix(cam.combined);
        shapeBatch.begin(ShapeRenderer.ShapeType.Filled);
        shapeBatch.setColor(Color.FOREST);
        fireboy.draw(shapeBatch);
        test.draw(shapeBatch);
        shapeBatch.end();
        batch.end();
        batch.setProjectionMatrix(cam.combined);
        
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
