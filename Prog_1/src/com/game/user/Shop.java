package com.game.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.tutorial.main.Handler;

public class Shop extends MouseAdapter {

	Handler handler;
	HUD hud;

	private int B1 = 2000;
	private int B2 = 1000;
	private int B3 = 1000;
	private int B4 = 2000;
	private int B5 = 2000;

	public Shop(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("arial", 0, 48));
		g.drawString("SHOP", 240, 50);

		// box 1
		g.setFont(new Font("arial", 0, 12));
		g.drawString("Upgrade Health", 110, 120);
		g.drawString("Cost:" + B1, 110, 140);
		g.drawRect(100, 100, 100, 50);

		// box 2
		g.drawString("Upgrade Speed", 260, 120);
		g.drawString("Cost:" + B2, 260, 140);
		g.drawRect(250, 100, 100, 50);

		// box 3
		g.drawString("Refill Health", 410, 120);
		g.drawString("Cost:" + B3, 410, 140);
		g.drawRect(400, 100, 100, 50);

		// box 4
		g.drawString("Buy Shield", 105, 185);
		g.drawString("Cost:" + B4, 105, 205);
		g.drawRect(100, 170, 100, 50);
		
		// box 5
		g.drawString("Increase Shield", 255, 185);
		g.drawString("Capacity", 255, 205);
		g.drawString("Cost:" + B5, 255, 225);
		g.drawRect(250, 170, 100, 60);

		g.drawString("SCORE:" + hud.getScore(), 10, 50);
		g.drawString("Press Space To Go Back", 10, 70);
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		// box 1
		if (mx >= 100 && mx <= 200) {
			if (my >= 100 && my <= 150) {
				// you've selected box 1
				if (hud.getScore() >= B1) {
					hud.setScore((int) (hud.getScore() - B1));
					B1 += 1000;
					hud.bounds += 10;
					HUD.HEALTH = (100 + hud.bounds / 2);
				}
			}
		}

		// box 2
		if (mx >= 250 && mx <= 350) {
			if (my >= 100 && my <= 150) {
				// you've selected box 2
				if (hud.getScore() >= B2) {
					hud.setScore((int) (hud.getScore() - B3));
					B2 += 750;
					handler.speed++;

				}
			}
		}

		// box 3
		if (mx >= 400 && mx <= 500) {
			if (my >= 100 && my <= 150) {
				// you've selected box 3
				if (hud.getScore() >= B3) {
					hud.setScore((int) (hud.getScore() - B3));
					hud.bounds += 10;
					HUD.HEALTH = (100 + hud.bounds / 2);
				}
			}
		}
		// box 4
		if (mx >= 100 && mx <= 200) {
			if (my >= 170 && my <= 220) {
				// you've selected box 4
				if (hud.getScore() >= B4) {
					hud.setScore((int) (hud.getScore() - B4));
					HUD.SHIELD = 100;
				}
			}
		}
		// box 5
		if (mx >= 250 && mx <= 350) {
			if (my >= 170 && my <= 230) {
				// you've selected box 5
				if (hud.getScore() >= B5) {
					hud.setScore((int) (hud.getScore() - B5));
					B5 += 1000;
					hud.bounds2 += 10;
					HUD.SHIELD = (100 + hud.bounds2 / 2);
		
				}
			}
		}
	}
}
