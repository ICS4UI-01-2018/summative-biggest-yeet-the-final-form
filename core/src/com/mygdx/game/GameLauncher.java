/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Launches the MainMenu, and the Levels of the game.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class GameLauncher extends ApplicationAdapter {

    private MainMenu mainMenu;
    private LevelOne levelOne;
    private LevelTwo levelTwo;
    private LevelThree levelThree;
    private FitViewport viewport;
    private OrthographicCamera camera;

    /**
     * Initializes the Screens, and the FitViewport.
     */
    @Override
    public void create() {
        this.mainMenu = new MainMenu();
        this.mainMenu.create();
        this.levelOne = new LevelOne();
        this.levelOne.create();
        this.levelTwo = new LevelTwo();
        this.levelTwo.create();
        this.levelThree = new LevelThree();
        this.levelThree.create();

        this.camera = new OrthographicCamera();
        this.viewport = new FitViewport(672, 544, this.camera);
        this.viewport.apply();
        this.camera.position.x = 336;
        this.camera.position.y = 272;
        this.camera.update();
    }

    /**
     * Launch the game in the correct order.
     */
    @Override
    public void render() {
//        // display the MainMenu
//        if (this.mainMenu.getDisplay()) {
//            this.mainMenu.render();
//        }
//
//        // if spacebar is pressed, then proceed to LevelOne
//        if (this.mainMenu.goNext()) {
//            this.levelOne.setDisplay(true);
//        }
//        
//        // display LevelOne
//        if (this.levelOne.getDisplay()) {
//            this.levelOne.render();
//        }
//
//        // set LevelTwo to be displayed
//        if (this.levelOne.getNextLevel()) {
//            this.levelOne.setDisplay(false);
//            this.levelTwo.setDisplay(true);
//        }
//        
//        // display LevelTwo
//        if (this.levelTwo.getDisplay()) {
//            this.levelTwo.render();
//        }
//
//        // set LevelThree to be displayed
//        if (this.levelTwo.getNextLevel()) {
//            this.levelTwo.setDisplay(false);
//            this.levelThree.setDisplay(true);
//        }
//        
//        // display LevelThree
//        if (this.levelThree.getDisplay()) {
//            this.levelThree.render();
//        }
        
        this.levelThree.render();
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
}
