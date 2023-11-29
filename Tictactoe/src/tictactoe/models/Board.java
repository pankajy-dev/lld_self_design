package tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

	List<List<Cell>> board;
	private int dimension;

	public Board(int argDimension) {
		dimension = argDimension;
		createBoard();
	}

	private void createBoard() {
		board = new ArrayList<List<Cell>>();
		for (int i = 0; i < dimension; i++) {
			List<Cell> row = new ArrayList<>();
			for (int j = 0; j < dimension; j++) {
				row.add(new Cell(i, j));
			}
			board.add(row);
		}
	}

	public List<List<Cell>> getBoard() {
		return board;
	}

	public int getDimension() {
		return dimension;
	}

	public void display() {

		int num = 0;
		System.out.println();

		System.out.print("  ");
		for (int i = 0; i < dimension; i++) {
			System.out.print("  " + num++ + "  ");
		}

		num = 0;

		for (List<Cell> row : board) {
			System.out.println();
			System.out.print(num++ + " ");
			for (Cell cell : row) {
				if (cell.getCellState().equals(CellState.EMPTY)) {
					System.out.print("| - |");
				} else {
					System.out.print("| " + cell.getPlayer().getSymbol().getSymbol() + " |");
				}
			}
		}
		System.out.println();
	}
}
