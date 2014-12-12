package com.runner.planets;

import java.util.ArrayList;
import java.util.StringTokenizer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.runner.planets.objects.Coin;
import com.runner.planets.objects.DangerGround;
import com.runner.planets.objects.Flag;
import com.runner.planets.objects.GameObject;
import com.runner.planets.objects.Ground;
import com.runner.planets.objects.Plank;
import com.runner.planets.objects.Plant;
import com.runner.planets.objects.Runner;
import com.runner.planets.objects.Spikes;
import com.runner.screens.AbstractScreen;

public class Planeta {
	private Runner runner;
	private ArrayList<GameObject> list = new ArrayList<GameObject>();
	private ArrayList<GameObject> pleaseDelete = new ArrayList<GameObject>();
	private int pts;
	private int vidas;
	private boolean isGameFinished;
	private int gameS = 1; //1 = Main Game, 2 = Game Finished Screen, 3 = Game Over Screen
	private OrthographicCamera camera;
	private TextureAtlas atlas;
	private SpriteBatch batch;
	private BitmapFont font;
	protected PlanetListener listener;
	
	private boolean started;
	private boolean finish;
	private boolean over;
	private int pass;
	
	public Planeta(){
		camera = new OrthographicCamera();
		camera.setToOrtho(false, AbstractScreen.VIEWPORT_WIDTH, AbstractScreen.VIEWPORT_HEIGHT);
		batch = new SpriteBatch();
		started = false;
		finish = false;
		over = false;
		
		runner = new Runner(0,70);
		
		pts = 0;
		vidas = 3;
		isGameFinished = false;
		
	}
	
	public void setBaseGameListener(PlanetListener listener){
		this.listener = listener;
	}
	
	public void setAssets(AssetManager manager){
		atlas = manager.get("game.atlas",com.badlogic.gdx.graphics.g2d.TextureAtlas.class);
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
		font = manager.get("fonts/default-32.fnt",BitmapFont.class);
	}
	
	public boolean isFinish(){
		return finish;
	}
	
	public boolean isOver(){
		return over;
	}
	
	public void gameOver(){
		started = false;
		over = true;
	}
	
	public void pause(){
		started = false;
		finish = true;
	}
	
	public void resume(){
		started = true;
	}
	
	public void startGame(){
		started = true;
		pass = 1;
	}
	
	public void startPass(){
		started = true;
		pass++;
	}
	
	public void render(){
		switch(this.gameS){
		case 1:
			this.mainGame();
			break;
		case 2:
			this.listener.setPts(pts);
			this.pause();
			break;
		case 3: 
			this.gameOver();
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
		batch.end();
		
		runner.update(Gdx.graphics.getDeltaTime());
		Rectangle temp = new Rectangle(0,0,AbstractScreen.VIEWPORT_WIDTH,70);
		if (runner.hits(temp) != -1) {
			runner.action(1, 0, 70);
		}
		
		touchSomething();
		coinCollected();
		
		if(isGameFinished){
			this.gameS = 2;
		}
		
		updateCamera();
		controles();
	}
	public void setMap(String DATA_FILE){
		FileHandle file = Gdx.files.internal(DATA_FILE);
		StringTokenizer tokens = new StringTokenizer(file.readString());
		while(tokens.hasMoreTokens()){
			String type = tokens.nextToken();
			if(type.equals("ground")){
				list.add(new Ground(Integer.parseInt(tokens.nextToken()), 
						Integer.parseInt(tokens.nextToken()), 
						Integer.parseInt(tokens.nextToken())));
			}else if(type.equals("spikes")){
				list.add(new Spikes(Integer.parseInt(tokens.nextToken()), 
						Integer.parseInt(tokens.nextToken())));
			}else if(type.equals("dangerGround")){
				list.add(new DangerGround(Integer.parseInt(tokens.nextToken()), 
						Integer.parseInt(tokens.nextToken()), 
						Integer.parseInt(tokens.nextToken())));
			}else if(type.equals("coin")){
				list.add(new Coin(Integer.parseInt(tokens.nextToken()), 
						Integer.parseInt(tokens.nextToken()), 
						Integer.parseInt(tokens.nextToken())));
			}else if(type.equals("plank")){
				list.add(new Plank(Integer.parseInt(tokens.nextToken()), 
						Integer.parseInt(tokens.nextToken())));
			}else if(type.equals("plant")){
				list.add(new Plant(Integer.parseInt(tokens.nextToken()), 
						Integer.parseInt(tokens.nextToken()), 
						Integer.parseInt(tokens.nextToken())));
			}else if(type.equals("flag")){
				list.add(new Flag(Integer.parseInt(tokens.nextToken()), 
						Integer.parseInt(tokens.nextToken())));
			}
		}
	}
	private void touchSomething(){
		for(GameObject t : list){
			switch(runner.hits(t.getHitBox())){
			case 1:
				switch(t.hitAction(1)){
				case 1:
					runner.action(1, 0, t.getHitBox().y + t.getHitBox().height);
					break;
				case 2:
					listener.playSoundHit();
					vidas--;
					if(vidas==0)
						this.gameS = 3;
					runner.reastart(0, 100);
					break;
				case 3:
					listener.playSoundCoin();
					pleaseDelete.add(t);
					break;
				case 4:
					isGameFinished = true;
					break;
				}
				break;
			case 2:
				switch(t.hitAction(2)){
				case 1:
					runner.action(2, t.getHitBox().x + t.getHitBox().width + 1, 0);
					break;
				case 2:
					listener.playSoundHit();
					vidas--;
					if(vidas==0)
						this.gameS = 3;
					runner.reastart(0, 100);
					break;
				case 3:
					listener.playSoundCoin();
					pleaseDelete.add(t);
					break;
				case 4:
					isGameFinished = true;
					break;
				}
				break;
			case 3:
				switch(t.hitAction(3)){
				case 1:
					runner.action(3, t.getHitBox().x - runner.getHitBox().width - 1, 0);
					break;
				case 2:
					listener.playSoundHit();
					vidas--;
					if(vidas==0)
						this.gameS = 3;
					runner.reastart(0, 100);
					break;
				case 3:
					listener.playSoundCoin();
					pleaseDelete.add(t);
					break;
				case 4:
					isGameFinished = true;
					break;
				}
				break;
			case 4:
				switch(t.hitAction(4)){
				case 1:
					runner.action(4, 0, t.getHitBox().y - runner.getHitBox().height);
					break;
				case 2:
					listener.playSoundHit();
					vidas--;
					if(vidas==0)
						this.gameS = 3;
					runner.reastart(0, 100);
					break;
				case 3:
					listener.playSoundCoin();
					pleaseDelete.add(t);
					break;
				case 4:
					isGameFinished = true;
					break;
				}
				break;
			}
		}
	}
	private void updateCamera(){
		camera.position.x = runner.getHitBox().x;
		camera.update();
	}
	private void coinCollected(){
		while(!pleaseDelete.isEmpty()){
			list.remove(pleaseDelete.get(0));
			Coin coin = (Coin) pleaseDelete.get(0);
			pleaseDelete.remove(0);
			pts += coin.getPoints();
		}
	}
 	private void controles(){
		runner.moveRight(Gdx.graphics.getDeltaTime());
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isTouched()) {
			runner.jump();
		}
	}
}
