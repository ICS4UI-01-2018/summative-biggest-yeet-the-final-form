/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import java.util.ArrayList;

/**
 * Draws the objects of the games on the screen.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Level extends Screen {

    private long time, timePassed, secondsPassed, secondsDisplayed, minutesDisplayed;
    private FreeTypeFontGenerator generator;
    private FreeTypeFontParameter timerFontParameter, gemCountParameter, highScoreParameter;
    private BitmapFont timerFont, gemCountFont, highScoreFont;
    private Texture pauseButton, levelCompleteScreen, deathScreen;
    private boolean levelWon, pause, nextLevel, reset;
    Fireboy fireboy;
    Watergirl watergirl;
    ArrayList<Platform> platforms;
    ArrayList<MovingPlatform> movingPlatforms;
    ArrayList<Fire> fire;
    ArrayList<Water> water;
    ArrayList<Mud> mud;
    ArrayList<Button> buttons;
    ArrayList<FireGem> fireGems;
    ArrayList<WaterGem> waterGems;
    FireDoor fireDoor;
    WaterDoor waterDoor;
    private Files highScore;
    private ArrayList<Platform> temp;
    private ArrayList<Gem> tempGem;
    private String timeDisplayed;
    private ArrayList<String> scores;
    private Scores hello;
    private boolean resetTimer, pausetimer;
    private long timeee;
    private int co;

    /**
     * Initializes the SpriteBatch, ShapeRenderer, OrthographicCamera,
     * FitViewport, a variable for height for jumping, and a variable to
     * determine whether if the Fireboy and Watergirl have beat the Level.
     */
    @Override
    public void create() {
        // initialize the SpriteBatch, ShapeRenderer, Camera, and FitViewport
        super.create();

        this.temp = new ArrayList<Platform>();
        this.tempGem = new ArrayList<Gem>();

        // level completion variables
        this.levelWon = false;
        this.nextLevel = false;
        this.levelCompleteScreen = new Texture("LevelComplete.jpg");

        // character death variables
        this.reset = false;
        this.deathScreen = new Texture("LevelLost.jpg");

        // pause variables
        this.pause = false;
        this.pauseButton = new Texture("pause button.jpg");

        // initialize fonts
        this.generator = new FreeTypeFontGenerator(Gdx.files.internal("data-latin.ttf"));

        // initialize the timer font
        this.timerFontParameter = new FreeTypeFontParameter();
        this.timerFontParameter.size = 30;
        this.timerFontParameter.characters = "abcdefghijklmnopqrstuvwxyz0123456789.:";
        this.timerFont = this.generator.generateFont(this.timerFontParameter);
        
        // initialize the gem count font
        this.gemCountParameter = new FreeTypeFontParameter();
        this.gemCountParameter.size = 16;
        this.gemCountParameter.characters = "abcdefghijklmnopqrstuvwxyz0123456789.:";
        this.gemCountFont = this.generator.generateFont(this.gemCountParameter);

        // initialize the high score count font
        this.highScoreParameter = new FreeTypeFontParameter();
        this.highScoreParameter.size = 40;
        this.highScoreParameter.characters = "abcdefghijklmnopqrstuvwxyz0123456789.:";
        this.highScoreFont = this.generator.generateFont(this.highScoreParameter);

        this.generator.dispose();
        this.nextLevel = false;
        this.scores = new ArrayList();
        this.hello = null;
        this.time = System.currentTimeMillis();
        this.resetTimer = false;
        this.pausetimer = false;
        this.co = 0;
        this.timeee = 0;
    }

    public void resetTimer() {
        this.resetTimer = true;
        timer();
    }

    public String timer() {
        long prebv = 0;
        if (resetTimer) {
            time = System.currentTimeMillis();
            resetTimer = false;
        }
//        
//        if (pausetimer){
//            if (co == 0){
//             timeee = System.currentTimeMillis();
//             co = 3;
//            }
//        prebv = System.currentTimeMillis() - timeee;
//            System.out.println(prebv);
//            time += prebv;
//            System.out.println(time);
//            return "PAUSED";
//        }
        //  resetTimer = false;

        this.timePassed = System.currentTimeMillis() - (time + prebv);
        this.secondsPassed = timePassed / 1000;
        this.secondsDisplayed = secondsPassed % 60;
        this.minutesDisplayed = secondsPassed / 60;
        if (secondsDisplayed < 10) {
            if (minutesDisplayed < 10) {
                return ("0" + minutesDisplayed + ":0" + secondsDisplayed);
            }
            return (minutesDisplayed + ":0" + secondsDisplayed);
        } else if (minutesDisplayed < 10) {
            return ("0" + minutesDisplayed + ":" + secondsDisplayed);
        } else {
            return ("0" + minutesDisplayed + ":" + secondsDisplayed);
        }
    }

    public void pauseTimer() {//pause timer
        this.pausetimer = true;
    }

    /**
     * Implements the basic game logic for Fireboy and Watergirl.
     */
    @Override
    public void render() {
        // clear the background
        super.render();

        if (Gdx.input.isKeyPressed(Input.Keys.Y)) {
            System.out.println(fireboy.getY());
            resetTimer();
        } else {
            // pausetimer = false;
        }

        // Characters can only move if the level hasn't been won yet
        if (!this.levelWon && !this.pause) {
            this.timeDisplayed = timer();
            // constantly update the x and y positions of the Characters, the moving Platforms, and the Buttons
            this.fireboy.updatePositions();
            this.watergirl.updatePositions();
            for (Button button : this.buttons) {
                button.updatePositions();
            }
            for (MovingPlatform p : this.movingPlatforms) {
                p.moveDown();
                p.moveUp();
                p.updatePositions();
            }
            // Fireboy keyboard listeners
            // only move the Fireboy if he hasn't died yet
            if (!this.fireboy.isDead()) {
                // make the Fireboy move left
                if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                    this.fireboy.moveLeft();
                }
                // make the Watergirl move right
                if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                    this.fireboy.moveRight();
                }
                // make the Watergirl jump
                if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                    this.fireboy.jump();
                }
            }

            //the character being checked 
            Character character = this.fireboy;
            //run through actions with fireboy and watergirl
            for (int i = 0; i < 2; i++) {
                character.jumpAction();

                for (MovingPlatform mp : this.movingPlatforms) {
                    character.tieTo(mp);
                    if (mp.getBounds().overlaps(character.getBounds())) {
                        mp.hitPlatform(character);
                    }
                }

                character.needsToBeRenamed(this.platforms, this.movingPlatforms);

                //check if he is hitting a platform or a moving platform
                for (Platform p : this.platforms) {
                    //if platform is broken add it to the temp array and set it as unbroken
                    if (p.isPlatformBroken()) {
                        this.temp.add(p);
                        p.breakable = false;
                    }
                    if (p.getBounds().overlaps(character.getBounds())) {
                        p.hitPlatform(character);
                    }
                }
                //remove all broken platforms from platform array
                this.platforms.removeAll(temp);

                //repeat actions with watergirl
                character = this.watergirl;
            }

            // Watergirl keyboard listeners
            // only move the Watergirl is she hasn't died yet
            if (!this.watergirl.isDead()) {
                // make the Watergirl move left
                if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                    this.watergirl.moveLeft();
                }
                // make the Watergirl move right
                if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                    this.watergirl.moveRight();
                }
                // make the Watergirl jump
                if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                    this.watergirl.jump();
                }
            }

            // allow the Fireboy to collect the FireGems
            for (FireGem fireGem : this.fireGems) {
                // determine if the Fireboy has collected the FireGem
                if (fireGem.collision(this.fireboy)) {
                    // add to the fireboy's fire gem count
                    this.fireboy.addGem(fireGem);
                    // don't draw the FireGem on the screen
                    fireGem.setCollected(true);
                }
            }

            // allow the Watergirl to collect the WaterGems
            for (WaterGem waterGem : this.waterGems) {
                // determine if the Watergirl has collected the WaterGem
                if (waterGem.collision(this.watergirl)) {
                    // add to the Watergirl's WaterGem count
                    this.watergirl.addGem(waterGem);
                    // don't draw the WaterGem on the screen
                    waterGem.setCollected(true);

                }
            }

            // allow the Watergirl to die when it comes into contact with Fire
            for (Fire f : this.fire) {
                if (f.collidesWith(this.watergirl)) {
                    this.watergirl.setDead(true);
                }
            }

            // allow the Fireboy to die when it comes into contact with Water
            for (Water w : this.water) {
                if (w.collidesWith(this.fireboy)) {
                    this.fireboy.setDead(true);
                }
            }

            for (Mud m : this.mud) {
                // allow the Fireboy to die when it comes into contact with Mud
                if (m.collidesWith(this.fireboy)) {
                    this.fireboy.setDead(true);
                }

                // allow the Watergirl to die when it comes into contact with Mud
                if (m.collidesWith(this.watergirl)) {
                    this.watergirl.setDead(true);
                }
            }

            // determines if the Buttons are pressed
            for (Button b : this.buttons) {
                b.pressed(this.fireboy, this.watergirl);
            }

            // win the game if Fireboy and Watergirl stand in front of their respected Doors
            if (this.fireDoor.collision(this.fireboy)
                    && this.waterDoor.collision(this.watergirl)) {
                this.levelWon = true;
                this.resetTimer();

                int hm = fireboy.getGemsCollected() + fireboy.getGemsCollected();
                this.hello = new Scores(java.time.LocalDate.now(), hm, this.secondsDisplayed, this.minutesDisplayed);
                this.hello.add(this.hello, "scoresL1");
            }
        }

        // pause button
        Vector3 click = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        super.getCamera().unproject(click);
        // determine if the pause button is clicked
        if (Gdx.input.justTouched()
                && (click.x >= 620 && click.x <= 670)
                && (click.y >= 2 && click.y <= 30)
                && !this.pause) {
            // pause the game
            this.pause = true;
        } else if (Gdx.input.justTouched()
                && (click.x >= 620 && click.x <= 670)
                && (click.y >= 2 && click.y <= 30)
                && this.pause) {
            // unpause the game
            this.pause = false;
        }

        // advance to the next level
        if (this.levelWon && Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            this.nextLevel = true;
            resetTimer();
            this.fireboy.clearGems();
            super.setDisplay(false);
        }

        // determine if you need to reset the Level
        if (((this.fireboy.isDead() || this.watergirl.isDead())
                || this.fireboy.isDead() && this.watergirl.isDead())
                && Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            this.fireboy.clearGems();
            this.reset = true;
            // set the Characters to not be dead
            this.fireboy.setDead(false);
            this.watergirl.setDead(false);
            // set the Gems to be not collected
            for (FireGem fireGem : this.fireGems) {
                fireGem.setCollected(false);
            }
            for (WaterGem waterGem : this.waterGems) {
                waterGem.setCollected(false);
            }
            // reset the timer
            this.resetTimer();
        }
    }

    /**
     * Allows for the drawing of the game objects.
     */
    /**
     * Allows for the drawing of the game objects.
     */
    public void draw() {
        // allows for the drawing of game objects to begin
        super.getShapeRenderer().setProjectionMatrix(super.getCamera().combined);
        super.getShapeRenderer().begin(ShapeRenderer.ShapeType.Filled);

        // draws a black background
        super.getShapeRenderer().setColor(Color.BLACK);
        super.getShapeRenderer().rect(0, 0, 672, 544);

        // draw the moving Platforms
        for (MovingPlatform p : this.movingPlatforms) {
            p.draw(super.getShapeRenderer());
        }

        // allows for the drawing of the game objects to end
        super.getShapeRenderer().end();

        // allows for the drawing of Textures
        super.getSpriteBatch().setProjectionMatrix(super.getCamera().combined);
        super.getSpriteBatch().begin();

        // draw the Platforms
        for (Platform p : this.platforms) {
            if (!p.getBroken()) {
                p.draw(super.getSpriteBatch());
            }
        }

        // draw the timer
        this.timerFont.setColor(Color.WHITE);
        this.timerFont.draw(super.getSpriteBatch(), timeDisplayed, 298, 537);

        // draw the Gems
        for (FireGem fireGem : this.fireGems) {
            fireGem.draw(super.getSpriteBatch());
        }
        for (WaterGem waterGem : this.waterGems) {
            waterGem.draw(super.getSpriteBatch());
        }

        // draw the Obstacles
        for (Button button : this.buttons) {
            button.draw(super.getSpriteBatch());
        }
        for (Fire f : this.fire) {
            f.draw(super.getSpriteBatch());
        }
        for (Water w : this.water) {
            w.draw(super.getSpriteBatch());
        }
        for (Mud m : this.mud) {
            m.draw(super.getSpriteBatch());
        }

        // draw the Doors
        this.fireDoor.draw(super.getSpriteBatch());
        this.waterDoor.draw(super.getSpriteBatch());

        // draw the Characters if they haven't died yet
        if (!this.fireboy.isDead()) {
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && !this.pause) {
                this.fireboy.drawLeft(super.getSpriteBatch());
            } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && !this.pause) {
                this.fireboy.drawRight(super.getSpriteBatch());
            } else {
                this.fireboy.draw(super.getSpriteBatch());
            }
        } else {
//            this.highScore.saveFile("playerScores");
        }
        if (!this.watergirl.isDead()) {
            if (Gdx.input.isKeyPressed(Input.Keys.A) && !this.pause) {
                this.watergirl.drawLeft(super.getSpriteBatch());
            } else if (Gdx.input.isKeyPressed(Input.Keys.D) && !this.pause) {
                this.watergirl.drawRight(super.getSpriteBatch());
            } else {
                this.watergirl.draw(super.getSpriteBatch());
            }
        } else {
            // this.highScore.saveFile("playerScores");
        }

        // draw pause button
        super.getSpriteBatch().draw(this.pauseButton, 642, 2, 28, 28);

        // draw the level complete screen
        if (levelWon) {
            super.getSpriteBatch().draw(this.levelCompleteScreen, 100, 20, 500, 500);
            // display the FireGem count
            this.gemCountFont.setColor(Color.RED);
            this.gemCountFont.draw(super.getSpriteBatch(), this.fireboy.getGemsCollected() + "", 320, 165);
            // display the WaterGem count
            this.gemCountFont.setColor(Color.BLUE);
            this.gemCountFont.draw(super.getSpriteBatch(), this.watergirl.getGemsCollected() + "", 320, 138);
            this.resetTimer();
            this.gemCountFont.setColor(Color.VIOLET);
            this.gemCountFont.draw(super.getSpriteBatch(), hello.points((fireGems.size() + waterGems.size())) + "", 210, 320);
        }

        // draw the character death screen
        if ((this.fireboy.isDead() || this.watergirl.isDead())
                || (this.fireboy.isDead() && this.watergirl.isDead())) {
            super.getSpriteBatch().draw(this.deathScreen, 221, 136, 230, 272);
            // display the FireGem count
            this.gemCountFont.setColor(Color.RED);
            this.gemCountFont.draw(super.getSpriteBatch(), this.fireboy.getGemsCollected() + "", 320, 217);
            // display the WaterGem count
            this.gemCountFont.setColor(Color.BLUE);
            this.gemCountFont.draw(super.getSpriteBatch(), this.watergirl.getGemsCollected() + "", 320, 202);
        }

        // end the drawing of Textures
        super.getSpriteBatch().end();
    }

    /**
     * Returns whether or not if the Level has been won yet.
     *
     * @return a boolean representing whether or not the Level has been won yet
     */
    public boolean isLevelWon() {
        return this.levelWon;
    }

    /**
     * Returns whether or not the next Level should be displayed on the screen.
     *
     * @return a boolean representing whether or not the next Level should be
     * displayed
     */
    public boolean getNextLevel() {
        return this.nextLevel;
    }

    /**
     * Returns whether or not the Level needs to be reset.
     *
     * @return a boolean representing whether or not the Level should be reset
     */
    public boolean reset() {
        return this.reset;
    }

    /**
     * Sets the reset variable to the specified boolean.
     *
     * @param reset a boolean representing the new value of the reset variable
     */
    public void setReset(boolean reset) {
        this.reset = reset;
    }
}
