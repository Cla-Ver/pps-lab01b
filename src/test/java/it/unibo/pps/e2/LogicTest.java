package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
    private Logics logics;
    private static final int BOARD_SIZE = 5;
    private static final int KNIGHT_START_X_POS = 0;
    private static final int KNIGHT_START_Y_POS = 0;

    @BeforeEach
    public void init() {
        logics = new LogicsImpl.Builder(BOARD_SIZE).randomKnight().randomPawn().build();
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
        assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(BOARD_SIZE, BOARD_SIZE));
    }

    @Test
    public void shouldNotBeAbleToPositionKnightOutOfBounds(){
        assertThrows(IndexOutOfBoundsException.class, () -> logics = new LogicsImpl.Builder(BOARD_SIZE).randomPawn().knight(new Pair<>(BOARD_SIZE, BOARD_SIZE)).build());
    }

    @Test
    public void shouldNotBeAbleToPositionPawnOutOfBounds(){
        assertThrows(IndexOutOfBoundsException.class, () -> logics = new LogicsImpl.Builder(BOARD_SIZE).randomKnight().pawn(new Pair<>(BOARD_SIZE, BOARD_SIZE)).build());
    }

    @Test
    public void shouldNotBeAbleToStartGameWithNoKnight(){
        assertThrows(IllegalStateException.class, () -> logics = new LogicsImpl.Builder(BOARD_SIZE).randomPawn().build());
    }

    @Test
    public void shouldNotBeAbleToStartGameWithNoPawn(){
        assertThrows(IllegalStateException.class, () -> logics = new LogicsImpl.Builder(BOARD_SIZE).randomKnight().build());
    }

    @Test
    public void knightShouldNotChangePositionOnIllegalMove(){
        logics = new LogicsImpl.Builder(BOARD_SIZE).randomPawn().knight(new Pair<>(KNIGHT_START_X_POS, KNIGHT_START_Y_POS)).build();
        logics.hit(BOARD_SIZE - 1, BOARD_SIZE - 1);
        assertTrue(logics.hasKnight(KNIGHT_START_X_POS, KNIGHT_START_Y_POS));
    }

    @Test
    public void knightShouldChangePositionOnValidMove(){
        final int verticalMovement = 1;
        final int horizontalMovement = 2;
        logics = new LogicsImpl.Builder(BOARD_SIZE).randomPawn().knight(new Pair<>(KNIGHT_START_X_POS, KNIGHT_START_Y_POS)).build();
        logics.hit(KNIGHT_START_X_POS + horizontalMovement, KNIGHT_START_Y_POS + verticalMovement);
        assertTrue(logics.hasKnight(KNIGHT_START_X_POS + horizontalMovement, KNIGHT_START_Y_POS + verticalMovement));
    }

    @Test
    public void knightShouldSuccessfullyHitPawnWhenMovingOnSameSquare(){
        final int pawnX = 1;
        final int pawnY = 2;
        logics = new LogicsImpl.Builder(BOARD_SIZE).knight(new Pair<>(KNIGHT_START_X_POS, KNIGHT_START_Y_POS)).pawn(new Pair<>(KNIGHT_START_X_POS + pawnX, KNIGHT_START_Y_POS + pawnY)).build();
        assertTrue(logics.hit(KNIGHT_START_X_POS + pawnX, KNIGHT_START_X_POS + pawnY));
    }

}
