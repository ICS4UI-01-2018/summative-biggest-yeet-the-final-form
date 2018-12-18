///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mygdx.game;
//
//import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//import com.badlogic.gdx.math.Rectangle;
//
///**
// * Creates a Door to use in a game of Fireboy and Watergirl. Allows for the
// * creation of either a FireDoor or a WaterDoor for a Fireboy or a Watergirl to
// * pass through to enter the next level.
// *
// * @author biGgEsT yEeT: tHe fiNaL fOrM
// */
//public abstract class Door {
//
//    private int height, width;
//    private float x, y;
//    Rectangle door;
//
//    /**
//     * Create a Character using the Character-type allowed through the door, and
//     * the x and y position of the Door.
//     *
//     * @param x a float representing the x position of the Door
//     * @param y a float representing the y position of the Door
//     */
//    public Door(float x, float y) {
//        this.x = x;
//        this.y = y;
//        this.width = 32;
//        this.height = 40;
//        
//        this.door = new Rectangle(this.x, this.y, this.width, this.height);
//    }
//
//    /**
//     * Returns the x position of the Door.
//     *
//     * @return a float representing the x position of the Door
//     */
//    public float getX() {
//        return this.x;
//    }
//
//    /**
//     * Returns the y position of the Door.
//     *
//     * @return a float representing the y position of the Door
//     */
//    public float getY() {
//        return this.y;
//    }
//
//    /**
//     * Returns the Door's height.
//     *
//     * @return an integer representing the Door's height
//     */
//    public int getHeight() {
//        return this.height;
//    }
//
//    /**
//     * Returns the Door's width.
//     *
//     * @return an integer representing the Door's width
//     */
//    public int getWidth() {
//        return this.width;
//    }
//
//    /**
//     * Draws the Door on the screen using a ShapeRenderer.
//     *
//     * @param shapeBatch a ShapeRenderer used to draw the Door on the screen
//     */
//    public void draw(ShapeRenderer shapeBatch) {
//        shapeBatch.rect(door.x, door.y, door.width, door.height);
//    }
//}
