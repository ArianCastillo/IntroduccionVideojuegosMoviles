package game.mrnom.screens;

import java.util.List;

import framework.Game;
import framework.Input.TouchEvent;
import game.mrnom.Settings;
import framework.Graphics;
import game.mrnom.Assets;

/**
 * Created by Arian Castillo on 01/10/2014.
 */
public class HighScoresScreen extends ScreenBase {

    String[] lines = new String[5];

    public HighScoresScreen(Game game){
        super(game);
        for(int i=0;i<5;i++){
            lines[i] = (i+1) + ". " + Settings.highscores;
        }
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        for(TouchEvent event: touchEvents) {
            if(event.type == TouchEvent.TOUCH_UP) {
                if(inBounds(event, 0, 416, 64, 64)) {
                    playSound();
                    game.setScreen(new MenuScreen(game));
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
        for (int i = 0; i < 5; i++) {
            drawText(g, lines[i], 20, y);
            y += 50;
        }

        g.drawPixmap(Assets.buttons, 0, 416, 64, 64, 64, 64);
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
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
