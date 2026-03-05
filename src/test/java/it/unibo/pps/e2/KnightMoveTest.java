package it.unibo.pps.e2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KnightMoveTest {
    @ParameterizedTest
    @CsvSource({
            "DOWN_RIGHT, 1, 2",
            "DOWN_LEFT, -1, 2",
            "UP_RIGHT, 1, -2",
            "UP_LEFT, -1, -2",
            "RIGHT_UP, 2, -1",
            "RIGHT_DOWN, 2, 1",
            "LEFT_UP, -2, -1",
            "LEFT_DOWN, -2, 1"
    })
    public void knightMoveShouldReturnCorrectMove(KnightMove expected, int x, int y){
        assertEquals(expected, KnightMove.from(x, y));
    }

    @Test
    public void knightMoveShouldThrowExceptionOnInvalidMove(){
        assertThrows(IllegalArgumentException.class, () -> KnightMove.from(0, 0));
    }
}
