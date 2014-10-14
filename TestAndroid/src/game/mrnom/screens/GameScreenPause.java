package game.mrnom.screens;

import android.graphics.Color;
import framework.Game;
import framework.Graphics;
import game.mrnom.Assets;

public class GameScreenPause extends ScreenBase{

	public GameScreenPause(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float deltaTime) {
		
		
	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.background, 0, 0);
		drawWorld();
		
		g.drawLine(0, 416, 480, 416, Color.BLACK);
		g.drawPixmap(Assets.pause, 80, 100);
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
