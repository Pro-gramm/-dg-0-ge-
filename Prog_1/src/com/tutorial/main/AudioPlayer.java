package com.tutorial.main;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer {

	public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	public static Map<String, Music> musicMap = new HashMap<String, Music>();
	
	
	public static void load() {
		
		try {
			soundMap.put("menu_Sound", new Sound("res/mixkit-retro-arcade-casino-notification-211.wav"));
			
			musicMap.put("Music1", new Music("res/Lost In Sound - ROY KNOX Magic.ogg"));
			musicMap.put("Music2", new Music("res/0086.-Power-AShamaluevMusic.ogg"));
			musicMap.put("Music3", new Music("res/Soulsplit 2013 Soundtrack.ogg"));
		} catch (SlickException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static Music getMusic(String key) {
		return musicMap.get(key);
	}
	
	public static Sound getSound(String key) {
		return soundMap.get(key);
	}
}
