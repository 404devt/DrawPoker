package com.flipturnapps.drawpoker.server;

import java.awt.Image;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

import com.flipturnapps.kevinLibrary.helper.Numbers;
import com.flipturnapps.kevinLibrary.net.ClientData;
import com.flipturnapps.kevinLibrary.net.KServer;

public class ServerClient extends ClientData 
{
	private String screenName;
	private int score;
	private Image lastDrawing;
	private HashMap<String, String> clientValues;
	public ServerClient(Socket socket, KServer<?> server) throws IOException 
	{
		super(socket, server);	
		clientValues = new HashMap<String,String>();
		clientValues.put("stest",Math.random() + "");
		
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Image getLastDrawing() {
		return lastDrawing;
	}

	public void setLastDrawing(Image lastDrawing) {
		this.lastDrawing = lastDrawing;
	}

	public HashMap<String, String> getClientValuesMap() 
	{
		return clientValues;
	}


}
