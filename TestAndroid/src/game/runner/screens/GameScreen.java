package game.runner.screens;

import java.util.List;

import framework.Game;
import framework.Input.TouchEvent;
import framework.Screen;
import game.runner.world.Mundo;

public class GameScreen extends Screen{
	enum GameState{
		Listo,
		Corriendo,
		Pausa,
		GameOver
	}
	
	GameState estado = GameState.Listo;
	Mundo mundo;
	int viejaPuntuación = 0;
	String puntuacion = "0";

	public GameScreen(Game game) {
		super(game);
		mundo = new Mundo();
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        
        if(estado == GameState.Listo)
        	updateListo(touchEvents);
        if(estado == GameState.Corriendo)
        	updateCorriendo(touchEvents, deltaTime);
        if(estado == GameState.Pausa)
        	updatePausa(touchEvents);
        if(estado == GameState.GameOver)
            updateGameOver(touchEvents);
	}
	
	public void update(Game game){
		
	}
	
	public void updateListo(List<TouchEvent> touchEvents){
		
	}
	
	public void updateCorriendo(List<TouchEvent> touchEvents, float deltaTime){
		
	}
	
	public void updatePausa(List<TouchEvent> touchEvents){
		
	}
	
	public void updateGameOver(List<TouchEvent> touchEvents){
		
	}

	@Override
	public void present(float deltaTime) {
		// TODO Auto-generated method stub
		
	}
	
	private void dibujarMundo(Mundo mundo){
		
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
