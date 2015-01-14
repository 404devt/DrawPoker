package com.flipturnapps.drawpoker.main;

import java.awt.Color;
import java.awt.Dimension;

import com.flipturnapps.drawpoker.client.DrawPanelWrapper;
import com.flipturnapps.drawpoker.client.RadioButtonConstraints;
import com.flipturnapps.kevinLibrary.gui.KJFrame;
import com.flipturnapps.kevinLibrary.helper.KevinColor;


public class Main 
{
	public static final String DEV_NAME = "FlipTurnApps";
	public static final String APP_NAME = "DrawPoker";
	public static final RadioButtonConstraints[] ALLOWED_COLORS = new RadioButtonConstraints[]{
		new RadioButtonConstraints(Color.RED,Color.BLACK,"Red"),
		new RadioButtonConstraints(Color.BLUE,Color.BLACK,"Blue"),
		new RadioButtonConstraints(KevinColor.kgreen,Color.BLACK,"Green"),
		new RadioButtonConstraints(Color.YELLOW,Color.BLACK,"Yellow"),
		new RadioButtonConstraints(KevinColor.kpink,Color.BLACK,"Pink"),
		new RadioButtonConstraints(KevinColor.kpurple,Color.BLACK,"Purple"),
		new RadioButtonConstraints(Color.BLACK,Color.BLACK,"Black"),
		new RadioButtonConstraints(Color.CYAN,Color.BLACK,"Cyan")
			};

	public static void main (String[] args)
	{
		/*Uncomment to test DrawPanel
		KJFrame frame = new KJFrame();
		frame.getContentPane().add(new DrawPanel());
		frame.setSize(new Dimension(500,500));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		*/
		KJFrame frame = new KJFrame();
		frame.getContentPane().add(new DrawPanelWrapper());
		frame.setSize(new Dimension(700,700));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
