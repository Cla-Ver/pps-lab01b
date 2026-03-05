package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChessboardTest {
    private Chessboard chessboard;
    private static final Pair<Integer, Integer>  INITIAL_KNIGHT_POSITION = new Pair<>(0, 0);
    private static final Pair<Integer, Integer>  INITIAL_PAWN_POSITION = new Pair<>(1, 2);
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

    @Test
    public void chessboardShouldNotAllowSettingInitialKnightPositionMoreThanOnce(){
        chessboard.placeKnight(new KnightImpl(INITIAL_KNIGHT_POSITION));
        assertThrows(IllegalStateException.class, () -> chessboard.placeKnight(new KnightImpl(INITIAL_KNIGHT_POSITION)));
    }

    @Test
    public void chessboardShouldNotAllowSettingInitialPawnPositionMoreThanOnce(){
        chessboard.placePawn(new Pawn(INITIAL_PAWN_POSITION));
        assertThrows(IllegalStateException.class, () -> chessboard.placePawn(new Pawn(INITIAL_PAWN_POSITION)));
    }

    @Test
    public void chessboardShouldNotAllowMovingKnightIfItsPositionIsNotSet(){
        assertThrows(IllegalStateException.class, () -> chessboard.moveKnight(KnightMove.DOWN_RIGHT));
    }

    @Test
    public void chessboardShouldNotAllowMovingKnightIfPawnPositionIsNotSet(){
        chessboard.placeKnight(new KnightImpl(INITIAL_KNIGHT_POSITION));
        assertThrows(IllegalStateException.class, () -> chessboard.moveKnight(KnightMove.DOWN_RIGHT));
    }

    @Test
    public void chessboardShouldNotAllowKnightMovingOutOfBounds(){
        chessboard.placeKnight(new KnightImpl(INITIAL_KNIGHT_POSITION));
        chessboard.placePawn(new Pawn(INITIAL_PAWN_POSITION));
        assertThrows(IllegalArgumentException.class, () -> chessboard.moveKnight(KnightMove.UP_LEFT));
    }

}
