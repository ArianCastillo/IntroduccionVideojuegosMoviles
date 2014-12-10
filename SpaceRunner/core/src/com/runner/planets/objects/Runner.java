package com.runner.planets.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.runner.RunnerGame;

public class Runner extends GameObject{
	private Rectangle bottom, left, right, top, full;
	private float velocityY;
	private String image;
	private boolean isJump;

	public Runner(int x, int y) {
		this.setX(x);
		Gdx.app.log(RunnerGame.LOG, "Ahora X vale " + x);
		this.setY(y);
		Gdx.app.log(RunnerGame.LOG, "Ahora Y vale " + y);
		full =   new Rectangle(512.0f, 71.0f, 75f, 96f);
		bottom = new Rectangle(512.0f, 71.0f, 75f, 12f);
		left =   new Rectangle(512.0f, 83.0f, 37f, 72f);
		right =  new Rectangle(549.0f, 83.0f, 38f, 72f);
		top =    new Rectangle(512.0f,156.0f, 75f, 12f);
		velocityY = 0;
		image = "walk010";
		isJump = false;
	}
	
	public void draw(SpriteBatch batch, TextureAtlas atlas){
		full.x = this.getX();
		full.y = this.getY();
		Gdx.app.log(RunnerGame.LOG, "Coordenadas de astronauta: Sprite:" + getX() + ", " + getY() + "Full: " + full.x + ", " + full.y + " al dibujar");
		
		bottom.x = this.getX();
		bottom.y = this.getY();
		
		left.x = this.getX();
		left.y = this.getY()+12;
		
		right.x = this.getX()+37;
		right.y = this.getY()+12;
		 
		top.x = this.getX();
		top.y = this.getY()+84;
		
		batch.draw(atlas.findRegion(image),getX(), getY());
	}
	
	public int hits(Rectangle r){
//		if (left.overlaps(r)) {
//			Gdx.app.log(RunnerGame.LOG, "Coordenadas del rectangle: " + r.getX() + ", " + r.getY() + ". De dimensiones: alto " + r.height + " ancho" + r.width);
//			Gdx.app.log(RunnerGame.LOG, "Choque a la izquiera");
//			Gdx.app.log(RunnerGame.LOG, "Coordenadas de astronauta:" + getX() + ", " + getY() + " en el choque");
//			return 2;
//		}
		if (right.overlaps(r)) {
			Gdx.app.log(RunnerGame.LOG, "CHOQUE A LA DERECHA");
			Gdx.app.log(RunnerGame.LOG, "Coordenadas del rectangle: " + r.getX() + ", " + r.getY() + ". De dimensiones: alto " + r.height + " ancho" + r.width);
			Gdx.app.log(RunnerGame.LOG, "Coordenadas de astronauta: Sprite:" + getX() + ", " + getY() + "Full: " + full.x + ", " + full.y + " en el choque");
			return 3;
		}
		
		if(bottom.overlaps(r)) {
			Gdx.app.log(RunnerGame.LOG, "CHOQUE ABAJO");
			Gdx.app.log(RunnerGame.LOG, "Coordenadas del rectangle: " + r.getX() + ", " + r.getY() + ". De dimensiones: alto " + r.height + " ancho" + r.width);
			Gdx.app.log(RunnerGame.LOG, "Coordenadas de astronauta: Sprite:" + getX() + ", " + getY() + "Full: " + full.x + ", " + full.y + " en el choque");
			isJump = false;
			return 1;
		}
		
		if (top.overlaps(r)) {
			Gdx.app.log(RunnerGame.LOG, "CHOQUE ARRIBA");
			Gdx.app.log(RunnerGame.LOG, "Coordenadas del rectangle: " + r.getX() + ", " + r.getY() + ". De dimensiones: alto " + r.height + " ancho" + r.width);
			Gdx.app.log(RunnerGame.LOG, "Coordenadas de astronauta: Sprite:" + getX() + ", " + getY() + "Full: " + full.x + ", " + full.y + " en el choque");
			return 4;
		}

		return -1;
	}
	
