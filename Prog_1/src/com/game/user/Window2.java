package com.game.user;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.tutorial.main.Game;
import com.tutorial.main.Game.STATE;

public class Window2 extends Canvas {
	private static final long serialVersionUID = 892311462267794012L;

	public Window2(int width, int height, String title, Bought bought) {
		
		
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(bought);
		frame.setVisible(true);
		if (Game.gameState == STATE.Bought) {
			bought.start();
		}
	}
}
