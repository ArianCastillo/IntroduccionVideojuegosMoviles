package com.runner.planets;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.runner.planets.objects.GameObject;
import com.runner.planets.objects.Runner;
import com.runner.screens.AbstractScreen;

public class PlanetLvl extends BasePlanet{
	private Runner runner;
	protected ArrayList<GameObject> list = new ArrayList<GameObject>();
	protected ArrayList<GameObject> pleaseDelete = new ArrayList<GameObject>();
	protected int pts;
	protected int hp;
	protected boolean isGameFinished;
	protected MapManager mapManager;
	protected int gameS = 1; //1 = Main Game, 2 = Game Finished Screen, 3 = Game Over Screen

	public PlanetLvl(){
		runner = new Runner(0,70);
		mapManager = new MapManager(this);
		isGameFinished = false;
		pts = 0;
		hp = 3;
	}
	
	public void render(){
		switch(this.gameS){
		case 1:
			this.mainGame();
			break;
		case 2:
			this.listener.setPts(pts);
			this.finished();
			break;
		case 3: 
			this.gameOver();
			break;
		case 4:
			this.pauseGame();
			break;
		}
	}
	
	private void mainGame(){
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		runner.draw(batch, atlas);
		for(GameObject t : list){
			t.draw(batch, atlas);
		}
		this.showScore();
		this.showHP();
		batch.end();
		
		runner.update(Gdx.graphics.getDeltaTime());
		Rectangle temp = new Rectangle(0,0,AbstractScreen.VIEWPORT_WIDTH,70);
		if (runner.hits(temp) != -1) {
			runner.action(1, 0, 70);
		}
		
		mapManager.touchSomething();
		mapManager.coinCollected();
		
		if(isGameFinished){
			this.gameS = 2;
		}
		
		mapManager.updateCamera();
		mapManager.controles();
	}
	
	private void pauseGame(){
		
	}
	
	private void showScore(){
		font.draw(batch, "PTS: " + Integer.toString(pts), camera.position.x - (AbstractScreen.VIEWPORT_WIDTH/2), AbstractScreen.VIEWPORT_HEIGHT-25);
	}
	
	private void showHP(){
		font.draw(batch, "HP: " + Integer.toString(hp), camera.position.x - (AbstractScreen.VIEWPORT_WIDTH/2) + 200, AbstractScreen.VIEWPORT_HEIGHT-25);
	}
	
	public Runner getRunner() {
		return runner;
	}
	
	public ArrayList<GameObject> getList() {
		return list;
	}

	public ArrayList<GameObject> getPleaseDelete() {
		return pleaseDelete;
	}

	public int getPts() {
		return pts;
	}

	public void setPts(int pts) {
		this.pts = pts;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setGameFinished(boolean isGameFinished) {
		this.isGameFinished = isGameFinished;
	}

	public void setGameS(int gameS) {
		this.gameS = gameS;
	}
	
	public void setMap(String DATA_FILE){
		mapManager.setMap(DATA_FILE);
	}
}
