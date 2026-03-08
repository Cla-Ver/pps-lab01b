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
     * @param minePosition the position to hit.
     * @return True if the cell is armed (there is a mine).
     * @throws IllegalArgumentException if the position is out of bounds.
     *
     * */
    boolean hit(Pair<Integer, Integer> minePosition);

    /**
     *
     * Returns the number of mines (armed cells) from the given position.
     *
     * @param center The center of the 3*3 square to check.
     * @return The amount of mines found.
     *
     */
    long getAmountOfNearbyMines(Pair<Integer, Integer> center);

    /**
     *
     * Checks if the cell in the specified position has already been hit.
     *
     * @param hitPosition The position to check.
     * @return True if it has already been hit at least once.
     * @throws IllegalArgumentException if no cell is found in the provided position.
     *
     * */
    boolean hasBeenHit(Pair<Integer, Integer> hitPosition);

    /**
     *
     * Checks if the game is won.
     *
     * @return True if the player has won the game.
     *
     * */
    boolean isGameWon();

    /**
     *
     * Checks if the game is over, either because of a revealed mine or because the player has won.
     *
     * @return True if the game has ended.
     *
     * */
    boolean isGameOver();
}
