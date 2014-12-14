package com.runner.planets.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

public class Plant extends GameObject{
	private Rectangle hitBox;
	int type;

	public Plant(int x, int y, int type){
		this.setX(x);
		this.setY(y);
		this.type = type;
		switch(type){
		case 0:
			hitBox = new Rectangle (x, y, 35, 40);
			break;
		case 1:
			hitBox = new Rectangle (x, y, 70, 26);
			break;
		case 2:
			hitBox = new Rectangle (x, y, 54, 28);
			break;
		}
		
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
		switch(type){
		case 0:
			batch.draw(atlas.findRegion("grass"),getX(), getY());
			break;
		case 1:
			batch.draw(atlas.findRegion("bush"),getX(), getY());
			break;
		case 2:
			batch.draw(atlas.findRegion("alien_plant"),getX(), getY());
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
		return hitBox;
	}

	@Override
	public int hitAction(int side) {
		// TODO Auto-generated method stub
		return 0;
	}}
