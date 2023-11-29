package tictactoe.model;

import tictactoe.strategies.MoveStrategy;

public class Bot extends Player {

	public Bot(int id, String name, Symbol symbol, PlayerType playerType) {
		super(id, name, symbol, playerType);
		// TODO Auto-generated constructor stub
	}
	private DifficultyLevel difficultyLevel;
	private MoveStrategy moveStrategy;
	
	public DifficultyLevel getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	public MoveStrategy getMoveStrategy() {
		return moveStrategy;
	}
	public void setMoveStrategy(MoveStrategy moveStrategy) {
		this.moveStrategy = moveStrategy;
	}
	
	
}
