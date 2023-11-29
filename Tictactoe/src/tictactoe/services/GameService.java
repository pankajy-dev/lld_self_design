package tictactoe.services;

import tictactoe.models.Cell;
import tictactoe.models.CellState;
import tictactoe.models.Game;
import tictactoe.models.GameStatus;
import tictactoe.strategies.WinnningStrategies;

public class GameService {

	public void displayBoard(Game game) {
		game.getBoard().display();
	}

	public void checkWinner(Game game) {
		for (WinnningStrategies winStr : game.getWinStrategies()) {
			winStr.checkWinner(game);
		}
	}

	public Boolean moveAvailable(Game game) {

		for (int j = 0; j < game.getDimension(); j++) {
			for (int i = 0; i < game.getDimension(); i++) {
				Cell cell = game.getBoard().getBoard().get(j).get(i);
				if (cell.getCellState().equals(CellState.EMPTY)) {
					return true;
				}
			}
		}
		game.setGameStatus(GameStatus.DRAW);
		System.out.println();
		System.out.println("Game drawn.");
		return false;
	}
}
