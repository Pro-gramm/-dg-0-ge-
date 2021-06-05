package com.game.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
//import java.awt.image.BufferedImage;
import java.util.Random;

import com.game.user.Trail;
import com.tutorial.main.Game;
import com.tutorial.main.GameObject;
import com.tutorial.main.Handler;
import com.tutorial.main.ID;

public class Shrapnel extends GameObject {
	
	private Handler handler;
	
	private Random r = new Random();
	
	//private BufferedImage enemy_image;

	public Shrapnel(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velx = r.nextInt(5);
		vely = 7;
		
		//SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
	      // enemy_image = ss.grabImage(2, 4, 8, 8);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 4, 4);
	}
	public void tick() {
		x += velx;
		y += vely;
		
		//if(y <= 0 || y >= Game.HEIGHT - 32) vely *= -1;
		//if(x <= 0 || x >= Game.WIDTH - 16) velx *= -1;
		
		if(x <= 0 || y <= 0) handler.removeObject(this);
		if(y >= Game.HEIGHT) handler.removeObject(this);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.yellow, 4, 4, 0.06f, handler));
		
	}
	public void render(Graphics g) {
	    g.setColor(Color.yellow);
        g.fillRect((int)x, (int)y, 4, 4 );
		//g.drawImage(enemy_image, (int)x, (int)y, null);
	}
}
