package com.mygdx.game;

/**
 * Level One of the Fireboy and Watergirl game.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class LevelOne extends Level {

    @Override
    public void create() {
        // initialize the SpriteBatch, ShapeRenderer, Camera, FitViewport, and a boolean to determine whether the game has been won
        super.create();

        // initialize the Characters
        super.fireboy = new Fireboy(super.multiplesOf20(new int[]{2, 30}));
        super.watergirl = new Watergirl(super.multiplesof20(new int[]{}));
        
        // initialize the Platforms
        super.platforms = new Platform[];
        super.platforms[0] = new Platform(super.multiplesOf20(new int[]{}));
        super.platforms[1] = new Platform(super.multiplesOf20(new int[]{}));
        super.platforms[2] = new Platform(super.multiplesOf20(new int[]{}));
        super.platforms[3] = new Platform(super.multiplesOf20(new int[]{}));
        super.platforms[4] = new Platform(super.multiplesOf20(new int[]{}));
        super.platforms[5] = new Platform(super.multiplesOf20(new int[]{}));
        super.platforms[6] = new Platform(super.multiplesOf20(new int[]{}));
        super.platforms[7] = new Platform(super.multiplesOf20(new int[]{}));
        super.platforms[8] = new Platform(super.multiplesOf20(new int[]{}));
        super.platforms[9] = new Platform(super.multiplesOf20(new int[]{}));
        
        // initialize the MovingPlatforms
        super.movingPlatforms = new MovingPlatform[1];
        super.movingPlatforms[0] = new MovingPlatform(super.multiplesof20(new int[]{}));
        
        // initialize Fire
        // initialize Water
        // initialize Mud
        // initialize Buttons
        
        // initialize FireGems
        // initialize WaterGems
        
        // initialize the FireDoor
        // initialize the WaterDoor
    }
}
