package game.mrnom.screens;

import framework.Game;
import framework.Graphics;
import framework.Input.TouchEvent;
import game.mrnom.Assets;
import game.mrnom.Settings;

import java.util.List;

public class MenuScreen extends ScreenBase {
    public MenuScreen(Game game) {
        super(game);               
    }   

    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        for(TouchEvent event: touchEvents) {
            if(event.type == TouchEvent.TOUCH_UP) {
                if(inBounds(event, 0, 416, 63, 63)) {
                    Settings.soundEnabled = !Settings.soundEnabled;
                    playSound();
                }
                if(inBounds(event, 64, 220, 191, 41) ) {
                    playSound();
                    game.setScreen(new GameScreenIntro(game));
                }
                if(inBounds(event, 64, 220 + 42, 191, 41) ) {
                    playSound();
                    game.setScreen(new HighScoresScreen(game));
                }
                if(inBounds(event, 64, 220 + 84, 191, 41) ) {
                    playSound();
                }
            }
        }
    }

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

    public void pause() {        
        Settings.save(game.getFileIO());
    }

    public void resume() {

    }

    public void dispose() {

    }
}

