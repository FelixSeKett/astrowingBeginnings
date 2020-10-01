package com.astrowingbeginnings.game.groups;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Group;

public class Tile extends Group
{
    // =====================================================
    // FIELDS
    // =====================================================

    public static final int    WIDTH_IN_PIXELS  = 16;
    public static final int    HEIGHT_IN_PIXELS = 16;
    private final       Sprite SPRITE;

    // =====================================================
    // CONSTRUCTORS
    // =====================================================

    public Tile(int textureRegionColumn, int textureRegionRow)
    {
        this(0, 0, textureRegionColumn, textureRegionRow);
    }

    public Tile(int column, int row, int textureRegionColumn, int textureRegionRow)
    {
        SPRITE = new Sprite(World.TEXTURE,
                            textureRegionColumn * WIDTH_IN_PIXELS,
                            textureRegionRow * HEIGHT_IN_PIXELS,
                            WIDTH_IN_PIXELS,
                            HEIGHT_IN_PIXELS);
        setBounds(column * WIDTH_IN_PIXELS, row * HEIGHT_IN_PIXELS, WIDTH_IN_PIXELS, HEIGHT_IN_PIXELS);
        setOrigin(WIDTH_IN_PIXELS / 2f, HEIGHT_IN_PIXELS / 2f);
    }

    // =====================================================
    // METHODS
    // =====================================================

    @Override public void draw(Batch batch, float parentAlpha)
    {
        SPRITE.draw(batch);
        super.draw(batch, parentAlpha);
    }

    @Override public void positionChanged()
    {
        super.positionChanged();
        float x = getX();
        float y = getY();
        SPRITE.setPosition(x, y);
    }

    @Override public void rotationChanged()
    {
        super.rotationChanged();
        float rotation = getRotation();
        SPRITE.setRotation(rotation);
    }

    @Override public void setOrigin(float x, float y)
    {
        super.setOrigin(x, y);
        SPRITE.setOrigin(x, y);
    }
}
