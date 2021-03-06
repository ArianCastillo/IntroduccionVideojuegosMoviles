package game.screens;

import java.util.List;

import framework.Game;
import framework.Graphics;
import framework.Input.TouchEvent;
import framework.Screen;
import game.controllers.Assets;
import game.controllers.Settings;

public class MainMenuScreen extends Screen{
    
    public MainMenuScreen(Game game) {
		super(game);
	}
    
	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
        
		for(int i = 0; i < touchEvents.size(); i++) {
			TouchEvent event = touchEvents.get(i);
			if(event.type == TouchEvent.TOUCH_UP) {
				if(inBounds(event, 0, g.getHeight() - 64, 64, 64)) {
					Settings.soundEnabled = !Settings.soundEnabled;
					if(Settings.soundEnabled)
						Assets.click.play(1);
				}
				if(inBounds(event, 140, 80, 192, 42) ) {//64, 220, 192, 42
					//game.setScreen(new GameScreen(game));
					if(Settings.soundEnabled)
						Assets.click.play(1);
					return;
				}
				if(inBounds(event, 140, 80 + 42, 192, 42) ) {
					game.setScreen(new HighscoreScreen(game));
					if(Settings.soundEnabled)
						Assets.click.play(1);
					return;
				}
				if(inBounds(event, 140, 80 + 84, 192, 42) ) {
					//game.setScreen(new HelpScreen(game));
					if(Settings.soundEnabled)
						Assets.click.play(1);
					return;
				}
			}
				
		}
	}
	
	private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
		if(event.x > x && event.x < x + width - 1 && event.y > y && event.y < y + height - 1)
			return true;
		else
			return false;
	}
	
	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.background, 0, 0);
		g.drawPixmap(Assets.logo, 32, 20);
		g.drawPixmap(Assets.mainMenu, 140, 80);
		g.drawPixmap(Assets.front, 50, 228);
		if(Settings.soundEnabled)
			g.drawPixmap(Assets.buttons, 200, 258, 0, 0, 64, 64);
		else
			g.drawPixmap(Assets.buttons, 200, 258, 64, 0, 64, 64);
	}
	
	@Override
	public void pause() {
		Settings.save(game.getFileIO());
	}
	
	@Override
	public void resume() {}
	
	@Override
	public void dispose() {}
}
