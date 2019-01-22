package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.GameLauncher;
import com.mygdx.game.LevelOne;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        LwjglApplication lwjglApplication = new LwjglApplication (new GameLauncher(), config);
        // new LwjglApplication(new LevelOne(), config);
    }
}
