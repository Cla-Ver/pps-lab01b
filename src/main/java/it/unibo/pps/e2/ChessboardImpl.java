package it.unibo.pps.e2;

public class ChessboardImpl implements Chessboard {
    private final int size;
    private Knight knight;
    private Pawn pawn;
    private static final int MIN_BOARD_SIZE = 3;
    public ChessboardImpl(int boardSize) {
        if(boardSize < MIN_BOARD_SIZE){
            throw new IllegalArgumentException("Grid too small");
        }
        size = boardSize;
    }

    private boolean isSquareValid(Pair<Integer, Integer> position){
        return position.getX() >= 0 && position.getX() < size && position.getY() >= 0 && position.getY() < size;
    }

    private void validateInitialPosition(Pair<Integer, Integer> position) {
        if(!isSquareValid(position)){
            throw new IllegalArgumentException("Invalid starting position");
        }
    }

    private void validateKnightMove(KnightMove move){
        if(!isSquareValid(new Pair<>(this.knight.getPosition().getX() + move.getDx(), this.knight.getPosition().getY() + move.getDy()))){
            throw new IllegalArgumentException("Invalid destination square");
        }
    }

    @Override
    public void placeKnight(Knight knight) {
        if(this.knight != null){
            throw new IllegalStateException("Knight's position already set");
        }
        validateInitialPosition(knight.getPosition());
        this.knight = knight;
    }

    @Override
    public void placePawn(Pawn pawn) {
        if(this.pawn != null){
            throw new IllegalStateException("Pawn's position already set");
        }
        validateInitialPosition(pawn.position());
        this.pawn = pawn;
    }

    @Override
    public void moveKnight(KnightMove move) {
        if(knight == null){
            throw new IllegalStateException("Knight's position is not set");
        }
        if(pawn == null){
            throw new IllegalStateException("Pawn's position is not set");
        }
        validateKnightMove(move);
        knight.move(move);
    }

}
