package com.astrowingbeginnings.game.groups.tiles.ships;

import com.astrowingbeginnings.game.GameScreen;
import com.astrowingbeginnings.game.groups.tiles.Area;
import com.astrowingbeginnings.game.groups.tiles.Ship;

public class Arwing extends Ship
{
    // =====================================================
    // FIELDS
    // =====================================================

    // nothing

    // =====================================================
    // CONSTRUCTORS
    // =====================================================

    public Arwing(Area area)
    {
        super(area);
    }

    // =====================================================
    // METHODS
    // =====================================================

    /**
     * Diese Methode beinhaltet alle Anweisungen für den Autopiloten. Beim {@link GameScreen#play() Spielstart}
     * werden diese in der Reihenfolge abgearbeitet, in der sie eingetragen wurden. Folgende Anweisungen stehen zur
     * Verfügung:
     * move() - Bewegt den Arwing ein Feld in Flugrichtung nach vorn
     * turnLeft() - Dreht den Arwing um 90° nach links
     */
    @Override public void setCourse()
    {

    }
}
