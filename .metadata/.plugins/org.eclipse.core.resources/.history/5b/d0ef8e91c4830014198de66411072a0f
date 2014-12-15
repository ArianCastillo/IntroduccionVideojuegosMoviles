package com.runner.planets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.runner.screens.AbstractScreen;

public abstract class BasePlanet {
	protected BasePlanetListener listener;
	protected OrthographicCamera camera;
	protected BitmapFont font;
	protected TextureAtlas atlas;
	protected SpriteBatch batch;
	
	private boolean finish;
	private boolean over;
	
	public BasePlanet(){
		camera = new OrthographicCamera();
		camera.setToOrtho(false, AbstractScreen.VIEWPORT_WIDTH, AbstractScreen.VIEWPORT_HEIGHT);
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("fonts/default-16.fnt"), Gdx.files.internal("fonts/default-16.png"), false);
		
		finish = false;
		over = false;
	}
	
	public void setBaseGameListener(BasePlanetListener listener){
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
	
	public void finished(){
		finish = true;
	}
	
	public void gameOver(){
		over = true;
	}

	public BasePlanetListener getListener() {
		return listener;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}
	
	public abstract void render();
	
}
