package com.astrowingbeginnings.game.groups.tables;

import com.astrowingbeginnings.game.GameScreen;
import com.astrowingbeginnings.game.groups.Tile;
import com.astrowingbeginnings.game.groups.tables.buttons.PlayImageButton;
import com.astrowingbeginnings.game.groups.tables.buttons.StopImageButton;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Hud extends Table
{
    // =====================================================
    // FIELDS
    // =====================================================

    public static final Texture TEXTURE = new Texture("core/assets/hud.png");

    // =====================================================
    // CONSTRUCTORS
    // =====================================================

    public Hud(GameScreen gameScreen)
    {
        setBounds(9f * Tile.WIDTH_IN_PIXELS, 0f, Tile.WIDTH_IN_PIXELS, 9f * Tile.HEIGHT_IN_PIXELS);
        ImageButton playImageButton = new PlayImageButton(gameScreen);
        add(playImageButton);
        row();
        ImageButton stopImageButton = new StopImageButton(gameScreen);
        add(stopImageButton);
    }

    // =====================================================
    // METHODS
    // =====================================================

    // nothing
}
