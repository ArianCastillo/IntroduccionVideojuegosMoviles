package com.runner.screens;

import com.runner.RunnerGame;
import com.runner.services.RunnerMusic;
import com.runner.services.RunnerSound;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class SplashScreen extends AbstractScreen{
	public SplashScreen(RunnerGame game) {
		super(game);
	}
	
	@Override
	public void show(){
		super.show();
		Table table = super.getTable();
		
		Texture back = new Texture("background.png");
		back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		table.setBackground(new TextureRegionDrawable(new TextureRegion(back,0,0,1024,768)));
		
		game.getAssetManager().load("game.atlas", com.badlogic.gdx.graphics.g2d.TextureAtlas.class);
		game.getAssetManager().load("fonts/default-32.fnt",BitmapFont.class);
		
		game.getAssetManager().load(RunnerSound.CLICK.getFileName(), Sound.class);
		game.getAssetManager().load(RunnerSound.GAME.getFileName(), Sound.class);
		game.getAssetManager().load(RunnerSound.COIN.getFileName(), Sound.class);
		game.getAssetManager().load(RunnerSound.HIT.getFileName(), Sound.class);
		game.getAssetManager().load(RunnerSound.JUMP.getFileName(), Sound.class);
		game.getAssetManager().load(RunnerMusic.MENU_MUSIC.getFileName(), Music.class);
		game.getAssetManager().load(RunnerMusic.TITLE_MUSIC.getFileName(), Music.class);
		
	}
	
	@Override
	public void render(float delta){
		super.render(delta);
		
		if (game.getAssetManager().update()){
			stage.addAction(Actions.sequence(Actions.delay(0.15f),Actions.fadeOut(0.55f),
					new Action(){
						public boolean act(float delta){
							game.setScreen(new IntroScreen(game));
							return true;
						}
					}));
		}
	}
}
