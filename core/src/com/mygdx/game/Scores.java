/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import java.time.LocalDate;

/**
 * Contains player score.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Scores {

    private LocalDate date;
    private int gems;

    /**
     * Creates a container for the scores.
     *
     * @param date a date representing the current date
     * @param fireboy a Character representing a Fireboy
     * @param watergirl a Character representing a Watergirl
     */
    public Scores(LocalDate date, Fireboy fireboy, Watergirl watergirl) {
        this.date = date;
        this.gems = fireboy.getGemsCollected() + watergirl.getGemsCollected();
    }

    /**
     * 
     * @return an integer representing...
     */
    public int getGemsCollected() {
        return this.gems;
    }
}
