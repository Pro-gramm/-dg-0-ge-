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

public class BasicEnemy extends GameObject {
	
	private Handler handler;
	
	//private BufferedImage enemy_image;

	public BasicEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velx = 5;
		vely = 5;
		
		//SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		//enemy_image = ss.grabImage(1, 2, 16, 16);
	
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	public void tick() {
		x += velx;
		y += vely;
		
		if(y <= 0 || y >= Game.HEIGHT - 32) vely *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velx *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.03f, handler));
		
	}
	public void render(Graphics g) {
	   g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 16, 16 );
		//g.drawImage(enemy_image, (int)x, (int)y, null);
	}
}
