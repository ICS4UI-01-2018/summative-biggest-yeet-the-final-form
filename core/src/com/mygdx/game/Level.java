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

    private long time, timePassed, secondsPassed, secondsDisplayed, minutesDisplayed, previousMinutes, previousSeconds;
    //should all instance variable be private?
    private FreeTypeFontGenerator generator;
    private FreeTypeFontParameter timerFontParameter, gemCountParameter, highScoreParameter;
    private BitmapFont timerFont, gemCountFont, highScoreFont;
    private Texture pauseButton, levelCompleteScreen, deathScreen;
    boolean levelWon, pause, nextLevel, reset;
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
    private ArrayList<Platform> temp;
    private String timeDisplayed;
    private TimeTaken playersScore;
    private int currentLevel;
    private boolean startTimer;

    /**
     * Initializes the SpriteBatch, ShapeRenderer, OrthographicCamera, fonts,
     * FitViewport, a variable for height for jumping, and a variable to
     * determine whether if the Fireboy and Watergirl have beat the Level.
     */
    public void create(int num) {
        // initialize the SpriteBatch, ShapeRenderer, Camera, and FitViewport
        super.create();
        this.currentLevel = num;
        this.temp = new ArrayList<Platform>();

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
        this.highScoreParameter.size = 20;
        this.highScoreParameter.characters = "abcdefghijklmnopqrstuvwxyz0123456789H.:";
        this.highScoreFont = this.generator.generateFont(this.highScoreParameter);

        this.generator.dispose();
        this.nextLevel = false;
        this.playersScore = null;
        this.startTimer = true;
        this.previousSeconds = 0;
        this.previousMinutes = 0;
    }

    /**
     * Starts timer at 0
     */
    public void startTimer() {
        this.time = System.currentTimeMillis();
    }

    /**
     * Keeps track of how much time has passed
     *
     * @return a string representing the minutes and seconds that have passed
     */
    public String timer() {
        this.timePassed = System.currentTimeMillis() - this.time;
        this.secondsPassed = this.timePassed / 1000;
        this.secondsDisplayed = (this.secondsPassed % 60) + this.previousSeconds;
        this.minutesDisplayed = (this.secondsPassed / 60) + this.previousMinutes;
        //decide how to display time
        if (secondsDisplayed < 10) {
            if (minutesDisplayed < 10) {
                return ("0" + minutesDisplayed + ":0" + secondsDisplayed);
            } else {
                return (minutesDisplayed + ":0" + secondsDisplayed);
            }
        } else if (minutesDisplayed < 10) {
            return ("0" + minutesDisplayed + ":" + secondsDisplayed);
        } else {
            return (minutesDisplayed + ":" + secondsDisplayed);
        }
    }

    /**
     * Pauses timer
     */
    public void pauseTimer() {
        this.previousSeconds = this.secondsDisplayed;
        this.previousMinutes = this.minutesDisplayed;
    }

    /**
     * Implements the basic game logic for Fireboy and Watergirl.
     */
    @Override
    public void render() {
        // clear the background
        super.render();
        //start timer from 0 once game has started


        // Characters can only move if the level hasn't been won yet
        if (!this.levelWon && !this.pause) {
            if (startTimer) {
                startTimer();
                startTimer = false;
            }
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

                character.getPlatformOn(platforms, movingPlatforms);

                //check if he is hitting a platform or a moving platform
                for (Platform p : this.platforms) {
                    //if platform is broken add it to the temp array and set it as unbroken
                    if (p.isPlatformBroken()) {
                        this.temp.add(p);
                        System.out.println("adding");
                        p.notBroken();
                    }
                    if (p.getBounds().overlaps(character.getBounds())) {
                        p.hitPlatform(character);
                    }
                }
                //remove all broken platforms from platform array
                this.platforms.removeAll(this.temp);

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
                this.playersScore = new TimeTaken(this.minutesDisplayed, this.secondsDisplayed, this.currentLevel, (fireboy.getGemsCollected() + watergirl.getGemsCollected()));
                this.playersScore.importScores();
                this.playersScore.add(this.playersScore);
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
            // pause the game and timer
            pauseTimer();
            this.pause = true;
        } else if (Gdx.input.justTouched()
                && (click.x >= 620 && click.x <= 670)
                && (click.y >= 2 && click.y <= 30)
                && this.pause) {
            // unpause the game and timer
            this.pause = false;
            this.startTimer = true;
        }

        // advance to the next level
        if (this.levelWon
                && Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            this.nextLevel = true;
            this.fireboy.clearGems();
            this.watergirl.clearGems();
            this.startTimer = true;
            super.setDisplay(false);
        }

        // determine if you need to reset the Level
        if (((this.fireboy.isDead()
                || this.watergirl.isDead())
                || this.fireboy.isDead() && this.watergirl.isDead())
                && Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            this.fireboy.clearGems();
            this.watergirl.clearGems();
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
            
            //adds back broken platforms
            this.platforms.addAll(this.temp);
            this.temp.clear();         
            // reset the timer
            this.startTimer = true;
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

         // draw the Doors
        this.fireDoor.draw(super.getSpriteBatch());
        this.waterDoor.draw(super.getSpriteBatch());
        
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

       

        // draw the Characters if they haven't died yet
        if (!this.fireboy.isDead()) {
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && !this.pause) {
                this.fireboy.drawLeft(super.getSpriteBatch());
            } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && !this.pause) {
                this.fireboy.drawRight(super.getSpriteBatch());
            } else {
                this.fireboy.draw(super.getSpriteBatch());
            }
        }
        if (!this.watergirl.isDead()) {
            if (Gdx.input.isKeyPressed(Input.Keys.A) && !this.pause) {
                this.watergirl.drawLeft(super.getSpriteBatch());
            } else if (Gdx.input.isKeyPressed(Input.Keys.D) && !this.pause) {
                this.watergirl.drawRight(super.getSpriteBatch());
            } else {
                this.watergirl.draw(super.getSpriteBatch());
            }
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
            //  time = System.currentTimeMillis();
            this.highScoreFont.setColor(Color.VIOLET);
            this.highScoreFont.draw(super.getSpriteBatch(), playersScore.getHighScore() + "", 260, 320);
        }

        // draw the character death screen
        if ((this.fireboy.isDead() || this.watergirl.isDead())
                || (this.fireboy.isDead() && this.watergirl.isDead())) {
            time = System.currentTimeMillis();
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
