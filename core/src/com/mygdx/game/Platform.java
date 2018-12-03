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

    private Rectangle shape;
    private int height;
    private int width;
    private float x;
    private float y;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean collision(Character c) {
        return shape.overlaps(c.getBounds());
    }

    public void draw(ShapeRenderer shapeBatch) {
        shapeBatch.rect(shape.x, shape.y, shape.width, shape.height);
    }
}

