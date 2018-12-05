/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Door {
    
    /**
     * allows the doors to be drawn
     * @param shapeBatch draws the doors
     */
    public void draw(ShapeRenderer shapeBatch) {
        shapeBatch.rect(character.x, character.y, character.width, character.height);
    }
    
}
