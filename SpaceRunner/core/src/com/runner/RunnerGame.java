package com.runner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.runner.game.World;
import com.runner.screens.SplashScreen;
import com.runner.services.MusicManager;
import com.runner.services.PreferencesManager;
import com.runner.services.ProfileManager;
import com.runner.services.SoundManager;

public class RunnerGame extends Game {
	public static final String LOG = RunnerGame.class.getSimpleName();
	public static final boolean DEV_MODE = false;
	public float factorX, factorY;
	private AssetManager manager = new AssetManager();
	private SoundManager soundManager;
	private MusicManager musicManager;
	private ProfileManager profileManager;
	private PreferencesManager preferencesManager;
	private World world;
	
	public AssetManager getAssetManager(){
		return manager;
	}
	public SoundManager getSoundManager(){
		return soundManager;
	}
	public MusicManager getMusicManager(){
		return musicManager;
	}
	public ProfileManager getProfileManager(){
		return profileManager;
	}
	public PreferencesManager getPreferencesManager(){
		return preferencesManager;
	}
	public World getWorld(){
		return world;
	}
	public RunnerGame(){
	}
	
	@Override
	public void create () {
		Gdx.app.log(RunnerGame.LOG, "Creando juego en " + Gdx.app.getType());
		preferencesManager = new PreferencesManager();
		profileManager = new ProfileManager();
		world = new World(profileManager.retrieveGameState());
		musicManager = new MusicManager(manager);
		soundManager = new SoundManager(manager);
	}

	@Override
	public void resize(int width, int height){
		super.resize(width, height);
		Gdx.app.log(RunnerGame.LOG, "Cambiando resolucion a: " + width + "x" + height);
		factorX = 1024f/(float)width;
		factorY = 768f/(float)height;
		if (getScreen()==null){
			setScreen(new SplashScreen(this));
		}
	}
}
