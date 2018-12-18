//package com.mygdx.game;
//
//import com.badlogic.gdx.ApplicationAdapter;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//import com.badlogic.gdx.utils.viewport.FitViewport;
//
///**
// * Level One of the Fireboy and Watergirl game.
// *
// * @author biGgEsT yEeT: tHe fiNaL fOrM
// */
//public class LevelOne extends ApplicationAdapter {
//
//    private OrthographicCamera camera;
//    private FitViewport viewport;
//    private ShapeRenderer shapeBatch;
//    private SpriteBatch batch;
//    // create a new Level
//    private Level level;
//    // landing variable
//    private float newHeight;
//    // Characters
//    private Fireboy fireboy;
//    private Watergirl watergirl;
//    // an array to store all of the Platforms
//    private Platform[] platforms;
//    // Obstacles
//    private Button[] buttons;
//    // arrays to store all of the Gems
//    
//    // Doors
//    // variable to determine whether or not if Fireboy and Watergirl passed the level
//    private boolean levelWon;
//
//    @Override
//    public void create() {
//        // create a new Level
//        this.level = new Level();
//        // initialize the SpriteBatch and the ShapeRenderer
//        this.batch = new SpriteBatch();
//        this.shapeBatch = new ShapeRenderer();
//        // initialize the Camera and the Viewport
//        this.camera = new OrthographicCamera();
//        this.viewport = new FitViewport(672, 544, this.camera);
//        this.viewport.apply();
//        this.camera.position.x = 336;
//        this.camera.position.y = 272;
//        this.camera.update();
//        // initialize the variable for the height
//        this.newHeight = 32;
//        // Fireboy and Watergirl haven't won the level yet
//        this.levelWon = false;
//
//        // initialize the Characters
//        // fireboy = 32, 32
//        this.fireboy = new Fireboy(96, 288);
//        this.watergirl = new Watergirl(32, 122);
//
//        // initialize the Platforms
//        this.platforms = new Platform[31];
//        this.platforms[0] = new Platform(0, 0, 336, 32);
//        this.platforms[1] = new Platform(0, 32, 16, 512);
//        this.platforms[2] = new Platform(336, 0, 64, 16);
//        this.platforms[3] = new Platform(400, 0, 32, 32);
//        this.platforms[4] = new Platform(432, 0, 64, 16);
//        this.platforms[5] = new Platform(496, 0, 176, 32);
//        this.platforms[6] = new Platform(592, 32, 64, 64);
//        this.platforms[7] = new Platform(656, 32, 16, 512);
//        this.platforms[8] = new Platform(16, 80, 192, 32);
//        this.platforms[9] = new Platform(16, 160, 256, 32);
//        this.platforms[10] = new Platform(256, 144, 32, 48);
//        this.platforms[11] = new Platform(288, 144, 128, 32);
//        this.platforms[12] = new Platform(416, 144, 64, 16);
//        this.platforms[13] = new Platform(460, 144, 96, 32);
//        this.platforms[14] = new Platform(608, 208, 48, 64);
//        this.platforms[15] = new Platform(560, 224, 48, 48);
//        this.platforms[16] = new Platform(336, 240, 224, 32);
//        this.platforms[17] = new Platform(304, 240, 32, 48);
//        this.platforms[18] = new Platform(96, 256, 208, 32);
//        this.platforms[19] = new Platform(16, 336, 64, 96);
//        this.platforms[20] = new Platform(80, 336, 256, 32);
//        this.platforms[21] = new Platform(336, 336, 144, 64);
//        this.platforms[22] = new Platform(480, 320, 32, 48);
//        this.platforms[23] = new Platform(512, 320, 64, 32);
//        this.platforms[24] = new Platform(272, 432, 384, 32);
//        this.platforms[25] = new Platform(448, 464, 64, 16);
//        this.platforms[26] = new Platform(176, 400, 96, 64);
//        this.platforms[27] = new Platform(128, 448, 48, 16);
//        this.platforms[28] = new Platform(16, 528, 640, 16);
//        this.platforms[29] = new Platform(288, 512, 96, 32);
//        this.platforms[30] = new Platform(576, 320, 80, 8);
//
//        // initialize the Obstacles
//        this.fire = new Fire[1];
//        this.fire[0] = new Fire(336, 16, 64, 16);
//        this.water = new Water[1];
//        this.water[0] = new Water(432, 16, 64, 16);
//        this.mud = new Mud[1];
//        this.mud[0] = new Mud(416, 160, 64, 16);
//        this.buttons = new Button[2];
//        this.buttons[0] = new Button(168, 288);
//        this.buttons[1] = new Button(488, 368);
//
//        // initialize the Gems
//        this.fireGems = new FireGem[4];
//        this.fireGems[0] = new FireGem(22.5f, 4);
//        this.fireGems[1] = new FireGem(7, 19);
//        this.fireGems[2] = new FireGem(9, 30);
//        this.fireGems[3] = new FireGem(19, 30);
//        this.waterGems = new WaterGem[4];
//        this.waterGems[0] = new WaterGem(28.5f, 4);
//        this.waterGems[1] = new WaterGem(23, 18);
//        this.waterGems[2] = new WaterGem(2, 28);
//        this.waterGems[3] = new WaterGem(22, 30);
//
//        // initialize the Doors
//        this.fireDoor = new FireDoor(544, 464);
//        this.waterDoor = new WaterDoor(592, 464);
//    }
//
//    @Override
//    public void render() {
//        // clear the background
//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        // constantly update the x and y positions of the Fireboy and the Watergirl and the moving Platform
//        this.level.updateCharacterPositions(fireboy, watergirl);
//        this.platforms[30].updatePositions();
//
//        this.level.gameLogic(this.levelWon, this.fireboy, this.watergirl, this.newHeight, this.platforms, this.fireGems, this.waterGems, this.fire, this.water, this.mud, this.fireDoor, this.waterDoor);
//
////        // Button moves down if a Character is on it
////        for (Button button : this.buttons) {
////            if (button.collision(this.fireboy) || button.collision(this.watergirl)) {
////                // move the Platform downwards
////                if (this.platforms[30].getY() > 272) {
////                    this.platforms[30].moveDown();
////                }
////            }
////        }
////        
////        // Button moves up if a Character isn't on it
////        for (Button button : this.buttons) {
////            if (!button.collision(this.fireboy) && !button.collision(this.watergirl)) {
////                // move the Platform upwards
////                if (this.platforms[30].getY() < 320) {
////                    this.platforms[30].moveUp();
////                }
////            }
////        }
//        // win the game if Fireboy and Watergirl stand in front of their respected Doors
//        if (this.fireDoor.collision(this.fireboy) && this.waterDoor.collision(this.watergirl)) {
//            this.levelWon = true;
//        }
//
//        // start drawing
//        this.level.beginDraw(this.batch, this.shapeBatch, this.camera);
//        // set the background colour to be black
//        this.level.drawBackground(this.shapeBatch);
//        // draw the Platforms
//        this.shapeBatch.setColor(Color.WHITE);
//        for (int i = 0; i < this.platforms.length - 1; i++) {
//            this.platforms[i].draw(this.shapeBatch);
//        }
//        // draw the Platform that connects to the Buttons
//        this.shapeBatch.setColor(Color.PURPLE);
//        this.platforms[30].draw(this.shapeBatch);
//        // draw the Obstacles
//        this.level.drawObstacles(this.shapeBatch, this.fire, this.water, this.mud, this.buttons);
//        // draw the Gems
//        this.level.drawGems(this.shapeBatch, this.fireGems, this.waterGems);
//        // draw the Doors
//        this.level.drawDoors(this.shapeBatch, this.fireDoor, this.waterDoor);
//        // draw the Characters if they aren't dead yet
//        this.level.drawCharacters(this.shapeBatch, this.fireboy, this.watergirl);
//        // draw a lime green screen over everything once the game was been won
//        this.level.drawLevelComplete(this.shapeBatch, this.levelWon);
//        // end drawing
//        this.level.endDraw(this.batch, this.shapeBatch, this.camera);
//    }
//
//    @Override
//    public void dispose() {
//        this.batch.dispose();
//    }
//
//    /**
//     * Resizes the screen so that the game doesn't look distorted.
//     *
//     * @param width an integer representing the width of the original screen
//     * @param height an integer representing the height of the original screen
//     */
//    @Override
//    public void resize(int width, int height) {
//        this.viewport.update(width, height);
//    }
//}
