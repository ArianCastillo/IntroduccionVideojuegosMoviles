package game.screens;

import framework.Game;
import framework.Graphics;
import framework.PixmapFormat;
import framework.Screen;
import game.controllers.Settings;
import game.controllers.Assets;

public class LoadingScreen extends Screen{

	public LoadingScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
		Assets.background = g.newPixmap("background.png", PixmapFormat.RGB565);
        Assets.logo = g.newPixmap("logo.png", PixmapFormat.ARGB4444);
        Assets.mainMenu = g.newPixmap("mainmenu.png", PixmapFormat.ARGB4444);
        Assets.buttons = g.newPixmap("buttons.png", PixmapFormat.ARGB4444);
        Assets.numbers = g.newPixmap("numbers.png", PixmapFormat.ARGB4444);
        Assets.ready = g.newPixmap("ready.png", PixmapFormat.ARGB4444);
        Assets.pause = g.newPixmap("pausemenu.png", PixmapFormat.ARGB4444);
        Assets.gameOver = g.newPixmap("gameover.png", PixmapFormat.ARGB4444);
		Assets.obstacle1 = g.newPixmap("obstacle1.png", PixmapFormat.ARGB4444);
		Assets.obstacle2 = g.newPixmap("obstacle2.png", PixmapFormat.ARGB4444);
		Settings.load(game.getFileIO());
		Assets.click = game.getAudio().newSound("click.ogg");
		Assets.explosion = game.getAudio().newSound("explosion.ogg");
		game.setScreen(new GameScreenMenu(game));
	}

	@Override
	public void present(float deltaTime) {
		// TODO Auto-generated method stub
		
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
