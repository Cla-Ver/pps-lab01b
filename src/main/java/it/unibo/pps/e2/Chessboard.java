package it.unibo.pps.e2;

public interface Chessboard {
    /**
    *
     * Retrieves the size of the board in both directions.
     *
     * @return the board size.
    *
    * */
    int getSize();
    /**
     *
     * Places the knight on the chessboard.
     *
     * @throws IllegalArgumentException if the knight is placed out of bounds.
     * @throws IllegalStateException if the knight has already been placed.
     *
     */
    void placeKnight(Knight knight);
    /**
    *
     * Places the pawn on the chessboard.
     *
     * @throws IllegalArgumentException if the pawn is placed out of bounds.
     * @throws IllegalStateException if the pawn has already been placed.
    * */
    void placePawn(Pawn pawn);

    /**
     *
     * Checks if the knight has been placed.
     *
     * @return true if the knight has been placed.
     */
    boolean isKnightPlaced();

    /**
     *
     * Checks if the pawn has been placed.
     *
     * @return true if the pawn has been placed.
     * */
    boolean isPawnPlaced();

    /**
     *
     * Moves the knight given the corresponding move.
     *
     * @param move The move to perform.
     * @throws IllegalArgumentException if the move would place the knight out of bounds.
     *
     * */
    void moveKnight(KnightMove move);

    /**
     *
     * Retrieves the knight's position on the chessboard.
     *
     * @return The knight's position.
     * @throws IllegalStateException if the knight has not been placed.
     *
     * */
    Pair<Integer, Integer> getKnightPosition();

    /**
     *
     * Retrieves the pawn's position on the chessboard.
     *
     * @return The pawn's position.
     * @throws IllegalStateException if the pawn has not been placed.
     * */
    Pair<Integer, Integer> getPawnPosition();
}
