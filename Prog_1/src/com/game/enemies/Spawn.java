package com.game.enemies;

import java.util.Random;

import com.game.user.HUD;
import com.tutorial.main.Game;
import com.tutorial.main.Handler;
import com.tutorial.main.ID;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Game game;
	private Random r = new Random();
	
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud, Game game) {
		this.handler = handler;
		this.hud = hud;
		this.game = game;
	}
	
	public void tick() {
		scoreKeep++;
		
		if(scoreKeep >= 100) {
			scoreKeep = 0;
			hud.setLevel((int) (hud.getLevel() + 1));
			
			if(game.diff == 0)
			{
				hud.setCoins((int) (hud.getCoins() + 1));
				if(hud.getLevel() == 2) {
					   handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
				}else if(hud.getLevel() == 3) { 
					    handler.addObject(new Minion(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.Minion, handler));
					}else if(hud.getLevel() == 4) {
					    handler.addObject(new LightninEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.LightninEnemy,handler));
					    handler.addObject(new Minion(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.Minion, handler));
				    }else if(hud.getLevel() == 5) {
			            handler.addObject(new Heatseeker(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.Heatseeker,handler));
		            }
					else if(hud.getLevel() == 7) {
			            handler.addObject(new LightninEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.LightninEnemy,handler));
		            }else if(hud.getLevel() == 8) {
		        		handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy,handler)); 
	                }else if(hud.getLevel() == 10) {
	                	handler.clearEnemies();
	            		handler.addObject(new Boss1(r.nextInt(Game.WIDTH/2) - 20, -120, ID.Boss1,handler));
	                }
			    } else if(game.diff == 1)
				    {
			    	hud.setCoins((int) (hud.getCoins() + 3));
					if(hud.getLevel() == 2) {
						   handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.HardEnemy, handler));
						   handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.HardEnemy, handler));
					}else if(hud.getLevel() == 3) { 
						    handler.addObject(new MegaMinion(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.Minion, handler));
						    handler.addObject(new MegaMinion(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.Minion, handler));
					}else if(hud.getLevel() == 4) {
						    handler.addObject(new RandomFastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.RandomFastEnemy,handler));
						    handler.addObject(new MegaMinion(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.Minion, handler));
				    }else if(hud.getLevel() == 5) {
				    	    handler.addObject(new RandomFastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.RandomFastEnemy,handler));   
				    	    handler.addObject(new FastHeatseeker(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastHeatSeeker,handler));
				            handler.addObject(new FastHeatseeker(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastHeatSeeker,handler));
			        }
					else if(hud.getLevel() == 7) {
           		            handler.addObject(new RandomFastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.RandomFastEnemy,handler));
		            }else if(hud.getLevel() == 8) {
			        		handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.HardEnemy,handler)); 
	                }else if(hud.getLevel() == 10) {
		                	handler.clearEnemies();
		            		handler.addObject(new MegaBoss1(r.nextInt(Game.WIDTH/2) - 10, -190, ID.MegaBoss1,handler));
		                }
				    }
		}
	}
}  




