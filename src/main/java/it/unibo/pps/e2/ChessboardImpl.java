package it.unibo.pps.e2;

public class ChessboardImpl implements Chessboard {
    private int size;
    private Knight knight;
    private Pawn pawn;
    private static final int MIN_BOARD_SIZE = 3;
    public ChessboardImpl(int boardSize) {
        if(boardSize < MIN_BOARD_SIZE){
            throw new IllegalArgumentException("Grid too small");
        }
        size = boardSize;
    }

    @Override
    public boolean hasKnight() {
        return false;
    }

    @Override
    public boolean hasPawn() {
        return false;
    }

    @Override
    public Pair<Integer, Integer> getKnightPosition() {
        return null;
    }

    @Override
    public Pair<Integer, Integer> getPawnPosition() {
        return null;
    }

    @Override
    public boolean isSquareValid() {
        return false;
    }
}
