package tictactoe.strategies;

import tictactoe.models.Cell;
import tictactoe.models.CellState;
import tictactoe.models.Game;
import tictactoe.models.Move;
import tictactoe.models.Player;

public class EasyBotStrategy implements BotPlayingStrategy {

	@Override
	public Move makeMove(Game game) {

		int row = -1;
		int col = -1;

		System.out.println();
		System.out.println(game.getCurrentPlayer().getName() + " played.");

		for (int j = 0; j < game.getDimension(); j++) {
			for (int i = 0; i < game.getDimension(); i++) {
				Cell cell = game.getBoard().getBoard().get(j).get(i);
				if (cell.getCellState().equals(CellState.EMPTY)) {
					row = cell.getRow();
					col = cell.getCol();
				}
			}
		}

		if (row >= 0 && col >= 0) {

			Cell newCell = game.getBoard().getBoard().get(row).get(col);
			newCell.setPlayer(game.getCurrentPlayer());
			newCell.setCellState(CellState.FILLED);
			game.getBoard().getBoard().get(row).set(col, newCell);

			int currentPlayerId = game.getCurrentPlayer().getId();

			currentPlayerId = (currentPlayerId + 1);

			if (currentPlayerId > game.getPlayers().size()) {
				currentPlayerId = 1;
			}

			Player currentPlayer = game.getPlayers().get(currentPlayerId - 1);
			game.setCurrentPlayer(currentPlayer);

			Move move = new Move(newCell);
			game.getMoves().add(move);
			return move;
		}
		return null;
	}

}
