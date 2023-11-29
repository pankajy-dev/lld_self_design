package tictactoe.controllers;

import java.util.List;

import tictactoe.model.Game;
import tictactoe.model.Player;
import tictactoe.strategies.WinningStrategy;

public class GameController {
	
	public Game startGame(
			int dimension, 
			List<Player> players,
			List<WinningStrategy> winningStrategy
			) {
		return Game.builder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategy)
                .build();
	}
	
    public void printBoard(Game game) {
        game.printBoard();
    }

}
