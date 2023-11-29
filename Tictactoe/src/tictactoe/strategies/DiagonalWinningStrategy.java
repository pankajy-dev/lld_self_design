package tictactoe.strategies;

import tictactoe.models.Cell;
import tictactoe.models.CellState;
import tictactoe.models.Game;
import tictactoe.models.GameStatus;
import tictactoe.models.Move;
import tictactoe.models.Player;

public class DiagonalWinningStrategy implements WinnningStrategies {

	@Override
	public Player checkWinner(Game game) {
		int lastMove = game.getMoves().size() - 1;

		Move move = game.getMoves().get(lastMove);

		int lastMoveplayerId = move.getCell().getPlayer().getId();

		int row = move.getCell().getRow();
		int col = move.getCell().getCol();
		int count = 0;

		if (row == col) {
			for (int j = 0; j < game.getDimension(); j++) {
				Cell cell = game.getBoard().getBoard().get(j).get(j);
				if (cell.getCellState().equals(CellState.FILLED) && lastMoveplayerId == cell.getPlayer().getId()) {
					count++;
				}
			}
			if (count == game.getDimension()) {
				System.out.println("We have a winner - " + move.getCell().getPlayer().getName());
				game.setGameStatus(GameStatus.WIN);
				return move.getCell().getPlayer();
			}
		}
		if (row + col == game.getDimension() - 1) {
			for (int j = game.getDimension() - 1; j >= 0; j--) {
				Cell cell = game.getBoard().getBoard().get(j).get(j);
				if (cell.getCellState().equals(CellState.FILLED) && lastMoveplayerId == cell.getPlayer().getId()) {
					count++;
				}
			}
			if (count == game.getDimension()) {
				System.out.println("We have a winner - " + move.getCell().getPlayer().getName());
				game.setGameStatus(GameStatus.WIN);
				return move.getCell().getPlayer();
			}
		}
		return null;
	}
}
