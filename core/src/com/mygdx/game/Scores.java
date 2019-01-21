/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import java.time.LocalDate;

/**
 *
 * @author camet2651
 */
public class Scores {
    private LocalDate date;
    private int gems;
    public Scores (LocalDate date, int gems){
        this.date = date;
        this.gems = gems;
    }
}
