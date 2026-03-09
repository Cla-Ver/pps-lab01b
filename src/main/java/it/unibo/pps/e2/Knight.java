package it.unibo.pps.e2;

public interface Knight extends Piece {
    /**
     *
     * Tries to move the knight with the specified movement.
     *
     * @param movement The direction in which the knight will move.
     * */
    void move(KnightMove movement);
}
