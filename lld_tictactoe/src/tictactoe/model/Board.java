package tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private int dimension;
	List<List<Cell>> board;

	public Board(int dimension) {
		this.dimension = dimension;
		this.board = new ArrayList<>();
		
		for(int i = 0 ; i < dimension ; i++) {
			board.add(new ArrayList<>());
			for(int j = 0 ; j < dimension ; j++) {
				board.get(i).add(new Cell(i, j));
			}
		}
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public void printBoard() {
		for(List<Cell> row : board) {
			System.out.println();
			for(Cell cell : row) {
				if(cell.getCellState().equals(CellState.EMPTY)) {
					System.out.print("| - |");
				}
				else {
					System.out.print("| " + cell.getCellPlayer().getSymbol() + " |");
				}
			}
		}
	}
}
