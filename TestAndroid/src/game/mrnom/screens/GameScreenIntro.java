package game.mrnom.screens;

import java.util.List;

import android.graphics.Color;
import framework.Game;
import framework.Graphics;
import framework.Input.TouchEvent;
import game.mrnom.Assets;

public class GameScreenIntro extends ScreenBase{

	public GameScreenIntro(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> events = game.getInput().getTouchEvents();
		if(events.size()>0)
			game.setScreen(new GameScreen(game));
	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.background, 0, 0);
		g.drawPixmap(Assets.ready, 47, 100);
		g.drawLine(0, 416, 480, 416, Color.BLACK);
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
