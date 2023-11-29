package tictactoe.strategies;

import tictactoe.models.Cell;
import tictactoe.models.CellState;
import tictactoe.models.Game;
import tictactoe.models.GameStatus;
import tictactoe.models.Move;
import tictactoe.models.Player;

public class ColWinningStrategy implements WinnningStrategies {

	@Override
	public Player checkWinner(Game game) {
		int lastMove = game.getMoves().size() - 1;

		Move move = game.getMoves().get(lastMove);

		int lastMoveplayerId = move.getCell().getPlayer().getId();

		int col = move.getCell().getCol();
		int count = 0;
		for (int j = 0; j < game.getDimension(); j++) {
			Cell cell = game.getBoard().getBoard().get(j).get(col);
			if (cell.getCellState().equals(CellState.FILLED) && lastMoveplayerId == cell.getPlayer().getId()) {
				count++;
			}
		}
		if (count == game.getDimension()) {
			System.out.println("We have a winner - " + move.getCell().getPlayer().getName());
			game.setGameStatus(GameStatus.WIN);
			return move.getCell().getPlayer();
		}
		return null;

	}
}
