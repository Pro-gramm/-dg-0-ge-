package com.game.user;

import java.awt.Color;
import java.awt.Graphics;

import com.tutorial.main.Game;

public class HUD {
	
	public static float SHIELD = 0;
	public int bounds = 0;
	public int bounds2 = 0;
	public static float HEALTH = 100;
	private float greenValue = 255;
   
    private int score = 0;
    private int level = 1;
    public int coins = 0;
	
	public void tick() {
		HEALTH = Game.clamp(HEALTH, 0, 100 +(bounds/2));
		SHIELD = Game.clamp(SHIELD, 0,  100+(bounds2/2));
		greenValue = HEALTH * 2;
		greenValue = Game.clamp(greenValue, 0, 255);
		
		score++;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200 + bounds, 32);
		g.setColor(new Color (75, (int)greenValue, 0));
		g.fillRect(15, 15, (int)(HEALTH * 2), 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200 + bounds, 32);
		
		g.drawString("Score:" + score, 15, 79);
		g.drawString("Level:" + level, 15, 95);
		g.drawString("Coins:" + coins, 15, 110);
		g.drawString("Space for Shop", 15, 164 );
		if(SHIELD > 0) {
			g.setColor(Color.gray);
			g.fillRect(15, 55, 200 + bounds2, 5);
			g.setColor(Color.blue);
			g.fillRect(15, 55, (int)(SHIELD * 2) , 5);
			g.setColor(Color.white);
			g.drawRect(15, 55, 200 + bounds2, 5);
			g.drawString("Shield is Active", 15, 149 );
		}
		else {
			g.setColor(Color.blue);
			g.drawRect(15, 55, 200 + bounds2, 5);
			g.drawString("No Shield", 15, 149 );
		}
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public float getScore() {
		return score;
	}
	
	public float getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	public void setCoins(int coins) {
		this.coins = coins;
	}
	public float getCoins() {
		return coins;
	}
}
