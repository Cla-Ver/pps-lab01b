package it.unibo.pps.e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {
    private Grid grid;
    private static final int GRID_SIZE = 5;
    private static final int N_MINES = 5;

    @Test
    public void gridShouldHaveCorrectNumberOfCells(){
        grid = new GridImpl(GRID_SIZE, N_MINES);
        assertEquals(GRID_SIZE * GRID_SIZE, grid.getNumberOfCells());
    }

    @Test
    public void gridShouldHaveEnoughMines(){
        grid = new GridImpl(GRID_SIZE, N_MINES);
        assertEquals(N_MINES, grid.getNumberOfMines());
    }

    @Test
    public void gridShouldThrowExceptionOnHittingInvalidMinePosition(){
        grid = new GridImpl(GRID_SIZE, N_MINES);
        assertThrows(IllegalArgumentException.class, () -> grid.hitCell(new Pair<>(GRID_SIZE, GRID_SIZE)));
    }

    @Test
    public void gridShouldBeClearIfOnlyMinesRemain(){
        grid = new GridImpl(GRID_SIZE, 0);
        for(int row = 0; row < GRID_SIZE; row++){
            for(int col = 0; col < GRID_SIZE; col++){
                grid.hitCell(new Pair<>(col, row));
            }
        }
        assertTrue(grid.isClear());
    }
}
