package tictactoe.dtos;

import tictactoe.models.Game;
import tictactoe.services.GameService;

public class RequestGameControllerDto {

	GameService gameService;
	Game game;

	public RequestGameControllerDto(GameService gameService, Game game) {
		this.gameService = gameService;
		this.game = game;
	}

	public GameService getGameService() {
		return gameService;
	}

	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
