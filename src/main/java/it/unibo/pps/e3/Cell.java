package it.unibo.pps.e3;

public interface Cell {
    /**
     *
     * Checks whether the cell has a mine or not.
     *
     * @return true if the cell is armed.
     *
     * */
    boolean hit();
    /**
     *
     * Arms the cell.
     *
     * @param isArmed whether the cell has a mine.
     *
     * */
    void setMine(boolean isArmed);
}
