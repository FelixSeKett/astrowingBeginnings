package com.astrowingbeginnings.game;

public enum Direction
{
    // =====================================================
    // NESTED CLASSES
    // =====================================================

    UP(0, 1),
    RIGHT(1, 0),
    DOWN(0, -1),
    LEFT(-1, 0);

    // =====================================================
    // FIELDS
    // =====================================================

    public final int   COLUMN;
    public final int   ROW;
    public final float ROTATION;

    // =====================================================
    // CONSTRUCTORS
    // =====================================================

    Direction(int column, int row)
    {
        COLUMN   = column;
        ROW      = row;
        ROTATION = -90 * ordinal();
    }

    // =====================================================
    // METHODS
    // =====================================================

    public Direction giveNextDirectionClockwise()
    {
        int index = ordinal() - 1;
        if (index < 0) {
            index += 4;
        }
        return values()[index];
    }

    public Direction giveOppositeDirection()
    {
        Direction nextDirectionClockwise = giveNextDirectionClockwise();
        return nextDirectionClockwise.giveNextDirectionClockwise();
    }

    public Direction giveNextDirectionCounterClockwise()
    {
        Direction oppositeDirection = giveOppositeDirection();
        return oppositeDirection.giveNextDirectionClockwise();
    }
}
