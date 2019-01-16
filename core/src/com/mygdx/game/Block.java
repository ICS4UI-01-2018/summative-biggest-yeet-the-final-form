/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

/**
 * A Block in a game of Fireboy and Watergirl that inherits from the class
 * Platform. This acts as an obstacle that the Fireboy and Watergirl will have
 * to work around through the Levels of the game.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Block extends Platform {

    private float speed, ySpeed, gravity;
    private boolean onGround;
    private Rectangle overlap;

    /**
     * Initializes a Block in a game of Fireboy and Watergirl using its x and y
     * position, and its width and height.
     *
     * @param x a float representing the x position of the Block
     * @param y a float representing the y position of the Block
     * @param width a float representing the width of the Block
     * @param height a float representing the height of the Block
     */
    public Block(float x, float y, float width, float height) {
        super(x, y, width, height);
        this.speed = 2;
        this.overlap = new Rectangle(0, 0, 0, 0);
    }

    public void fall() {
        if (!this.onGround) {
            ySpeed += gravity;
            super.setY(super.getY() - this.ySpeed);
        }
    }

    /**
     * Sets block to be standing on a platform
     *
     * @param platforms array of platforms
     */
    public void onTop(Platform[] platforms) {
        int counter = 0;
        for (Platform p : platforms) {
            if (super.getY() == p.getTop()) {
                if ((super.getX() >= p.getX() && super.getFarX() <= p.getFarX())) {
                    this.onGround = true;
                    counter++;
                } else if (super.getX() < p.getX() && super.getFarX() >= p.getX()) {
                    this.onGround = true;
                    counter++;
                } else if (super.getFarX() > p.getFarX() && super.getX() <= p.getFarX()) {
                    this.onGround = true;
                    counter++;
                }
            }
        }

        if (counter == 0) {
            this.onGround = false;
            // this.speed = 2f;//tweak
        }
        super.updatePositions();
    }
    
    public void hmmm (Character c){//have to check if c is on to of block
       if (this instanceof Platform){
           
    }
        
    }
    


    /**
     * Stops character from jumping if on platform
     *
     * @param p
     */
    @Override
    public void whereIsPlayer(Character c) {
        this.overlap = super.intersection(c.getBounds(), super.getBounds(), this.overlap);
//        System.out.println(this.overlap.width + " " + this.overlap.height);
        if (this.overlap.height < this.overlap.width) {
            if (c.getYSpeed() > 0) {
                c.setY(this.getTop());
                c.setOnGround(true);
                c.setJumping(false);
                //   System.out.println("on top");
            }
        } else {
            // player is on the right
            if (c.getX() < this.getX()) {
                c.setFarX(super.getX());
                //   System.out.println(" right");
                //c.setX(c.getX() - super.getX());//tweak the 10
                super.setX(super.getX() + this.speed);
                super.updatePositions();
                //   System.out.println(" right");
                // c.setX(c.getX() - super.getX() - 10);//tweak the 10
                super.updatePositions();
            } else {
                //   System.out.println("left");
                c.setX(super.getFarX());
                super.setX(super.getX() - this.speed);
                super.updatePositions();
            }
            // c.setOnGround(false); 
        }
        c.updatePositions();
    }

    /**
     * Stops character from jumping if on platform
     *
     * @param p
     */
    public void isBlockHittingPlatform(Platform p) {
        this.overlap = super.intersection(super.getBounds(), p.getBounds(), this.overlap);
//        System.out.println(this.overlap.width + " " + this.overlap.height);
        if (this.overlap.height < this.overlap.width) {
//            if (c.getYSpeed() > 0) {
//                c.setY(this.getTop());
//                c.setOnGround(true);
//                c.setJumping(false);
//                //   System.out.println("on top");
//            }
        } else {
            // player is on the right
            if (super.getX() < p.getX()) {
                System.out.println("h");
                super.setFarX(p.getX());
                super.updatePositions();
            } else {
                super.setX(p.getFarX());
                //   System.out.println("left");
                super.updatePositions();
            }
            // c.setOnGround(false); 
        }

    }

    public void updatePos(Character c, Platform[] platforms) {
        if (c.getBounds().overlaps(super.getBounds())) {
            this.whereIsPlayer(c);
        }
        for (Platform p : platforms) {
            if (p.getBounds().overlaps(super.getBounds())) {
                this.isBlockHittingPlatform(p);
            }
        }
        this.onTop(platforms);
        this.fall();
    }
}
