package game.mrnom.screens;

import framework.Game;
import framework.Graphics;
import framework.Pixmap;
import framework.Screen;
import framework.Input.TouchEvent;
import game.mrnom.Assets;
import game.mrnom.MrNomGame;
import game.mrnom.Settings;
import game.mrnom.world.Snake;
import game.mrnom.world.SnakePart;
import game.mrnom.world.Stain;
import game.mrnom.world.World;

/**
 * Created by Arian Castillo on 01/10/2014.
 */
public abstract class ScreenBase extends Screen{
	String score = "0";
	
	public ScreenBase(Game game) {
        super(game);
    }
	
	protected World getWorld(){
		MrNomGame mrNomGame = (MrNomGame)game;
		return mrNomGame.world;
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
        int srcX;
        int srcWidth;
        for(int i=0;i<line.length();i++){
            char character = line.charAt(i);

            if(character==' '){
                x+=20;
            }

            if(character=='.'){
                srcX = 200;
                srcWidth = 10;
            }else {
                srcX = (character-'0')*20;
                srcWidth = 20;
            }
            g.drawPixmap(Assets.numbers, x, y, srcX, 0, srcWidth, 32);
            x+=srcWidth;
        }
    }
    
    protected void drawWorld(){
    	World world = getWorld();
    	Graphics g = game.getGraphics();
    	
    	Snake snake = world.snake;
    	SnakePart head = snake.parts.get(0);
    	Stain stain = world.stain;
    	
    	//Dibujar la tinta
    	Pixmap stainPixmap = null;
    	if(stain.type==Stain.TYPE_1)
    		stainPixmap = Assets.stain1;
    	if(stain.type==Stain.TYPE_2)
    		stainPixmap = Assets.stain2;
    	if(stain.type==Stain.TYPE_3)
    		stainPixmap = Assets.stain3;
    	
    	g.drawPixmap(stainPixmap, stain.x*32, stain.y*32);
    	
    	for(int i=1;i<snake.parts.size();i++){
    		SnakePart part = snake.parts.get(i);
    		g.drawPixmap(Assets.tail, part.x*32, part.y*32);
    	}
    	
    	Pixmap headPixmap = null;
    	if(snake.direction==Snake.UP)
    		headPixmap = Assets.headUp;
    	if(snake.direction==Snake.DOWN)
    		headPixmap = Assets.headDown;
    	if(snake.direction==Snake.LEFT)
    		headPixmap = Assets.headLeft;
    	if(snake.direction==Snake.RIGHT)
    		headPixmap = Assets.headRight;
    	g.drawPixmap(headPixmap, head.x*32, head.y*32);
    	
    	drawText(g, score, g.getWidth() / 2 - (score.length()*20) / 2, g.getHeight() - 42);
    }
}
