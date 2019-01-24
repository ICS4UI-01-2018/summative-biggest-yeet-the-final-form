/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Contains player score.
 *
 * @author biGgEsT yEeT: tHe fiNaL fOrM
 */
public class Scores {

    private LocalDate date;
    private int gems;
    private long seconds;
    private long minutes;//hours?
    private long pointsTime;
    ArrayList<Scores> scores = new ArrayList();
    ArrayList<Scores> time = new ArrayList();
    ArrayList<Long> temp = new ArrayList();
    ArrayList<Scores> temps = new ArrayList();
String file;
    /**
     * Creates a container for the scores.
     *
     * @param date a date representing the current date
     * @param fireboy a Character representing a Fireboy
     * @param watergirl a Character representing a Watergirl
     */
    public Scores(LocalDate date, int gems, long seconds, long minutes) {
        this.date = date;
        this.minutes = minutes;
        this.seconds = seconds;
        this.gems = gems;
    }

    public String points(int numGems) {
        String Highscore = "";
        for (Scores h : this.scores) {
            if (h.gems == numGems) {
                time.add(h);
            }
        }

        temp = insertionSort(time, 1);

        for (Scores f : time) {
            if (temp.get(0) < f.minutes) {
                temps.add(f);
            }
        }
        time.removeAll(temps);
        temp = insertionSort(time, 2);

        for (Scores f : time) {
            if (temp.get(0) < f.seconds) {
                temps.add(f);
            }
        }

        time.removeAll(temps);
        if (time.get(0).seconds < 10) {
            Highscore = "The fastest time was 0" + time.get(0).minutes + ":0" + time.get(0).seconds + " on " + time.get(0).date;
        } else {
            Highscore = "The fastest time was 0" + time.get(0).minutes + ":" + time.get(0).seconds + " on " + time.get(0).date;
        }
        return Highscore;
    }

 

    public void saved(String file) {
        String line = "";
        try {
            Scanner input = new Scanner(new File(file));
            // scores.add(s);
            //while there are still customers
            while (input.hasNext()) {
                line = input.nextLine();
                String[] scoreInfo = line.split(",");
                long secondsPassed = Long.parseLong(scoreInfo[0].trim());
                long minutesPassed = Long.parseLong(scoreInfo[1].trim());
                int gems = Integer.parseInt(scoreInfo[2].trim());
                LocalDate date = LocalDate.parse(scoreInfo[3].trim());
                Scores haha = new Scores(date, gems, secondsPassed, minutesPassed) ;
                this.scores.add(haha);
            }
            int g = scores.size();
            save(file);
        } catch (IOException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    public void save(String file) {
        try {
            PrintWriter output = new PrintWriter(new File(file));
            for (Scores s : this.scores) {
                long secondsPassed = s.seconds;
                long minutesPassed = s.minutes;
                int gems = s.gems;
                LocalDate date = s.date;
                output.println(secondsPassed + "," + minutesPassed + "," + gems + "," + date);
            }
            output.close();

        } catch (IOException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void add(Scores s, String f) {
        this.scores.add(s);
        saved(f);
    }

    public void swap(ArrayList<Long> n, int pos1, int pos2) {
        long temp = n.get(pos1);
        n.set(pos1, n.get(pos2));
        n.set(pos2, temp);
    }

    public ArrayList<Long> insertionSort(ArrayList<Scores> n, int num) {
        if (num == 1) {
            temp.clear();

            for (Scores x : time) {
                temp.add(x.minutes);
            }
        } else {
            temp.clear();
            for (Scores x : time) {

                temp.add(x.seconds);
            }
        }

        // go through the list
        for (int i = 0; i < temp.size() - 1; i++) {
            // start tracking the minimum spot
            int min = i;
            // go through looking for smaller
            for (int j = i + 1; j < temp.size(); j++) {
                // did you find smaller?
                if (temp.get(min) > temp.get(j)) {
                    // track that position instead
                    min = j;
                }
            }
            // put the minimum in position
            swap(temp, i, min);
        }

        return temp;
    }

}
