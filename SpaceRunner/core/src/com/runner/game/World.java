package com.runner.game;

public class World {
	private GameState gameState;
	private Planet currentPlanet;
	
	public World(GameState gameState){
		this.setGameState(gameState);
	}
	
	public GameState getGameState() {
		return gameState;
	}
	
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public Planet getCurrentPlanet() {
		return currentPlanet;
	}

	public void setCurrentPlanet(Planet currentPlanet) {
		this.currentPlanet = currentPlanet;
	}
}
