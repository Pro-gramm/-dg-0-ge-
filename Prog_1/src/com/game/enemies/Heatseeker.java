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

public class Heatseeker extends GameObject {
	
	private Handler handler;
	private GameObject player;
	
	//private BufferedImage enemy_image;

	public Heatseeker(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
        //SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
       //enemy_image = ss.grabImage(1, 4, 16, 16);
		
		for(int i = 0; i < handler.object.size();i++) {
			if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);		
		}
	
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	public void tick() {
		x += velx;
		y += vely;
		
		float diffX = x - player.getx() - 8;
		float diffY = y - player.gety() - 8;
		float distance = (float) Math.sqrt((x-player.gety())*(x-player.gety()) + (y-player.gety())*(y-player.gety()));
		
		velx = (float) ((-1.0/distance) * diffX);
		vely = (float) ((-1.0/distance) * diffY);
		
		if(y <= 0 || y >= Game.HEIGHT - 32) vely *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velx *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.orange, 16, 16, 0.03f, handler));
		
	}
	public void render(Graphics g) {
		g.setColor(Color.orange);
        g.fillRect((int)x, (int)y, 16, 16 );
		// g.drawImage(enemy_image, (int)x, (int)y, null);
	}
}
