package com.runner.planets.objects.danger;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.runner.planets.objects.GameObject;

public class Spikes extends GameObject{
	private Rectangle hitBox;
	
	public Spikes(int x, int y){
		this.setX(x);
		this.setY(y);
		hitBox = new Rectangle(x, y, 70, 35);
	}

	@Override
	public int hits(Rectangle r) {
		return -1;
	}

	@Override
	public void draw(SpriteBatch batch, TextureAtlas atlas) {
		hitBox.x = getX();
		hitBox.y = getY();
		batch.draw(atlas.findRegion("spikes"),getX(), getY());
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
		//if(side == 1) return 2;
		return 2;
	}
}
