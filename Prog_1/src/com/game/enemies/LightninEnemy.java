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

public class LightninEnemy extends GameObject {
	
	private Handler handler;
	
	//private BufferedImage enemy_image;

	public LightninEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velx = 2;
		vely = 10;
		
       // SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		//enemy_image = ss.grabImage(1, 3, 16, 16);
	
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	public void tick() {
		x += velx;
		y += vely;
		
		if(y <= 0 || y >= Game.HEIGHT - 32) vely *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velx *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 16, 16, 0.02f, handler));
		
	}
	public void render(Graphics g) {
		g.setColor(Color.cyan);
        g.fillRect((int)x, (int)y, 16, 16 );
        //g.drawImage(enemy_image, (int)x, (int)y, null);
	}
}
