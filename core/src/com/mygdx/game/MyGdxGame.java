package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MyGdxGame extends ApplicationAdapter {

    // Characters
    private Fireboy fireboy;
    private Watergirl watergirl;

    // an array to store all of the Platforms
    private Platform[] platforms;

    // Water and Fire pools
    private Water water;
    private Fire fire;
    
    private OrthographicCamera camera;
    private FitViewport viewport;
    private ShapeRenderer shapeBatch;
    private SpriteBatch batch;

    @Override
    public void create() {
        // intialize the SpriteBatch and the ShapeRenderer
        batch = new SpriteBatch();
        shapeBatch = new ShapeRenderer();

        // initialize the Platform array
        this.platforms = new Platform[10];
        
        // initialize the camera and the viewport
        this.camera = new OrthographicCamera();
        this.viewport = new FitViewport(672, 544, camera);
        this.viewport.apply();
        this.camera.position.x = 336;
        this.camera.position.y = 272;
        this.camera.update();

        // initialize the Characters
        this.fireboy = new Fireboy(32, 32);
        this.watergirl = new Watergirl(32, 112);

        // initialize the Platforms
        this.platforms[0] = new Platform(0, 0, 336, 32);
        this.platforms[1] = new Platform(0, 32, 16, 512);
        this.platforms[2] = new Platform(336, 0, 64, 16);
        this.platforms[3] = new Platform(400, 0, 32, 32);
        this.platforms[4] = new Platform(432, 0, 64, 16);
        this.platforms[5] = new Platform(496, 0, 176, 32);
        
        // create the Fire and the Water pools
        this.fire = new Fire(336, 16, 64, 16);
        this.water = new Water(432, 16, 64, 16);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Fireboy keyboard listeners
        // make the Fireboy jump
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            fireboy.jump();
        }
        // make the Fireboy move right
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            fireboy.moveRight();
        }
        // make the Fireboy move left
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
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
        fireboy.updatePostions();
        watergirl.updatePostions();

        // start drawing
        batch.begin();
        shapeBatch.setProjectionMatrix(camera.combined);
        shapeBatch.begin(ShapeRenderer.ShapeType.Filled);

        // change background colour
        shapeBatch.setColor(Color.BLACK);
        shapeBatch.rect(0, 0, 672, 544);

        // draw the Fireboy
        shapeBatch.setColor(Color.RED);
        fireboy.draw(shapeBatch);

        // draw the Watergirl
        shapeBatch.setColor(Color.BLUE);
        watergirl.draw(shapeBatch);

        // draw the Platforms
        shapeBatch.setColor(Color.WHITE);
        platforms[0].draw(shapeBatch);
        platforms[1].draw(shapeBatch);
        platforms[2].draw(shapeBatch);
        platforms[3].draw(shapeBatch);
        platforms[4].draw(shapeBatch);
        platforms[5].draw(shapeBatch);
        
//        for (int i = 0; i < this.platforms.length; i++) {
//            platforms[i].draw(shapeBatch);
//        }

        // draw the Fire and the Water
        shapeBatch.setColor(Color.MAGENTA);
        fire.draw(shapeBatch);
        shapeBatch.setColor(Color.CYAN);
        water.draw(shapeBatch);
        
        // end drawing
        shapeBatch.end();
        batch.end();
        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
