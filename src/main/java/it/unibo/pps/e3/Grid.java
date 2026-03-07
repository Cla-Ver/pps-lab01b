package it.unibo.pps.e3;

public interface Grid {
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
    //boolean isClear();
}
