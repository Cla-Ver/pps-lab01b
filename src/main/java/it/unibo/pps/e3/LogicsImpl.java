package it.unibo.pps.e3;

public class LogicsImpl implements Logics {

    private final Grid grid;
    private boolean isGameOver = false;

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
        isGameOver = grid.hitCell(minePosition);
        return isGameOver;
    }

    @Override
    public long getAmountOfNearbyMines(Pair<Integer, Integer> center) {
        return grid.getNumberOfNearbyMines(center);
    }

    @Override
    public boolean hasBeenHit(Pair<Integer, Integer> hitPosition) {
        return grid.hasBeenHit(hitPosition);
    }

    @Override
    public boolean isGameWon() {
        return grid.isClear();
    }

    @Override
    public boolean isGameOver() {
        return this.isGameOver;
    }

    @Override
    public void toggleFlag(Pair<Integer, Integer> flagPosition) {
        grid.toggleFlag(flagPosition);
    }

    @Override
    public boolean isFlagged(Pair<Integer, Integer> position) {
        return grid.isFlagged(position);
    }

}
