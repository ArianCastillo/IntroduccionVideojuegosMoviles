package com.runner.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.runner.RunnerGame;
import com.runner.game.GameState;
import com.runner.game.Planet;
import com.runner.planets.BaseGame;
import com.runner.planets.BaseGameListener;
import com.runner.services.RunnerSound;

public class GameScreen extends AbstractScreen implements BaseGameListener {
	private Planet planet;
	private Texture back;
	private Table table;
	private BaseGame baseGame;
	private String background;
	private int pts;
	private int lives;
	
	public GameScreen(RunnerGame game) {
		super(game);
	}

	public void show(){
		super.show();
		
		planet = game.getWorld().getCurrentPlanet();
		Gdx.app.log(RunnerGame.LOG, "Entrando a minigame: " + planet.name);
		
		try {
			Class theClass = Class.forName("com.runner.planets." + planet.className);
			baseGame = (BaseGame)theClass.newInstance();
			baseGame.setBaseGameListener(this);
			baseGame.setAssets(game.getAssetManager());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		background = "background.png";
		if(planet.name.compareTo("Tierra")==0){
			background = "sky_earth.png";
		}
		if(planet.name.compareTo("Marte")==0){
			background = "sky_earth.png";
		}
		if(planet.name.compareTo("Jupiter")==0){
			background = "sky_earth.png";
		}
		if(planet.name.compareTo("Saturno")==0){
			background = "sky_earth.png";
		}
		table = super.getTable();
		
		back = new Texture(background);
		back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		table.setBackground(new TextureRegionDrawable(new TextureRegion(back,0,0,1024,768)));
	}
	
	@Override
	public void render(float delta){
		baseGame.update(delta);
		super.render(delta);
		baseGame.render();
		if(baseGame.isFinish()){
			game.setScreen(new FinishWorldScreen(game));
		}
		if(baseGame.isOver()){
			game.setScreen(new DeadWorldScreen(game));
		}
	}
	

	@Override
	public void setPts(int pts) {
		this.pts = pts;
		GameState gameState = game.getWorld().getGameState();
		gameState.points += this.pts;
		game.getWorld().setGameState(gameState);
		game.getProfileManager().persist(gameState);
		setNvl();
	}

	@Override
	public void setNvl() {
		GameState gameState = game.getWorld().getGameState();
		if(gameState.points >= 10){
			gameState.level++;
			game.getWorld().setGameState(gameState);
			game.getProfileManager().persist(gameState);
		}
	}

	@Override
	public void playSoundCoin() {
		// TODO Auto-generated method stub
		game.getSoundManager().play(RunnerSound.COIN);
	}

	@Override
	public void playSoundHit() {
		// TODO Auto-generated method stub
		game.getSoundManager().play(RunnerSound.HIT);
	}

}
