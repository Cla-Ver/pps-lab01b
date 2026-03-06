package it.unibo.pps.e3;

public class CellImpl implements Cell {
    private boolean hasMine;
    public CellImpl(boolean hasMine) {
        this.hasMine = hasMine;
    }

    @Override
    public boolean hit() {
        return hasMine;
    }

    @Override
    public void setMine(boolean isArmed) {
        hasMine = isArmed;
    }
}
