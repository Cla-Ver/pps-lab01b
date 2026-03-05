package it.unibo.pps.e2;

public interface Chessboard {
    int getChessboardSize();
    void placeKnight(Knight knight);
    void placePawn(Pawn pawn);
    void moveKnight(KnightMove move);
}
