package com.runner.planets.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.runner.planets.BasePlanetListener;

public class Runner extends GameObject{
	private Rectangle bottom, left, right, top, full;
	private float velocityY;
	private String image;
	private int count;
	private boolean isWalk;
	private boolean pause;

	public Runner(float x, float y) {
		this.setX(x);
		this.setY(y);
		full =   new Rectangle(512.0f, 71.0f, 75f, 96f);//Rectangle(512.0f, 71.0f, 75f, 96f)//Rectangle(   x,    y, 75f, 96f)
		bottom = new Rectangle(512.0f, 71.0f, 75f, 10f);//Rectangle(512.0f, 71.0f, 75f, 12f)//Rectangle(   x,    y, 75f, 10f)
		left =   new Rectangle(512.0f, 81.0f, 37f, 76f);//Rectangle(512.0f, 83.0f, 37f, 72f)//Rectangle(   x, y+10, 37f, 76f)
		right =  new Rectangle(549.0f, 81.0f, 38f, 76f);//Rectangle(549.0f, 83.0f, 38f, 72f)//Rectangle(x+37, y+10, 38f, 76f)
		top =    new Rectangle(512.0f,157.0f, 75f, 10f);//Rectangle(512.0f,156.0f, 75f, 12f)//Rectangle(   x, y+86, 75f, 10f)
		velocityY = 0;
		count = 1;
		image = "walk010";
		isWalk = true;
		pause = false;
	}
	
	public void draw(SpriteBatch batch, TextureAtlas atlas){
		full.x = this.getX();
		full.y = this.getY();
		
		bottom.x = this.getX();
		bottom.y = this.getY();
		
		left.x = this.getX();
		left.y = this.getY()+12;
		
		right.x = this.getX()+37;
		right.y = this.getY()+12;
		 
		top.x = this.getX();
		top.y = this.getY()+84;
		
		if(!pause) 
			setSprite();
		else{
			image = "jump";
		}
		batch.draw(atlas.findRegion(image),this.getX(), this.getY());
		count++;
	}
	
	public int hits(Rectangle r){
		if (right.overlaps(r)) {
			return 3;
		}
		
		if(bottom.overlaps(r)) {
			//isWalk = true;
			return 1;
		}
		
		if (top.overlaps(r)) {
			return 4;
		}

		return -1;
	}
	
	public void action (int type, float x, float y){
		if (type == 1 || type == 4) {
			if(!isWalk){
				count = 0;
				isWalk = true;
			}
			velocityY = 0;
			this.setX(full.x);
			this.setY(y);
		}
		
		if (type == 2) {
			velocityY = 0;
			this.setX(x);
			this.setY(full.y);
		}
	}
	
	public void update(float delta){
		if (delta > .2) delta = 0.05f;
		velocityY -= 1000 * delta;
		this.setY(full.y + (velocityY*delta));
	}
	
	public void moveRight(float delta){
		full.x += (250*delta);
		this.setX(full.x);
	}
	
	public void jump(BasePlanetListener listener){
		if (velocityY == 0) {
			count = 100;
			image = "jump";
			isWalk = false;
			listener.playSoundJump();
			velocityY = 600;
		}
	}

	@Override
	public Rectangle getHitBox() {
		return full;
	}
	
	public void setPause(boolean pause){
		this.pause = pause;
		if(!pause)
			count = 0;
		else
			count = 100;
	}

	@Override
	public int hitAction(int side) {
		return 0;
	}
	
	public void setSprite(){
		if(count >= 1 && count <=5){
			image = "walk010";
		}else if(count >= 6 && count <= 10){
			image = "walk012";
		}else if(count >=11 && count <= 15){
			image = "walk013";
		}else if(count >=16 && count <= 20){
			image = "walk014";
		}else if(count >=21 && count <= 25){
			image = "walk015";
		}else if(count >=26 && count <= 30){
			image = "walk016";
		}else if(count >=31 && count <= 35){
			image = "walk017";
		}else if(count >=36 && count <= 40){
			image = "walk018";
		}else if(count >=41 && count <= 45){
			image = "walk019";
		}else if(count >=46 && count <= 50){
			image = "walk020";
			count = 0;
		}
	}
	
	public void reastart(int x, int y){
		this.setX(x);
		this.setY(y);
		
		full.x = this.getX();
		full.y = this.getY();
		
		bottom.x = this.getX();
		bottom.y = this.getY();
		
		left.x = this.getX();
		left.y = this.getY()+12;
		
		right.x = this.getX()+37;
		right.y = this.getY()+12;
		 
		top.x = this.getX();
		top.y = this.getY()+84;
	}
}
