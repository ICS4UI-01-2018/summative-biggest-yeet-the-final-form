package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
//import com.mygdx.game.LevelOne;
import com.mygdx.game.testFalling;
//import com.mygdx.game.LevelTwo;
//import com.mygdx.game.LevelThree;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
       //         new LwjglApplication(new LevelOne(), config);
     new LwjglApplication(new testFalling(), config);
//        new LwjglApplication(new LevelTwo(), config);
//        new LwjglApplication(new LevelThree(), config);
    }
}
