/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Platform {

    //Creates a Rectangle that can be used to create platforms
    private Rectangle shape;
    //Create integers for the platform to function
    private int height;
    private int width;
    private float x;
    private float y;

    //Constructor for the platform
    public Platform(float x, float y, int width, int height) {
        shape = new Rectangle(x, y, width, height);
    }

    //Gets the X-coordinate of the platform
    public float getX() {
        return this.x;
    }

    //Gets the Y-coordinate of the platform
    public float getY() {
        return this.y;
    }

    //Detects player collision with the platform
    public boolean collision(Character c) {
        return shape.overlaps(c.getBounds());
    }

    //Allows the platforms to be drawn onto the map
    public void draw(ShapeRenderer shapeBatch) {
        shapeBatch.rect(shape.x, shape.y, shape.width, shape.height);
    }

}

