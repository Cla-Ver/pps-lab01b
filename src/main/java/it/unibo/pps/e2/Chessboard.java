package it.unibo.pps.e2;

public interface Chessboard {
    boolean hasKnight();
    boolean hasPawn();
    void placeKnight(Knight knight);
    void placePawn(Pawn pawn);
    void moveKnight(KnightMove move);
    Pair<Integer, Integer> getKnightPosition();
    Pair<Integer, Integer> getPawnPosition();
}
