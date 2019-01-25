/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import java.util.ArrayList;

/**
 * Level Three of the Fireboy and Watergirl game.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class LevelThree extends Level {

    /**
     * Initializes the different game objects in the Level.
     */
    @Override
    public void create() {
        // initialize SpriteBatch, ShapeRenderer, OrthographicCamera, FitViewport
        super.create();

        // initialize the Characters
        super.fireboy = new Fireboy(22.5f, 28);
        super.watergirl = new Watergirl(18, 28);

        // initialize the Platforms
        super.platforms = new ArrayList<Platform>();
        super.platforms.add(new Platform(0, 0, 42, 2));
        super.platforms.add(new Platform(0, 2, 1, 31));
        super.platforms.add(new Platform(41, 2, 1, 31));
        super.platforms.add(new Platform(0, 33, 42, 1));
        super.platforms.add(new Platform(18, 32, 6, 1));
        super.platforms.add(new Platform(17, 8, 8, 1));
        super.platforms.add(new Platform(17, 9, 1, 2));
        super.platforms.add(new Platform(42, 9, 1, 2));
        super.platforms.add(new Platform(16, 14, 10, 1));
        super.platforms.add(new Platform(17, 15, 8, 1));
        super.platforms.add(new Platform(17, 20, 1, 1));
        super.platforms.add(new Platform(24, 20, 1, 1));
        super.platforms.add(new Platform(17, 21, 2, 1));
        super.platforms.add(new Platform(23, 21, 2, 1));
        super.platforms.add(new Platform(17, 22, 8, 1));
        super.platforms.add(new Platform(18, 26, 6, 1));
        super.platforms.add(new Platform(17, 27, 8, 1));
        super.platforms.add(new Platform(6, 29, 2, 1));
        super.platforms.add(new Platform(7, 28, 1, 1));
        super.platforms.add(new Platform(10, 29, 1, 1));
        super.platforms.add(new Platform(9, 28, 2, 1));
        super.platforms.add(new Platform(13, 29, 2, 1));
        super.platforms.add(new Platform(14, 28, 1, 1));
        super.platforms.add(new Platform(11, 27, 2, 1));
        super.platforms.add(new Platform(12, 26, 1, 1));
        super.platforms.add(new Platform(9, 24, 1, 1));
        super.platforms.add(new Platform(10, 20, 2, 2));
        super.platforms.add(new Platform(12, 20, 1, 1));
        super.platforms.add(new Platform(13, 17, 1, 1));
        super.platforms.add(new Platform(7, 17, 1, 3));
        super.platforms.add(new Platform(3.5f, 12, 2, 1));
        super.platforms.add(new Platform(8, 11, 1, 3));
        super.platforms.add(new Platform(1, 10, 8, 1));
        super.platforms.add(new Platform(11, 11, 3, 1));
        super.platforms.add(new Platform(28, 11, 3, 1));
        super.platforms.add(new Platform(33, 10, 8, 1));
        super.platforms.add(new Platform(33, 11, 1, 3));
        super.platforms.add(new Platform(36.5f, 12, 2, 1));
        super.platforms.add(new Platform(28, 17, 1, 1));
        super.platforms.add(new Platform(34, 17, 1, 3));
        super.platforms.add(new Platform(29, 20, 1, 1));
        super.platforms.add(new Platform(30, 20, 2, 2));
        super.platforms.add(new Platform(32, 24, 1, 1));
        super.platforms.add(new Platform(27, 29, 2, 1));
        super.platforms.add(new Platform(27, 28, 1, 1));
        super.platforms.add(new Platform(31, 29, 1, 1));
        super.platforms.add(new Platform(31, 28, 2, 1));
        super.platforms.add(new Platform(34, 29, 2, 1));
        super.platforms.add(new Platform(34, 28, 1, 1));
        super.platforms.add(new Platform(29, 27, 2, 1));
        super.platforms.add(new Platform(29, 26, 1, 1));
        super.platforms.add(new Platform(1, 23, 6, 1));
        super.platforms.add(new Platform(35, 23, 6, 1));
        super.platforms.add(new Platform(24, 9, 1, 2));

        // initialize the MovingPlatforms
        super.movingPlatforms = new ArrayList<MovingPlatform>();
        super.movingPlatforms.add(new MovingPlatform(true, 17, 11, 1, 3, 14));
        super.movingPlatforms.add(new MovingPlatform(true, 17, 16, 1, 4, 20));
        super.movingPlatforms.add(new MovingPlatform(true, 17, 23, 1, 3, 26));
        super.movingPlatforms.add(new MovingPlatform(true, 24, 11, 1, 3, 14));
        super.movingPlatforms.add(new MovingPlatform(true, 24, 16, 1, 4, 20));
        super.movingPlatforms.add(new MovingPlatform(true, 24, 23, 1, 3, 26));

        // initialize the Obstacles
        super.fire = new ArrayList<Fire>();
        super.fire.add(new Fire(1, 11, 7, 1));
        super.water = new ArrayList<Water>();
        super.water.add(new Water(34, 11, 7, 1));
        super.mud = new ArrayList<Mud>();
        super.mud.add(new Mud(1, 2, 40, 1));
        super.buttons = new ArrayList<Button>();
        super.buttons.add(new Button(4, 13));
        super.buttons.add(new Button(37, 13));
        super.buttons.add(new Button(20.5f, 9));
        super.buttons.add(new Button(20.5f, 16));

        // initialize the Gems
        super.fireGems = new ArrayList<FireGem>();
        super.fireGems.add(new FireGem(20, 18));
        super.fireGems.add(new FireGem(22, 18));
        super.fireGems.add(new FireGem(19, 12));
        super.fireGems.add(new FireGem(21, 12));
        super.fireGems.add(new FireGem(20, 11));
        super.fireGems.add(new FireGem(22, 11));
        super.waterGems = new ArrayList<WaterGem>();
        super.waterGems.add(new WaterGem(19, 18));
        super.waterGems.add(new WaterGem(21, 18));
        super.waterGems.add(new WaterGem(20, 12));
        super.waterGems.add(new WaterGem(22, 12));
        super.waterGems.add(new WaterGem(19, 11));
        super.waterGems.add(new WaterGem(21, 11));

        // initialize the Doors
        super.fireDoor = new FireDoor(21.5f, 23);
        super.waterDoor = new WaterDoor(18.5f, 23);
    }

    /**
     * Implement the basic game logic and draw all the game objects on the
     * screen.
     */
    @Override
    public void render() {
        // clear the screen and implement the basic game logic
        super.render();
        
        // determine if the Button is being pressed
        if (super.buttons.get(0).isPressed()) {
            // move the MovingPlatform of the Button up
            super.movingPlatforms.get(1).moveUp();
        } else {
            // move the MovingPlatform of the Button down
            super.movingPlatforms.get(1).moveDown();
        }

        // determine if the Button is being pressed
        if (super.buttons.get(1).isPressed()) {
            // move the MovingPlatform of the Button up
            super.movingPlatforms.get(4).moveUp();
        } else {
            // move the MovingPlatform of the Button down
            super.movingPlatforms.get(4).moveDown();
        }
        
        // determine which MovingPlatforms the Button controls
        super.buttons.get(2).addMovingPlatform(super.movingPlatforms.get(2));
        super.buttons.get(2).addMovingPlatform(super.movingPlatforms.get(5));
        ArrayList<MovingPlatform> button2Platforms = buttons.get(2).getMovingPlatforms();
        // determine if the Button is pressed
        if (super.buttons.get(2).isPressed()) {
            // move each MovingPlatform that belongs to the Button up
           for (MovingPlatform mp : button2Platforms) {//is it getting faster going down?
                mp.isMovingDown = true;
                mp.isMovingUp = false;
                mp.updatePositions();
            }
        } else {
            // Moving Platform returns to its original state if the Button isn't pressed
            for (MovingPlatform mp : button2Platforms) {
                mp.isMovingDown = false;
                mp.isMovingUp = true;
            }        }
        
        // determine which MovingPlatforms the Button controls
        super.buttons.get(3).addMovingPlatform(super.movingPlatforms.get(0));
        super.buttons.get(3).addMovingPlatform(super.movingPlatforms.get(3));
        ArrayList<MovingPlatform> button3Platforms = buttons.get(3).getMovingPlatforms();
        // determine if the Button is pressed
        if (super.buttons.get(3).isPressed()) {
            // move each MovingPlatform that belongs to the Button up
           for (MovingPlatform mp : button3Platforms) {//is it getting faster going down?
                mp.isMovingDown = true;
                mp.isMovingUp = false;
                mp.updatePositions();
            }
        } else {
            // Moving Platform returns to its original state if the Button isn't pressed
            for (MovingPlatform mp : button3Platforms) {
                mp.isMovingDown = false;
                mp.isMovingUp = true;
            }
     
        }

        // reset the Level
        if (super.reset()) {
            // reset the Characters
            super.fireboy.setX(360);
            super.fireboy.setY(448);
            super.watergirl.setX(288);
            super.watergirl.setY(448);
            
            super.setReset(false);
        }
        
        // draw the game elements
        super.draw();
    }
}
