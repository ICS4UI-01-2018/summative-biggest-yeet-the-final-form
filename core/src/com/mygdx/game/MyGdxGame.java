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
import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {

    // Characters
    private Fireboy fireboy;
    private Watergirl watergirl;
    private Platform test;
    private OrthographicCamera cam;
    private FitViewport viewport;

    @Override
    public void create() {
        // intialize the SpriteBatch and the ShapeRenderer
        batch = new SpriteBatch();
        shapeBatch = new ShapeRenderer();
        
        // initialize the camera and the viewport
        this.camera = new OrthographicCamera();
        this.viewport = new FitViewport(672, 544, camera);
        this.viewport.apply();
        this.camera.position.x = 336;
        this.camera.position.y = 272;
        this.camera.update();
        
        // initialize the Characters
        this.fireboy = new Fireboy(32,32);
        this.watergirl = new Watergirl(32,112);
        this.test = new Platform (50,10,30,24);
        
        
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       
        
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            fireboy.jump();
        }
        // make the Fireboy move right
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            fireboy.moveRight();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            fireboy.moveLeft();
        }
        
        // Watergirl keyboard listeners
        // make the Watergirl jump
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            watergirl.jump();
        }
        // make the Watergirl move right
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            watergirl.moveRight();
        }
        // make the Waterfirl move left
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            watergirl.moveLeft();
        }
        
        // constantly update the x and y positions of the Fireboy and the Watergirl
        fireboy.updatePositions();
        watergirl.updatePositions();
        
        batch.begin();
        shapeBatch.setProjectionMatrix(camera.combined);
        shapeBatch.begin(ShapeRenderer.ShapeType.Filled);
        shapeBatch.setColor(Color.FOREST);
        fireboy.draw(shapeBatch);
        test.draw(shapeBatch);
        shapeBatch.end();
        batch.end();
        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
    
    @Override
        public void resize(int width, int height){
            viewport.update(width, height);
            
        }
}
