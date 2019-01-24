/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

/**
 * Creates a Button as a subclass of Obstacle to use in a game of Fireboy and
 * Watergirl. The Fireboy and Watergirl can push the button to move
 * MovingPlatforms to help each other win each Levels.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Button extends Obstacle {

    private final ArrayList<MovingPlatform> movingPlatforms;
    private final float maximumY, minimumY;
    private boolean isPressed;

    /**
     * Initializes a Button to use in a game of Fireboy and Watergirl using it's
     * x and y position on the screen.
     *
     * @param x a float representing the x coordinate of the Button
     * @param y a float representing the y coordinate of the Button
     */
    public Button(float x, float y) {
        // initialize the Texture, x and y position, and the width and height of the Button
        super(new Texture("Button.jpg"), x, y, 1, 0.5f);

        // initialize an ArrayList of MovingPlatforms that the Button controls
        this.movingPlatforms = new ArrayList<MovingPlatform>();

        // Button cannot move higher than this y position
        this.maximumY = y;
        // Button cannot move lower than this y position
        this.minimumY = y - 4;

        // initialize the Button to not be in a pressed state
        this.isPressed = false;
    }

    /**
     * Adds a MovingPlatform that the Button controls to the ArrayList.
     *
     * @param movingPlatform a MovingPlatform that the Button controls
     */
    public void addMovingPlatform(MovingPlatform movingPlatform) {
        this.movingPlatforms.add(movingPlatform);
    }

    /**
     * Updates the position of the Button as it is moving up and down.
     */
    public void updatePositions() {
        super.setObstacleY(super.getY());
    }

    /**
     * Returns the maximum y position that the Button can reach.
     *
     * @return a float representing the maximum y position that the Button can
     * reach
     */
    public float getMaximumY() {
        return this.maximumY;
    }

    /**
     * Returns the minimum y position that the Button can be.
     *
     * @return a float representing the minimum y position that the Button can
     * be
     */
    public float getMinimumY() {
        return this.minimumY;
    }

    /**
     * Returns the MovingPlatform that the Button is controlling.
     *
     * @return an ArrayList of MovingPlatforms representing the
     * MovingPlatform(s) that the Button can control
     */
    public ArrayList<MovingPlatform> getMovingPlatforms() {
        return this.movingPlatforms;
    }

    /**
     * Returns whether if the Button is pressed or not.
     *
     * @return a boolean representing if the Button is pressed or not
     */
    public boolean isPressed() {
        return this.isPressed;
    }

    /**
     * Sets the Button to be in a pressed state if a Character is colliding with
     * it.
     *
     * @param fireboy a Character representing a Fireboy that would be colliding
     * with the Button
     * @param watergirl a Character representing a Watergirl that would be
     * colliding with the Button
     */
    public void pressed(Fireboy fireboy, Watergirl watergirl) {
        this.isPressed = (super.collidesWith(fireboy) || super.collidesWith(watergirl))
                || (super.collidesWith(fireboy) && super.collidesWith(watergirl));
    }

    /**
     * Draws the Button on the screen using a SpriteBatch.
     *
     * @param batch a SpriteBatch used to draw the Button on the screen
     */
    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(super.getTexture(), super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
}
