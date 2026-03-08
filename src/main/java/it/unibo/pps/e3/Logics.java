package it.unibo.pps.e3;

public interface Logics {

    /**
     *
     * Retrieves the number of cells of the minefield.
     *
     * @return The number of cells.
     *
     * */
    long getNumberOfCells();

    /**
     *
     * How many mines there are on the minefield.
     *
     * @return The amount of mines.
     *
     * */
    long countMines();

    /**
     *
     * Hits the cell in the given position.
     *
     * @return True if the cell is armed (there is a mine).
     * @throws IllegalArgumentException if the position is out of bounds.
     *
     * */
    boolean hit(Pair<Integer, Integer> minePosition);
}
