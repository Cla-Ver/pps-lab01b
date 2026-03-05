package it.unibo.pps.e2;

public class KnightImpl implements Knight {

    private Pair<Integer, Integer> position;

    public KnightImpl(Pair<Integer, Integer> startPosition) {
        position = startPosition;
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
