/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author camet2651
 */
public class Files {

    private ArrayList<Scores> scores;

    public Files(String file, Character f, Character w) {
        this.scores = new ArrayList<Scores>();
        try {
            Scanner input = new Scanner(new File(file));
            //while there are still customers
            while (input.hasNext()) {
                System.out.println("hello");
                String line = input.nextLine();
                String[] customerInfo = line.split(",");
                LocalDate date = LocalDate.parse(customerInfo[0].trim());
                int gemsCollected = Integer.parseInt(customerInfo[1].trim());
                //if last customers account number is not one less than the current one there is a deleted customer  between them --> account number shouldn't be used
                //add customer to array
                Scores s = new Scores(date, f, w);
                this.scores.add(s);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("error");
        }
    }

    public void saveFile(String file, Character f, Character w) {
        try {
            for (Scores c : this.scores) {
                PrintWriter output = new PrintWriter(new File(file));
                //get customer info and encrypt it 
                LocalDate date = java.time.LocalDate.now();
                // String time = 
                int gemsCollected = c.getGemsCollected();
                output.println(date + "," + gemsCollected);
                output.close();
                System.out.println("here");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("error saving");

        }
    }

}
