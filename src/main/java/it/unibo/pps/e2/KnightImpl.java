package it.unibo.pps.e2;

public class KnightImpl implements Knight {

    private Pair<Integer, Integer> position;

    public KnightImpl(int startX, int startY){
        position = new Pair<>(startX, startY);
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public void move(KnightMove move) {
        position = new Pair<>(position.getX() + move.getDx(), position.getY() + move.getDy());
    }
}
