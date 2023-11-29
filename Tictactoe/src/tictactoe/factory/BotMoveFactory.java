package tictactoe.factory;

import tictactoe.models.BotDifficultyLevel;
import tictactoe.strategies.BotPlayingStrategy;
import tictactoe.strategies.EasyBotStrategy;

public class BotMoveFactory {

	public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
		if (botDifficultyLevel.equals(BotDifficultyLevel.EASY)) {
			return new EasyBotStrategy();
		}
		return null;
	}
}
