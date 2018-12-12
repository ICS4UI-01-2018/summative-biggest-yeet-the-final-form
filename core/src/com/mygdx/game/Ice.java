/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

/**
 *
 * @author hadim9637
 */
public class Ice extends Platform{
    
    public Ice(float x, float y, int width, int height){
        super(x,y,width,height);
    }
    public boolean onIce (Character character){
        if (character.getBounds().overlaps(this.getBounds())){
            return true;
        }else{ 
            return false;
    }
  
}
}
