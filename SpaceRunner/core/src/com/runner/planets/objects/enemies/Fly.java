package com.runner.planets.objects.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.runner.planets.objects.GameObject;

public class Fly extends GameObject{
	private Rectangle hitBox;
	private String image;
	private int count;
	
	public Fly(int x, int y){
		this.setX(x);
		this.setY(y);
		image = "fly_normal";
		count = 1;
		hitBox = new Rectangle(x, y, 96, 32);
	}
	
	@Override
	public int hits(Rectangle r) {
		return -1;
	}

	@Override
	public void draw(SpriteBatch batch, TextureAtlas atlas) {
		hitBox.x = getX();
		hitBox.y = getY();
		setSprite();
		batch.draw(atlas.findRegion(image),getX(), getY());
		count++;
	}

	private void setSprite() {
		if(count >= 1 && count <=5){
			image = "fly_normal";
		}else if(count >= 6 && count <= 10){
			image = "fly_fly";
		}else if(count >=11){
			count = 0;
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
		return 2;
	}
}
