///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mygdx.game;
//
///**
// * Creates a FireDoor as a subclass of Door to use in the Fireboy and Watergirl
// * game.
// *
// * @author biGgEsT yEeT: tHe fiNaL fOrM
// */
//public class FireDoor extends Door {
//
//    /**
//     * Creates a FireDoor using the x and y position, which only lets Fireboys
//     * pass through.
//     *
//     * @param x a float representing the x position of the FireDoor
//     * @param y a float representing the y position of the FireDoor
//     */
//    public FireDoor(float x, float y) {
//        super(x, y);
//    }
//
//    /**
//     * Determines whether the Fireboy is standing in front of the FireDoor.
//     *
//     * @param fireboy the Fireboy in the game
//     * @return a boolean representing whether if the Fireboy is standing in
//     * front of the Firedoor
//     */
//    public boolean collision(Fireboy fireboy) {
//        return super.door.overlaps(fireboy.getBounds());
//    }
//}
