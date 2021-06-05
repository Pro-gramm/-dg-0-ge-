package com.game.user;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


import com.game.user.Bought;
import com.tutorial.main.Game;
import com.tutorial.main.Game.STATE;

public class Bought extends Canvas implements Runnable{

	private static final long serialVersionUID = 9137275489151360138L;
	public static final int WIDTH = 320, HEIGHT = WIDTH / 12 * 9;
	private static Thread thread;
	private static boolean running = false;
	
	public Bought() {
		
		new Window2(WIDTH, HEIGHT, "Confirmation Screen", this);
	}
	
	public synchronized void start() {
		thread = new Thread();
		thread.start();
		running = true;
	}
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountofTicks = 60.0;
		double ns = 1000000000 / amountofTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running)
			render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS:" + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		
	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
	    g.setColor(Color.black);
		g.fillRect(0, 0,  WIDTH, HEIGHT);
		
		if(Game.gameState == STATE.Bought ) {
			Bought.render(g);
		}
	}
	
	public static float clamp(float var, float min, float max) {
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else 
			return var;
	}
	
	public static void main(String args[]) {
		new Bought();
		
	}
}
