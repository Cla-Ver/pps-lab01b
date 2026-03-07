package it.unibo.pps.e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {
    private Grid grid;
    private static final int GRID_SIZE = 5;
    private static final int N_MINES = 5;

    @Test
    public void gridShouldHaveEnoughMines(){
        grid = new GridImpl(GRID_SIZE, N_MINES);
        int nmines = 0;
        for(int row = 0; row < GRID_SIZE; row++){
            for(int col = 0; col < GRID_SIZE; col++){
                if(grid.hitCell(new Pair<>(row, col))){
                    nmines++;
                }
            }
        }
        assertEquals(N_MINES, nmines);
    }

    @Test
    public void gridShouldThrowExceptionOnHittingInvalidMinePosition(){
        grid = new GridImpl(GRID_SIZE, N_MINES);
        assertThrows(IllegalArgumentException.class, () -> grid.hitCell(new Pair<>(GRID_SIZE, GRID_SIZE)));
    }

    /*@Test
    public void gridShouldBeClearIfOnlyMinesRemain(){
        grid = new GridImpl(GRID_SIZE, 0);
        assertTrue(grid.isClear());
    }*/
}
