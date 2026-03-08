package it.unibo.pps.e3;

public class LogicsImpl implements Logics {

    private final int size;
    private final int nMines;

    public LogicsImpl(int size, int nMines) {
        this.size = size;
        this.nMines = nMines;
    }

    @Override
    public int getNumberOfCells() {
        return size * size;
    }

    @Override
    public int countMines() {
        return nMines;
    }
}
