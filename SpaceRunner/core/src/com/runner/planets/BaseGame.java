package com.runner.planets;

import java.util.Random;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.runner.screens.AbstractScreen;

public abstract class BaseGame {
	protected OrthographicCamera camera;
	protected TextureAtlas atlas;
	protected SpriteBatch batch;
	protected BitmapFont font;
	protected BaseGameListener listener;
	protected Random random;
	
	protected boolean started;
	protected int pass;
	
	public BaseGame(){
		camera = new OrthographicCamera();
		camera.setToOrtho(false, AbstractScreen.VIEWPORT_WIDTH, AbstractScreen.VIEWPORT_HEIGHT);
		batch = new SpriteBatch();
		started = false;
		random = new Random();
	}
	
	public void setBaseGameListener(BaseGameListener listener){
		this.listener = listener;
	}
	
	public void setAssets(AssetManager manager){
		atlas = manager.get("game.atlas",com.badlogic.gdx.graphics.g2d.TextureAtlas.class);
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
		font = manager.get("fonts/default-32.fnt",BitmapFont.class);
	}
	
	public void pause(){
		started = false;
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
	
	public abstract void update(float delta);
	public abstract void render();
}