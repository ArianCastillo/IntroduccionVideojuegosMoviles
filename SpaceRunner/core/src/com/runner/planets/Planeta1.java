package com.runner.planets;

import java.util.ArrayList;
import java.util.StringTokenizer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.runner.RunnerGame;
import com.runner.planets.objects.Coin;
import com.runner.planets.objects.DangerGround;
import com.runner.planets.objects.GameObject;
import com.runner.planets.objects.Ground;
import com.runner.planets.objects.Plank;
import com.runner.planets.objects.Runner;
import com.runner.planets.objects.Spikes;
import com.runner.screens.AbstractScreen;
import com.runner.screens.MenuScreen;
import com.runner.services.RunnerSound;

public class Planeta1 extends BaseGame{
//Planeta Tierra
	private Runner runner;
	private ArrayList<GameObject> list = new ArrayList<GameObject>();
	private ArrayList<GameObject> pleaseDelete = new ArrayList<GameObject>();
//	private boolean walk = true;
	
	public Planeta1() {
		super();
		runner = new Runner(0,71);
		
		FileHandle file = Gdx.files.internal("data/planeta1");
		StringTokenizer tokens = new StringTokenizer(file.readString());
		Gdx.app.log(RunnerGame.LOG, "Obteniendo mapa");
		getMap(tokens);
		Gdx.app.log(RunnerGame.LOG, "Mapa obtenido");
	}
	
	@Override
	public void update(float delta) {
		runner.update(Gdx.graphics.getDeltaTime());
		Rectangle temp = new Rectangle(0,0,AbstractScreen.VIEWPORT_WIDTH,70);
		if (runner.hits(temp) != -1) {
			runner.action(1, 0, 71);
		}
		
		for(GameObject t : list){
			switch(runner.hits(t.getHitBox())){
			case 1:
				switch(t.hitAction(1)){
				case 1:
					Gdx.app.log(RunnerGame.LOG, "Tocando suelo");
					runner.action(1, 0, t.getHitBox().y + t.getHitBox().height);
					break;
				case 2:
					Gdx.app.log(RunnerGame.LOG, "Herido. Reiniciando...");
					runner.setX(0);runner.setY(71);
					break;
				case 3:
					pleaseDelete.add(t);
					break;
				}
				break;
			case 2:
				switch(t.hitAction(2)){
				case 1:
					Gdx.app.log(RunnerGame.LOG, "Tocando izquierda");
					runner.action(2, t.getHitBox().x + t.getHitBox().width + 1, 0);
					break;
				case 2: 
					Gdx.app.log(RunnerGame.LOG, "Moneda obtenida!");
					runner.setX(0);runner.setY(71);
					break;
				case 3:
					pleaseDelete.add(t);
					break;
				}
				break;
			case 3:
				switch(t.hitAction(3)){
				case 1:
					Gdx.app.log(RunnerGame.LOG, "Tocando derecha");
					runner.action(3, t.getHitBox().x - runner.getHitBox().width - 1, 0);
					break;
				case 2: 
					Gdx.app.log(RunnerGame.LOG, "");
					runner.setX(0);runner.setY(71);
					break;
				case 3:
					pleaseDelete.add(t);
					break;
				}
				break;
			case 4:
				switch(t.hitAction(4)){
				case 1:
					Gdx.app.log(RunnerGame.LOG, "Tocando techo");
					runner.action(4, 0, t.getHitBox().y - runner.getHitBox().height);
					break;
				case 2:
					Gdx.app.log(RunnerGame.LOG, "");
					runner.setX(0);runner.setY(71);
					break;
				case 3:
					pleaseDelete.add(t);
					break;
				}
				break;
			}
		}
		while(!pleaseDelete.isEmpty()){
			list.remove(pleaseDelete.get(0));
			pleaseDelete.remove(0);
		}
		updateCamera();
	}

	@Override
	public void render() {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		runner.draw(batch, atlas);
		Gdx.app.log(RunnerGame.LOG, "Dibujando mapa");
		for(GameObject t : list){
			t.draw(batch, atlas);
		}
		Gdx.app.log(RunnerGame.LOG, "Mapa dibujado");
		batch.end();
		
		runner.moveRight(Gdx.graphics.getDeltaTime());
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isTouched()) {
			Gdx.app.log(RunnerGame.LOG, "Tecla espacio presionada");
			runner.jump();
		}
	}
	
	public void updateCamera(){
		camera.position.x = runner.getHitBox().x;
		camera.update();
	}
	
	public void getMap(StringTokenizer tokens){
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
			}
		}
	}

}
