package com.runner.planets.objects.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.runner.planets.objects.GameObject;

public class Slime extends GameObject{
	private Rectangle hitBox;
	
	public Slime(int x, int y){
		this.setX(x);
		this.setY(y);
		hitBox = new Rectangle(x, y, 43, 28);
	}
	
	@Override
	public int hits(Rectangle r) {
		return -1;
	}

	@Override
	public void draw(SpriteBatch batch, TextureAtlas atlas) {
		hitBox.x = getX();
		hitBox.y = getY();
		batch.draw(atlas.findRegion("slime"),getX(), getY());
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
		return hitBox;
	}

	@Override
	public int hitAction(int side) {
		// TODO Auto-generated method stub
		return 2;
	}

}
