/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * The basic game logic of Fireboy and Watergirl that are standard across each
 * Level of the game. This class also can draw the different game elements
 * needed in the game, and initialize things such as the Camera, and the
 * FitViewport.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Level {

    /**
     * Implements the basic game logic in a game of Fireboy and Watergirl. This
     * will constantly update the position of the Characters on the screen. It
     * allows for the Characters to move right, or left when certain keys are
     * pressed. It allows for the Characters to jump when certain keys are
     * pressed. It also allows for the Characters to collect their corresponding
     * Gems.
     *
     * @param f a Character representing a Fireboy in a game
     * @param w a Character representing a Watergirl in a game
     * @param fg an array of FireGems for the Fireboy to collect during the game
     * @param wg an array of WaterGems for the Watergirl to collect during the
     * game
     * @param lw a boolean representing whether or not the Fireboy or Watergirl
     * have passed the level yet
     */
    public void basicGameLogic(Fireboy f, Watergirl w, FireGem[] fg, WaterGem[] wg, boolean levelWon) {
        // constantly updates the positions of the Characters
        f.updatePostions();
        w.updatePostions();

        // the Characters can only move if the game hasn't been won yet
        if (levelWon == false) {
            // Fireboy keyboard listeners
            // make the Fireboy move left
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                f.moveLeft();
            }
            // make the Fireboy move right
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                f.moveRight();
            }
            // make the Fireboy jump
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                f.jump();
            }

            // Watergirl keyboard listeners
            // make the Watergirl move left
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                w.moveLeft();
            }
            // make the Watergirl move right
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                w.moveRight();
            }
            // make the Watergirl jump
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                w.jump();
            }
        }

        // allow the Fireboy to collect the FireGems
        for (FireGem fireGem : fg) {
            // determine if the Fireboy has collected the FireGem
            if (fireGem.collision(f)) {
                // don't draw the FireGem on the screen
                fireGem.collected();
                // add to the Fireboy's FireGem count
                f.addGem();
            }
        }

        // allow the Watergirl to collect the WaterGems
        for (WaterGem waterGem : wg) {
            // determine if the Watergirl has collected the WaterGem
            if (waterGem.collision(w)) {
                // don't draw the WaterGem on the screen
                waterGem.collected();
                // add to the Watergirl's WaterGem count
                w.addGem();
            }
        }

        // game can be won once the Fireboy and Watergirl are in front of their respected Doors
        // allow the Fireboy and the Watergirl to jump
        // make the Button move downwards if a Character has collided with it
        // allow the Fireboy to die in the Water
        // allow the Fireboy to die in the Mud
        // allow the Watergirl to die in the Fire
        // allow the Watergirl to die in the Mud
    }

    /**
     * Allows for the drawing of game elements.
     *
     * @param batch a SpriteBatch
     * @param shapeBatch a ShapeRenderer to draw the game elements
     * @param camera an OrthographicCamera
     */
    public void startDrawing(SpriteBatch batch, ShapeRenderer shapeBatch, OrthographicCamera camera) {
        batch.begin();
        shapeBatch.setProjectionMatrix(camera.combined);
        shapeBatch.begin(ShapeRenderer.ShapeType.Filled);
    }

    /**
     * Draws the background of the game to be black.
     *
     * @param shapeBatch a ShapeRenderer to draw the background
     */
    public void drawBackground(ShapeRenderer shapeBatch) {
        // set the background to be black
        shapeBatch.setColor(Color.BLACK);
        shapeBatch.rect(0, 0, 672, 544);
    }

    /**
     * Ends the drawing of game elements.
     *
     * @param batch a SpriteBatch
     * @param shapeBatch a ShapeRenderer to draw the game elements
     * @param camera an OrthographicCamera
     */
    public void endDrawing(SpriteBatch batch, ShapeRenderer shapeBatch, OrthographicCamera camera) {
        shapeBatch.end();
        batch.end();
        batch.setProjectionMatrix(camera.combined);
    }

    /**
     * Draws the Gems in the level of the game.
     *
     * @param shapeBatch a ShapeRenderer to draw the Gems
     * @param fireGems an array of Gems representing FireGems to draw
     * @param waterGems an array of Gems representing WaterGems to draw
     */
    public void drawGems(ShapeRenderer shapeBatch, FireGem[] fireGems, WaterGem[] waterGems) {
        // draw the FireGems
        shapeBatch.setColor(Color.RED);
        for (FireGem fireGem : fireGems) {
            // only draw the FireGem if it hasn't been collected by the Fireboy yet
            if (!fireGem.isCollected()) {
                fireGem.draw(shapeBatch);
            }
        }

        // draw the WaterGems
        shapeBatch.setColor(Color.BLUE);
        for (WaterGem waterGem : waterGems) {
            // only draw the WaterGem if it hasn't been collected by the Watergirl yet
            if (!waterGem.isCollected()) {
                waterGem.draw(shapeBatch);
            }
        }
    }

    /**
     * Draws the Doors in the level of the game.
     *
     * @param shapeBatch a ShapeRenderer to draw the Doors
     * @param fireDoor a Door representing a FireDoor to draw
     * @param waterDoor a Door representing a WaterDoor to draw
     */
    public void drawDoors(ShapeRenderer shapeBatch, FireDoor fireDoor, WaterDoor waterDoor) {
        shapeBatch.setColor(Color.MAGENTA);
        fireDoor.draw(shapeBatch);
        shapeBatch.setColor(Color.CYAN);
        waterDoor.draw(shapeBatch);
    }

    /**
     * Draws the Characters in the level of the game.
     *
     * @param shapeBatch a ShapeRenderer to draw the Characters
     * @param fireboy a Character representing a Fireboy to draw
     * @param watergirl a Character representing a Watergirl to draw
     */
    public void drawCharacters(ShapeRenderer shapeBatch, Fireboy fireboy, Watergirl watergirl) {
        // draw the Characters if they aren't dead yet
        shapeBatch.setColor(Color.RED);
        if (!fireboy.isDead()) {
            fireboy.draw(shapeBatch);
        }
        shapeBatch.setColor(Color.BLUE);
        if (!watergirl.isDead()) {
            watergirl.draw(shapeBatch);
        }
    }

    /**
     * Draws the Obstacles of a Level using a ShapeRenderer.
     *
     * @param shapeBatch a ShapeRenderer to draw the Obstacles with
     * @param fire an array of Obstacles representing Fire to draw
     * @param water an array of Obstacles representing Water to draw
     * @param mud an array of Obstacles representing Mud to draw
     * @param buttons an array of Obstacles representing Buttons to draw
     */
    public void drawObstacles(ShapeRenderer shapeBatch, Fire[] fire, Water[] water, Mud[] mud, Button[] buttons) {
        // draw the Fire
        shapeBatch.setColor(Color.MAGENTA);
        for (Fire f : fire) {
            f.draw(shapeBatch);
        }

        // draw the Water
        shapeBatch.setColor(Color.CYAN);
        for (Water w : water) {
            w.draw(shapeBatch);
        }

        // draw the Mud
        shapeBatch.setColor(Color.FOREST);
        for (Mud m : mud) {
            m.draw(shapeBatch);
        }

        // draw the Buttons
        shapeBatch.setColor(Color.PURPLE);
        for (Button b : buttons) {
            b.draw(shapeBatch);
        }
    }

    /**
     * Initializes the SpriteBatch, the ShapeRenderer, the OrthographicCamera,
     * the FitViewport, and the winning variable to use in a game of Fireboy and
     * Watergirl.
     *
     * @param batch a SpriteBatch
     * @param shapeBatch a ShapeRenderer to draw game elements with
     * @param camera an OrthographicCamera
     * @param viewport a FitViewport
     * @param levelWon a boolean representing whether the Level was been won or
     * not
     */
    public void initialize(SpriteBatch batch, ShapeRenderer shapeBatch, OrthographicCamera camera, FitViewport viewport, boolean levelWon) {
        // intialize the SpriteBatch and the ShapeRenderer
        batch = new SpriteBatch();
        shapeBatch = new ShapeRenderer();

        // initialize the camera and the viewport
        camera = new OrthographicCamera();
        viewport = new FitViewport(672, 544, camera);
        viewport.apply();
        camera.position.x = 336;
        camera.position.y = 272;
        camera.update();

        // Fireboy and Watergirl have not died yet
        levelWon = false;
    }
}
