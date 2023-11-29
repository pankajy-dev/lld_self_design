package tictactoe.controllers;

import tictactoe.dtos.RequestGameControllerDto;
import tictactoe.models.Game;
import tictactoe.services.GameService;

public class GameController {

	GameService gameService;
	Game game;

	public GameController(RequestGameControllerDto reqGameControllerDto) {
		gameService = reqGameControllerDto.getGameService();
		game = reqGameControllerDto.getGame();
	}

	public void displayBoard(Game game) {
		gameService.displayBoard(game);
	}

	public void makeMove(Game argGame) {
		if (gameService.moveAvailable(argGame)) {
			argGame.getCurrentPlayer().makeMove(argGame);
			gameService.checkWinner(argGame);
		}
	}
}