	public void action (int type, float x, float y){
		if (type == 1 || type == 4) {
			//if(type == 1) {
				//isJump = false;
				velocityY = 0;
			//}
			Gdx.app.log(RunnerGame.LOG, "TOMANDO ACCION POR CHOQUE ARRIBA-ABAJO");
			Gdx.app.log(RunnerGame.LOG, "Coordenadas de astronauta: Sprite:" + getX() + ", " + getY() + "Full: " + full.x + ", " + full.y + " tocando arriba o abajo");
			Gdx.app.log(RunnerGame.LOG, "Tocando arriba o abajo");
			Gdx.app.log(RunnerGame.LOG, "X valia " + getX() + " antes de tocar arriba o abajo");
			this.setX(full.x);
			Gdx.app.log(RunnerGame.LOG, "Ahora X vale " + getX() + " despues de tocar arriba o abajo");
			Gdx.app.log(RunnerGame.LOG, "Y valia " + getY() + " antes de tocar arriba o abajo");
			this.setY(y);
			Gdx.app.log(RunnerGame.LOG, "Ahora Y vale " + getY() + " despues de tocar arriba o abajo");
			image = "walk010";
			Gdx.app.log(RunnerGame.LOG, "Coordenadas de astronauta: Sprite:" + getX() + ", " + getY() + "Full: " + full.x + ", " + full.y + " tocando arriba o abajo");
		}
		
		if (type == 2) {
			Gdx.app.log(RunnerGame.LOG, "TOMANDO ACCION POR CHOQUE DER");
			Gdx.app.log(RunnerGame.LOG, "Coordenadas de astronauta: Sprite:" + getX() + ", " + getY() + "Full: " + full.x + ", " + full.y + " tocando izq o der");
			Gdx.app.log(RunnerGame.LOG, "Tocando izquierda o derecha");
			velocityY = 0;
			Gdx.app.log(RunnerGame.LOG, "X valia " + getX() + " antes de tocar der");
			this.setX(x);
			Gdx.app.log(RunnerGame.LOG, "Ahora X vale " + getX() + " despues de tocar der");
			Gdx.app.log(RunnerGame.LOG, "Y valia " + getY() + " antes de tocar der");
			this.setY(full.y);
			Gdx.app.log(RunnerGame.LOG, "Ahora Y vale " + getY() + " despues de tocar der");
			image = "walk010";
			Gdx.app.log(RunnerGame.LOG, "Coordenadas de astronauta: Sprite:" + getX() + ", " + getY() + "Full: " + full.x + ", " + full.y + " tocando izq o der");
		}
	}
	
	public void update(float delta){
		Gdx.app.log(RunnerGame.LOG, "ACTUALIZANDO");
		Gdx.app.log(RunnerGame.LOG, "Coordenadas de astronauta: Sprite:" + getX() + ", " + getY() + "Full: " + full.x + ", " + full.y + " actualizando");
		if (delta > .2) delta = 0.05f;
		velocityY -= 1000 * delta;
		if(isJump){
			Gdx.app.log(RunnerGame.LOG, "X valia " + getX() + " antes de actualizar");
			//this.setX(full.x);
			Gdx.app.log(RunnerGame.LOG, "Ahora X vale " + getX() + " despues de actualizar");
			Gdx.app.log(RunnerGame.LOG, "Y valia " + getY() + " antes de actualizar");
			//this.setY(full.y + (velocityY*delta));
			Gdx.app.log(RunnerGame.LOG, "Ahora Y vale " + getY() + " despues de actualizar");
		}
		Gdx.app.log(RunnerGame.LOG, "Coordenadas de astronauta: Sprite:" + getX() + ", " + getY() + "Full: " + full.x + ", " + full.y + " actualizando");
	}
	
//	public void moveLeft(float delta){
//		Gdx.app.log(RunnerGame.LOG, "Retrocediendo");
//		bottom.x -= (100*delta);
//		Gdx.app.log(RunnerGame.LOG, "X valia " + getX() + " antes de ir izq");
//		this.setX(bottom.x);
//		Gdx.app.log(RunnerGame.LOG, "Ahora X vale " + getX() + " despues de ir a la izq");
//		Gdx.app.log(RunnerGame.LOG, "Y valia " + getY() + " antes de ir izq");
//		this.setY(bottom.y);
//		Gdx.app.log(RunnerGame.LOG, "Ahora Y vale " + getY() + " despues de ir a la izq");
//	}
	
	public void moveRight(float delta){
		Gdx.app.log(RunnerGame.LOG, "CAMINANDO");
		Gdx.app.log(RunnerGame.LOG, "Coordenadas de astronauta: Sprite:" + getX() + ", " + getY() + "Full: " + full.x + ", " + full.y + " moviendose a la der");
		bottom.x += (50*delta);
		Gdx.app.log(RunnerGame.LOG, "X valia " + getX() + " antes de ir der");
		this.setX(bottom.x);
		Gdx.app.log(RunnerGame.LOG, "Ahora X vale " + getX() + " despues de ir a la der");
		Gdx.app.log(RunnerGame.LOG, "Y valia " + getY() + " antes de ir der");
		this.setY(bottom.y);
		Gdx.app.log(RunnerGame.LOG, "Ahora Y vale " + getY() + " despues de ir a la der");
		Gdx.app.log(RunnerGame.LOG, "Coordenadas de astronauta: Sprite:" + getX() + ", " + getY() + "Full: " + full.x + ", " + full.y + " moviendose a la der");
	}
	
	public void jump(){
		if (velocityY == 0) {
			Gdx.app.log(RunnerGame.LOG, "BRINCANDO");
			isJump = true;
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
