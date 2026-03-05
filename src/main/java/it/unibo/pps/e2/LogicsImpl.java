package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Chessboard chessboard;

	private LogicsImpl(Chessboard chessboard){
		this.chessboard = chessboard;
	}

	public static class Builder{
		private final Chessboard chessboard;
		private final Random random = new Random();
		private final int size;


		public Builder (int size) {
			final int sizeLowerBound = 3;
			if(size < sizeLowerBound){
				throw new IllegalArgumentException("Board size too small");
			}
			this.size = size;
			chessboard = new ChessboardImpl(size);
		}
		private void checkInBoundsCreation(Pair<Integer, Integer> position){
			if(position.getX() < 0 || position.getX() >= size || position.getY() < 0 || position.getY() >= size){
				throw new IndexOutOfBoundsException("Knight out of bounds");
			}
		}
		public Builder knight(Knight knight){
			checkInBoundsCreation(knight.getPosition());
			chessboard.placeKnight(knight);
			return this;
		}
		public Builder randomKnight(){
			chessboard.placeKnight(new KnightImpl(randomEmptyPosition()));
			return this;
		}
		public Builder pawn(Pawn pawn){
			checkInBoundsCreation(pawn.position());
			chessboard.placePawn(pawn);
			return this;
		}
		public Builder randomPawn(){
			chessboard.placePawn(new Pawn(randomEmptyPosition()));
			return this;
		}
		public LogicsImpl build() {
			if(!chessboard.isKnightPlaced() || !chessboard.isPawnPlaced()){
				throw new IllegalStateException("No position chosen for knight or pawn");
			}
			return new LogicsImpl(chessboard);
		}
		private final Pair<Integer,Integer> randomEmptyPosition(){
			Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
			// the recursive call below prevents clash with an existing pawn
			return this.chessboard.isPawnPlaced() && this.chessboard.getPawnPosition().equals(pos) ? randomEmptyPosition() : pos;
		}

	}

	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.chessboard.getChessboardSize() || col >= this.chessboard.getChessboardSize()) {
			throw new IndexOutOfBoundsException();
		}
		// Below a compact way to express allowed moves for the knight
		int x = row-this.chessboard.getKnightPosition().getX();
		int y = col-this.chessboard.getKnightPosition().getY();
		if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
			this.chessboard.moveKnight(KnightMove.from(x, y));
			return this.chessboard.getPawnPosition().equals(this.chessboard.getKnightPosition());
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.chessboard.isKnightPlaced() && this.chessboard.getKnightPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.chessboard.isPawnPlaced() && this.chessboard.getPawnPosition().equals(new Pair<>(row,col));
	}
}
