package com.astrowingbeginnings.game.groups.tiles;

import com.astrowingbeginnings.game.Direction;
import com.astrowingbeginnings.game.games.AstrowingBeginnings;
import com.astrowingbeginnings.game.groups.Tile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.utils.Array;

public abstract class Ship extends Tile
{
    // =====================================================
    // FIELDS
    // =====================================================

    private static final float          MOVEMENT_SPEED = 1f / AstrowingBeginnings.SPEED_MULTIPLIER;
    private              SequenceAction sequenceAction;
    private              Area           area;
    private              Direction      sightDirection;

    // =====================================================
    // CONSTRUCTORS
    // =====================================================

    public Ship(Area area)
    {
        super(0, 1);
        takeArea(area);
        takeSightDirection(Direction.UP);
        sequenceAction = new SequenceAction();
        run();
        removeSequenceAction();
    }

    // =====================================================
    // METHODS
    // =====================================================

    private void moveToArea(Area areaToMoveTo)
    {
        if (areaToMoveTo != null) {
            takeArea(areaToMoveTo);
        } else {
            area.WORLD.GAME_SCREEN.cancel("Keine Area Vorhanden!");
        }
    }

    private void takeArea(Area areaToTake)
    {
        areaToTake.addActor(this);
        area = areaToTake;
    }

    private void takeSightDirection(Direction sightDirectionToTake)
    {
        if (sightDirectionToTake != null) {
            sightDirection = sightDirectionToTake;
            setRotation(sightDirectionToTake.ROTATION);
        }
    }

    public void move()
    {
        RunnableAction runnableAction = new RunnableAction()
        {
            @Override public void run()
            {
                Area newArea = area.WORLD.giveArea(area, sightDirection);
                moveToArea(newArea);
            }
        };
        sequenceAction.addAction(runnableAction);
        delay();
    }

    public void turnLeft()
    {
        RunnableAction runnableAction = new RunnableAction()
        {
            @Override public void run()
            {
                Direction newSightDirection = sightDirection.giveNextDirectionClockwise();
                takeSightDirection(newSightDirection);
            }
        };
        sequenceAction.addAction(runnableAction);
        delay();
    }

    public void broadcast()
    {
        broadcast("");
    }

    public void broadcast(final Object OBJECT)
    {
        RunnableAction runnableAction = new RunnableAction()
        {
            @Override public void run()
            {
                String name = Ship.this.toString();
                String message = OBJECT.toString();
                String position = area.COLUMN + "-" + area.ROW;
                Gdx.app.log(name + " at " + position, message);
            }
        };
        sequenceAction.addAction(runnableAction);
        delay();
    }

    public abstract void run();

    private void removeSequenceAction()
    {
        RunnableAction runnableAction = new RunnableAction()
        {
            @Override public void run()
            {
                sequenceAction = null;
            }
        };
        sequenceAction.addAction(runnableAction);
    }

    public void play()
    {
        if (sequenceAction != null) {
            Array<Action> actions = getActions();
            if (!actions.contains(sequenceAction, false)) {
                addAction(sequenceAction);
            }
        }
    }

    public void stop()
    {
        if (sequenceAction != null) {
            removeAction(sequenceAction);
        }
    }

    private void delay()
    {
        DelayAction delayAction = new DelayAction(MOVEMENT_SPEED);
        sequenceAction.addAction(delayAction);
    }
}
