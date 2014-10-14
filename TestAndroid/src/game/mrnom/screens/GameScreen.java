package game.mrnom.screens;

import java.util.List;

import game.mrnom.Settings;

import android.graphics.Color;

import framework.Game;
import framework.Graphics;
import framework.Input.TouchEvent;
import game.mrnom.Assets;
import game.mrnom.world.World;

public class GameScreen extends ScreenBase{

	public GameScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		World world = getWorld();
		
		for(TouchEvent event: touchEvents){
			if(event.type==TouchEvent.TOUCH_UP){
				if(inBounds(event,0,0,64,64)){
					playSound();
					game.setScreen(new GameScreenPause(game));
				}
				if(inBounds(event,0,416,64,64)){
					world.snake.turnLeft();
				}
				if(inBounds(event,256,416,64,64)){
					world.snake.turnRight();
				}
			}
		}
		
		world.update(deltaTime);
		
		if(world.gameOver){
			
		}
	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.background, 0, 0);
		drawWorld();
		
		g.drawPixmap(Assets.ready, 47, 100);
		g.drawLine(0, 416, 480, 416, Color.BLACK);
		g.drawPixmap(Assets.buttons, 47, 100);
	}

	@Override
	public void pause() {
		World world = getWorld();
		if(world.gameOver) {
            Settings.addScore(world.score);
            Settings.save(game.getFileIO());
        }
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
