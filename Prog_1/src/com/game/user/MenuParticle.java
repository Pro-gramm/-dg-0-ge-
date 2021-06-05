package com.game.user;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.tutorial.main.Game;
import com.tutorial.main.GameObject;
import com.tutorial.main.Handler;
import com.tutorial.main.ID;

public class MenuParticle extends GameObject {
	
	private Handler handler;
	
	Random r = new Random();
	
    private Color col;
	
    public MenuParticle(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velx = r.nextInt((7 - -7) + -7);
		vely = r.nextInt((7 - -7) + -7);
		if(velx == 0) velx = 1;
		if(vely == 0) vely = 1;
		
		col = new Color( r.nextInt(255), r.nextInt(255), r.nextInt(255));
		
    }
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	public void tick() {
		x += velx;
		y += vely;
		
		if(y <= 0 || y >= Game.HEIGHT - 32) vely *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velx *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, col, 16, 16, 0.03f, handler));
		
	}
	public void render(Graphics g) {
		g.setColor(col);
        g.fillRect((int)x, (int)y, 16, 16 );
	}
}
