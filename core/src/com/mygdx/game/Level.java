///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mygdx.game;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//
///**
// * Draws the objects of the games on the screen.
// *
// * @author biGgEsT yEeT: tHe fiNaL fOrM
// */
//public class Level {
//
//    /**
//     * Constantly update the positions of the Characters as it is moving on the
//     * screen.
//     *
//     * @param fireboy a Character representing a Fireboy
//     * @param watergirl a Character representing a Watergirl
//     */
//    public void updateCharacterPositions(Fireboy fireboy, Watergirl watergirl) {
//        fireboy.updatePositions();
//        watergirl.updatePositions();
//    }
//
//    /**
//     * Implements the basic game logic of a game of Fireboy and Watergirl.
//     * Allows for the user to move the Characters left, and right across the
//     * screen if the level hasn't been won, and if they haven't died yet. Allows
//     * for the user to make the Characters jump if the level hasn't been won,
//     * and if they haven't died yet. Implements gravity and jumping motion for
//     * the Characters. Allows for the Characters to collect their respected
//     * Gems. Allows for the Fireboy to die when it collides with Water or Mud.
//     * Allows for the Watergirl to die when it collides with Fire or Mud.
//     *
//     * @param levelWon a boolean representing whether or not the Level has been
//     * won yet
//     * @param fireboy a Character representing a Fireboy in the Level
//     * @param watergirl a Character representing a Watergirl in the Level
//     * @param newHeight a float representing the new height
//     * @param platforms an array of Platforms representing the Platforms in the
//     * Level
//     * @param fireGems an array of Gems representing FireGems for the Fireboy to
//     * collect in the Level
//     * @param waterGems an array of Gems representing WaterGems for the
//     * Watergirl to collect in the Level
//     * @param fire an Obstacle representing Fire for the Watergirl to die in
//     * @param water an Obstacle representing Water for the Fireboy to die in
//     * @param mud an Obstacle representing Mud for Characters to die in
//     * @param fireDoor a Door representing a FireDoor for the Fireboy to pass
//     * into
//     * @param waterDoor a Door representing a WaterDoor for the Watergirl to
//     * pass into
//     */
//    public void gameLogic(boolean levelWon, Fireboy fireboy, Watergirl watergirl, float newHeight, Platform[] platforms, FireGem[] fireGems, WaterGem[] waterGems, Fire[] fire, Water[] water, Mud[] mud, FireDoor fireDoor, WaterDoor waterDoor) {
//        // Characters can only move if the level hasn't been won yet
//        if (!levelWon) {
//            // Fireboy keyboard listeners
//            // only move the Fireboy if he hasn't died yet
//            if (!fireboy.isDead()) {
//                // make the Fireboy move left
//                if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
//                    fireboy.moveLeft();
//                }
//                // make the Watergirl move right
//                if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
//                    fireboy.moveRight();
//                }
//                // make the Watergirl jump
//                if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
//                    fireboy.jump();
//                }
//            }
//
//            // Watergirl keyboard listeners
//            // only move the Watergirl is she hasn't died yet
//            if (!watergirl.isDead()) {
//                // make the Watergirl move left
//                if (Gdx.input.isKeyPressed(Input.Keys.A)) {
//                    watergirl.moveLeft();
//                }
//                // make the Watergirl move right
//                if (Gdx.input.isKeyPressed(Input.Keys.D)) {
//                    watergirl.moveRight();
//                }
//                // make the Watergirl jump
//                if (Gdx.input.isKeyPressed(Input.Keys.W)) {
//                    watergirl.jump();
//                }
//            }
//        }
//
//        // gravity and jumping for the Fireboy
//        newHeight = fireboy.newGround(platforms);
//        fireboy.jumpAction(newHeight);
//        fireboy.falling(newHeight, fireboy.standing(platforms));
//
//        // gravity and jumping for the Watergirl
//        newHeight = watergirl.newGround(platforms);
//        watergirl.jumpAction(newHeight);
//        watergirl.falling(newHeight, watergirl.standing(platforms));
//
//        // allow the Fireboy to collect the FireGems
//        for (FireGem fireGem : fireGems) {
//            // determine if the Fireboy has collected the FireGem
//            if (fireGem.collision(fireboy)) {
//                // don't draw the FireGem on the screen
//                fireGem.collected();
//                // add to the Fireboy's FireGem count
//                fireboy.addGem();
//            }
//        }
//
//        // allow the Watergirl to collect the WaterGems
//        for (WaterGem waterGem : waterGems) {
//            // determine if the Watergirl has collected the WaterGem
//            if (waterGem.collision(watergirl)) {
//                // don't draw the WaterGem on the screen
//                waterGem.collected();
//                // add to the Watergirl's WaterGem count
//                watergirl.addGem();
//            }
//        }
//
//        // allow the Watergirl to die when it comes into contact with Fire
//        for (Fire f : fire) {
//            if (f.collidesWith(watergirl)) {
//                watergirl.died();
//            }
//        }
//
//        // allow the Fireboy to die when it comes into contact with Water
//        for (Water w : water) {
//            if (w.collidesWith(fireboy)) {
//                fireboy.died();
//            }
//        }
//
//        for (Mud m : mud) {
//            // allow the Fireboy to die when it comes into contact with Mud
//            if (m.collidesWith(fireboy)) {
//                fireboy.died();
//            }
//
//            // allow the Watergirl to die when it comes into contact with Mud
//            if (m.collidesWith(watergirl)) {
//                watergirl.died();
//            }
//        }
//
//        // win the game if Fireboy and Watergirl stand in front of their respected Doors
//        if (fireDoor.collision(fireboy) && waterDoor.collision(watergirl)) {
//            levelWon = true;
//        }
//    }
//
//    /**
//     * Allows for the drawing to begin.
//     *
//     * @param batch a SpriteBatch
//     * @param shapeBatch a ShapeRenderer to draw the objects with
//     * @param camera an OrthographicCamera
//     */
//    public void beginDraw(SpriteBatch batch, ShapeRenderer shapeBatch, OrthographicCamera camera) {
//        batch.begin();
//        shapeBatch.setProjectionMatrix(camera.combined);
//        shapeBatch.begin(ShapeRenderer.ShapeType.Filled);
//    }
//
//    /**
//     * Allows for the drawing to end.
//     *
//     * @param batch a SpriteBatch
//     * @param shapeBatch a ShapeRenderer to draw the objects with
//     * @param camera an OrthographicCamera
//     */
//    public void endDraw(SpriteBatch batch, ShapeRenderer shapeBatch, OrthographicCamera camera) {
//        shapeBatch.end();
//        batch.end();
//        batch.setProjectionMatrix(camera.combined);
//    }
//
//    /**
//     * Draws a black background using a ShapeRenderer.
//     *
//     * @param shapeBatch a ShapeRenderer used to draw the background with
//     */
//    public void drawBackground(ShapeRenderer shapeBatch) {
//        shapeBatch.setColor(Color.BLACK);
//        shapeBatch.rect(0, 0, 672, 544);
//    }
//
//    /**
//     * Draws the Obstacles used in the game using a ShapeRenderer.
//     *
//     * @param shapeBatch a ShapeRenderer used to draw the Obstacles with
//     * @param fire an Obstacle representing Fire to draw
//     * @param water an Obstacle representing Water to draw
//     * @param mud an Obstacle representing Mud to draw
//     * @param buttons an Obstacle representing Buttons to draw
//     */
//    public void drawObstacles(ShapeRenderer shapeBatch, Fire[] fire, Water[] water, Mud[] mud, Button[] buttons) {
//        // set the Fire to be magenta
//        shapeBatch.setColor(Color.MAGENTA);
//        // go through the array and draw each Fire
//        for (Fire f : fire) {
//            f.draw(shapeBatch);
//        }
//
//        // set the Water to be cyan
//        shapeBatch.setColor(Color.CYAN);
//        // go through the array and draw each Water
//        for (Water w : water) {
//            w.draw(shapeBatch);
//        }
//
//        // set the Mud to be forest green
//        shapeBatch.setColor(Color.FOREST);
//        // go through the array and draw each Mud
//        for (Mud m : mud) {
//            m.draw(shapeBatch);
//        }
//
//        // go through the array and draw each Button
//        for (Button b : buttons) {
//            b.draw(shapeBatch);
//        }
//    }
//
//    /**
//     * Draws the Gems using a Shape Renderer.
//     *
//     * @param shapeBatch a ShapeRenderer used to draw the Gems with
//     * @param fireGems an array of Gems representing FireGems to draw
//     * @param waterGems an array of WaterGems representing WaterGems to draw
//     */
//    public void drawGems(ShapeRenderer shapeBatch, FireGem[] fireGems, WaterGem[] waterGems) {
//        // set the FireGems to be red
//        shapeBatch.setColor(Color.RED);
//        // go through the array and draw each FireGem
//        for (FireGem fireGem : fireGems) {
//            // only draw the FireGem if it hasn't been collected by a Fireboy yet
//            if (!fireGem.isCollected()) {
//                fireGem.draw(shapeBatch);
//            }
//        }
//
//        // set the WaterGems to be blue
//        shapeBatch.setColor(Color.BLUE);
//        // go through the array and draw each WaterGem
//        for (WaterGem waterGem : waterGems) {
//            // only draw the WaterGem if it hasn't been collected by a Watergirl yet
//            if (!waterGem.isCollected()) {
//                waterGem.draw(shapeBatch);
//            }
//        }
//    }
//
//    /**
//     * Draws the Doors using a ShapeRenderer.
//     *
//     * @param shapeBatch a ShapeRenderer used to draw the Doors with
//     * @param fireDoor a Door representing a FireDoor to draw
//     * @param waterDoor a Door representing a WaterDoor to draw
//     */
//    public void drawDoors(ShapeRenderer shapeBatch, FireDoor fireDoor, WaterDoor waterDoor) {
//        // set the FireDoor to be magenta
//        shapeBatch.setColor(Color.MAGENTA);
//        fireDoor.draw(shapeBatch);
//
//        // set the WaterDoor to be cyan
//        shapeBatch.setColor(Color.CYAN);
//        waterDoor.draw(shapeBatch);
//    }
//
//    /**
//     * Draws the Characters using a ShapeRenderer.
//     *
//     * @param shapeBatch a ShapeRenderer used to draw the Characters with
//     * @param fireboy a Character representing a Fireboy to draw
//     * @param watergirl a Character represnting a Watergirl to draw
//     */
//    public void drawCharacters(ShapeRenderer shapeBatch, Fireboy fireboy, Watergirl watergirl) {
//        // only draw the Fireboy if he hasn't died yet
//        if (!fireboy.isDead()) {
//            // set the Fireboy to be red
//            shapeBatch.setColor(Color.RED);
//            fireboy.draw(shapeBatch);
//        }
//
//        // only draw the Watergirl if she hasn't died yet
//        if (!watergirl.isDead()) {
//            // set the Watergirl to be blue
//            shapeBatch.setColor(Color.BLUE);
//            watergirl.draw(shapeBatch);
//        }
//    }
//
//    /**
//     * Draws a level complete screen when the Level has been won using a
//     * ShapeRenderer.
//     *
//     * @param shapeBatch a ShapeRenderer used to draw the level complete screen
//     * with
//     * @param levelWon a boolean representing whether if the level has been won
//     * yet
//     */
//    public void drawLevelComplete(ShapeRenderer shapeBatch, boolean levelWon) {
//        if (levelWon) {
//            shapeBatch.setColor(Color.LIME);
//            shapeBatch.rect(0, 0, 672, 544);
//        }
//    }
//}
