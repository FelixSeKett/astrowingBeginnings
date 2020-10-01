package com.astrowingbeginnings.game.groups.tiles;

import com.astrowingbeginnings.game.groups.Tile;
import com.astrowingbeginnings.game.groups.World;

public class Area extends Tile
{
    // =====================================================
    // FIELDS
    // =====================================================

    final        World WORLD;
    public final int   COLUMN;
    public final int   ROW;

    // =====================================================
    // CONSTRUCTORS
    // =====================================================

    public Area(World world, int column, int row)
    {
        super(column, row, 0, 0);
        WORLD  = world;
        COLUMN = column;
        ROW    = row;
    }

    // =====================================================
    // METHODS
    // =====================================================

    // nothing
}
