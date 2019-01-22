package com.mygdx.game;

/**
 * Level One of the Fireboy and Watergirl game.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class LevelOne extends Level {

    /**
     * Initialize the different game objects in the Level.
     */
    @Override
    public void create() {
        // initialize SpriteBatch, ShapeRenderer, OrthographicCamera, FitViewport
        super.create();
        super.highScore = new Files("playerScores", fireboy, watergirl);

        // initialize the Characters
        super.fireboy = new Fireboy(15, 18);
        super.watergirl = new Watergirl(15, 12);

        // initialize the Platforms
        super.platforms = new Platform[30];
        super.platforms[0] = new Platform(0, 0, 21, 2);
        super.platforms[1] = new Platform(0, 2, 1, 32);
        super.platforms[2] = new Platform(21, 0, 4, 1);
        super.platforms[3] = new Platform(25, 0, 2, 2);
        super.platforms[4] = new Platform(27, 0, 4, 1);
        super.platforms[5] = new Platform(31, 0, 11, 2);
        super.platforms[6] = new Platform(37, 2, 4, 4);
        super.platforms[7] = new Platform(41, 2, 1, 32);
        super.platforms[8] = new Platform(1, 5, 12, 2);
        super.platforms[9] = new Platform(1, 10, 16, 2);
        super.platforms[10] = new Platform(16, 9, 2, 3);
        super.platforms[11] = new Platform(18, 9, 8, 2);
        super.platforms[12] = new Platform(26, 9, 4, 1);
        super.platforms[13] = new Platform(30, 9, 6, 2);
        super.platforms[14] = new Platform(38, 13, 3, 4);
        super.platforms[15] = new Platform(35, 14, 3, 3);
        super.platforms[16] = new Platform(21, 15, 14, 2);
        super.platforms[17] = new Platform(19, 15, 2, 3);
        super.platforms[18] = new Platform(6, 16, 13, 2);
        super.platforms[19] = new Platform(1, 21, 4, 6);
        super.platforms[20] = new Platform(5, 21, 16, 2);
        super.platforms[21] = new Platform(21, 21, 9, 4);
        super.platforms[22] = new Platform(30, 20, 2, 3);
        super.platforms[23] = new Platform(32, 20, 4, 2);
        super.platforms[24] = new Platform(17, 27, 24, 2);
        super.platforms[25] = new Platform(29, 29, 4, 1);
        super.platforms[26] = new Platform(11, 25, 6, 4);
        super.platforms[27] = new Platform(8, 28, 3, 1);
        super.platforms[28] = new Platform(1, 33, 40, 1);
        super.platforms[29] = new Platform(18, 32, 6, 2);

        // initialize the moving Platforms
        this.movingPlatforms = new MovingPlatform[1];
        this.movingPlatforms[0] = new MovingPlatform(false, 1, 17f, 5, 1f, 12);

        // initialize the Obstacles
        super.fire = new Fire[1];
        super.fire[0] = new Fire(21, 1, 4, 1);
        super.water = new Water[1];
        super.water[0] = new Water(27, 1, 4, 1);
        super.mud = new Mud[1];
        super.mud[0] = new Mud(26, 10, 4, 1);
        super.buttons = new Button[2];
        super.buttons[0] = new Button(10.5f, 18, new MovingPlatform[]{this.movingPlatforms[0]});
        super.buttons[1] = new Button(10.5f, 12, new MovingPlatform[]{this.movingPlatforms[0]});

        // initialize the Gems
        super.fireGems = new FireGem[4];
        super.fireGems[0] = new FireGem(22.5f, 4);
        super.fireGems[1] = new FireGem(7, 19);
        super.fireGems[2] = new FireGem(9, 30);
        super.fireGems[3] = new FireGem(19, 30);
        super.waterGems = new WaterGem[4];
        super.waterGems[0] = new WaterGem(28.5f, 4);
        super.waterGems[1] = new WaterGem(23, 18);
        super.waterGems[2] = new WaterGem(2, 28);
        super.waterGems[3] = new WaterGem(22, 30);

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

        // determine which MovingPlatforms the Button controls
        MovingPlatform[] buttonPlatforms = buttons[0].getMovingPlatforms();
        // determine if any Buttons are pressed
        if ((buttons[0].isPressed() || buttons[1].isPressed())
                || (buttons[0].isPressed() && buttons[1].isPressed())) {
            // MovingPlatform moves down if a Button is pressed
            for (MovingPlatform mp : buttonPlatforms) {
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
