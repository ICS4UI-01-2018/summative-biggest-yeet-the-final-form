/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 * Draws the objects of the games on the screen.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Level extends ApplicationAdapter {
//make arraylist

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
        this.viewport = new FitViewport(672, 544, this.camera);
        this.viewport.apply();
        this.camera.position.x = 336;
        this.camera.position.y = 272;
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

        // constantly update the x and y positions of the Characters, the moving Platforms, and the Buttons
        this.fireboy.updatePositions();
        this.watergirl.updatePositions();
        for (MovingPlatform p : this.movingPlatforms) {
            p.updatePositions();
        }
        for (Button b : this.buttons) {
            b.updatePositions();
        }

        // Characters can only move if the level hasn't been won yet
        if (!this.levelWon) {
            // Fireboy keyboard listeners
            // only move the Fireboy if he hasn't died yet
            if (!this.fireboy.isDead()) {
                // make the Fireboy move left
                if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                    this.fireboy.moveLeft();
                }
                // make the Watergirl move right
                if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                    this.fireboy.moveRight();
                }
                // make the Watergirl jump
                if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                    this.fireboy.jump();
                }
                //     block.updatePos(fireboy, platforms); 
                //make fireboy jump
                this.fireboy.jumpAction();
                int counter = 0;
                if (this.movingPlatforms instanceof Platform[]) {
                    Platform[] temp = (Platform[]) this.movingPlatforms;
                    if (temp[0].getBounds().overlaps(fireboy.getBounds())) {
                        System.out.println("true");
                    }
                    //boolean onMoving = fireboy.onTop(temp);

                    System.out.println(counter);

                }

                for (MovingPlatform p : this.movingPlatforms) {
                    int hm = (p.onTop(fireboy));
                    counter += hm;
                    if (p.getBounds().overlaps(fireboy.getBounds())) {
                        p.whereIsPlayer(fireboy);
                    }

                    if (counter != 0) {
                        p.wasOnTop = true;
                        fireboy.setOnGround(true);
                    }
                    
                    if (fireboy.jump) {
                        p.wasOnTop = false;
                    }
                    p.tieTo(fireboy);
                }

                //check if he is on the ground
                //check if he is hitting a platform or a moving platform
                for (Platform p : this.platforms) {
                    int hm = (p.onTop(fireboy));
                    counter += hm;
                    if (p.getBounds().overlaps(fireboy.getBounds())) {
                        p.whereIsPlayer(fireboy);
                    }
                }
                if (counter != 0) {
                    fireboy.setOnGround(true);
                }
            }

            // Watergirl keyboard listeners
            // only move the Watergirl is she hasn't died yet
            if (!this.watergirl.isDead()) {
//                watergirl.onTop(this.platforms, this.movingPlatforms);
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
                this.watergirl.jumpAction();
                for (Platform p : this.platforms) {
                    if (p.getBounds().overlaps(watergirl.getBounds())) {
                    }
                }

                for (Platform p : this.movingPlatforms) {
                    if (p.getBounds().overlaps(watergirl.getBounds())) {
                        // watergirl.whereIsPlayer(p);
                    }
                }
            }
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

        // allow the Watergirl to die when it comes into contact with Fire
        for (Fire f : this.fire) {
            if (f.collidesWith(this.watergirl)) {
                this.watergirl.died();
            }
        }

        // allow the Fireboy to die when it comes into contact with Water
        for (Water w : this.water) {
            if (w.collidesWith(this.fireboy)) {
                this.fireboy.died();
            }
        }

        for (Mud m : this.mud) {
            // allow the Fireboy to die when it comes into contact with Mud
            if (m.collidesWith(this.fireboy)) {
                this.fireboy.died();
            }

            // allow the Watergirl to die when it comes into contact with Mud
            if (m.collidesWith(this.watergirl)) {
                this.watergirl.died();
            }
        }

        // win the game if Fireboy and Watergirl stand in front of their respected Doors
        if (this.fireDoor.collision(
                this.fireboy)
                && this.waterDoor.collision(this.watergirl)) {
            this.levelWon = true;
        }

        // determines if the Buttons are pressed
        for (Button b : this.buttons) {
            b.pressed(this.fireboy, this.watergirl);
        }
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

    /**
     * Allows for the drawing of the game objects.
     */
    public void draw() {
        // allows for the drawing of game objects to begin
        this.shapeBatch.setProjectionMatrix(camera.combined);
        this.shapeBatch.begin(ShapeRenderer.ShapeType.Filled);

        // draws a black background
        this.shapeBatch.setColor(Color.BLACK);
        this.shapeBatch.rect(0, 0, 672, 544);

        // go through the array and draw each Button
        for (Button b : this.buttons) {
            b.draw(this.shapeBatch);
        }

        // draws the standing Platforms
        this.shapeBatch.setColor(Color.WHITE);
        for (Platform p : this.platforms) {
            p.draw(this.shapeBatch);
        }

        // draws the moving Platforms
        this.shapeBatch.setColor(Color.PURPLE);
        for (Platform p : this.movingPlatforms) {
            p.draw(this.shapeBatch);
        }

        // set the FireDoor to be magneta
        this.shapeBatch.setColor(Color.MAGENTA);
        this.fireDoor.draw(this.shapeBatch);

        // set the WaterDoor to be cyan
        this.shapeBatch.setColor(Color.CYAN);
        this.waterDoor.draw(this.shapeBatch);

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

        // draws a level complete screen when the Level has been won using a ShapeRenderer
        if (this.levelWon) {
            this.shapeBatch.setColor(Color.LIME);
            this.shapeBatch.rect(0, 0, 672, 544);
        }

        // allows for the drawing of the game objects to end
        this.shapeBatch.end();
        this.batch.setProjectionMatrix(this.camera.combined);
        
//        // allows for the drawing of Textures
//        this.batch.begin();
//
//        // draw the FireGems
//        for (FireGem fireGem : this.fireGems) {
//            fireGem.draw(this.batch);
//        }
//        // draw the WaterGems
//        for (WaterGem waterGem : this.waterGems) {
//            waterGem.draw(this.batch);
//        }
//        
//        // draw the Buttons
//        for (Button button : this.buttons) {
//            button.draw(this.batch);
//        }
//        
//        // draw the Fire
//        for (Fire f : this.fire) {
//            f.draw(this.batch);
//        }
//        
//        // draw the Water
//        for (Water w : this.water) {
//            w.draw(this.batch);
//        }
//        
//        // draw the Mud
//        for (Mud m : this.mud) {
//            m.draw(this.batch);
//        }
//        
//        // end the drawing of Textures
//        this.batch.end();
    }
}
