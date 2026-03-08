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

}
