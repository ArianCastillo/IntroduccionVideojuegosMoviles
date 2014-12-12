package com.runner.planets.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

public class Heart extends GameObject{
	private Rectangle hitBox;
	private int lives;
	
	public Heart(int x, int y){
		System.out.println("x = " + x + ", y = " + y);
		this.setX(x);
		this.setY(y);
		this.lives = 3;
		hitBox = new Rectangle (x, y, 75, 70);
	}

	@Override
	public int hits(Rectangle r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(SpriteBatch batch, TextureAtlas atlas) {
		hitBox.x = getX();
		hitBox.y = getY();
		if(lives == 3){
			batch.draw(atlas.findRegion("heart"),getX(), getY());
			batch.draw(atlas.findRegion("heart"),getX() + 5, getY());
			batch.draw(atlas.findRegion("heart"),getX() + 80, getY());
		}else if(lives == 2){
			batch.draw(atlas.findRegion("heart"),getX(), getY());
			batch.draw(atlas.findRegion("heart"),getX() + 5, getY());
		}else if(lives == 1){
			batch.draw(atlas.findRegion("heart"),getX(), getY());
		}
	}

	@Override
	public void action(int type, float x, float y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getHitBox() {
		// TODO Auto-generated method stub
		return hitBox;
	}

	@Override
	public int hitAction(int side) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setLives(int lives){
		this.lives = lives;
	}

}
