package com.runner.screens;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.runner.RunnerGame;
import com.runner.game.Planet;
import com.runner.services.RunnerSound;

public class PlanetsScreen extends AbstractScreen{

	public PlanetsScreen(RunnerGame game) {
		super(game);
	}

	public void show(){
		super.show();
		Table table = super.getTable();
		table.clear();
		Image image = new Image(game.getAssetManager().get("game.atlas", TextureAtlas.class).findRegion("SpacePlanet"));
		table.setBackground(image.getDrawable());
		
		Label label = new Label("NIVELES",getSkin());
		table.add(label).spaceBottom(30).colspan(2);
		table.row();
		
		Array<Planet> planets = game.getWorld().getGameState().planets;
		int i=0;
		for (final Planet planet: planets){
			TextButton planetButton = new TextButton(Integer.toString(i+1), getSkin());
			planetButton.addListener(new ClickListener(){
				public void clicked(InputEvent event, float x, float y){
					game.getSoundManager().play(RunnerSound.CLICK);
					
					game.getWorld().setCurrentPlanet(planet);
					game.setScreen(new GameScreen(game));
				}
			});
			table.add(planetButton);
			table.getCell(planetButton).spaceLeft(100);
			table.getCell(planetButton).spaceBottom(100);
			i++;
			if (i%2==0) table.row();
		}
		TextButton returnButton = new TextButton("Regresar", getSkin());
		returnButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				game.getSoundManager().play(RunnerSound.CLICK);
				game.setScreen(new MenuScreen(game));
			}
		});
		table.add(returnButton).colspan(2);
	}
}
