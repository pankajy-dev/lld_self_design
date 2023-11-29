package tictactoe.model;

public class Cell {
	private int row;
	private int col;
	private Player cellPlayer;
	private CellState cellState;

	public Cell(int i, int j) {
		this.cellState = CellState.EMPTY;
		row = i;
		col = j;
		// TODO Auto-generated constructor stub
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

	public Player getCellPlayer() {
		return cellPlayer;
	}

	public void setCellPlayer(Player cellPlayer) {
		this.cellPlayer = cellPlayer;
	}

	public CellState getCellState() {
		return cellState;
	}

	public void setCellState(CellState cellState) {
		this.cellState = cellState;
	}

}
