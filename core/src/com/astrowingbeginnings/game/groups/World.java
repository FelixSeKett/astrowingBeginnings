package com.astrowingbeginnings.game.groups;

import com.astrowingbeginnings.game.Direction;
import com.astrowingbeginnings.game.GameScreen;
import com.astrowingbeginnings.game.groups.tiles.Area;
import com.astrowingbeginnings.game.groups.tiles.ships.Arwing;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;

public class World extends Group
{
    // =====================================================
    // FIELDS
    // =====================================================

    static final         Texture    TEXTURE         = new Texture("core/assets/map.png");
    private static final int        WIDTH_IN_TILES  = 8;
    private static final int        HEIGHT_IN_TILES = 8;
    public final         GameScreen GAME_SCREEN;
    private final        Area[][]   AREAS;
    private final        Arwing     ARWING;

    // =====================================================
    // CONSTRUCTORS
    // =====================================================

    public World(GameScreen gameScreen)
    {
        GAME_SCREEN = gameScreen;
        AREAS       = new Area[WIDTH_IN_TILES][HEIGHT_IN_TILES];
        for (int i = 0; i < WIDTH_IN_TILES; i++) {
            for (int j = 0; j < HEIGHT_IN_TILES; j++) {
                Area area = new Area(this, i, j);
                AREAS[i][j] = area;
                addActor(area);
            }
        }
        ARWING = new Arwing(AREAS[3][3]);
        setPosition(Tile.WIDTH_IN_PIXELS / 2f, Tile.HEIGHT_IN_PIXELS / 2f);
    }

    // =====================================================
    // METHODS
    // =====================================================

    public Area giveArea(Area referenceArea, Direction direction)
    {
        int column = referenceArea.COLUMN + direction.COLUMN;
        int row    = referenceArea.ROW + direction.ROW;
        return giveArea(column, row);
    }

    private Area giveArea(int column, int row)
    {
        if (column >= 0 && column < AREAS.length && row >= 0 && row < AREAS[column].length) {
            return AREAS[column][row];
        }
        return null;
    }

    public void play()
    {
        ARWING.play();
    }

    public void stop()
    {
        ARWING.stop();
    }
}
