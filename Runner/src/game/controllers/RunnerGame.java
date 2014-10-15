package game.controllers;

import framework.Screen;
import framework.impl.RunnerActivity;
import game.screens.LoadingScreen;
import game.world.World;

public class RunnerGame extends RunnerActivity{
	public World world = new World();
	
    public Screen getStartScreen() {
        return new LoadingScreen(this);
    }
}
