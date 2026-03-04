package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTest {
    private Knight knight;

    @BeforeEach
    public void init() {
        knight = new KnightImpl(0, 0);
    }

    @Test
    public void knightShouldMove(){
        final Pair<Integer, Integer> targetPosition = new Pair<>(1, 2);
        knight.move(KnightMove.DOWN_RIGHT);
        assertEquals(targetPosition, knight.getPosition());
    }

    @Test
    public void knightShouldAllowNegativeYPosition(){
        knight.move(KnightMove.UP_RIGHT);
        assertTrue(knight.getPosition().getY() < 0);
    }

}
