package it.unibo.pps.e3;

public class CellImpl implements Cell {
    private boolean hasMine;

    public boolean hasBeenHit() {
        return hasBeenHit;
    }

    private boolean hasBeenHit = false;
    public CellImpl(boolean hasMine) {
        this.hasMine = hasMine;
    }

    @Override
    public boolean hit() {
        hasBeenHit = true;
        return hasMine;
    }

    @Override
    public void setMine(boolean isArmed) {
        hasMine = isArmed;
    }
}
