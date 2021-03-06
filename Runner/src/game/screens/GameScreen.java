package game.screens;

import java.util.List;

import framework.Game;
import framework.Graphics;
import framework.Input.TouchEvent;
import framework.Screen;
import game.controllers.Settings;
import game.world.Runner;
import game.world.World;

public class GameScreen extends Screen {
	enum GameState {
        Ready,
        Running,
        Paused,
        GameOver
    }
	GameState state = GameState.Ready;
    World world;
    int oldScore = 0;
    String score = "0";
    
	public GameScreen(Game game) {
		super(game);
		world = new World();
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        
        if(state == GameState.Ready)
            updateReady(touchEvents);
        if(state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if(state == GameState.Paused)
            updatePaused(touchEvents);
        if(state == GameState.GameOver)
            updateGameOver(touchEvents); 
	}
	
	private void updateReady(List<TouchEvent> touchEvents) {
        if(touchEvents.size() > 0)
            state = GameState.Running;
    }
	private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {
		
	}
	private void updatePaused(List<TouchEvent> touchEvents) {
		
	}
	private void updateGameOver(List<TouchEvent> touchEvents) {
		
	}

	@Override
	public void present(float deltaTime) {
		// TODO Auto-generated method stub
		
	}
	
	private void drawWorld(World world) {
		Graphics g = game.getGraphics();
		Runner runner = world.runner;
		
	}
	private void drawReadyUI() {
		
	}
	private void drawRunningUI() {
		
	}
	private void drawPausedUI() {
		
	}
	private void drawGameOverUI() {
		
	}
	public void drawText(Graphics g, String line, int x, int y) {
		
	}

	@Override
	public void pause() {
		if(state == GameState.Running)
            state = GameState.Paused;
        
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
