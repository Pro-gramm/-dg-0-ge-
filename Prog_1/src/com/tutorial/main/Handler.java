package com.tutorial.main;

import java.awt.Graphics;
import java.util.ArrayList;

import com.game.user.Player;

public class Handler {

	public ArrayList<GameObject> object = new ArrayList<GameObject>();
	
	public int speed = 5;
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			    GameObject tempObject = object.get(i);
			    
			    tempObject.tick();
			}
		}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
		    GameObject tempObject = object.get(i);
		    
		    tempObject.render(g);
		}
	}
	
	public void clearEnemies() {
		for(int i = 0; i < object.size(); i++) {
		    GameObject tempObject = object.get(i);
		    
		   if(tempObject.getId() == ID.Player) 
		   {
			   object.clear();
			   if(Game.gameState != Game.STATE.End)
			   addObject(new Player((int)tempObject.getx(), (int)tempObject.gety(), ID.Player, this));
		   }
	  }
}
	
	public void clearEnemies2() {
		object.clear();
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
		}
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
}