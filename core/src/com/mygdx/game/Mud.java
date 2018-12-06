/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Mud extends Obstacle {

    private Rectangle mud;

    public Mud(int width, int height, float x, float y) {
        super(x, y, width, height);
    }

    public float getX() {
        return super.getX();
    }

    public float getY() {
        return super.getY();
    }

    public Rectangle getBounds() {
        return mud;
    }

    {

    }

}
