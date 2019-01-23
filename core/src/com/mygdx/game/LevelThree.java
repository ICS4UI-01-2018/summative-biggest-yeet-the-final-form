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

    private long time = System.currentTimeMillis();

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
        
        super.platforms.add(new Platform(1, 2, 1, 31));

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
    }

    /**
     * Implement the basic game logic and draw all the game objects on the
     * screen.
     */
    @Override
    public void render() {
        // clear the screen and implement the basic game logic
        super.render();

        //calculated display times
        long timePassed = System.currentTimeMillis() - time;
        long secondsPassed = timePassed / 1000;
        long secondsDisplayed = secondsPassed % 60;
        long minutesDisplayed = secondsPassed / 60;

        System.out.println(minutesDisplayed + ":" + secondsDisplayed);

        // draw the game elements
        super.draw();
    }
}
