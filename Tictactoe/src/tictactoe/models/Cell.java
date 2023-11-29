package tictactoe.models;

public class Cell {

	int row;
	int col;
	Player Player;
	CellState cellState;

	public Cell(int argRow, int argcol) {
		row = argRow;
		col = argcol;
		cellState = CellState.EMPTY;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Player getPlayer() {
		return Player;
	}

	public void setPlayer(Player player) {
		Player = player;
	}

	public CellState getCellState() {
		return cellState;
	}

	public void setCellState(CellState cellState) {
		this.cellState = cellState;
	}
}
