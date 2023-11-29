package tictactoe.models;

import tictactoe.factory.BotMoveFactory;
import tictactoe.strategies.BotPlayingStrategy;

public class Bot extends Player {
	BotDifficultyLevel botDifficultyLevel;
	BotPlayingStrategy botPlayingStrategy;

	public Bot(int id, String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
		super(id, name, symbol, PlayerType.BOT);
		this.botDifficultyLevel = botDifficultyLevel;
	}

	public BotDifficultyLevel getBotDifficultyLevel() {
		return botDifficultyLevel;
	}

	public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
		this.botDifficultyLevel = botDifficultyLevel;
	}

	public BotPlayingStrategy getBotPlayingStrategy() {
		return botPlayingStrategy;
	}

	public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
		this.botPlayingStrategy = botPlayingStrategy;
	}

	@Override
	public Move makeMove(Game game) {
		BotPlayingStrategy botPlay = BotMoveFactory.getBotPlayingStrategy(botDifficultyLevel);
		return botPlay.makeMove(game);
	}

}
