package com.game.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.game.enemies.BasicEnemy;
import com.game.enemies.HardEnemy;
import com.tutorial.main.AudioPlayer;
import com.tutorial.main.Game;
import com.tutorial.main.Handler;
import com.tutorial.main.ID;
import com.tutorial.main.Game.STATE;

public class Menu extends MouseAdapter {

	 private Game game;
	 private Handler handler;
	 private HUD hud;
	 private Random r= new Random();
	 private Color col5 = new Color( r.nextInt(230), r.nextInt(230),r.nextInt(230));
	 private Color col6 = new Color( r.nextInt(230), r.nextInt(230),r.nextInt(230));
	 private Color col7 = new Color( r.nextInt(230), r.nextInt(230),r.nextInt(230));
	 
	 public int C1 = 0;
	
	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.hud = hud;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(Game.gameState == STATE.Menu) {
			//play button
			if(mouseOver(mx, my, 221, 220, 200, 64)) {
			    Game.gameState = STATE.Select;
			 
			AudioPlayer.getSound("menu_Sound").play();
			return;
			
			}
			
			//help button
			if(mouseOver(mx, my, 20, 110, 170, 54)) {
				Game.gameState = STATE.Help;
				AudioPlayer.getSound("menu_Sound").play();
			}
			
			
			//quit button
			if(mouseOver(mx, my, 442, 110, 170, 54)) {
				System.exit(1);
				
			}
			//Customize button
			if(mouseOver(mx, my, 211, 310, 220, 54)) {
				Game.gameState = STATE.Customize;
				AudioPlayer.getSound("menu_Sound").play();
			}
		}
		//Customization Options
		if(mouseOver(mx, my, 30, 90, 170, 100)) {
			if(hud.getCoins() >= C1) {
				hud.setCoins((int) (hud.getCoins() - C1));
				//Player.player_image = 
				SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
			Player.player_image = ss.grabImage(1, 1, 32, 32);
			AudioPlayer.getSound("menu_Sound").play();
			return;
			}
		}
		
		if(Game.gameState == STATE.Select) {
			//normal button
			if(mouseOver(mx, my, 210, 150, 200, 64)) {
				Game.gameState = STATE.Game; 
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemies();
			    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
			 
			    game.diff = 0;
			    
			  AudioPlayer.getMusic("Music3").loop();
			  AudioPlayer.getSound("menu_Sound").play();
			
			}
			
			//hard button
			if(mouseOver(mx, my, 210, 250, 200, 64)) {
				Game.gameState = STATE.Game; 
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemies();
			    handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.HardEnemy, handler));
			 
			    game.diff = 1;
			    
