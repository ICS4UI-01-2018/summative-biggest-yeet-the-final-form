/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

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
        // super.platforms = new Platform[];
        
        // initialize the MovingPlatforms
        super.movingPlatforms = new MovingPlatform[6];
        movingPlatforms[0] = new MovingPlatform(true, 17, 11, 1, 3, 14);
        movingPlatforms[1] = new MovingPlatform(true, 17, 16, 1, 4, 20);
        movingPlatforms[2] = new MovingPlatform(true, 17, 23, 1, 3, 26);
        movingPlatforms[3] = new MovingPlatform(true, 24, 11, 1, 3, 14);
        movingPlatforms[4] = new MovingPlatform(true, 24, 16, 1, 4, 20);
        movingPlatforms[5] = new MovingPlatform(true, 24, 23, 1, 3, 26);
       
        // initialize the Obstacles
        super.fire = new Fire[1];
        fire[0] = new Fire(1, 11, 7, 1);
        super.water = new Water[1];
        water[0] = new Water(34, 11, 7, 1);
        super.mud = new Mud[1];
        mud[0] = new Mud(1, 2, 40, 1);
        
        // initialize the Gems
        // initialize the Doors
    }

    /**
     * Implement the basic game logic and draw all the game objects on the
     * screen.
     */
    @Override
    public void render() {
        // clear the screen and implement the basic game logic
        super.render();

        // draw the game elements
        super.draw();
    }
}
