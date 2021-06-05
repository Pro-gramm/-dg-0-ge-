package com.game.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.game.user.Trail;
import com.tutorial.main.Game;
import com.tutorial.main.GameObject;
import com.tutorial.main.Handler;
import com.tutorial.main.ID;

public class Boss1Bullet extends GameObject {
	
	private Handler handler;
	Random r = new Random();

	public Boss1Bullet(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velx = r.nextInt((5 - -5) + -5);
		vely = 5;
	
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	public void tick() {
		x += velx;
		y += vely;
		
		//if(y <= 0 || y >= Game.HEIGHT - 32) vely *= -1;
		//if(x <= 0 || x >= Game.WIDTH - 16) velx *= -1;
		
		if(y >= Game.HEIGHT) handler.removeObject(this);
		
		if(y<= Game.HEIGHT/2) {
			handler.addObject(new Trail(x, y, ID.Trail, Color.green, 16, 16, 0.03f, handler));
			}
			else {
				
				handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 16, 16, 0.03f, handler));
				handler.addObject(new Trail(x, y, ID.Trail, Color.yellow, 16, 16, 0.03f, handler));
			
			}
			
	}
	public void render(Graphics g) {
		g.setColor(Color.green);
        g.fillRect((int)x, (int)y, 16, 16 );
	}
}
