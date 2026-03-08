package it.unibo.pps.e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void logicsShouldNotHitMineIfTheCellIsSafe(){
        Pair<Integer, Integer> minePosition = new Pair<>(0, 0);
        logics = new LogicsImpl(new GridImpl(GRID_SIZE, 1, List.of(minePosition)));
        assertFalse(logics.hit(new Pair<>(GRID_SIZE - 1, GRID_SIZE - 1)));
    }

    @Test
    public void logicsShouldReturnMinesInTheNeighborhood(){
        Pair<Integer, Integer> mine1 = new Pair<>(1, 0);
        Pair<Integer, Integer> mine2 = new Pair<>(0, 1);
        logics = new LogicsImpl(new GridImpl(GRID_SIZE, 2, List.of(mine1, mine2)));
        assertEquals(2, logics.getAmountOfNearbyMines(new Pair<>(0, 0)));
    }

    @Test
    public void logicsShouldCheckForAlreadyHitCells(){
        logics = new LogicsImpl(new GridImpl(GRID_SIZE, N_MINES));
        Pair<Integer, Integer> hitPosition = new Pair<>(0, 0);
        logics.hit(hitPosition);
        assertTrue(logics.hasBeenHit(hitPosition));
    }

    @Test
    public void logicsShouldCheckOnGameWinIfEveryNonMineCellIsRevealed(){
        logics = new LogicsImpl(new GridImpl(GRID_SIZE, 0));
        logics.hit(new Pair<>(0, 0));
        assertTrue(logics.isGameWon());
    }

}
