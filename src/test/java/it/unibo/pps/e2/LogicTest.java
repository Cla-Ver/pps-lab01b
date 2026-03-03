package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {
    private Logics logics;
    private static final int BOARD_SIZE = 5;

    @BeforeEach
    public void init() {
        logics = new LogicsImpl.Builder(BOARD_SIZE).randomKnight().randomPawn().build();
    }

    @Test
    public void test() {
        assert (true);
        // TODO: Add your test logic here
        // You can generate random inputs and assert the expected output
        // For example:
        // int result = Logic.someMethod(5, 10);
        // assertEquals(expectedResult, result);
    }

    @Test
    public void chessboardShouldHaveOnlyOneKnight() {
        int knights = 0;
        for (int column = 0; column < BOARD_SIZE; column++) {
            for (int row = 0; row < BOARD_SIZE; row++) {
                if (logics.hasKnight(row, column)) {
                    knights++;
                }
            }
        }
        assertEquals(1, knights);
    }

    @Test
    public void chessboardShouldHaveOnlyOnePawn() {
        int pawns = 0;
        for (int column = 0; column < BOARD_SIZE; column++) {
            for (int row = 0; row < BOARD_SIZE; row++) {
                if (logics.hasPawn(row, column)) {
                    pawns++;
                }
            }
        }
        assertEquals(1, pawns);
    }

    @Test
    public void shouldNotBeAbleToAccessOutOfBoundsSquares(){
        assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(BOARD_SIZE + 1, BOARD_SIZE + 1));
    }

    @Test
    public void shouldNotBeAbleToPositionKnightOutOfBounds(){
        assertThrows(IndexOutOfBoundsException.class, () -> logics = new LogicsImpl.Builder(BOARD_SIZE).randomPawn().knight(new Pair<>(BOARD_SIZE, BOARD_SIZE)).build());
    }

}
