package com.game.enemies;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
//import java.awt.image.BufferedImage;

import com.game.user.Trail;
import com.tutorial.main.Game;
import com.tutorial.main.GameObject;
import com.tutorial.main.Handler;
import com.tutorial.main.ID;

public class MegaMinion extends GameObject {
	
	private Handler handler;
	
	//private BufferedImage enemy_image;

	public MegaMinion(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velx = 7;
		vely = 7;
		
		//SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
	      // enemy_image = ss.grabImage(2, 4, 8, 8);
	
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 12, 12);
	}
	public void tick() {
		x += velx;
		y += vely;
		
		if(y <= 0 || y >= Game.HEIGHT - 60) vely *= -1;
		if(x <= 0 || x >= Game.WIDTH - 60) velx *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 12, 12, 0.06f, handler));
		
	}
	public void render(Graphics g) {
	    g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 12, 12 );
		//g.drawImage(enemy_image, (int)x, (int)y, null);
	}
}
