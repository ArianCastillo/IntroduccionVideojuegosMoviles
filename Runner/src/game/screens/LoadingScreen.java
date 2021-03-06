package game.screens;

import framework.Game;
import framework.Graphics;
import framework.PixmapFormat;
import framework.Screen;
import game.controllers.Assets;
import game.controllers.Settings;

public class LoadingScreen extends Screen{

	public LoadingScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
		//Escenario
		Assets.background = g.newPixmap("background.png", PixmapFormat.ARGB4444);
		Assets.ground= g.newPixmap("ground.png", PixmapFormat.ARGB4444);
		Assets.ground_cave= g.newPixmap("ground_cave.png", PixmapFormat.ARGB4444);
		Assets.ground_dirty= g.newPixmap("ground_dirty.png", PixmapFormat.ARGB4444);
		Assets.ground_rock= g.newPixmap("ground_rock.png", PixmapFormat.ARGB4444);
		Assets.ground_sand= g.newPixmap("ground_sand.png", PixmapFormat.ARGB4444);
		
		//Adornos
		Assets.alien_plant= g.newPixmap("alien_plant.png", PixmapFormat.ARGB4444);
		Assets.bush= g.newPixmap("bush.png", PixmapFormat.ARGB4444);
		Assets.fence= g.newPixmap("fence.png", PixmapFormat.ARGB4444);
		Assets.fence_broken= g.newPixmap("fence_broken.png", PixmapFormat.ARGB4444);
		Assets.grass= g.newPixmap("grass.png", PixmapFormat.ARGB4444);
		Assets.rock= g.newPixmap("rock.png", PixmapFormat.ARGB4444);
		Assets.shroom= g.newPixmap("shroom.png", PixmapFormat.ARGB4444);
		
		//Objetos
		Assets.bridge= g.newPixmap("bridge.png", PixmapFormat.ARGB4444);
		Assets.plank= g.newPixmap("plank.png", PixmapFormat.ARGB4444);
		
		//Ambiente
		Assets.lava= g.newPixmap("lava.png", PixmapFormat.ARGB4444);
		Assets.water= g.newPixmap("water.png", PixmapFormat.ARGB4444);
		
		//Obstaculos
		Assets.block= g.newPixmap("block.png", PixmapFormat.ARGB4444);
		Assets.crate= g.newPixmap("crate.png", PixmapFormat.ARGB4444);
		Assets.spikes= g.newPixmap("spikes.png", PixmapFormat.ARGB4444);
		
		//Personaje
		Assets.front= g.newPixmap("front.png", PixmapFormat.ARGB4444);
		Assets.jump= g.newPixmap("jump.png", PixmapFormat.ARGB4444);
		Assets.slide= g.newPixmap("slide.png", PixmapFormat.ARGB4444);
		Assets.walk_sheet= g.newPixmap("walk_sheet.png", PixmapFormat.ARGB4444);
		
		//Monedas
		Assets.coin_bronze= g.newPixmap("coin_bronze.png", PixmapFormat.ARGB4444);
		Assets.coin_gold= g.newPixmap("coin_gold.png", PixmapFormat.ARGB4444);
		Assets.coin_silver= g.newPixmap("coin_silver.png", PixmapFormat.ARGB4444);
		
		//Enemigos
		Assets.fly_dead= g.newPixmap("fly_dead.png", PixmapFormat.ARGB4444);
		Assets.fly_fly= g.newPixmap("fly_fly.png", PixmapFormat.ARGB4444);
		Assets.fly_normal= g.newPixmap("fly_normal.png", PixmapFormat.ARGB4444);
		Assets.slime_dead= g.newPixmap("slime_dead.png", PixmapFormat.ARGB4444);
		Assets.slime_normal= g.newPixmap("slime_normal.png", PixmapFormat.ARGB4444);
		
		//Otros (Por remplazar)
		Assets.logo= g.newPixmap("logo.png", PixmapFormat.ARGB4444);
		Assets.mainMenu= g.newPixmap("mainMenu.png", PixmapFormat.ARGB4444);
		Assets.buttons= g.newPixmap("buttons.png", PixmapFormat.ARGB4444);
		Assets.numbers= g.newPixmap("numbers.png", PixmapFormat.ARGB4444);
		
		Assets.ready= g.newPixmap("ready.png", PixmapFormat.ARGB4444);
	    Assets.pauseMenu= g.newPixmap("pauseMenu.png", PixmapFormat.ARGB4444);
	    Assets.gameover= g.newPixmap("gameover.png", PixmapFormat.ARGB4444);
		
	    Assets.click = game.getAudio().newSound("click.ogg");
	    Assets.explosion = game.getAudio().newSound("explosion.ogg");
	    
	    Settings.load(game.getFileIO());
	    game.setScreen(new MainMenuScreen(game));
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
