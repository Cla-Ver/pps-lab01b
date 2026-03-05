package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChessboardTest {
    private Chessboard chessboard;
    private static final int BOARD_SIZE = 5;

    @BeforeEach
    public void init(){
        chessboard = new ChessboardImpl(BOARD_SIZE);
    }

    @Test
    public void chessboardShouldNotHaveGridTooSmall(){
        assertThrows(IllegalArgumentException.class, ()-> chessboard = new ChessboardImpl(0));
    }

    @Test
    public void chessboardShouldNotAllowInvalidInitialKnightPosition(){
        assertThrows(IllegalArgumentException.class, () -> chessboard.placeKnight(new KnightImpl(new Pair<>(BOARD_SIZE, BOARD_SIZE))));
    }

    @Test
    public void chessboardShouldNotAllowInvalidInitialPawnPosition(){
        assertThrows(IllegalArgumentException.class, () -> chessboard.placePawn(new Pawn(new Pair<>(BOARD_SIZE, BOARD_SIZE))));
    }

}
