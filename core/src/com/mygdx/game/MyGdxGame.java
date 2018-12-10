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

    // arrays to store all of the Gems
    private FireGem[] fireGems;
    private WaterGem[] waterGems;

    // Doors
    private FireDoor fireDoor;
    private WaterDoor waterDoor;

    private OrthographicCamera camera;
    private FitViewport viewport;
    private ShapeRenderer shapeBatch;
    private SpriteBatch batch;

    //landing variable
    private float newHeight;

    // variable to determine whether or not if Fireboy and Watergirl passed the level
    private boolean gameWon;

    @Override
    public void create() {
        // intialize the SpriteBatch and the ShapeRenderer
        this.batch = new SpriteBatch();
        this.shapeBatch = new ShapeRenderer();

        // initialize the camera and the viewport
        this.camera = new OrthographicCamera();
        this.viewport = new FitViewport(672, 544, this.camera);
        this.viewport.apply();
        this.camera.position.x = 336;
        this.camera.position.y = 272;
        this.camera.update();
        
        //dont worry about it bois
        this.newHeight = 0;
        
        // initialize the Platforms
        this.platforms = new Platform[30];
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
        this.platforms[12] = new Platform(416, 144, 64, 16);
        this.platforms[13] = new Platform(460, 144, 96, 32);
        this.platforms[14] = new Platform(608, 208, 48, 64);
        this.platforms[15] = new Platform(560, 224, 48, 48);
        this.platforms[16] = new Platform(336, 240, 224, 32);
        this.platforms[17] = new Platform(304, 240, 32, 48);
        this.platforms[18] = new Platform(96, 256, 208, 32);
        this.platforms[19] = new Platform(16, 336, 64, 96);
        this.platforms[20] = new Platform(80, 336, 256, 32);
        this.platforms[21] = new Platform(336, 336, 144, 64);
        this.platforms[22] = new Platform(480, 320, 32, 48);
        this.platforms[23] = new Platform(512, 320, 64, 32);
        this.platforms[24] = new Platform(272, 432, 384, 32);
        this.platforms[25] = new Platform(448, 464, 64, 16);
        this.platforms[26] = new Platform(176, 400, 96, 64);
        this.platforms[27] = new Platform(128, 448, 48, 16);
        this.platforms[28] = new Platform(16, 528, 640, 16);
        this.platforms[29] = new Platform(288, 512, 96, 32);

        // initialize the Characters
        this.fireboy = new Fireboy(32, 32);
        this.watergirl = new Watergirl(32, 112);

        // create the Obstacles
        this.fire = new Fire(336, 16, 64, 16);
        this.water = new Water(432, 16, 64, 16);
        this.mud = new Mud(416, 160, 64, 16);

        // initialize the Gems
        this.fireGems = new FireGem[4];
        this.fireGems[0] = new FireGem(360, 64);
        this.fireGems[1] = new FireGem(112, 304);
        this.fireGems[2] = new FireGem(144, 480);
        this.fireGems[3] = new FireGem(304, 480);
        this.waterGems = new WaterGem[4];
        this.waterGems[0] = new WaterGem(440, 64);
        this.waterGems[1] = new WaterGem(352, 288);
        this.waterGems[2] = new WaterGem(32, 448);
        this.waterGems[3] = new WaterGem(352, 480);

        // initialize the Doors
        this.fireDoor = new FireDoor(544, 464);
        this.waterDoor = new WaterDoor(592, 464);
        
        this.gameWon = false;
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // constantly update the x and y positions of the Fireboy and the Watergirl
        this.fireboy.updatePostions();
        this.watergirl.updatePostions();

        this.newHeight = fireboy.newGround(this.platforms);
     //   System.out.println("new Height " + this.newHeight);
        fireboy.jumpAction(this.newHeight);

        fireboy.falling(this.newHeight, fireboy.standing(this.platforms));
        
        this.newHeight = this.watergirl.newGround(this.platforms);
        this.watergirl.jumpAction(this.newHeight);
        this.watergirl.falling(this.newHeight, this.watergirl.standing(this.platforms));
        
        // Fireboy keyboard listeners
        // make the Fireboy move left
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.fireboy.moveLeft();
        }
        // make the Fireboy move right
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.fireboy.moveRight();
        }
        // make the Fireboy jump
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.fireboy.jump();
        }

        // Watergirl keyboard listeners
        // make the Watergirl move left
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            this.watergirl.moveLeft();
        }
        // make the Watergirl move right
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            this.watergirl.moveRight();
        }
        // make the Watergirl jump
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            this.watergirl.jump();
        }

        // allow the Fireboy to collect the FireGems
        for (FireGem fireGem : this.fireGems) {
            // determine if the Fireboy has collected the FireGem
            if (fireGem.collision(this.fireboy)) {
                // don't draw the FireGem on the screen
                fireGem.collected();
                // add to the Fireboy's FireGem count
                this.fireboy.addGem();
            }
        }

        // allow the Watergirl to collect the WaterGems
        for (WaterGem waterGem : this.waterGems) {
            // determine if the Watergirl has collected the WaterGem
            if (waterGem.collision(this.watergirl)) {
                // don't draw the WaterGem on the screen
                waterGem.collected();
                // add to the Watergirl's WaterGem count
                this.watergirl.addGem();
            }
        }

        // allow the Fireboy to die when it comes into contact with Mud or Water
        if (this.water.collision(this.fireboy) || this.mud.collision(this.fireboy)) {
            // set the Fireboy to be dead
            this.fireboy.died();
        }

        // allow the Watergirl to die when it comes into contact with Mud or Fire
        if (this.fire.collision(this.watergirl) || this.mud.collision(this.watergirl)) {
            // set the Watergirl to be dead
            this.watergirl.died();
        }

        // win the game if Fireboy and Watergirl stand in front of their respected Doors
        if (this.fireDoor.collision(this.fireboy) && this.waterDoor.collision(this.watergirl)) {
            this.gameWon = true;
        }

        // start drawing
        this.batch.begin();
        this.shapeBatch.setProjectionMatrix(this.camera.combined);
        this.shapeBatch.begin(ShapeRenderer.ShapeType.Filled);

        // set the background colour to be black
        this.shapeBatch.setColor(Color.BLACK);
        this.shapeBatch.rect(0, 0, 672, 544);

        // draw the Platforms
        this.shapeBatch.setColor(Color.WHITE);
        for (Platform platform : this.platforms) {
            platform.draw(this.shapeBatch);
        }

        // draw the Characters if they aren't dead yet
        this.shapeBatch.setColor(Color.RED);
        if (!this.fireboy.isDead()) {
            this.fireboy.draw(this.shapeBatch);
        }
        this.shapeBatch.setColor(Color.BLUE);
        if (!this.watergirl.isDead()) {
            this.watergirl.draw(shapeBatch);
        }

        // draw the Obstacles
        shapeBatch.setColor(Color.MAGENTA);
        fire.draw(shapeBatch);
        shapeBatch.setColor(Color.CYAN);
        water.draw(shapeBatch);
        shapeBatch.setColor(Color.FOREST);
        mud.draw(shapeBatch);

        // draw the Gems
        shapeBatch.setColor(Color.RED);
        for (FireGem fireGem : this.fireGems) {
            // only draw the FireGem if it hasn't been collected by the Fireboy yet
            if (fireGem.isCollected()) {
            } else {
                fireGem.draw(shapeBatch);
            }
        }
        shapeBatch.setColor(Color.BLUE);
        for (WaterGem waterGem : this.waterGems) {
            // only draw the WaterGem if it hasn't been collected by the Watergirl yet
            if (!waterGem.isCollected()) {
                waterGem.draw(shapeBatch);
            }
        }

        // draw the Doors
        this.shapeBatch.setColor(Color.MAGENTA);
        this.fireDoor.draw(this.shapeBatch);
        this.shapeBatch.setColor(Color.CYAN);
        this.waterDoor.draw(this.shapeBatch);

        // end drawing
        this.shapeBatch.end();
        this.batch.end();
        this.batch.setProjectionMatrix(this.camera.combined);
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
        viewport.update(width, height);
    }
}
