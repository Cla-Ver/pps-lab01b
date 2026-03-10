package it.unibo.pps.e3;

import java.util.*;

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
    public boolean hit(Pair<Integer, Integer> position) {
        isGameOver = grid.hitCell(position);
        if (!isGameOver && grid.getAmountOfNearbyMines(position) == 0) {
            hitNeighbors(position);
        }
        return isGameOver;
    }

    @Override
    public long getAmountOfNearbyMines(Pair<Integer, Integer> center) {
        return grid.getAmountOfNearbyMines(center);
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

    private void hitNeighbors(Pair<Integer, Integer> center) {
        Collection<Pair<Integer, Integer>> neighbors = grid.getNeighborPositions(center);
        neighbors.forEach(neighborPos -> {
            if (!grid.hasBeenHit(neighborPos) && !grid.isFlagged(neighborPos)) {
                grid.hitCell(neighborPos);
                if (grid.getAmountOfNearbyMines(neighborPos) == 0) {
                    hitNeighbors(neighborPos);
                }
            }
        });
    }

}
