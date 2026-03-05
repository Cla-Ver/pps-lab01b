package it.unibo.pps.e2;

public interface Chessboard {
    int getChessboardSize();
    void placeKnight(Knight knight);
    void placePawn(Pawn pawn);
    void moveKnight(KnightMove move);
    Pair<Integer, Integer> getKnightPosition();
    Pair<Integer, Integer> getPawnPosition();
}
