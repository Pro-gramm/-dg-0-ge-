package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.game.enemies.BasicEnemy;
import com.game.enemies.Spawn;
import com.game.user.HUD;
import com.game.user.Menu;
import com.game.user.MenuParticle;
import com.game.user.Player;
import com.game.user.Shop;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1550691097823471818L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	
	public static boolean paused = false;              
	public int diff = 0;
	
	// 0 = normal
	//1 = hard
	
	private Random r;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	private Shop shop;
	
	public enum STATE{
		Menu,
		Help,
		Help2,
		Shop,
		Customize,
		Bought,
		Game,
		Select,
		End, 
	};
	
	public static STATE gameState = STATE.Menu;
		
	public static BufferedImage sprite_sheet = null;
	public static BufferedImage sprite_sheet2 = null;
	
	public Game() {
		
		BufferedImageLoader loader = new BufferedImageLoader();
		
			try {
				sprite_sheet = ImageIO.read(getClass().getResource("/sprite_sheet.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				sprite_sheet = ImageIO.read(getClass().getResource("/sprite_sheet 2.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			
		handler = new Handler();
		hud = new HUD();
		shop = new Shop(handler, hud);
		menu = new Menu(this, handler, hud);
		this.addKeyListener(new KeyInput(handler, this));
		this.addMouseListener(menu);
		this.addMouseListener(shop);
		
		AudioPlayer.load();
		
		AudioPlayer.getMusic("Music2").loop();
		
		
		new Window(WIDTH, HEIGHT, "Dodge! | o |", this);
		
		sprite_sheet = loader.loadImage("/sprite_sheet.png");
	    sprite_sheet2 = loader.loadImage("/sprite_sheet 2.png");
		
		spawner = new Spawn(handler, hud, this);
		r = new Random();
		
		if(gameState == STATE.Game)
	    {
	    	handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
		    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
	    }else {
	    	for(int i = 0; i < 20; i++) {
	    		handler.addObject(new MenuParticle(r.nextInt(WIDTH),r.nextInt(HEIGHT), ID.MenuParticle, handler));
	    	}
	    }
	
}
	
	public synchronized void start() {
		thread = new Thread(this);
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
		
		if(gameState == STATE.Game) 
		{
			if(!paused)
			{
				hud.tick();
				spawner.tick();
				handler.tick();
				
				if(HUD.HEALTH <= 0) {
					HUD.HEALTH = 100;
					gameState = STATE.End;
					handler.clearEnemies();
					for(int i = 0; i < 20; i++) {
			    		handler.addObject(new MenuParticle(r.nextInt(WIDTH),r.nextInt(HEIGHT), ID.MenuParticle, handler));
					}
			    }
				
			}
			
		}else if(gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Select) {
			menu.tick();
			handler.tick();
		}
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
		
		if(paused) {
			if(gameState == STATE.Game) {
			g.setColor(Color.white);
			g.drawString("PAUSED", 15, 127);
		} else if(gameState == STATE.End) {
			paused = false;
		}
	}
		
		
		if(gameState == STATE.Game ) {
			hud.render(g);
			handler.render(g);
		}else if (gameState == STATE.Shop) {
			shop.render(g);
		}else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.Help2 || gameState == STATE.End || gameState == STATE.Select || gameState == STATE.Customize) {
			menu.render(g);
			handler.render(g);
		
		}
		
		g.dispose();
		bs.show();
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
		new Game();
		
	}

}
