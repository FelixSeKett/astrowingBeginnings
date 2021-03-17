package com.astrowingbeginnings.game.games;

import com.astrowingbeginnings.game.GameScreen;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class AstrowingBeginnings extends Game
{
    // =====================================================
    // FIELDS
    // =====================================================

    public static final boolean DEBUG            = true;
    public static final int     SPEED_MULTIPLIER = 5;

    // =====================================================
    // METHODS
    // =====================================================

    @Override public void create()
    {
        GameScreen gameScreen = new GameScreen();
        setScreen(gameScreen);
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
    }
}
