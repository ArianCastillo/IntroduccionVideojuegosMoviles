package com.runner.planets.objects.danger;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.runner.planets.objects.GameObject;

public class DangerGround extends GameObject{
	private Rectangle hitBox;
	private int type;

	public DangerGround(int x, int y, int type){
		this.setX(x);
		this.setY(y);
		this.type = type;
		hitBox = new Rectangle (x, y, 70, 45);
	}
	
	@Override
	public int hits(Rectangle r) {
		return -1;
	}

	@Override
	public void draw(SpriteBatch batch, TextureAtlas atlas) {
		hitBox.x = getX();
		hitBox.y = getY();
		switch(type){
		case 0:
			batch.draw(atlas.findRegion("water"),getX(), getY());
			break;
		case 1:
			batch.draw(atlas.findRegion("lava"),getX(), getY());
			break;
		default:
			batch.draw(atlas.findRegion("water"),getX(), getY());
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
		return hitBox;
	}

	@Override
	public int hitAction(int side) {
		if(side == 1) return 2;
		return 1;
	}
}
