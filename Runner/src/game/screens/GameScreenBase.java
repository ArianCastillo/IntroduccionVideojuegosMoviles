package game.screens;

import framework.Game;
import framework.Graphics;
import framework.Pixmap;
import framework.Screen;
import framework.Input.TouchEvent;
import game.controllers.Assets;
import game.controllers.RunnerGame;
import game.controllers.Settings;
import game.world.Obstacle;
import game.world.Runner;
import game.world.World;

public abstract class GameScreenBase extends Screen{
	int oldScore = 0;
	String score = "0";
	
	public GameScreenBase(Game game) {
		super(game);
	}
	
	protected World getWorld(){
		RunnerGame runnerGame = (RunnerGame)game;
		return runnerGame.world;
	}
	
	protected void playSound(){
        if(Settings.soundEnabled)
            Assets.click.play(1);
    }
	
	protected boolean inBounds(TouchEvent event, int x, int y, int width, int height){
        if(event.x > x && event.x < x + width && event.y > y && event.y < y + height)
            return true;
        else
            return false;
    }
	
	protected void drawText(Graphics g, String line, int x, int y){
        int srcHigh,srcWidth;
        for(int i=0;i<line.length();i++){
            char character = line.charAt(i);

            if(character==' '){
                x+=20;
            }

            if(character=='.'){
            	srcHigh = 200;
                srcWidth = 10;
            }else {
            	srcHigh = (character-'0')*20;
                srcWidth = 20;
            }
            g.drawPixmap(Assets.numbers, x, y, srcHigh, 0, srcWidth, 32);
            x+=srcWidth;
        }
    }
    
    protected void drawWorld(){
    	World world = getWorld();
    	Graphics g = game.getGraphics();
    	
    	Runner runner = world.runner;
    	Obstacle obstacle = world.obstacle;
    	
    	//Dibujar la tinta
    	Pixmap obstaclePixmap = null;
    	if(obstacle.type==Obstacle.TYPE_1)
    		obstaclePixmap = Assets.obstacle1;
    	if(obstacle.type==Obstacle.TYPE_2)
    		obstaclePixmap = Assets.obstacle2;
    	
    	g.drawPixmap(obstaclePixmap, obstacle.x*32, obstacle.y*32);
    	
    	/*for(int i=1;i<snake.parts.size();i++){
    		SnakePart part = snake.parts.get(i);
    		g.drawPixmap(Assets.tail, part.x*32, part.y*32);
    	}*/
    	
    	/*Pixmap headPixmap = null;
    	if(snake.direction==Snake.UP)
    		headPixmap = Assets.headUp;
    	if(snake.direction==Snake.DOWN)
    		headPixmap = Assets.headDown;
    	if(snake.direction==Snake.LEFT)
    		headPixmap = Assets.headLeft;
    	if(snake.direction==Snake.RIGHT)
    		headPixmap = Assets.headRight;
    	g.drawPixmap(headPixmap, head.x*32, head.y*32);*/
    	
    	drawText(g, score, g.getWidth() / 2 - (score.length()*20) / 2, g.getHeight() - 42);
    }
}
