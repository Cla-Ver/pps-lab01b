package it.unibo.pps.e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogicsTest {
    private Logics logics;
    private static final int GRID_SIZE = 5;

    @Test
    public void logicsShouldCreateGridOfCorrectSize(){
        logics = new LogicsImpl(GRID_SIZE);
        assertEquals(GRID_SIZE * GRID_SIZE, logics.getNumberOfCells());
    }

}
