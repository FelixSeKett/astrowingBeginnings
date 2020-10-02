package com.astrowingbeginnings.game;

import com.astrowingbeginnings.game.games.AstrowingBeginnings;
import com.astrowingbeginnings.game.groups.Tile;
import com.astrowingbeginnings.game.groups.World;
import com.astrowingbeginnings.game.groups.tables.Hud;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen
{
    // =====================================================
    // FIELDS
    // =====================================================

    private static final int      WIDTH_IN_TILES   = 10;
    private static final int      HEIGHT_IN_TILES  = 9;
    public static final  int      WIDTH_IN_PIXELS  = WIDTH_IN_TILES * Tile.WIDTH_IN_PIXELS;
    public static final  int      HEIGHT_IN_PIXELS = HEIGHT_IN_TILES * Tile.HEIGHT_IN_PIXELS;
    private final        Stage    STAGE;
    private final        World    WORLD;
    private final        Viewport VIEWPORT;
    private              boolean  run;

    // =====================================================
    // CONSTRUCTORS
    // =====================================================

    public GameScreen()
    {
        VIEWPORT = new FitViewport(WIDTH_IN_PIXELS, HEIGHT_IN_PIXELS);
        STAGE    = new Stage();
        WORLD    = new World(this);
        run      = true;
        STAGE.addActor(WORLD);
        Hud hud = new Hud(this);
        STAGE.addActor(hud);
    }

    // =====================================================
    // METHODS
    // =====================================================

    @Override public void show()
    {
        STAGE.setDebugAll(AstrowingBeginnings.DEBUG);
        Gdx.input.setInputProcessor(STAGE);
        STAGE.setViewport(VIEWPORT);
        VIEWPORT.apply(true);
    }

    @Override public void render(float delta)
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        STAGE.act();
        STAGE.draw();
    }

    @Override public void resize(int width, int height)
    {
        VIEWPORT.update(width, height);
    }

    @Override public void pause()
    {
    }

    @Override public void resume()
    {
    }

    @Override public void hide()
    {
    }

    @Override public void dispose()
    {
        World.TEXTURE.dispose();
        Hud.TEXTURE.dispose();
    }

    public void play()
    {
        if (run) {
            WORLD.play();
        }
    }

    public void stop()
    {
        if (run) {
            WORLD.stop();
        }
    }

    public void cancel(String string)
    {
        Gdx.app.log("ERROR", string);
        stop();
        run = false;
        createLabel();
    }

    private void createLabel()
    {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font      = new BitmapFont();
        labelStyle.fontColor = Color.WHITE;
        Label label = new Label("ABBRUCH", labelStyle);
        float x     = STAGE.getWidth() / 2f - label.getWidth() / 2f;
        float y     = STAGE.getHeight() / 2f - label.getHeight() / 2f;
        label.setPosition(x, y);
        STAGE.addActor(label);
    }
}
