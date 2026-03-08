package it.unibo.pps.e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogicsTest {
    private Logics logics;
    private static final int GRID_SIZE = 5;
    private static final int N_MINES = 5;

    @BeforeEach
    public void init(){
        logics = new LogicsImpl(new GridImpl(GRID_SIZE, N_MINES));
    }

    @Test
    public void logicsShouldCreateGridOfCorrectSize(){
        assertEquals(GRID_SIZE * GRID_SIZE, logics.getNumberOfCells());
    }

    @Test
    public void logicsShouldCreateCorrectNumberOfMines(){
        assertEquals(N_MINES, logics.countMines());
    }

}
