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
    Texture img;
    private Fireboy fireboy;
    private Watergirl watergirl;
    private OrthographicCamera cam;
    private FitViewport viewport;
    private ShapeRenderer shapeBatch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        shapeBatch = new ShapeRenderer();

        cam = new OrthographicCamera(672, 544);
        viewport = new FitViewport(672, 544, cam);
        viewport.apply();

        cam.position.x = 336;
        cam.position.y = 272;
        cam.update();

        fireboy = new Fireboy(30, 30);
        watergirl = new Watergirl(20, 20);

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            watergirl.moveRight();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            watergirl.moveLeft();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            fireboy.moveLeft();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            fireboy.moveRight();
        }

        shapeBatch.setProjectionMatrix(cam.combined);
        shapeBatch.begin(ShapeRenderer.ShapeType.Line);

        shapeBatch.setColor(Color.RED);
        fireboy.draw(shapeBatch);
        watergirl.draw(shapeBatch);

        shapeBatch.end();
        
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
