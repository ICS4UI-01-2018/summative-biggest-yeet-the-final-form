package com.mygdx.game;

import java.util.ArrayList;

/**
 * Level One of the Fireboy and Watergirl game.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class LevelOne extends Level {

    
      private long time = System.currentTimeMillis();
      
    /**
     * Initialize the different game objects in the Level.
     */
    @Override
    public void create() {
        // initialize SpriteBatch, ShapeRenderer, OrthographicCamera, FitViewport
        super.create();
        super.highScore = new Files("playerScores", fireboy, watergirl);

        // initialize the Characters
        super.fireboy = new Fireboy(33, 30);
        super.watergirl = new Watergirl(34, 30);

        // initialize the Platforms
        super.platforms = new ArrayList<Platform>();
        super.platforms.add(new Platform(0, 0, 21, 2));
        super.platforms.add(new Platform(0, 2, 1, 32));
        super.platforms.add(new Platform(21, 0, 4, 1));
        super.platforms.add(new Platform(25, 0, 2, 2));
        super.platforms.add(new Platform(27, 0, 4, 1));
        super.platforms.add(new Platform(31, 0, 11, 2));
        super.platforms.add(new Platform(37, 2, 4, 4));
        super.platforms.add(new Platform(41, 2, 1, 32));
        super.platforms.add(new Platform(1, 5, 12, 2));
        super.platforms.add(new Platform(1, 10, 16, 2));
        super.platforms.add(new Platform(16, 9, 2, 3));
        super.platforms.add(new Platform(18, 9, 8, 2));
        super.platforms.add(new Platform(26, 9, 4, 1));
        super.platforms.add(new Platform(29, 9, 7, 2));
        super.platforms.add(new Platform(38, 13, 3, 4));
        super.platforms.add(new Platform(35, 14, 3, 3));
        super.platforms.add(new Platform(21, 15, 14, 2, 500));
        super.platforms.add(new Platform(19, 15, 2, 3));
        super.platforms.add(new Platform(6, 16, 13, 2));
        super.platforms.add(new Platform(1, 21, 4, 6));
        super.platforms.add(new Platform(5, 21, 16, 2));
        super.platforms.add(new Platform(21, 21, 9, 4));
        super.platforms.add(new Platform(30, 20, 2, 3));
        super.platforms.add(new Platform(32, 20, 4, 2));
        super.platforms.add(new Platform(17, 27, 24, 2));
        super.platforms.add(new Platform(29, 29, 4, 1));
        super.platforms.add(new Platform(11, 25, 6, 4));
        super.platforms.add(new Platform(8, 28, 3, 1));
        super.platforms.add(new Platform(1, 33, 40, 1));
        super.platforms.add(new Platform(18, 32, 6, 2));

        // initialize the moving Platforms
        super.movingPlatforms = new ArrayList<MovingPlatform>();
        super.movingPlatforms.add(new MovingPlatform(false, 1, 17f, 5, 1f, 12));

        // initialize the Obstacles
        super.fire = new ArrayList<Fire>();
        super.fire.add(new Fire(21, 1, 4, 1));

        super.water = new ArrayList<Water>();
        super.water.add(new Water(27, 1, 4, 1));

        super.mud = new ArrayList<Mud>();
        super.mud.add(new Mud(26, 10, 3, 1));

        this.buttons = new ArrayList<Button>();
        this.buttons.add(new Button(10.5f, 18));
        this.buttons.add(new Button(10.5f, 12));

        // initialize the Gems
        super.fireGems = new ArrayList<FireGem>();
        super.fireGems.add(new FireGem(22.5f, 4));
        super.fireGems.add(new FireGem(7, 19));
        super.fireGems.add(new FireGem(9, 30));
        super.fireGems.add(new FireGem(19, 30));

        super.waterGems = new ArrayList<WaterGem>();
        super.waterGems.add(new WaterGem(28.5f, 4));
        super.waterGems.add(new WaterGem(23, 18));
        super.waterGems.add(new WaterGem(2, 28));
        super.waterGems.add(new WaterGem(22, 30));

        // initialize the Doors
        super.fireDoor = new FireDoor(35, 29);
        super.waterDoor = new WaterDoor(38, 29);
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
    long secondsPassed = timePassed/1000;
    long secondsDisplayed = secondsPassed % 60;
    long minutesDisplayed = secondsPassed/60;
        
        System.out.println(minutesDisplayed +":"+ secondsDisplayed);
        
        
        buttons.get(0).addMovingPlatform(this.movingPlatforms.get(0));
        buttons.get(1).addMovingPlatform(this.movingPlatforms.get(0));

        // determine which MovingPlatforms the Button controls
        ArrayList<MovingPlatform> buttonPlatforms = buttons.get(0).getMovingPlatforms();
        // determine if any Buttons are pressed
        if ((buttons.get(0).isPressed() || buttons.get(1).isPressed())
                || (buttons.get(0).isPressed() && buttons.get(1).isPressed())) {
            // MovingPlatform moves down if a Button is pressed
            for (MovingPlatform mp : buttonPlatforms) {//is it getting faster going down?
                mp.moveDown();
            }
        } else {
            // Moving Platform returns to its original state if the Button isn't pressed
            for (MovingPlatform mp : buttonPlatforms) {
                mp.moveUp();
            }
        }

        // draw the game elements
        super.draw();
    }
}
