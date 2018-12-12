/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

/**
 * Creates a Fireboy as a subclass of Character to use in a game of Fireboy and
 * Watergirl.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Fireboy extends Character {
//need to add some kind of check colllison method to see if colliding with ANY platform
    /**
     * Creates a Fireboy using it's x and y position on the screen.
     *
     * @param x a float representing the x position on the screen
     * @param y a float representing the y position on the screen
     */
    public Fireboy(float x, float y) {
        super(x, y);
    }
    public void moveLeft() {
        
        if(!hitSide){
            
//        // do not let the Character move off of the left-side of the screen
//        if (super.x > 16) {
//            // make the Character move towards the left of the screen
//            super.x = this.x - this.speed;
//        }
//        }
//        
//        
//    }
//
//    /**
//     * Allows the Character to move towards the right-side of the screen without
//     * it going off of the screen.
//     */
//    public void moveRight() {
//        if(!hitSide){
//        // do not let the Character move off of the right-side of the screen
//        if (this.x < 632) {
//            // make the Character move towards the right of the screen
//            this.x = this.x + this.speed;
//        }
//        }
//    }
    

}
