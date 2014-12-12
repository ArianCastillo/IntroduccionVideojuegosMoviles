package com.runner.planets.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

public class Notification extends GameObject {
	private Rectangle button;
	private int type;
	
	public Notification(int x, int y, int type){
		this.setX(x);
		this.setY(y);
		this.type = type;
		button = new Rectangle (x, y, 850, 70);
	}

	@Override
	public int hits(Rectangle r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(SpriteBatch batch, TextureAtlas atlas) {
		button.x = getX();
		button.y = getY();
		switch(type){
		case 1:
			batch.draw(atlas.findRegion("felicidades"),getX(), getY());
			break;
		case 2:
			batch.draw(atlas.findRegion("gameover"),getX(), getY());
			break;
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
		return button;
	}

	@Override
	public int hitAction(int side) {
		// TODO Auto-generated method stub
		return 0;
	}

}