package it.unibo.pps.e3;

public interface Cell {
    /**
     *
     * Hits the cell and registers the hit.
     *
     * @return true if the cell was armed.
     *
     * */
    boolean hit();

    /**
     *
     * Checks if the cell has already been hit.
     *
     * @return true if it has been hit at least once.
     * */
    boolean hasBeenHit();

    /**
     * Checks if the cell has a mine, without registering the hit.
     *
     * @return if the cell has a mine.
     * */
    boolean hasMine();
    /**
     *
     * Arms the cell.
     *
     * @param isArmed whether the cell has a mine.
     *
     * */
    void setMine(boolean isArmed);
}
