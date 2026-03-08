package it.unibo.pps.e3;

public class LogicsImpl implements Logics {

    private final int size;

    public LogicsImpl(int size) {
        this.size = size;
    }

    @Override
    public int getNumberOfCells() {
        return size * size;
    }
}
