package it.unibo.pps.e3;

public class LogicsImpl implements Logics {

    private final Grid grid;

    public LogicsImpl(Grid grid) {
        this.grid = grid;
    }

    @Override
    public long getNumberOfCells() {
        return grid.getNumberOfCells();
    }

    @Override
    public long countMines() {
        return grid.getNumberOfMines();
    }

    @Override
    public boolean hit(Pair<Integer, Integer> minePosition) {
        return grid.hitCell(minePosition);
    }
}
