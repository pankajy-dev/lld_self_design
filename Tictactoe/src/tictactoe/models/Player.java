package tictactoe.models;

import tictactoe.services.PlayerService;

public class Player {
	private int id;
	private String name;
	private Symbol symbol;
	private PlayerType playerType;
	private static int num = 0;

	public Player(int id, String name, Symbol symbol, PlayerType playerType) {
		num += 1;
		this.id = num;
		this.name = name;
		this.symbol = symbol;
		this.playerType = playerType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}

	public PlayerType getPlayerType() {
		return playerType;
	}

	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
	}

	public Move makeMove(Game game) {
		return new PlayerService().makeMove(game);
	}
}
