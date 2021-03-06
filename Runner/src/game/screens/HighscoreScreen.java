package game.screens;

import java.util.List;

import framework.Game;
import framework.Graphics;
import framework.Input.TouchEvent;
import framework.Screen;
import game.controllers.Assets;
import game.controllers.Settings;

public class HighscoreScreen extends Screen{
	String linesC1[] = new String[3];
	String linesC2[] = new String[2];
	
	public HighscoreScreen(Game game) {
		super(game);
		int index = 0;
        for (; index < 3; index++) {
            linesC1[index] = "" + (index + 1) + ". " + Settings.highscores[index];
        }
        for (int i = 0; index < 5; index++) {
        	linesC2[i] = "" + (index + 1) + ". " + Settings.highscores[index];i++;
        }
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();

        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if (event.x < 416 && event.y > 64) {
                    if(Settings.soundEnabled)
                        Assets.click.play(1);
                    game.setScreen(new MainMenuScreen(game));
                    return;
                }
            }
        }
	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();

        g.drawPixmap(Assets.background, 0, 0);
        g.drawPixmap(Assets.mainMenu, 64, 20, 0, 42, 196, 42);

        int y = 100;
        for (int i = 0; i < 3; i++) {
            drawText(g, linesC1[i], 20, y);
            y += 50;
        }
        y = 100;
        for (int i = 0; i < 2; i++) {
        	drawText(g, linesC2[i], 200, y);
        	y += 50;
        }

        g.drawPixmap(Assets.buttons, 200, 258, 64, 64, 64, 64);
	}
	
	public void drawText(Graphics g, String line, int x, int y) {
        int len = line.length();
        for (int i = 0; i < len; i++) {
            char character = line.charAt(i);
    
            if (character == ' ') {
                x += 20;
                continue;
            }
    
            int srcX = 0;
            int srcWidth = 0;
            if (character == '.') {
                srcX = 200;
                srcWidth = 10;
            } else {
                srcX = (character - '0') * 20;
                srcWidth = 20;
            }
    
            g.drawPixmap(Assets.numbers, x, y, srcX, 0, srcWidth, 32);
            x += srcWidth;
        }
    }

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void dispose() {}

}
