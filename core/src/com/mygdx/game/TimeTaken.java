/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Contains player score.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class TimeTaken {

    private int level, gemsCollected, gemsInLevel;
    private long seconds;
    private long minutes;
    private ArrayList<TimeTaken> scores;
    private String file;

    /**
     * Create a new score to possibly be added to the array list
     *
     * @param minutes the minutes taken to complete the level
     * @param seconds the seconds taken to complete the level
     * @param level the level the completed
     * @param gems the gems collected by the players
     */
    public TimeTaken(long minutes, long seconds, int level, int gems) {
        scores = new ArrayList();
        this.minutes = minutes;
        this.seconds = seconds;
        this.level = level;
        this.gemsCollected = gems;
        //determine which file to save to and the needed number of gems
        if (this.level == 1) {
            this.file = "scoresL1";
            this.gemsInLevel = 8;
        }
        if (this.level == 2) {
            this.file = "scoresL2";
            this.gemsInLevel = 16;
        }
        if (this.level == 3) {
            this.file = "scoresL3";
            this.gemsInLevel = 12;
        }

    }

    /**
     * Adds scores from a file to the array list
     */
    public void importScores() {
        String line = "";
        try {
            Scanner input = new Scanner(new File(this.file));
            //while there are still customers
            while (input.hasNext()) {
                line = input.nextLine();
                String[] scoreInfo = line.split(",");
                long minutesPassed = Long.parseLong(scoreInfo[0].trim());
                long secondsPassed = Long.parseLong(scoreInfo[1].trim());
                int gemsCollected = Integer.parseInt(scoreInfo[2].trim());
                TimeTaken haha = new TimeTaken(minutesPassed, secondsPassed, this.level, gemsCollected);
                this.scores.add(haha);
            }
            // save();
        } catch (IOException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    /**
     * Adds a new score to the list
     *
     * @param s the score being added
     */
    public void add(TimeTaken s) {
        if (s.gemsCollected == this.gemsInLevel) {
            this.scores.add(s);
        }
        save();
    }

    /**
     * Prints out all scores to the appropriate file
     */
    public void save() {
        try {
            PrintWriter output = new PrintWriter(new File(this.file));
            //sort the array list
            this.scores = insertionSort(this.scores);
            //print out sorted scores
            for (TimeTaken s : this.scores) {
                long secondsPassed = s.seconds;
                long minutesPassed = s.minutes;
                long gemsCollected = s.gemsCollected;
                output.println(minutesPassed + "," + secondsPassed + "," + gemsCollected);
            }
            output.close();

        } catch (IOException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    /**
     * Swaps two scores in an array list
     *
     * @param list array list scores are in
     * @param pos1 the position of the first score being switched
     * @param pos2 the position of the second score being switched
     */
    public void swap(ArrayList<TimeTaken> list, int pos1, int pos2) {
        TimeTaken temp = list.get(pos1);
        list.set(pos1, list.get(pos2));
        list.set(pos2, temp);
    }

    /**
     * Sorts an array from lowest to highest time
     *
     * @param n the array being sorted
     * @return the sorted array
     */
    public ArrayList<TimeTaken> insertionSort(ArrayList<TimeTaken> n) {
        // go through the list
        for (int i = 0; i < n.size() - 1; i++) {
            // start tracking the smallest minutes
            int min = i;
            // looking for smaller number
            for (int j = i + 1; j < n.size(); j++) {
                // did you find smaller?
                if (n.get(min).minutes > n.get(j).minutes) {
                    // track that position instead
                    min = j;
                } //if minutes are the same look at seconds instead
                else if (n.get(min).minutes == n.get(j).minutes && n.get(min).seconds > n.get(j).seconds) {
                    min = j;
                }
            }
            // put the minimum in position
            swap(n, i, min);
        }
        return n;
    }

    /**
     * Returns the fastest time the level was completed (all gems collected)
     *
     * @return the fastest time the level was completed
     */
    public String getHighScore() {
        String Highscore = "";
        if (this.scores.isEmpty()) {
            Highscore = "This level has not been completed";
        } else {
            if (scores.get(0).seconds < 10) {
                if (scores.get(0).minutes < 10) {
                    Highscore = "Highscore is 0" + scores.get(0).minutes + ":0" + scores.get(0).seconds;
                } else {
                    Highscore = "Highscore is " + scores.get(0).minutes + ":0" + scores.get(0).seconds;
                }
            } else if (scores.get(0).minutes < 10) {
                Highscore = "Highscore is 0" + scores.get(0).minutes + ":" + scores.get(0).seconds;
            } else {
                Highscore = "Highscore is " + scores.get(0).minutes + ":" + scores.get(0).seconds;
            }
        }
        return Highscore;
    }

}
