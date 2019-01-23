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
        }

        // Characters can only move if the level hasn't been won yet
        if (!this.levelWon && !this.pause) {
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
            //make fireboy jump

            Character c = this.fireboy;
            for (int i = 0; i < 2; i++) {
                c.jumpAction();

                if (c.onTop(platforms) != null || c.onTop(platforms) != null) {
                    c.setThat(true, null);
                } else {
                    c.setThat(false, null);
                }
                for (MovingPlatform mp : this.movingPlatforms) {
                    mp.tieTo(c);
                    if (mp.getBounds().overlaps(c.getBounds())) {
                        mp.whereIsPlayer(c);
                    }
                }
                //check if he is on the ground
                //check if he is hitting a platform or a moving platform
                for (Platform p : this.platforms) {
                    if (p.breakBlock()) {
                        this.temp.add(p);
                        p.breakable = false;
                    }
                    if (p.getBounds().overlaps(c.getBounds())) {
                        p.whereIsPlayer(c);
                    }
                }
                this.platforms.removeAll(temp);
                c = this.watergirl;
            }

            // Watergirl keyboard listeners
            // only move the Watergirl is she hasn't died yet
            if (!this.watergirl.isDead()) {
//                watergirl.onTop(this.platforms, this.movingPlatforms);
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

            // constantly update the x and y positions of the Characters, the moving Platforms, and the Buttons
            this.fireboy.updatePositions();
            this.watergirl.updatePositions();
            for (MovingPlatform p : this.movingPlatforms) {
                p.updatePositions();
            }
            for (Button b : this.buttons) {
                b.updatePositions();
            }

            // allow the Fireboy to collect the FireGems
            for (FireGem fireGem : this.fireGems) {
                // determine if the Fireboy has collected the FireGem
                if (fireGem.collision(this.fireboy)) {
                    // don't draw the FireGem on the screen
                    fireGem.collected();
                    // add to the Fireboy's FireGem count
                    this.fireboy.addGem();
                }
            }

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
            this.highScore.saveFile("playerScores", fireboy, watergirl);
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
            super.setDisplay(false);
        }
    }

    /**
     * Allows for the drawing of the game objects.
     */
    public void draw() {
        // g.drawString("hello", 0, 0);
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
