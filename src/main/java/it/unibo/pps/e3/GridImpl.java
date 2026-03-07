package it.unibo.pps.e3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GridImpl implements Grid {
    private final Map<Pair<Integer, Integer>, Cell> cells;
    private final int size;
    Random r = new Random();
    public GridImpl(int gridSize, int nMines) {
        this.size = gridSize;
        cells = new HashMap<>();
        generateGrid(gridSize);
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
                cells.get(cellPosition).setMine(true);
                minesLeftToPlace--;
            }
        }
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
}
