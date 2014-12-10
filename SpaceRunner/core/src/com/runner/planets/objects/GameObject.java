package com.runner.planets.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class GameObject extends Actor {
	public abstract int hits(Rectangle r);
	public abstract void draw(SpriteBatch batch, TextureAtlas atlas);
	public abstract void action (int type, float x, float y);
	public abstract void update(float delta);
	public abstract Rectangle getHitBox();
	public abstract int hitAction(int side);
}
