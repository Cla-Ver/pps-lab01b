package it.unibo.pps.e3;

public class CellImpl implements Cell {
    private final boolean hasMine;
    public CellImpl(boolean hasMine) {
        this.hasMine = hasMine;
    }

    @Override
    public boolean hit() {
        return hasMine;
    }
}
