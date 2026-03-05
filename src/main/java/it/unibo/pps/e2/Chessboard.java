package it.unibo.pps.e2;

public interface Chessboard {
    public boolean hasKnight();
    public boolean hasPawn();
    public Pair<Integer, Integer> getKnightPosition();
    public Pair<Integer, Integer> getPawnPosition();
    public boolean isSquareValid();
}
