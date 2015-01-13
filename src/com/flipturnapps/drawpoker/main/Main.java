package com.flipturnapps.drawpoker.main;

import java.awt.Dimension;

import com.flipturnapps.drawpoker.client.DrawPanel;
import com.flipturnapps.kevinLibrary.gui.KJFrame;


public class Main 
{
	public static final String DEV_NAME = "FlipTurnApps";
	public static final String APP_NAME = "DrawPoker";

	public static void main (String[] args)
	{
		//JUSt to test DrawPanel
		KJFrame frame = new KJFrame();
		frame.getContentPane().add(new DrawPanel());
		frame.setSize(new Dimension(500,500));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
