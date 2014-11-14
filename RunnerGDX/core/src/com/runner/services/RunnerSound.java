package com.runner.services;

public enum RunnerSound {
	CLICK("sounds/click.ogg"),
	GAME("sounds/game.mp3"),
	COIN("sounds/coin.mp3"),
	HIT("sounds/hit.mp3"),
	JUMP("sounds/jump.wav");
	private final String fileName;
	
	private RunnerSound(String fileName){
		this.fileName = fileName;
	}
	
	public String getFileName(){
		return fileName;
	}
}
