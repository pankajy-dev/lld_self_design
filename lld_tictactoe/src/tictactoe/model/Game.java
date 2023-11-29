package tictactoe.model;

import java.util.ArrayList;
import java.util.List;

import tictactoe.strategies.WinningStrategy;

public class Game {

	private Board board;
	private List<Player> players = new ArrayList<>();
	private List<WinningStrategy> winningStrategies = new ArrayList<>();
	private GameState gameState;
	private Player gameWinner;
	private int nextPlayerIndex;
	private int dimension;
	
	private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
		this.dimension = dimension;
		this.players = players;
		this.winningStrategies = winningStrategies;
		this.gameState = GameState.INPROGRESS;
		nextPlayerIndex = 0;
		board = new Board(dimension);
	}
	
	public static GameBuilder builder() {
		return new GameBuilder();
	}
	
	public void printBoard() {
		board.printBoard();
	}
	
	public static class GameBuilder{
		private int dimension;
		private List<Player> players;
		private List<WinningStrategy> winningStrategies;
		
		public GameBuilder setDimension(int dimension){
			this.dimension = dimension;
			return this;
		}
		
		public GameBuilder setPlayers(List<Player> players) {
			this.players = players;
			return this;
		}
		
		public GameBuilder setWinningStrategies(List<WinningStrategy> winningStrategies) {
			this.winningStrategies = winningStrategies;
			return this;
		}
		
		public Game build() {
			validate();
			return new Game(dimension, players, winningStrategies); 
		}

		private void validate() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
