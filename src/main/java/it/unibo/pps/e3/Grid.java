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
}
