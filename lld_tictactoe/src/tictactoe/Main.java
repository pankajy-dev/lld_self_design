package tictactoe;

import java.util.ArrayList;
import java.util.List;

import tictactoe.controllers.GameController;
import tictactoe.model.Game;
import tictactoe.model.Player;
import tictactoe.model.PlayerType;
import tictactoe.model.Symbol;

public class Main {

	public static void main(String[] args) {
		GameController gameController = new GameController();
		List<Player> players = new ArrayList<>();
		players.add(new Player(1, "Pankaj", new Symbol('x'), PlayerType.HUMAN));
		players.add(new Player(1, "Piyush", new Symbol('o'), PlayerType.HUMAN));
		Game game = gameController.startGame(3, players, null);
		gameController.printBoard(game);
	}
}
