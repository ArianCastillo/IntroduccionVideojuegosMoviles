package com.runner.planets.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

public class Bandera extends GameObject {
	private Rectangle hitBox;

	public Bandera(int x, int y){
		this.setX(x);
		this.setY(y);
		hitBox = new Rectangle (x, y, 80, 2000);
	}
	@Override
	public int hits(Rectangle r) {
		return 0;
	}

	@Override
	public void draw(SpriteBatch batch, TextureAtlas atlas) {
		hitBox.x = getX();
		hitBox.y = getY();
		batch.draw(atlas.findRegion("bandera"),getX(), getY());
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
		return 4;
	}

}
