package com.astrowingbeginnings.game.groups.tables.buttons;

import com.astrowingbeginnings.game.GameScreen;
import com.astrowingbeginnings.game.groups.Tile;
import com.astrowingbeginnings.game.groups.tables.Hud;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class PlayImageButton extends ImageButton
{
    // =====================================================
    // FIELDS
    // =====================================================

    // nothing

    // =====================================================
    // CONSTRUCTORS
    // =====================================================

    public PlayImageButton(final GameScreen GAME_SCREEN)
    {
        super(new TextureRegionDrawable(new TextureRegion(Hud.TEXTURE,
                                                          0,
                                                          0,
                                                          Tile.WIDTH_IN_PIXELS,
                                                          Tile.HEIGHT_IN_PIXELS)),
              new TextureRegionDrawable(new TextureRegion(Hud.TEXTURE,
                                                          0,
                                                          Tile.HEIGHT_IN_PIXELS,
                                                          Tile.WIDTH_IN_PIXELS,
                                                          Tile.HEIGHT_IN_PIXELS)));
        addListener(new ClickListener()
        {
            @Override public void clicked(InputEvent event, float x, float y)
            {
                GAME_SCREEN.play();
            }
        });
    }

    // =====================================================
    // METHODS
    // =====================================================

    // nothing
}
