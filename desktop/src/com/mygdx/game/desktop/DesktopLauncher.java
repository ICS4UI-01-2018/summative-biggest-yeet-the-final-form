package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;
//import com.mygdx.game.testFalling;
import com.mygdx.game.LevelTwo;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                new LwjglApplication(new MyGdxGame(), config);
//        new LwjglApplication(new testFalling(), config);
//        new LwjglApplication(new LevelTwo(), config);
    }
}
