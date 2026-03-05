package it.unibo.pps.e2;

public interface Chessboard {
    public boolean hasKnight();
    public boolean hasPawn();
    public Knight getKnight();
    public Pawn getPawn();
    public boolean isSquareValid();
}
