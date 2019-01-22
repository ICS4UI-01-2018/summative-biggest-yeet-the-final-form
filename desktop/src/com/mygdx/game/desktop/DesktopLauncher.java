package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.LevelOne;
import com.mygdx.game.LevelTwo;
import com.mygdx.game.MainMenu;
//import com.mygdx.game.testFalling;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        // new LwjglApplication(new LevelOne(), config);
        // new LwjglApplication(new testFalling(), config);
         new LwjglApplication(new LevelTwo(), config);
        
        // create a MainMenu screen
        MainMenu mainMenu = new MainMenu();
        
        // create LevelOne
        LevelOne levelOne = new LevelOne();
        levelOne.setScreenOn(true);
        
        // create LevelTwo
        LevelTwo levelTwo = new LevelTwo();
        
        if (levelOne.getScreenOn()) {
            new LwjglApplication(levelOne, config);
            if (levelOne.isLevelWon()) {
                levelTwo.setScreenOn(true);
            }
        }
    }
}
