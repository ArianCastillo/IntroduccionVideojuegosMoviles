package com.runner.planets.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

public class Runner extends GameObject{
	private Rectangle bottom, left, right, top, full;
	private float velocityY;
	private String image;

	public Runner(int x, int y) {
		this.setX(x);
		this.setY(y);
		full =   new Rectangle(0.0f, 0.0f, 75f, 96f);
		bottom = new Rectangle(0.0f, 0.0f, 75f, 12f);
		left =   new Rectangle(0.0f, 12f, 37f, 72f);
		right =  new Rectangle(37f, 12f, 38f, 72f);
		top =    new Rectangle(0.0f, 84f, 75f, 12f);
		velocityY = 0;
		image = "walk010";
	}
	
	public void draw(SpriteBatch batch, TextureAtlas atlas){
		full.x = getX();
		full.y = getY();
		
		bottom.x = getX();
		bottom.y = getY();
		
		left.x = getX();
		left.y = getY()+12;
		
		right.x = getX()+37;
		right.y = getY()+12;
		 
		top.x = getX();
		top.y = getY()+84;
		
		batch.draw(atlas.findRegion(image),getX(), getY());
	}
	
	public int hits(Rectangle r){
		if (left.overlaps(r)) {
			return 2;
		}
		if (right.overlaps(r)) {
			return 3;
		}
		
		if(bottom.overlaps(r)) {
			return 1;
		}
		
		if (top.overlaps(r)) {
			return 4;
		}

		return -1;
	}
	
	public void action (int type, float x, float y){
		if (type == 1 || type == 4) {
			velocityY = 0;
			this.setX(full.x);
			this.setY(y);
			image = "walk010";
		}
		
		if (type == 2 || type == 3) {
			velocityY = 0;
			this.setX(x);
			this.setY(full.y);
		}
	}
	
	public void update(float delta){
		if (delta > .2) delta = 0.05f;
		velocityY -= 1000 * delta;
		this.setX(full.x);
		this.setY(full.y + (velocityY*delta));
	}
	
	public void moveLeft(float delta){
		bottom.x -= (50*delta);
		this.setX(bottom.x);
		this.setY(bottom.y);
	}
	
	public void moveRight(float delta){
		bottom.x += (50*delta);
		this.setX(bottom.x);
		this.setY(bottom.y);
	}
	
	public void jump(){
		if (velocityY == 0) {
			velocityY = 600;
		}
		image="jump";
	}

	@Override
	public Rectangle getHitBox() {
		return bottom;
	}

	@Override
	public int hitAction(int side) {
		return 0;
	}
}