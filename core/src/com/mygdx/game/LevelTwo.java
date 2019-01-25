/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import java.util.ArrayList;

/**
 * Level Two of the Fireboy and Watergirl game.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class LevelTwo extends Level {

    /**
     * Initializes the different game objects in the Level.
     */
    @Override
    public void create() {
        // initialize SpriteBatch, ShapeRenderer, OrthographicCamera, FitViewport
        super.create(2);

        // initialize the Characters
        super.fireboy = new Fireboy(38.5f, 2);
        super.watergirl = new Watergirl(2, 2);

        // initialize the Platforms
        super.platforms = new ArrayList<Platform>();

        super.platforms.add(new Platform(0, 0, 9, 2));
        super.platforms.add(new Platform(6, 2, 3, 2));
        super.platforms.add(new Platform(6, 4, 5, 1));
        super.platforms.add(new Platform(9, 0, 7, 1));
        super.platforms.add(new Platform(16, 0, 1, 4));
        super.platforms.add(new Platform(15, 4, 3, 1, 25));
        super.platforms.add(new Platform(17, 0, 3, 1));
        super.platforms.add(new Platform(20, 0, 2, 8));
        super.platforms.add(new Platform(22, 0, 3, 1));
        super.platforms.add(new Platform(24, 4, 3, 1,25));
        super.platforms.add(new Platform(25, 0, 1, 4));
        super.platforms.add(new Platform(26, 0, 7, 1));
        super.platforms.add(new Platform(31, 4, 5, 1));
        super.platforms.add(new Platform(33, 2, 3, 2));
        super.platforms.add(new Platform(33, 0, 9, 2));
        super.platforms.add(new Platform(41, 2, 1, 32));
        super.platforms.add(new Platform(33, 7, 8, 2));
        super.platforms.add(new Platform(33, 9, 5, 1));
        super.platforms.add(new Platform(33, 10, 1, 20));
        super.platforms.add(new Platform(35, 12, 1, 1,15));
        super.platforms.add(new Platform(31, 12, 2, 1,15));
        super.platforms.add(new Platform(30.5f, 15, 1, 1));
        super.platforms.add(new Platform(36, 20, 5, 1));
        super.platforms.add(new Platform(34, 24, 5, 1));
        super.platforms.add(new Platform(36, 28, 5, 1));
        super.platforms.add(new Platform(36, 29, 1, 1,8));
        super.platforms.add(new Platform(26, 9, 3, 1,25));
        super.platforms.add(new Platform(13, 9, 3, 1,20));
        super.platforms.add(new Platform(1, 7, 8, 2));
        super.platforms.add(new Platform(0, 2, 1, 32));
        super.platforms.add(new Platform(4, 9, 5, 1));
        super.platforms.add(new Platform(4, 10, 1, 1));
        super.platforms.add(new Platform(6, 12, 1, 1,15));
        super.platforms.add(new Platform(8, 10, 1, 20));
        super.platforms.add(new Platform(9, 12, 2, 1,15));
        super.platforms.add(new Platform(10.5f, 15, 1, 1));
        super.platforms.add(new Platform(1, 19, 5, 1));
        super.platforms.add(new Platform(3, 23, 5, 1));
        super.platforms.add(new Platform(1, 27, 5, 1));
        super.platforms.add(new Platform(5, 28, 1, 1));
        super.platforms.add(new Platform(10, 29, 1, 1,8));
        super.platforms.add(new Platform(12, 29, 1, 1,8));
        super.platforms.add(new Platform(14, 29, 1, 1,8));
        super.platforms.add(new Platform(16, 29, 1, 1,8));
        super.platforms.add(new Platform(25, 29, 1, 1,8));
        super.platforms.add(new Platform(27, 29, 1, 1,8));
        super.platforms.add(new Platform(29, 29, 1, 1,8));
        super.platforms.add(new Platform(31, 29, 1, 1,8));
        super.platforms.add(new Platform(20, 17, 2, 15));
        super.platforms.add(new Platform(18, 26, 2, 1));
        super.platforms.add(new Platform(14, 23, 2, 1));
        super.platforms.add(new Platform(18, 21, 2, 1));
        super.platforms.add(new Platform(16, 19, 1, 1));
        super.platforms.add(new Platform(12, 17, 1, 1));
        super.platforms.add(new Platform(12, 16, 18, 1));
        super.platforms.add(new Platform(29, 17, 1, 1));
        super.platforms.add(new Platform(25, 19, 1, 1));
        super.platforms.add(new Platform(22, 21, 2, 1));
        super.platforms.add(new Platform(26, 23, 2, 1));
        super.platforms.add(new Platform(22, 26, 2, 1));
        super.platforms.add(new Platform(18, 32, 6, 1));
        super.platforms.add(new Platform(1, 33, 40, 1));
        super.platforms.add(new Platform(37, 10, 1, 1));
        super.platforms.add(new Platform(19, 7, 1, 1));
        super.platforms.add(new Platform(22, 7, 1, 1));

        // initialize the moving Platforms
        super.movingPlatforms = new ArrayList<MovingPlatform>();
        this.movingPlatforms.add(new MovingPlatform(false, 16, 13, 4, 1, 9));
        this.movingPlatforms.add(new MovingPlatform(false, 22, 13, 4, 1, 9));

        // initialize the Obstacles
        super.fire = new ArrayList<Fire>();
        super.fire.add(new Fire(34, 10, 3, 1));
        super.fire.add(new Fire(37, 29, 4, 1));
        super.fire.add(new Fire(22, 17, 7, 1));

        super.water = new ArrayList<Water>();
        super.water.add(new Water(5, 10, 3, 1));
        super.water.add(new Water(1, 28, 4, 1));
        super.water.add(new Water(13, 17, 7, 1));

        super.mud = new ArrayList<Mud>();
        super.mud.add(new Mud(9, 1, 7, 1));
        super.mud.add(new Mud(17, 1, 3, 1));
        super.mud.add(new Mud(22, 1, 3, 1));
        super.mud.add(new Mud(26, 1, 7, 1)
        );

        this.buttons = new ArrayList<Button>();
        super.buttons.add(new Button(20.5f, 8));

        // initialize the Gems
        super.fireGems = new ArrayList<FireGem>();
        super.fireGems.add(new FireGem(25, 6));
        super.fireGems.add(new FireGem(14, 11));
        super.fireGems.add(new FireGem(16, 21));
        super.fireGems.add(new FireGem(16, 26));
        super.fireGems.add(new FireGem(4, 25));
        super.fireGems.add(new FireGem(4, 21));
        super.fireGems.add(new FireGem(17, 15));
        super.fireGems.add(new FireGem(18, 15)
        );

        super.waterGems = new ArrayList<WaterGem>();
        super.waterGems.add(new WaterGem(16, 6));
        super.waterGems.add(new WaterGem(27, 11));
        super.waterGems.add(new WaterGem(25, 21));
        super.waterGems.add(new WaterGem(25, 26));
        super.waterGems.add(new WaterGem(37, 26));
        super.waterGems.add(new WaterGem(37, 22));
        super.waterGems.add(new WaterGem(23, 15));
        super.waterGems.add(new WaterGem(24, 15)
        );

        // initialize the Doors
        //water door
        super.fireDoor = (new FireDoor(1.5f, 9));
        //fire door
        super.waterDoor = (new WaterDoor(38.5f, 9));
    }

    /**
     * Implement the basic game logic and draw all the game objects on the
     * screen.
     */
    @Override
    public void render() {
        // clear the screen and implement the basic game logic
        super.render();

        buttons.get(0).addMovingPlatform(this.movingPlatforms.get(0));
        buttons.get(0).addMovingPlatform(this.movingPlatforms.get(1));
        // determine which MovingPlatforms that the Button controls
        ArrayList<MovingPlatform> buttonPlatforms = buttons.get(0).getMovingPlatforms();
        if (buttons.get(0).isPressed()) {
            // MovingPlatforms will move down when the Button is pressed
              for (MovingPlatform mp : buttonPlatforms) {//is it getting faster going down?
                mp.isMovingDown = true;
                mp.isMovingUp = false;
                mp.updatePositions();
            }
        } else {
            // Moving Platform returns to its original state if the Button isn't pressed
            for (MovingPlatform mp : buttonPlatforms) {
                mp.isMovingDown = false;
                mp.isMovingUp = true;
            }
        }
        
        
        // reset the Level
        if (super.reset()) {
           
            // reset the Characters
            super.fireboy.setX(616);
            super.fireboy.setY(32);
            super.watergirl.setX(32);
            super.watergirl.setY(32);
            
            super.setReset(false);
        }
        
        // draw the game elements
        super.draw();
    }
}
