package it.unibo.pps.e2;

public enum KnightMove {
    UP_RIGHT(new Pair<>(1, -2)),
    UP_LEFT(new Pair<>(-1, -2)),
    RIGHT_UP(new Pair<>(2, -1)),
    RIGHT_DOWN(new Pair<>(2, 1)),
    DOWN_RIGHT(new Pair<>(1, 2)),
    DOWN_LEFT(new Pair<>(-1, 2)),
    LEFT_UP(new Pair<>(-2, -1)),
    LEFT_DOWN(new Pair<>(-2, 1));

    private final int dx;
    private final int dy;

    public static KnightMove from(int x, int y) {
        for(KnightMove move : values()){
            if(move.getDx() == x && move.getDy() == y){
                return move;
            }
        }
        throw new IllegalArgumentException("No move found");
    }

    public int getDy() {
        return dy;
    }

    public int getDx() {
        return dx;
    }

    KnightMove(Pair<Integer, Integer> move){
        this.dx = move.getX();
        this.dy = move.getY();
    }

    /*public KnightMove fromCoordinatesToMove(int x, int y){
        for(KnightMove move : values()){
            if(move.getDx() == x && move.getDy() == y){
                return move;
            }
        }
        throw new IllegalArgumentException("")
    }*/

}
