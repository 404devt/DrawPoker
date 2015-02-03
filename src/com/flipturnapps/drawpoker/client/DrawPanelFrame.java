package com.flipturnapps.drawpoker.client;

import java.util.HashMap;

import javax.swing.JFrame;

import com.flipturnapps.drawpoker.main.Main;

public class DrawPanelFrame extends JFrame {

	private static final String VALUES_MAP_ENTRY_KEY = "drawpanelstate";
	private Client client;
	private HashMap<String, String> valuesMap;
	private DrawPanelWrapper dpWrapper;
	private static DrawPanelFrame currentFrame;

	public static DrawPanelFrame getCurrentFrame()
	{
		return currentFrame;
	}
	
	public void startSelf(Client client, HashMap<String, String> valuesMap) 
	{
		this.client = client;
		this.valuesMap = valuesMap;
		
		this.valuesMap.put(VALUES_MAP_ENTRY_KEY, true+"");
		
		dpWrapper = new DrawPanelWrapper();
		this.getContentPane().add(dpWrapper);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Main.DEFAULT_FRAME_DIMENSION);
		this.setTitle(Main.DEFAULT_FRAME_TITLE);
		this.setVisible(true);
		
		currentFrame = this;
	}

	public void selfDestruct()
	{
		this.setVisible(false);
		dpWrapper.stopAll();
		valuesMap.put(VALUES_MAP_ENTRY_KEY, false + "");
		this.dispose();
	}

}
