package com.runner.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.runner.RunnerGame;
import com.runner.game.Level;
import com.runner.levels.BaseGame;
import com.runner.levels.BaseGameListener;

public class GameScreen extends AbstractScreen
implements BaseGameListener {
	private Level level;
	private BaseGame baseGame;
	
	public GameScreen(RunnerGame game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	public void show(){
		super.show();
		
		level = game.getWorld().getCurrentLevel();
		Gdx.app.log(RunnerGame.LOG, "Entrando a minigame: " + level.name);
		
		try {
			Class theClass = Class.forName("com.runner.levels." + level.className);
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
		
		
		Table table = super.getTable();
		
		Texture back = new Texture("background.png");
		back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		table.setBackground(new TextureRegionDrawable(new TextureRegion(back,0,0,1024,768)));
		
		Label labelName = new Label("Minigame " + level.name,getSkin());
		Label labelPoints = new Label("Puntos: " + game.getWorld().getGameState().points,getSkin());
		Label labelLevel = new Label("Nivel: " + game.getWorld().getGameState().level,getSkin());
		Label labelXP = new Label("Experiencia: " + game.getWorld().getGameState().xp,getSkin());

		Table topTable = new Table();
		topTable.add(labelName);
		topTable.row();
		topTable.add(labelPoints);
		topTable.row();
		topTable.add(labelLevel);
		topTable.row();
		topTable.add(labelXP);
		topTable.row();
		
		table.add(topTable).expand().top().left();
		
	}
	
	@Override
	public void render(float delta){
		
		
		baseGame.update(delta);
		
		super.render(delta);
		baseGame.render();
		
	}

}
