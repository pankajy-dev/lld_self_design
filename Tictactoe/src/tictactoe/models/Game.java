package tictactoe.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tictactoe.exceptions.InvalidDimension;
import tictactoe.exceptions.InvalidPlayerCount;
import tictactoe.exceptions.InvalidPlayerSymbol;
import tictactoe.strategies.WinnningStrategies;

public class Game {

	private Board board;
	private List<Player> players;
	private List<WinnningStrategies> winStrategies;
	private List<Move> moves;
	private GameStatus gameStatus;
	private Player currentPlayer;
	private int dimension;
	public static final int MAX_DIMENSION = 10;

	private Game(int argDimension, List<Player> argPlayers, List<WinnningStrategies> argWinStrategies,
			Player argPlayer) {
		dimension = argDimension;
		board = new Board(dimension);
		players = argPlayers;
		winStrategies = argWinStrategies;
		gameStatus = GameStatus.INPROGRESS;
		moves = new ArrayList<>();
		currentPlayer = argPlayer;
	}

	public List<Move> getMoves() {
		return moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public Board getBoard() {
		return board;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public List<WinnningStrategies> getWinStrategies() {
		return winStrategies;
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(GameStatus argGameStatus) {
		gameStatus = argGameStatus;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public int getDimension() {
		return dimension;
	}

	public static GameBuilder builder() {
		return new GameBuilder();
	}

	public void setCurrentPlayer(Player argPlayer) {
		currentPlayer = argPlayer;
	}

	public static class GameBuilder {
		private List<Player> players;
		private List<WinnningStrategies> winStrategies;
		private int dimension;

		public GameBuilder setPlayers(List<Player> players) {
			this.players = players;
			return this;
		}

		public GameBuilder setWinStrategies(List<WinnningStrategies> winStrategies) {
			this.winStrategies = winStrategies;
			return this;
		}

		public GameBuilder setDimension(int dimension) {
			this.dimension = dimension;
			return this;
		}

		public Game build() throws InvalidPlayerCount, InvalidPlayerSymbol, InvalidDimension {
			validate();
			return new Game(dimension, players, winStrategies, players.get(0));
		}

		private void validate() throws InvalidPlayerCount, InvalidPlayerSymbol, InvalidDimension {
			validatePlayers();
			validateSymbol();
			validateDimension();
		}

		private void validateDimension() throws InvalidDimension {
			if (dimension > MAX_DIMENSION) {
				throw new InvalidDimension();
			}
		}

		private void validateSymbol() throws InvalidPlayerSymbol {
			Set<Character> symbolTaken = new HashSet<>();
			for (Player player : players) {
				if (symbolTaken.contains(player.getSymbol().getSymbol())) {
					throw new InvalidPlayerSymbol();
				} else {
					symbolTaken.add(player.getSymbol().getSymbol());
				}
			}
		}

		private void validatePlayers() throws InvalidPlayerCount {

			if (players.size() > dimension - 1) {
				throw new InvalidPlayerCount();
			}
		}
	}
}
