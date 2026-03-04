package it.unibo.pps.e2;

public interface Knight {
    /**
     *
     * Retrieves the knight's position
     *
     * @return The X and Y coordinates of the knight.
     */
    Pair<Integer, Integer> getPosition();
    /**
     *
     * Tries to move the knight with the specified movement.
     *
     * @param movement The direction in which the knight will move.
     * */
    void move(KnightMove movement);
}
