/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

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

    long time, timePassed, secondsPassed, secondsDisplayed, minutesDisplayed;
    //should all instance variable be private?
    private FreeTypeFontGenerator generator;
    private FreeTypeFontParameter parameter;
    private BitmapFont font;
    private Texture pauseButton, levelCompleteScreen;
    private boolean levelWon, pause;
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
    Files highScore;
    ArrayList<Platform> temp;
    ArrayList<Gem> tempGem;
    boolean nextLevel;

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

        // level complete variables
        this.levelWon = false;
        this.levelCompleteScreen = new Texture("LevelComplete.jpg");

        // pause variables
        this.pause = false;
        this.pauseButton = new Texture("pause button.jpg");

        // initialize the font
        this.generator = new FreeTypeFontGenerator(Gdx.files.internal("data-unifon.ttf"));
        this.parameter = new FreeTypeFontParameter();
        this.parameter.size = 30;
        this.parameter.characters = "abcdefghijklmnopqrstuvwxyz0123456789.:";
        this.font = generator.generateFont(this.parameter);
        this.generator.dispose();
        this.nextLevel = false;

        this.time = System.currentTimeMillis();

    }

    public void resetTimer() {
        time = System.currentTimeMillis();
    }

    public String timer() {
        this.timePassed = System.currentTimeMillis() - time;
        this.secondsPassed = timePassed / 1000;
        this.secondsDisplayed = secondsPassed % 60;
        this.minutesDisplayed = secondsPassed / 60;

        return (minutesDisplayed + ":" + secondsDisplayed);
    }

    public void pauseTimer(boolean b) {//pause timer
        if (b) {
            long timePassedTemp = this.timePassed;
            long secondsPassedtemp = this.secondsPassed;
        } else {
            timer();
        }
    }

    /**
     * Implements the basic game logic for Fireboy and Watergirl.
     */
    @Override
    public void render() {

        // clear the background
        super.render();

        if (Gdx.input.isKeyPressed(Input.Keys.Y)) {
            System.out.println(this.fireboy.getY());
            resetTimer();
        }

        // constantly update the x and y positions of the Characters, the moving Platforms, and the Buttons
        this.fireboy.updatePositions();
        this.watergirl.updatePositions();
        for (MovingPlatform p : this.movingPlatforms) {
            p.moveDown();
            p.moveUp();
            p.updatePositions();

        }
        for (Button b : this.buttons) {
            b.updatePositions();
        }

        // Characters can only move if the level hasn't been won yet
        if (!this.levelWon && !this.pause) {

            String time = timer();
            // System.out.println(time);
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

                character.needsToBeRenamed(platforms, movingPlatforms);

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
                    this.fireboy.addGem();
                    this.fireboy.getGemsCollected();
                    this.tempGem.add(fireGem);
                    fireGem.collected();
                }

                // don't draw the FireGem on the screen
                // add to the Fireboy's FireGem count
            }
            this.fireGems.removeAll(tempGem);

            // allow the Watergirl to collect the WaterGems
            for (WaterGem waterGem : this.waterGems) {
                // determine if the Watergirl has collected the WaterGem
                if (waterGem.collision(this.watergirl)) {
                    // don't draw the WaterGem on the screen
                    waterGem.collected();
                    // add to the Watergirl's WaterGem count
                    this.watergirl.addGem();
                }
            }

            // allow the Watergirl to die when it comes into contact with Fire
            for (Fire f : this.fire) {
                if (f.collidesWith(this.watergirl)) {
                    this.watergirl.died();
                }
            }

            // allow the Fireboy to die when it comes into contact with Water
            for (Water w : this.water) {
                if (w.collidesWith(this.fireboy)) {
                    this.fireboy.died();
                }
            }

            for (Mud m : this.mud) {
                // allow the Fireboy to die when it comes into contact with Mud
                if (m.collidesWith(this.fireboy)) {
                    this.fireboy.died();
                }

                // allow the Watergirl to die when it comes into contact with Mud
                if (m.collidesWith(this.watergirl)) {
                    this.watergirl.died();
                }
            }

            // determines if the Buttons are pressed
            for (Button b : this.buttons) {
                b.pressed(this.fireboy, this.watergirl);
            }
        }

        // win the game if Fireboy and Watergirl stand in front of their respected Doors
        if (this.fireDoor.collision(this.fireboy)
                && this.waterDoor.collision(this.watergirl)) {
            this.levelWon = true;
            //   this.highScore.saveFile("playerScores", fireboy, watergirl);
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
        if (levelWon && Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            this.nextLevel = true;
            super.setDisplay(false);
        }
    }

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

        // do not draw the Fireboy on the screen if the Fireboy has died
        if (!this.fireboy.isDead()) {
            // set the color of the Fireboy to be red
            super.getShapeRenderer().setColor(Color.RED);
            this.fireboy.draw(super.getShapeRenderer());
        } else {
            //           this.highScore.saveFile("playerScores", fireboy, watergirl);
        }
        // do not draw the Watergirl on the screen if the Watergirl has died
        if (!this.watergirl.isDead()) {
            // set the color of the Watergirl to be blue
            super.getShapeRenderer().setColor(Color.BLUE);
            this.watergirl.draw(super.getShapeRenderer());
        }

        // draws a level complete screen when the Level has been won using a ShapeRenderer
        // allows for the drawing of the game objects to end
        super.getShapeRenderer().end();

        // allows for the drawing of Textures
        super.getSpriteBatch().setProjectionMatrix(super.getCamera().combined);
        super.getSpriteBatch().begin();

        this.font.draw(super.getSpriteBatch(), timer(), 10, 6);

        // draw the Platforms
        for (Platform p : this.platforms) {
            if (!p.getBroken()) {
                p.draw(super.getSpriteBatch());
            }
        }

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

        if (!pause) {
            // draw the Characters if they haven't died yet
            if (!this.fireboy.isDead()) {
                if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                    this.fireboy.drawLeft(super.getSpriteBatch());
                } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                    this.fireboy.drawRight(super.getSpriteBatch());
                } else {
                    this.fireboy.draw(super.getSpriteBatch());
                }
            } else {
                this.highScore.saveFile("playerScores", this.fireboy, this.watergirl);
            }
            if (!this.watergirl.isDead()) {
                if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                    this.watergirl.drawLeft(super.getSpriteBatch());
                } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                    this.watergirl.drawRight(super.getSpriteBatch());
                } else {
                    this.watergirl.draw(super.getSpriteBatch());
                }
            } else {
                this.highScore.saveFile("playerScores", this.fireboy, this.watergirl);
            }
        }

        // draw pause button
        super.getSpriteBatch().draw(this.pauseButton, 642, 2, 28, 28);

        // this.font.setColor(Color.BLUE);
        // this.font.draw(super.getSpriteBatch(), "yeet", 50, 50);
        // draw the level complete screen
        if (levelWon) {
            super.getSpriteBatch().draw(this.levelCompleteScreen, 221, 136, 230, 272);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.F)) {

            this.font.setColor(Color.WHITE);
            this.font.draw(super.getSpriteBatch(), "AHAHAHAH", 50, 50);
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
}
