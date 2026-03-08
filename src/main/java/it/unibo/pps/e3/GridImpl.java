package it.unibo.pps.e3;

import java.util.*;

public class GridImpl implements Grid {
    private final Map<Pair<Integer, Integer>, Cell> cells;
    private final int size;
    Random r = new Random();

    public GridImpl(int gridSize, int nMines) {
        this(gridSize, nMines, List.of());
    }

    public GridImpl(int gridSize, int nMines, Collection<Pair<Integer, Integer>> minesPositions) {

        this.size = gridSize;
        cells = new HashMap<>();
        generateGrid(gridSize);
        minesPositions.forEach(this::placeMine);
        placeRandomMines(nMines);
    }

    private void generateGrid(int size){
        for(int col = 0; col < size; col++){
            for(int row = 0; row < size; row++){
                cells.put(new Pair<>(col, row), new CellImpl(false));
            }
        }
    }

    private void placeRandomMines(int nMines){
        int minesLeftToPlace = nMines;
        while(minesLeftToPlace > 0){
            Pair<Integer, Integer> cellPosition = new Pair<>(r.nextInt(this.size), r.nextInt(this.size));
            if(!cells.get(cellPosition).hasMine()){
                placeMine(cellPosition);
                minesLeftToPlace--;
            }
        }
    }

    private void placeMine(Pair<Integer, Integer> position){
        cells.get(position).setMine(true);
    }

    @Override
    public long getNumberOfCells() {
        return cells.size();
    }

    @Override
    public boolean hitCell(Pair<Integer, Integer> position) {
        if(!cells.containsKey(position)){
            throw new IllegalArgumentException("Invalid cell position");
        }
        return cells.get(position).hit();
    }

    @Override
    public boolean isClear() {
        return cells.values().stream().allMatch(cell -> !cell.hasMine() && cell.hasBeenHit());
    }

    @Override
    public long getNumberOfMines() {
        return cells.values().stream().filter(Cell::hasMine).count();
    }
}
