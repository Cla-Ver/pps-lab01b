package it.unibo.pps.e3;

import java.util.*;

public class GridImpl implements Grid {
    private final Map<Pair<Integer, Integer>, Cell> cells = new HashMap<>();
    private final int size;
    private final Random r = new Random();

    public GridImpl(int gridSize, int nMines) {
        this(gridSize, nMines, List.of());
    }

    private void validateMineAmount(int gridSize, int nMines, Collection<Pair<Integer, Integer>> minesPositions){
        if(nMines < 0){
            throw new IllegalArgumentException("Invalid amount of mines");
        }
        if(nMines >= gridSize * gridSize){
            throw new IllegalArgumentException("The amount of mines must be less than the total amount of squares (gridSize^2)");
        }
        if(minesPositions.size() > nMines){
            throw new IllegalArgumentException("The amount of mines given is larger than the number of allowed mines on the field");
        }

    }

    public GridImpl(int gridSize, int nMines, Collection<Pair<Integer, Integer>> minesPositions) {
        validateMineAmount(gridSize, nMines, minesPositions);
        this.size = gridSize;
        generateGrid(gridSize);
        minesPositions.forEach(this::placeMine);
        placeRandomMines(nMines - minesPositions.size());
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
        checkCellExistence(position);
        if(getNumberOfNearbyMines(position) == 0){
            hitNeighbors(position);
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

    @Override
    public long getNumberOfNearbyMines(Pair<Integer, Integer> position) {
        List<Cell> neighbors = new ArrayList<>(getNeighbors(position).stream().map(Pair::getY).toList());
        return neighbors.stream().filter(Cell::hasMine).count();
    }

    @Override
    public boolean hasBeenHit(Pair<Integer, Integer> position) {
        checkCellExistence(position);
        return cells.get(position).hasBeenHit();
    }

    @Override
    public void toggleFlag(Pair<Integer, Integer> flaggedCell) {
        checkCellExistence(flaggedCell);
        cells.get(flaggedCell).toggleFlag();
    }

    private Collection<Pair<Pair<Integer, Integer>, Cell>> getNeighbors(Pair<Integer, Integer> position){
        return cells.entrySet().stream()
                .filter(pairCellEntry -> pairCellEntry.getKey().getX() >= position.getX()-1 && pairCellEntry.getKey().getX() <= position.getX() + 1 && pairCellEntry.getKey().getY() >= position.getY() - 1 && pairCellEntry.getKey().getY() <= position.getY() + 1)
                .map(entry -> new Pair<>(entry.getKey(), entry.getValue()))
                .toList();
    }

    private void hitNeighbors(Pair<Integer, Integer> center){
        List<Pair<Pair<Integer, Integer>, Cell>> neighbors = new ArrayList<>(getNeighbors(center));
        neighbors.forEach(neighbor -> {
            if(!neighbor.getY().hasBeenHit() && !neighbor.getY().hasFlag()){
                neighbor.getY().hit();
                if(getNumberOfNearbyMines(neighbor.getX()) == 0){
                    hitNeighbors(neighbor.getX());
                }
            }
        });
    }

    private void checkCellExistence(Pair<Integer, Integer> position){
        if(!cells.containsKey(position)){
            throw new IllegalArgumentException("A cell at position " + position + " has not been found");
        }
    }

}
