package com.runner.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.runner.RunnerGame;
import com.runner.services.RunnerSound;

public class FinishWorldScreen extends AbstractScreen{

	public FinishWorldScreen(RunnerGame game) {
		super(game);
		// TODO Auto-generated constructor stub
	}
	
	public void show(){
		super.show();
		
		Table table = super.getTable();
		table.clear();
		Image image = new Image(game.getAssetManager().get("game.atlas", TextureAtlas.class).findRegion("Space"));
		table.setBackground(image.getDrawable());
		
		Label labelPoints = new Label("Puntos: " + game.getWorld().getGameState().points,getSkin());
		Label labelLevel = new Label("Nivel: " + game.getWorld().getGameState().level,getSkin());
		
		TextButton returnButton = new TextButton("Planetas", getSkin());
		returnButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				game.getSoundManager().play(RunnerSound.CLICK);
				game.setScreen(new PlanetsScreen(game));
			}
		});
		TextButton againButton = new TextButton("Otra vez", getSkin());
		againButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				game.getSoundManager().play(RunnerSound.CLICK);
				game.setScreen(new GameScreen(game));
			}
		});
		Image logo = new Image(game.getAssetManager().get("game.atlas", TextureAtlas.class).findRegion("felicidades"));
		table.add(logo);
		table.row();
		table.add(labelPoints).colspan(2);
		table.row();
		table.add(labelLevel).colspan(2);
		table.row();
		table.add(returnButton).size(250, 50).colspan(2);
		table.row();
		table.add(againButton).size(250, 50).colspan(2);
		table.getCell(logo).spaceBottom((float) (Gdx.graphics.getHeight()*0.1));
		table.getCell(labelLevel).spaceBottom((float) (Gdx.graphics.getHeight()*0.1));
		table.getCell(returnButton).spaceBottom((float) (Gdx.graphics.getHeight()*0.1));
		table.getCell(againButton).spaceBottom((float) (Gdx.graphics.getHeight()*0.1));
		
	}

}
