package tictactoe.strategies;

import tictactoe.models.Game;
import tictactoe.models.Player;

public interface WinnningStrategies {
	Player checkWinner(Game game);
}
