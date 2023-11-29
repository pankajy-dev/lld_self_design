package tictactoe.services;

import java.util.Scanner;

import tictactoe.models.Cell;
import tictactoe.models.CellState;
import tictactoe.models.Game;
import tictactoe.models.Move;
import tictactoe.models.Player;

public class PlayerService {
	public Move makeMove(Game game) {

		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println(game.getCurrentPlayer().getName() + " Select row.");
		int row = sc.nextInt();
		System.out.println(game.getCurrentPlayer().getName() + " Select col.");
		int col = sc.nextInt();

		Cell newCell = game.getBoard().getBoard().get(row).get(col);

		if (newCell.getCellState().equals(CellState.EMPTY)) {
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

		} else {
			System.out.println("Cell not empty, select different cell");
		}
		Move move = new Move(newCell);
		game.getMoves().add(move);
		return move;
	}
}
