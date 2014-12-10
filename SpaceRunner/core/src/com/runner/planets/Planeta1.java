package com.runner.planets;

import java.util.StringTokenizer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.runner.planets.objects.GameObject;
import com.runner.planets.objects.Ground;
import com.runner.planets.objects.Plank;
import com.runner.planets.objects.Runner;
import com.runner.planets.objects.Spikes;
import com.runner.screens.AbstractScreen;

public class Planeta1 extends BaseGame{
//Planeta Tierra
	private Runner runner;
	private Array<GameObject> list = new Array<GameObject>();
	
	public Planeta1() {
		super();
		runner = new Runner(AbstractScreen.VIEWPORT_WIDTH/2,AbstractScreen.VIEWPORT_HEIGHT);
		FileHandle file = Gdx.files.internal("data/planeta1");
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
			}
		}
	}
	
	@Override
	public void update(float delta) {
		runner.update(Gdx.graphics.getDeltaTime());
		Rectangle temp = new Rectangle(0,0,AbstractScreen.VIEWPORT_WIDTH,70);
		if (runner.hits(temp) != -1) {
			runner.action(1, 0, 70);
		}
		for(GameObject t : list){
			switch(runner.hits(t.getHitBox())){
			case 1:
				switch(t.hitAction(1)){
				case 1:
					runner.action(1, 0, t.getHitBox().y + t.getHitBox().height);
					break;
				case 2:
					runner.setX(0);runner.setY(AbstractScreen.VIEWPORT_HEIGHT);
					break;
				}
				break;
			case 2:
				runner.action(2, t.getHitBox().x + t.getHitBox().width + 1, 0);
				break;
			case 3:
				runner.action(3, t.getHitBox().x - runner.getHitBox().width - 1, 0);
				break;
			case 4:
				runner.action(4, 0, t.getHitBox().y - runner.getHitBox().height);
				break;
			}
		}
		updateCamera();
	}

	@Override
	public void render() {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		runner.draw(batch, atlas);
		for(GameObject t : list){
			t.draw(batch, atlas);
		}
		batch.end();
		
		runner.moveRight(Gdx.graphics.getDeltaTime());
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isTouched()) {
			runner.jump();
		}
	}
	
	public void updateCamera(){
		camera.position.x = runner.getHitBox().x;
		camera.update();
	}

}
