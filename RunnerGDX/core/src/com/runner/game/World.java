package com.runner.game;

public class World {
	private GameState gameState;
	private Level currentLevel;
	
	public World(GameState gameState){
		this.setGameState(gameState);
	}
	
	public GameState getGameState() {
		return gameState;
	}
	
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public Level getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(Level currentLevel) {
		this.currentLevel = currentLevel;
	}
}
