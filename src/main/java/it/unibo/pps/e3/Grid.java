package it.unibo.pps.e3;

public interface Grid {
    /**
     *
     * Retrieves the number of the grid cells.
     *
     * @return the number of the grid cells.
     *
     *
     */
    long getNumberOfCells();

    /**
     *
     * Hits a cell of the minefield.
     *
     * @return true if the cell is a mine.
     * @throws IllegalArgumentException if the position is invalid.
     *
     * */
    boolean hitCell(Pair<Integer, Integer> position);

    /**
     *
     * Checks if only mines remain.
     *
     * @return true if there are only mines.
     *
     * */
    boolean isClear();

    /**
     *
     * Retrieves the number of mines of the field.
     *
     * @return The amount of mines.
     *
     */
    long getNumberOfMines();

    /**
     *
     * Retrieves the number of adjacent mines given the position in a 3*3 square.
     *
     * @return The amount of mines.
     *
     *
     */
    long getNumberOfNearbyMines(Pair<Integer, Integer> integerIntegerPair);

    /**
     *
     * Checks if the cell in the given position has already been hit at least once.
     *
     * @param position The position to check.
     * @throws IllegalArgumentException If the cell does not exist.
     * @return True if the cell has been hit at least once.
     *
     * */
    boolean hasBeenHit(Pair<Integer, Integer> position);


    /**
     *
     * Adds or removes a flag on the cell with the corresponding position.
     *
     * @throws IllegalArgumentException If the cell does not exist.
     * */
    void toggleFlag(Pair<Integer, Integer> flaggedCell);

    /**
     *
     * Checks if the cell in the given position has a flag.
     * @param position The position of the cell to check.
     * @throws IllegalArgumentException If the cell does not exist.
     * @return True if the cell is flagged.
     *
     * */
    boolean isFlagged(Pair<Integer, Integer> position);
}
