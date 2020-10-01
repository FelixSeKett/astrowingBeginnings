package com.astrowingbeginnings.game.desktop;

import com.astrowingbeginnings.game.GameScreen;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.astrowingbeginnings.game.games.AstrowingBeginnings;

public class DesktopLauncher
{
    public static void main(String[] arg)
    {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        int                           scale  = 4;
        config.width  = GameScreen.WIDTH_IN_PIXELS * scale;
        config.height = GameScreen.HEIGHT_IN_PIXELS * scale;
        new LwjglApplication(new AstrowingBeginnings(), config);
    }
}
