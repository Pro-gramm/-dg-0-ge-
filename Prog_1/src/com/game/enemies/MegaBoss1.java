package com.game.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.game.user.SpriteSheet;
import com.tutorial.main.Game;
import com.tutorial.main.GameObject;
import com.tutorial.main.Handler;
import com.tutorial.main.ID;

public class MegaBoss1 extends GameObject {
	
	private Handler handler;
	Random r = new Random();
	
	private BufferedImage boss_image;
	
	private int timer = 60;
	private int timer2 = 40;

	public MegaBoss1(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velx = 0;
		vely = 3;
		
         SpriteSheet ss = new SpriteSheet(Game.sprite_sheet2);
		
		boss_image = ss.grabImage(1, 1, 96, 96);
	
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 96, 96);
	}
	public void tick() {
		x += velx;
		y += vely;
		
		if(timer <= 0) vely = 0;
		else timer--;
		
		if(timer <= 0) timer2--;
		if(timer2 <= 0) {
			if(velx == 0) velx = 2;
			if(velx > 0) {
			velx  += 0.005f;
			}
			else if(velx < 0) {
			velx  -= 0.005f;
			}
			
			velx = Game.clamp(velx, -13, 13);
			
			int spawn = r.nextInt(5);
			if(spawn == 0) handler.addObject(new MegaBossBullet((int) x + 1, (int) y + 48, ID.MegaBossBullet, handler)); 
		}
		
		//if(y <= 0 || y >= Game.HEIGHT - 32) vely *= -1;
		if(x <= 0 || x >= Game.WIDTH - 96) velx *= -1;
		
		
	}
	public void render(Graphics g) {
		//g.setColor(Color.red);
        //g.fillRect((int)x, (int)y, 115, 115);
        g.drawImage(boss_image, (int)x, (int)y, null);
	}
}
