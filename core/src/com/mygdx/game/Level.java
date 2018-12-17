/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Draws the objects of the games on the screen.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Level {

    /**
     * Allows for the drawing to begin.
     *
     * @param batch a SpriteBatch
     * @param shapeBatch a ShapeRenderer to draw the objects with
     * @param camera an OrthographicCamera
     */
    public void beginDraw(SpriteBatch batch, ShapeRenderer shapeBatch, OrthographicCamera camera) {
        batch.begin();
        shapeBatch.setProjectionMatrix(camera.combined);
        shapeBatch.begin(ShapeRenderer.ShapeType.Filled);
    }

    /**
     * Allows for the drawing to end.
     *
     * @param batch a SpriteBatch
     * @param shapeBatch a ShapeRenderer to draw the objects with
     * @param camera an OrthographicCamera
     */
    public void endDraw(SpriteBatch batch, ShapeRenderer shapeBatch, OrthographicCamera camera) {
        shapeBatch.end();
        batch.end();
        batch.setProjectionMatrix(camera.combined);
    }

    /**
     * Draws a black background using a ShapeRenderer.
     *
     * @param shapeBatch a ShapeRenderer used to draw the background with
     */
    public void drawBackground(ShapeRenderer shapeBatch) {
        shapeBatch.setColor(Color.BLACK);
        shapeBatch.rect(0, 0, 672, 544);
    }

    /**
     * Draws the Obstacles used in the game using a ShapeRenderer.
     * 
     * @param shapeBatch a ShapeRenderer used to draw the Obstacles with
     * @param fire an Obstacle representing Fire to draw
     * @param water an Obstacle representing Water to draw
     * @param mud an Obstacle representing Mud to draw
     * @param buttons an Obstacle representing Buttons to draw
     */
    public void drawObstacles(ShapeRenderer shapeBatch, Fire[] fire, Water[] water, Mud[] mud, Button[] buttons) {
        // set the Fire to be magenta
        shapeBatch.setColor(Color.MAGENTA);
        // go through the array and draw each Fire
        for (Fire f : fire) {
            f.draw(shapeBatch);
        }
        
        // set the Water to be cyan
        shapeBatch.setColor(Color.CYAN);
        // go though the array and draw each Water
        for (Water w : water) {
            w.draw(shapeBatch);
        }
        
        // set the Mud to be forest green
        shapeBatch.setColor(Color.FOREST);
        // go through the array and draw each Mud
        for (Mud m : mud) {
            m.draw(shapeBatch);
        }
        
        // go through the array and draw each Button
        for (Button b : buttons) {
            b.draw(shapeBatch);
        }
    }

    /**
     * Draws the Characters using a ShapeRenderer.
     *
     * @param shapeBatch a ShapeRenderer used to draw the Characters with
     * @param fireboy a Character representing a Fireboy to draw
     * @param watergirl a Character represnting a Watergirl to draw
     */
    public void drawCharacters(ShapeRenderer shapeBatch, Fireboy fireboy, Watergirl watergirl) {
        fireboy.draw(shapeBatch);
        watergirl.draw(shapeBatch);
    }
}
