package tictactoe;

import java.util.ArrayList;
import java.util.List;

import tictactoe.controllers.GameController;
import tictactoe.dtos.RequestGameControllerDto;
import tictactoe.exceptions.InvalidDimension;
import tictactoe.exceptions.InvalidPlayerCount;
import tictactoe.exceptions.InvalidPlayerSymbol;
import tictactoe.models.Bot;
import tictactoe.models.BotDifficultyLevel;
import tictactoe.models.Game;
import tictactoe.models.GameStatus;
import tictactoe.models.Player;
import tictactoe.models.PlayerType;
import tictactoe.models.Symbol;
import tictactoe.services.GameService;
import tictactoe.strategies.ColWinningStrategy;
import tictactoe.strategies.DiagonalWinningStrategy;
import tictactoe.strategies.RowWinningStrategy;
import tictactoe.strategies.WinnningStrategies;

public class Main {
	public static void main(String[] args) {
		GameService gameService = new GameService();

		List<Player> players = new ArrayList<>();

		players.add(new Player(1, "Piyush", new Symbol('x'), PlayerType.HUMAN));
		players.add(new Bot(2, "GPT", new Symbol('o'), BotDifficultyLevel.EASY));

		List<WinnningStrategies> winStrategies = new ArrayList<>();

		winStrategies.add(new RowWinningStrategy());
		winStrategies.add(new ColWinningStrategy());
		winStrategies.add(new DiagonalWinningStrategy());

		Game game;
		try {
			game = Game.builder().setDimension(3).setPlayers(players).setWinStrategies(winStrategies).build();

			RequestGameControllerDto reqDto = new RequestGameControllerDto(gameService, game);
			GameController gameController = new GameController(reqDto);

			while (game.getGameStatus().equals(GameStatus.INPROGRESS)) {
				gameController.displayBoard(game);
				gameController.makeMove(game);
			}

			if (game.getGameStatus().equals(GameStatus.WIN)) {
				gameController.displayBoard(game);
			}

		} catch (InvalidPlayerCount e) {
			e.printStackTrace();
		} catch (InvalidPlayerSymbol e) {
			e.printStackTrace();
		} catch (InvalidDimension e) {
			e.printStackTrace();
		}
	}
}
