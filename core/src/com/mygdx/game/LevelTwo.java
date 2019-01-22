/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

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
        super.create();
        
        // initialize the Characters
        super.fireboy = new Fireboy(38.5f, 2);
        super.watergirl = new Watergirl(2, 2);

        // initialize the Platforms
        super.platforms = new Platform[65];
        super.platforms[0] = new Platform(0, 0, 9, 2);
        super.platforms[1] = new Platform(6, 2, 3, 2);
        super.platforms[2] = new Platform(6, 4, 5, 1);
        super.platforms[3] = new Platform(9, 0, 7, 1);
        super.platforms[4] = new Platform(16, 0, 1, 4);
        super.platforms[5] = new Platform(15, 4, 3, 1);
        super.platforms[6] = new Platform(17, 0, 3, 1);
        super.platforms[7] = new Platform(20, 0, 2, 8);
        super.platforms[8] = new Platform(22, 0, 3, 1);
        super.platforms[9] = new Platform(24, 4, 3, 1);
        super.platforms[10] = new Platform(25, 0, 1, 4);
        super.platforms[11] = new Platform(26, 0, 7, 1);
        super.platforms[12] = new Platform(31, 4, 5, 1);
        super.platforms[13] = new Platform(33, 2, 3, 2);
        super.platforms[14] = new Platform(33, 0, 9, 2);
        super.platforms[15] = new Platform(41, 2, 1, 32);
        super.platforms[16] = new Platform(33, 7, 8, 2);
        super.platforms[17] = new Platform(33, 9, 5, 1);
        super.platforms[18] = new Platform(33, 10, 1, 20);
        super.platforms[19] = new Platform(35, 12, 1, 1);
        super.platforms[20] = new Platform(31, 12, 2, 1);
        super.platforms[21] = new Platform(30.5f, 15, 1, 1);
        super.platforms[22] = new Platform(36, 20, 5, 1);
        super.platforms[23] = new Platform(34, 24, 5, 1);
        super.platforms[24] = new Platform(36, 28, 5, 1);
        super.platforms[25] = new Platform(36, 29, 1, 1);
        super.platforms[26] = new Platform(26, 9, 3, 1);
        super.platforms[27] = new Platform(13, 9, 3, 1);
        super.platforms[28] = new Platform(1, 7, 8, 2);
        super.platforms[29] = new Platform(0, 2, 1, 32);
        super.platforms[30] = new Platform(4, 9, 5, 1);
        super.platforms[31] = new Platform(4, 10, 1, 1);
        super.platforms[32] = new Platform(6, 12, 1, 1);
        super.platforms[33] = new Platform(8, 10, 1, 20);
        super.platforms[34] = new Platform(9, 12, 2, 1);
        super.platforms[35] = new Platform(10.5f, 15, 1, 1);
        super.platforms[36] = new Platform(1, 19, 5, 1);
        super.platforms[37] = new Platform(3, 23, 5, 1);
        super.platforms[38] = new Platform(1, 27, 5, 1);
        super.platforms[39] = new Platform(5, 28, 1, 1);
        super.platforms[40] = new Platform(10, 29, 1, 1);
        super.platforms[41] = new Platform(12, 29, 1, 1);
        super.platforms[42] = new Platform(14, 29, 1, 1);
        super.platforms[43] = new Platform(16, 29, 1, 1);
        super.platforms[44] = new Platform(25, 29, 1, 1);
        super.platforms[45] = new Platform(27, 29, 1, 1);
        super.platforms[46] = new Platform(29, 29, 1, 1);
        super.platforms[47] = new Platform(31, 29, 1, 1);
        super.platforms[48] = new Platform(20, 17, 2, 15);
        super.platforms[49] = new Platform(18, 26, 2, 1);
        super.platforms[50] = new Platform(14, 23, 2, 1);
        super.platforms[51] = new Platform(18, 21, 2, 1);
        super.platforms[52] = new Platform(16, 19, 1, 1);
        super.platforms[53] = new Platform(12, 17, 1, 1);
        super.platforms[54] = new Platform(12, 16, 18, 1);
        super.platforms[55] = new Platform(29, 17, 1, 1);
        super.platforms[56] = new Platform(25, 19, 1, 1);
        super.platforms[57] = new Platform(22, 21, 2, 1);
        super.platforms[58] = new Platform(26, 23, 2, 1);
        super.platforms[59] = new Platform(22, 26, 2, 1);
        super.platforms[60] = new Platform(18, 32, 6, 1);
        super.platforms[61] = new Platform(1, 33, 40, 1);
        super.platforms[62] = new Platform(37, 10, 1, 1);
        super.platforms[63] = new Platform(19, 7, 1, 1);
        super.platforms[64] = new Platform(22, 7, 1, 1);

        // initialize the moving Platforms
        this.movingPlatforms = new MovingPlatform[2];
        this.movingPlatforms[0] = new MovingPlatform(false, 16, 13, 4, 1, 9);
        this.movingPlatforms[1] = new MovingPlatform(false, 22, 13, 4, 1, 9);

        // initialize the Obstacles
        super.fire = new Fire[3];
        super.fire[0] = new Fire(34, 10, 3, 1);
        super.fire[1] = new Fire(37, 29, 4, 1);
        super.fire[2] = new Fire(22, 17, 7, 1);
        super.water = new Water[3];
        super.water[0] = new Water(5, 10, 3, 1);
        super.water[1] = new Water(1, 28, 4, 1);
        super.water[2] = new Water(13, 17, 7, 1);
        super.mud = new Mud[4];
        super.mud[0] = new Mud(9, 1, 7, 1);
        super.mud[1] = new Mud(17, 1, 3, 1);
        super.mud[2] = new Mud(22, 1, 3, 1);
        super.mud[3] = new Mud(26, 1, 7, 1);
        super.buttons = new Button[1];
        super.buttons[0] = new Button(20.5f, 8, new MovingPlatform[]{this.movingPlatforms[0], this.movingPlatforms[1]});

        // initialize the Gems
        super.fireGems = new FireGem[8];
        super.fireGems[0] = new FireGem(25, 6);
        super.fireGems[1] = new FireGem(14, 11);
        super.fireGems[2] = new FireGem(16, 21);
        super.fireGems[3] = new FireGem(16, 26);
        super.fireGems[4] = new FireGem(4, 25);
        super.fireGems[5] = new FireGem(4, 21);
        super.fireGems[6] = new FireGem(17, 15);
        super.fireGems[7] = new FireGem(18, 15);
        super.waterGems = new WaterGem[8];
        super.waterGems[0] = new WaterGem(16, 6);
        super.waterGems[1] = new WaterGem(27, 11);
        super.waterGems[2] = new WaterGem(25, 21);
        super.waterGems[3] = new WaterGem(25, 26);
        super.waterGems[4] = new WaterGem(37, 26);
        super.waterGems[5] = new WaterGem(37, 22);
        super.waterGems[6] = new WaterGem(23, 15);
        super.waterGems[7] = new WaterGem(24, 15);

        // initialize the Doors
        //water door
        super.waterDoor = new WaterDoor(1.5f,9);
        //fire door
        super.fireDoor = new FireDoor(38.5f,9);
    }

    /**
     * Implement the basic game logic and draw all the game objects on the
     * screen.
     */
    @Override
    public void render() {
        // clear the screen and implement the basic game logic
        super.render();

        // determine which MovingPlatforms that the Button controls
        MovingPlatform[] buttonPlatforms = buttons[0].getMovingPlatforms();
        if (buttons[0].isPressed()) {
            // MovingPlatforms will move down when the Button is pressed
            for (MovingPlatform mp : buttonPlatforms) {
                mp.moveDown();
            }
        } else {
            // MovingPlatforms will move up when the Button isn't pressed
            for (MovingPlatform mp : buttonPlatforms) {
                mp.moveUp();
            }
        }

        // draw the game elements
        super.draw();
    }
}
