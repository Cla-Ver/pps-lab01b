package it.unibo.pps.e3;

public class CellImpl implements Cell {
    private boolean mine;
    private boolean hasBeenHit = false;
    private boolean hasFlag = false;

    public boolean hasMine() {
        return mine;
    }

    public boolean hasBeenHit() {
        return hasBeenHit;
    }

    public CellImpl(boolean mine) {
        this.mine = mine;
    }

    @Override
    public boolean hit() {
        hasBeenHit = true;
        return mine;
    }

    @Override
    public void setMine(boolean isArmed) {
        mine = isArmed;
    }

    @Override
    public void toggleFlag() {
        this.hasFlag = !this.hasFlag;
    }

    @Override
    public boolean hasFlag() {
        return this.hasFlag;
    }
}
