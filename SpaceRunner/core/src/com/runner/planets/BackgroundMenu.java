package com.runner.planets;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.runner.planets.objects.GameObject;

public class BackgroundMenu extends GameObject{
private Rectangle hitBox;
	
	public BackgroundMenu(int x, int y, int hitBX, int hitBY){
		this.setX(x);
		this.setY(y);
		hitBox = new Rectangle (x, y, hitBX, hitBY);
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
		batch.draw(atlas.findRegion("backMenu"),getX(), getY());
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
	
	public void setHitBoxPosition(float x){
		this.setX(x);
	}

}
