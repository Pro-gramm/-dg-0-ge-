package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected float x, y;
	protected ID id;
	protected float velx, vely;
	
	
	public GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public void setx(float x) {
		this.x = x;
	}	
	public void sety(float y) {
		this.y = y;
	}
	public float getx() {
		return x;
	}
	public float gety() {
		return y;
	}
	public void setId(ID id) {
		this.id = id;
	}
	public ID getId() {
		return id;
	}
	public void setVelx(int velx) {
		this.velx = velx;
	}
	public void setVely(int vely) {
		this.vely = vely;
	}
	public float getVelx() {
		return velx;
	}
	public float getVely() {
		return vely;
	}
}
