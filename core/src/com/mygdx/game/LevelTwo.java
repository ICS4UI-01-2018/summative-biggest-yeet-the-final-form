/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Level Two of the Fireboy and Watergirl game.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class LevelTwo extends ApplicationAdapter {

    private OrthographicCamera camera;
    private FitViewport viewport;
    private ShapeRenderer shapeBatch;
    private SpriteBatch batch;
    // Characters
    private Fireboy fireboy;
    private Watergirl watergirl;
    // Platforms
    private Platform[] platforms;
    private Ice[] ice;
    // Obstacles
    private Fire[] fire;
    private Water[] water;
    private Mud[] mud;
    private Button[] buttons;
    // Gems
    private FireGem[] fireGems;
    private WaterGem[] waterGems;
    // Doors
    private FireDoor fireDoor;
    private WaterDoor waterDoor;
    // landing variable
    private float newHeight;
    // variable to determine whether or not if Fireboy and Watergirl passed the level
    private boolean levelWon;

    @Override
    public void create() {
        // initialize the Characters
        this.fireboy = new Fireboy(360, 448);
        this.watergirl = new Watergirl(288, 448);

        // initialize the Platforms
        this.platforms = new Platform[57];
        this.platforms[0] = new Platform(0, 0, 672, 32);
        this.platforms[1] = new Platform(0, 32, 16, 496);
        this.platforms[2] = new Platform(656, 32, 16, 496);
        this.platforms[3] = new Platform(0, 528, 672, 16);
        this.platforms[4] = new Platform(288, 512, 96, 16);
        this.platforms[5] = new Platform(272, 128, 128, 16);
        this.platforms[6] = new Platform(272, 144, 16, 32);
        this.platforms[7] = new Platform(384, 144, 16, 32);
        this.platforms[8] = new Platform(272, 176, 16, 48);
        this.platforms[9] = new Platform(384, 176, 16, 48);
        this.platforms[10] = new Platform(256, 224, 160, 16);
        this.platforms[11] = new Platform(272, 240, 128, 16);
        this.platforms[12] = new Platform(272, 256, 16, 64);
        this.platforms[13] = new Platform(384, 256, 16, 64);
        this.platforms[14] = new Platform(272, 320, 16, 16);
        this.platforms[15] = new Platform(384, 320, 16, 16);
        this.platforms[16] = new Platform(272, 336, 32, 16);
        this.platforms[17] = new Platform(368, 336, 32, 16);
        this.platforms[18] = new Platform(272, 352, 128, 16);
        this.platforms[19] = new Platform(272, 368, 16, 48);
        this.platforms[20] = new Platform(384, 368, 16, 48);
        this.platforms[21] = new Platform(288, 416, 96, 16);
        this.platforms[22] = new Platform(272, 432, 128, 16);
        this.platforms[23] = new Platform(96, 464, 32, 16);
        this.platforms[24] = new Platform(112, 448, 16, 16);
        this.platforms[25] = new Platform(160, 464, 16, 16);
        this.platforms[26] = new Platform(144, 448, 32, 16);
        this.platforms[27] = new Platform(208, 464, 32, 16);
        this.platforms[28] = new Platform(224, 448, 16, 16);
        this.platforms[29] = new Platform(176, 432, 32, 16);
        this.platforms[30] = new Platform(192, 416, 16, 16);
        this.platforms[31] = new Platform(144, 384, 16, 16);
        this.platforms[32] = new Platform(160, 320, 32, 32);
        this.platforms[33] = new Platform(192, 320, 16, 16);
        this.platforms[34] = new Platform(208, 272, 16, 16);
        this.platforms[35] = new Platform(112, 272, 16, 48);
        this.platforms[36] = new Platform(56, 192, 32, 16);
        this.platforms[37] = new Platform(128, 176, 16, 48);
        this.platforms[38] = new Platform(16, 160, 128, 16);
        this.platforms[39] = new Platform(176, 176, 48, 16);
        this.platforms[40] = new Platform(448, 176, 48, 16);
        this.platforms[41] = new Platform(528, 160, 128, 16);
        this.platforms[42] = new Platform(528, 176, 16, 48);
        this.platforms[43] = new Platform(584, 192, 32, 16);
        this.platforms[44] = new Platform(448, 272, 16, 16);
        this.platforms[45] = new Platform(544, 272, 16, 48);
        this.platforms[46] = new Platform(464, 320, 16, 16);
        this.platforms[47] = new Platform(480, 320, 32, 32);
        this.platforms[48] = new Platform(512, 384, 16, 16);
        this.platforms[49] = new Platform(432, 464, 32, 16);
        this.platforms[50] = new Platform(432, 448, 16, 16);
        this.platforms[51] = new Platform(496, 464, 16, 16);
        this.platforms[52] = new Platform(496, 448, 32, 16);
        this.platforms[53] = new Platform(544, 464, 32, 16);
        this.platforms[54] = new Platform(544, 448, 16, 16);
        this.platforms[55] = new Platform(464, 432, 32, 16);
        this.platforms[56] = new Platform(464, 416, 16, 16);
        this.ice = new Ice[2];
        this.ice[0] = new Ice(16, 368, 96, 16);
        this.ice[1] = new Ice(560, 368, 96, 16);

        // initialize the Obstacles
        this.fire = new Fire[1];
        this.fire[0] = new Fire(16, 176, 112, 16);
        this.water = new Water[1];
        this.water[0] = new Water(544, 176, 112, 16);
        this.mud = new Mud[1];
        this.mud[0] = new Mud(16, 32, 640, 16);
        this.buttons = new Button[2];
        this.buttons[0] = new Button(64, 208);
        this.buttons[1] = new Button(592, 208);

        // initialize the Gems
        this.fireGems = new FireGem[6];
        this.fireGems[0] = new FireGem(320, 288);
        this.fireGems[1] = new FireGem(352, 288);
        this.fireGems[2] = new FireGem(304, 192);
        this.fireGems[3] = new FireGem(320, 176);
        this.fireGems[4] = new FireGem(336, 192);
        this.fireGems[5] = new FireGem(352, 176);
        this.waterGems = new WaterGem[6];
        this.waterGems[0] = new WaterGem(304, 288);
        this.waterGems[1] = new WaterGem(336, 288);
        this.waterGems[2] = new WaterGem(304, 176);
        this.waterGems[3] = new WaterGem(320, 192);
        this.waterGems[4] = new WaterGem(336, 176);
        this.waterGems[5] = new WaterGem(352, 192);

        // initialize the Doors
    }

    @Override
    public void render() {
        // clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void dispose() {
        this.batch.dispose();
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
