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

    // Obstacles
    private Water water;
    private Fire fire;
    private Mud mud;

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
        this.platforms = new Platform[31];

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
        this.platforms[6] = new Platform(592, 32, 64, 64);
        this.platforms[7] = new Platform(656, 32, 16, 512);
        this.platforms[8] = new Platform(16, 80, 192, 32);
        this.platforms[9] = new Platform(16, 160, 256, 32);
        this.platforms[10] = new Platform(256, 144, 32, 48);
        this.platforms[11] = new Platform(288, 144, 128, 32);
        this.platforms[12] = new Platform(400, 112, 32, 32);
        this.platforms[13] = new Platform(416, 144, 64, 16);
        this.platforms[14] = new Platform(460, 144, 96, 32);
        this.platforms[15] = new Platform(608, 208, 48, 64);
        this.platforms[16] = new Platform(560, 224, 48, 48);
        this.platforms[17] = new Platform(336, 240, 224, 32);
        this.platforms[18] = new Platform(304, 240, 32, 48);
        this.platforms[19] = new Platform(96, 256, 208, 32);
        this.platforms[20] = new Platform(16, 336, 64, 96);
        this.platforms[21] = new Platform(80, 336, 256, 32);
        this.platforms[22] = new Platform(336, 336, 144, 64);
        this.platforms[23] = new Platform(480, 320, 32, 48);
        this.platforms[24] = new Platform(512, 320, 64, 32);

        this.platforms[29] = new Platform(16, 528, 640, 16);
        this.platforms[30] = new Platform(288, 512, 96, 32);

        // create the Obstacles
        this.fire = new Fire(336, 16, 64, 16);
        this.water = new Water(432, 16, 64, 16);
        this.mud = new Mud(416, 160, 64, 16);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Fireboy keyboard listeners
        // make the Fireboy move left
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            fireboy.moveLeft();
        }
        // make the Fireboy move right
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            fireboy.moveRight();
        }
        // make the Fireboy jump
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            fireboy.jump();
        }

        // Watergirl keyboard listeners
        // make the Watergirl move left
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            watergirl.moveLeft();
        }
        // make the Watergirl move right
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            watergirl.moveRight();
        }
        // make the Watergirl jump
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            watergirl.jump();
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
        for (int i = 0; i < 25; i++) {
            platforms[i].draw(shapeBatch);
        }

        platforms[29].draw(shapeBatch);
        platforms[30].draw(shapeBatch);

        // draw the Obstacles
        shapeBatch.setColor(Color.MAGENTA);
        fire.draw(shapeBatch);
        shapeBatch.setColor(Color.CYAN);
        water.draw(shapeBatch);
        shapeBatch.setColor(Color.FOREST);
        mud.draw(shapeBatch);

        // end drawing
        shapeBatch.end();
        batch.end();
        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}
