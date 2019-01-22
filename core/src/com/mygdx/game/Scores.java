/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import java.time.LocalDate;

/**
 *Contains player score
 * @author camet2651
 */

public class Scores {
    private LocalDate date;
    private int gems;
    /**
     * Creates a container for scores
     * @param date
     * @param gems 
     */
    public Scores (LocalDate date, Character f, Character w){
        this.date = date;
        this.gems = f.getGemsCollected() + w.getGemsCollected();
  
    }
    
    public int getGemsCollected(){
        return gems;
    }
}
