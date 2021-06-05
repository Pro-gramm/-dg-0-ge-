package com.game.user;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.tutorial.main.Game;
import com.tutorial.main.Game.STATE;
import com.tutorial.main.GameObject;
import com.tutorial.main.Handler;
import com.tutorial.main.ID;

public class Player extends GameObject{

	Random r = new Random();
	Handler handler;
	
	public static BufferedImage player_image;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler= handler; 
		if(Game.gameState == STATE.Bought){
			  
		}else player_image = null;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	

	public void tick() {
		x += velx;
		y += vely;
		
		x = Game.clamp(x, 0, Game.WIDTH - 50);
		y = Game.clamp(y, 0, Game.HEIGHT - 68);
		
		if (player_image == null){
		handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.05f, handler));
		} else handler.removeObject(this);
		
		collision();
		
	}
	
	private void collision(){
		for(int i = 0; i < handler.object.size(); i++) {
			
			
			GameObject tempObject = handler.object.get(i);
			
			if(HUD.SHIELD > 0) {
				 if(tempObject.getId() == ID.BasicEnemy) {
						if(getBounds().intersects(tempObject.getBounds())){
							HUD.SHIELD -= 1;
						}
					}
					if(tempObject.getId() == ID.LightninEnemy) {
						if(getBounds().intersects(tempObject.getBounds())){
							HUD.SHIELD -= 2;
						}
					}
					if(tempObject.getId() == ID.Minion) {
						if(getBounds().intersects(tempObject.getBounds())){
							HUD.SHIELD -= 0.5;
						}
					}
					if(tempObject.getId() == ID.Heatseeker) {
						if(getBounds().intersects(tempObject.getBounds())){
							HUD.SHIELD -= 1;
						}
					}
					if(tempObject.getId() == ID.Boss1) {
						if(getBounds().intersects(tempObject.getBounds())){
							HUD.SHIELD -= 10000;
						}
					}
					if(tempObject.getId() == ID.Boss1Bullet) {
						if(getBounds().intersects(tempObject.getBounds())){
							HUD.SHIELD -= 0.4;
						}
					}
					if(tempObject.getId() == ID.HardEnemy) {
						if(getBounds().intersects(tempObject.getBounds())){
							HUD.SHIELD -= 2;
						}
					}
					if(tempObject.getId() == ID.RandomFastEnemy) {
						if(getBounds().intersects(tempObject.getBounds())){
							HUD.SHIELD-= 3;
						}
					}
					if(tempObject.getId() == ID.MegaMinion) {
						if(getBounds().intersects(tempObject.getBounds())){
							HUD.SHIELD -= 1;
						}
					}
					if(tempObject.getId() == ID.FastHeatSeeker) {
						if(getBounds().intersects(tempObject.getBounds())){
							HUD.SHIELD -= 1.5;
						}
					}
					if(tempObject.getId() == ID.MegaBoss1) {
						if(getBounds().intersects(tempObject.getBounds())){
							HUD.SHIELD -= 100000;
						}
					}
					if(tempObject.getId() == ID.MegaBossBullet) {
						if(getBounds().intersects(tempObject.getBounds())){
							HUD.SHIELD -= 0.8;
						}
					}
				}

		
			else if(HUD.SHIELD == 0) {
			if(tempObject.getId() == ID.BasicEnemy) {
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 1;
				}
			}
			if(tempObject.getId() == ID.LightninEnemy) {
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 2;
				}
			}
			if(tempObject.getId() == ID.Minion) {
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 0.5;
				}
			}
			if(tempObject.getId() == ID.Heatseeker) {
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 1;
				}
			}
			if(tempObject.getId() == ID.Boss1) {
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 10000;
				}
			}
			if(tempObject.getId() == ID.Boss1Bullet) {
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 0.4;
				}
			}
			if(tempObject.getId() == ID.HardEnemy) {
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 2;
				}
			}
			if(tempObject.getId() == ID.RandomFastEnemy) {
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 3;
				}
			}
			if(tempObject.getId() == ID.MegaMinion) {
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 1;
				}
			}
			if(tempObject.getId() == ID.FastHeatSeeker) {
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 1.5;
				}
			}
			if(tempObject.getId() == ID.MegaBoss1) {
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 10000;
				}
			}
			if(tempObject.getId() == ID.MegaBossBullet) {
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 1;
				}
			}
			if(tempObject.getId() == ID.Shrapnel) {
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 0.2;
				}
			}
		}
	}
}


	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		if (player_image == null){
		g.setColor(Color.red);
		g2d.draw(getBounds());
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 32, 32);
		} else {
			handler.removeObject(this);
		g.drawImage(player_image, (int)x, (int)y, null);
	    }
	}
	
	

}
