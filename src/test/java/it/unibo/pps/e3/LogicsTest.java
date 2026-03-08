package it.unibo.pps.e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void logicsShouldProperlyHitMine(){
        Pair<Integer, Integer> minePosition = new Pair<>(0, 0);
        logics = new LogicsImpl(new GridImpl(GRID_SIZE, 1, List.of(minePosition)));
        assertTrue(logics.hit(minePosition));
    }


}