			    AudioPlayer.getMusic("Music1").loop();
			    AudioPlayer.getSound("menu_Sound").play();
			}
			
			//back button
			if(mouseOver(mx, my, 210, 350, 200, 64)) {
				Game.gameState = STATE.Menu;
				AudioPlayer.getSound("menu_Sound").play();
				return;
				
			}
		}
		
		//back button for help
		    if(Game.gameState == STATE.Help) {
			if(mouseOver(mx, my, 45, 350, 200, 64)) {
			Game.gameState = STATE.Menu;
			AudioPlayer.getSound("menu_Sound").play();
			for(int i = 0; i < 20; i++) {
	    		handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.MenuParticle, handler));
			}
			return;
			}
		}
		    
	    //next button for help2
		    if(Game.gameState == STATE.Help) {
			if(mouseOver(mx, my, 350, 350, 240, 64)) {
			Game.gameState = STATE.Help2;
			AudioPlayer.getSound("menu_Sound").play();
			return;
			}
		}
		 
		 //back button for help2
		    if(Game.gameState == STATE.Help2) {
			if(mouseOver(mx, my, 45, 350, 200, 64)) {
			Game.gameState = STATE.Help;
			AudioPlayer.getSound("menu_Sound").play();
			return;
			}
		}
		    
	    //back button for customize
	    if(Game.gameState == STATE.Customize) {
	    	if(mouseOver(mx, my, 30, 90, 170, 100)) {
				Game.gameState = STATE.Bought;
	    		if(hud.getCoins() >= C1) {
					hud.setCoins((int) (hud.getCoins() - C1));
	    		//Player.player_image = 
	    		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
				Player.player_image = ss.grabImage(1, 1, 32, 32);
				AudioPlayer.getSound("menu_Sound").play();
				return;
				}
		    }
		}	
		    	
		    	
		    	
		    	if(mouseOver(mx, my, 210, 350, 200, 64)) {
			Game.gameState = STATE.Menu;
			AudioPlayer.getSound("menu_Sound").play();
			for(int i = 0; i < 20; i++) {
	    		handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.MenuParticle, handler));
			}
			return;
		}

			//Back To Menu
			  if(Game.gameState == STATE.End) {
		      if(mouseOver(mx, my, 180, 350, 280, 64)) {
			  Game.gameState = STATE.Menu;
			  hud.setLevel(1);
			  hud.setScore(0);
			  HUD.HEALTH = 100;
			  AudioPlayer.getMusic("Music2").loop();
			  AudioPlayer.getSound("menu_Sound").play();
			  return;
			}
	    }
    }
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}	
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		if(Game.gameState == STATE.Menu ) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 38);
			Font fnt3 = new Font("arial", 1, 20);
			
			g.setFont(fnt);
			g.setColor(col5);
			g.drawString(" dD   Ge ", 215, 70);
			g.setColor(col6);
			g.drawString("|            |", 220, 70);
			g.setColor(col7);
			g.drawString("    0    ", 247, 70);
			
			g.setFont(fnt2);
			g.setColor(Color.green);
			g.drawRect(221, 220, 200, 64);
			g.drawString(">> Play",259, 263); 
			
			g.setFont(fnt2);
			g.setColor(Color.yellow);
			g.drawRect(20, 110, 170, 54);
			g.drawString("? Help", 45, 150);
			
			g.setFont(fnt2);
			g.setColor(Color.red);
			g.drawRect(442, 110, 170, 54);
			g.drawString("X Quit", 469, 150);
			
			g.setFont(fnt2);
			g.setColor(Color.cyan);
			g.drawRect(211, 310, 220, 54);
			g.drawString("Customize", 225, 350);
			
			g.setFont(fnt3);
			g.drawString("Coins:" + hud.getCoins(), 215, 390);
		
		
			
		}else if(Game.gameState == STATE.Help) {
			handler.clearEnemies2();
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 38);
			Font fnt3 = new Font("arial", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.yellow);
			g.drawString("Help", 240, 60);
			
			g.setFont(fnt3);
			g.setColor(Color.cyan);
			g.drawString("1) Use W(Up), S(Down), A(Left), D(Right) to move Your Player", 10, 95);
			g.drawString("and dodge enemies.", 10, 120);
			g.drawString("2) Every 10 levels, you will have a boss fight, in which you have", 10, 140);
			g.drawString("to survive for 2 levels, do not come in contact with the boss as if", 10, 160);
			g.drawString("you do so, you will die.", 10, 180);
			g.drawString("3) Don't let the heatseeker(yellow, white), spawning at level 5", 10, 205);
			g.drawString("touch you!!! It will drain your health very quickly if it does", 10, 225);
			g.drawString("come in contact!! ", 10, 245);
			g.drawString("4) Use Shop to do various improvements to your player, main", 10, 265);
			g.drawString(" being refilling health bar and buying shields when possible.", 10, 285);
			g.drawString("5) Hard level setting will have a lot of surprises. Make sure", 10, 305);
			g.drawString("you are ready!!", 10, 325);
			
			g.setFont(fnt2);
			g.setColor(Color.yellow);
			g.drawRect(45, 350, 200, 64);
			g.drawString("<<Back", 62, 395);
			
			g.setFont(fnt2);
			g.setColor(Color.blue);
			g.drawRect(350, 350, 240, 64);
			g.drawString("Next Page>>", 362, 395);
		}
		else if(Game.gameState == STATE.Help2) {
			handler.clearEnemies2();
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 38);
			Font fnt3 = new Font("arial", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.yellow);
			g.drawString("Help (Pg 2)", 190, 60);
			
			g.setFont(fnt3);
			g.setColor(Color.green);
			g.drawString("6) All the bosses have one weakness or the other, you just have", 10, 95);
		    g.drawString(" to find them!!", 10, 115);
			
			g.setFont(fnt2);
			g.setColor(Color.yellow);
			g.drawRect(45, 350, 200, 64);
			g.drawString("<<Back", 62, 395);
		}
		else if(Game.gameState == STATE.End) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 38);
			Font fnt3 = new Font("arial", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.red);
			g.drawString("{GAME OVER}", 157, 70);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("You Lost with a Score of:" + hud.getScore(), 170, 200);
			g.drawString("Coins Collected:" + hud.getCoins(), 170, 250);
			
			g.setFont(fnt2);
			g.setColor(Color.blue);
			g.drawRect(180, 350, 280, 64);
			g.drawString("Back To Menu", 197, 395);
		}else if(Game.gameState == STATE.Select ) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 38);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("SELECT DIFFICULTY", 80, 70);
			
			g.setFont(fnt2);
			g.setColor(Color.blue);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Normal", 245, 190);
			
			g.setFont(fnt2);
			g.setColor(Color.red);
			g.drawRect(210, 250, 200, 64);
			g.drawString("Hard", 266, 290);
			
			g.setFont(fnt2);
			g.setColor(Color.yellow);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 266, 390);
		}else if (Game.gameState == STATE.Customize) {
			handler.clearEnemies2();
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 38);
			Font fnt3 = new Font("arial", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.yellow);
			g.drawString("Customize", 180, 50);
			
			g.setFont(fnt3);
			g.setColor(col5);
		    g.drawString(" Da Serious SKIN", 40, 160);
		    g.setColor(Color.white);
		    g.drawString("[BASIC]", 45, 180);
		    g.drawString("Cost:" + C1 , 125, 180);
			g.setColor(Color.white);
			g.drawRect(30, 90, 190, 100);
			
			g.setFont(fnt3);
			g.drawString("Coins:" + hud.getCoins(), 5, 70);
			
			g.setFont(fnt2);
			g.setColor(Color.yellow);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 262, 395);
		}
	}
}
