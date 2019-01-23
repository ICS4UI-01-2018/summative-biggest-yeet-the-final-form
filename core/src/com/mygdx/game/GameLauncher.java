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
//        // display the main menu
//                int counter = 0; 
//
//        if (this.mainMenu.getDisplay()) {
//            this.mainMenu.render();
//           counter++;
//            System.out.println(counter);
//                    if (counter > 1){
//                        this.mainMenu.ihatelife(levelOne);
//                    }            System.out.println("main");
//        }
//        
//        // set level one to be displayed
//  //  if (mainMenu.x = false){    this.levelOne.setDisplay(true);
//    
//        // display level one
//        if (this.levelOne.getDisplay()) {
//            this.levelOne.render();
// 
//            System.out.println("level");
//        }
//        
//        // set level two to be displayed
//        //this.levelTwo.setDisplay(true);
//        
//        // display level two
//        if (this.levelTwo.getDisplay()) {
//            this.levelTwo.render();
//        }
//        
//        // set level three to be displayed
//        this.levelThree.setDisplay(true);
//        
//        // display level three

        this.levelOne.render();
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
