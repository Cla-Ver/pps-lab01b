package it.unibo.pps.e2;

public interface Chessboard {
    public boolean hasKnight();
    public boolean hasPawn();
    public void placeKnight(Knight knight);
    public void placePawn(Pawn pawn);
    public Pair<Integer, Integer> getKnightPosition();
    public Pair<Integer, Integer> getPawnPosition();
}
