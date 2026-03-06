package it.unibo.pps.e3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
