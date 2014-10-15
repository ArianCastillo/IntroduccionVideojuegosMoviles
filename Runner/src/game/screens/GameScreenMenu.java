package game.screens;

import java.util.List;

import framework.Game;
import framework.Graphics;
import framework.Input.TouchEvent;
import game.controllers.Settings;
import game.controllers.Assets;
import game.screens.GameScreenIntro;
import game.screens.GameScreenHighScores;

public class GameScreenMenu extends GameScreenBase{

	public GameScreenMenu(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        for(TouchEvent event: touchEvents) {
            if(event.type == TouchEvent.TOUCH_UP) {
                if(inBounds(event, 0, 416, 64, 64)) {
                    Settings.soundEnabled = !Settings.soundEnabled;
                    playSound();
                }
                if(inBounds(event, 64, 220, 192, 42) ) {
                    game.setScreen(new GameScreenIntro(game));
                    playSound();
                    return;
                }
                if(inBounds(event, 64, 220 + 42, 191, 41) ) {
                    game.setScreen(new GameScreenHighScores(game));
                    playSound();
                    return;
                }
                if(inBounds(event, 64, 220 + 84, 191, 41) ) {
                    playSound();
                    return;
                }
            }
        }
	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
        g.drawPixmap(Assets.background, 0, 0);
        g.drawPixmap(Assets.logo, 32, 20);
        g.drawPixmap(Assets.mainMenu, 64, 220);
        if(Settings.soundEnabled)
            g.drawPixmap(Assets.buttons, 0, 416, 0, 0, 64, 64);
        else
            g.drawPixmap(Assets.buttons, 0, 416, 64, 0, 64, 64);
	}

	@Override
	public void pause() {
		Settings.save(game.getFileIO());
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