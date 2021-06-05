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

public class MegaBossBullet extends GameObject {
	
	private Handler handler;
	Random r = new Random();

	public MegaBossBullet(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velx = r.nextInt((5 - -5) + -5);
		vely = 5;
	
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 26, 26);
	}
	public void tick() {
		x += velx;
		y += vely;
		
		//if(y <= 0 || y >= Game.HEIGHT - 32) vely *= -1;
		//if(x <= 0 || x >= Game.WIDTH - 16) velx *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.yellow, 26, 26, 0.03f, handler));
		
		if(y >= 130) handler.removeObject(this);
		
		if( y >= 130) {
			int spawn = r.nextInt(5);
			if(spawn == 0) 
		    handler.addObject(new Shrapnel((int) x + 5, (int) y + 48, ID.Shrapnel, handler));
			handler.addObject(new Shrapnel((int) x + 5, (int) y + 48, ID.Shrapnel, handler));
			handler.addObject(new Shrapnel((int) x + 5, (int) y + 48, ID.Shrapnel, handler));
			handler.addObject(new Shrapnel((int) x + 5, (int) y + 48, ID.Shrapnel, handler));
			handler.addObject(new Shrapnel((int) x + 5, (int) y + 48, ID.Shrapnel, handler));
			handler.addObject(new Shrapnel((int) x + 5, (int) y + 48, ID.Shrapnel, handler));
			handler.addObject(new Shrapnel((int) x + 5, (int) y + 48, ID.Shrapnel, handler));
			handler.addObject(new Shrapnel((int) x + 5, (int) y + 48, ID.Shrapnel, handler));
			handler.addObject(new Shrapnel((int) x + 5, (int) y + 48, ID.Shrapnel, handler));
			handler.addObject(new Shrapnel((int) x + 5, (int) y + 48, ID.Shrapnel, handler));
		} 
	}
	public void render(Graphics g) {
		g.setColor(Color.yellow);
        g.fillRect((int)x, (int)y, 26, 26 );
	}
}
