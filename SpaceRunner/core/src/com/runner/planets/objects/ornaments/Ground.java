package com.runner.planets.objects.ornaments;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.runner.planets.objects.GameObject;

public class Ground extends GameObject {
	private Rectangle hitBox;
	private int type;

	public Ground(int x, int y, int type){
		this.setX(x);
		this.setY(y);
		this.type = type;
		hitBox = new Rectangle (x, y, 70, 70);
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
			batch.draw(atlas.findRegion("ground"),getX(), getY());
			break;
		case 1:
			batch.draw(atlas.findRegion("ground_cave"),getX(), getY());
			break;
		case 2:
			batch.draw(atlas.findRegion("ground_dirty"),getX(), getY());
			break;
		case 3:
			batch.draw(atlas.findRegion("ground_rock"),getX(), getY());
			break;
		case 4:
			batch.draw(atlas.findRegion("ground_sand"),getX(), getY());
			break;
		default:
			batch.draw(atlas.findRegion("ground_dirty"),getX(), getY());
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
		// TODO Auto-generated method stub
		return 1;
	}

	
}
