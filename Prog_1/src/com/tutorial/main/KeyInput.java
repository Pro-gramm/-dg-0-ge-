package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import com.game.user.MenuParticle;
import com.tutorial.main.Game.STATE;

public class KeyInput extends KeyAdapter{

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	private Handler handler;
	Random r = new Random();
	private boolean[] keyDown = new boolean[4];
	
	Game game;
	
	public KeyInput(Handler handler, Game game) {
		this.handler = handler;
		
		this.game = game;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}
	
	public void keyPressed(KeyEvent e) {
		float key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				
				if(key == KeyEvent.VK_W) { tempObject.setVely(-handler.speed); keyDown[0] = true;}
				if(key == KeyEvent.VK_S) { tempObject.setVely(handler.speed);  keyDown[1] = true;}
				if(key == KeyEvent.VK_D) { tempObject.setVelx(handler.speed);  keyDown[2] = true;}
				if(key == KeyEvent.VK_A) { tempObject.setVelx(-handler.speed); keyDown[3] = true;} 
			}
			
		}
		
		if(key == KeyEvent.VK_P) 
		{
			if(Game.gameState == STATE.Game)
			{
				if(Game.paused) Game.paused = false;
				else Game.paused = true;
			}
		
		}
		if(key == KeyEvent.VK_ESCAPE) { 
			if(Game.gameState == STATE.Game) {
			Game.gameState = STATE.End;
			handler.clearEnemies2();
			for(int i = 0; i < 20; i++) {
	    		handler.addObject(new MenuParticle(r.nextInt(WIDTH),r.nextInt(HEIGHT), ID.MenuParticle, handler));
	    	}
		}
	}
		
		if(key == KeyEvent.VK_SPACE) {
			if(Game.gameState == STATE.Game) Game.gameState = STATE.Shop;
			else if(Game.gameState == STATE.Shop) Game.gameState = STATE.Game;
		}
   }
	
	public void keyReleased(KeyEvent e) {
		float key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {			
				
				if(key == KeyEvent.VK_W) keyDown[0] = false;
				if(key == KeyEvent.VK_S) keyDown[1] = false;
				if(key == KeyEvent.VK_D) keyDown[2] = false;
				if(key == KeyEvent.VK_A) keyDown[3] = false;
			
				if(!keyDown[0] && !keyDown[1]) tempObject.setVely(0);
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelx(0);
			}

		}
		
	}
}
	

