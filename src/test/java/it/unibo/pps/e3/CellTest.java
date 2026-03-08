package it.unibo.pps.e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellTest {
    private Cell cell;

    @Test
    public void hitShouldReturnTrueIfCellHasMine(){
        cell = new CellImpl(true);
        assertTrue(cell.hit());
    }

    @Test
    public void hitShouldReturnFalseIfCellHasNoMine(){
        cell = new CellImpl(false);
        assertFalse(cell.hit());
    }

    @Test
    public void cellShouldRegisterHit(){
        cell = new CellImpl(false);
        cell.hit();
        assertTrue(cell.hasBeenHit());
    }

    @Test
    public void cellShouldBeFlaggable(){
        cell = new CellImpl(false);
        cell.toggleFlag();
        assertTrue(cell.hasFlag());
    }

    @Test
    public void cellShouldRemoveFlagIfFlaggedTwice(){
        cell = new CellImpl(false);
        cell.toggleFlag();
        cell.toggleFlag();
        assertFalse(cell.hasFlag());
    }


}
