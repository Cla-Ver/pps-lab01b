package it.unibo.pps.e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellTest {
    Cell cell;

    @Test
    public void hitShouldReturnTrueIfCellHasMine(){
        cell = new CellImpl(true);
        assertTrue(cell.hit());
    }
}
