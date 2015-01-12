package com.flipturnapps.drawpoker.main;

import java.awt.Image;
import java.io.IOException;
import java.net.Socket;

import com.flipturnapps.kevinLibrary.net.ClientData;
import com.flipturnapps.kevinLibrary.net.KServer;

public class Client extends ClientData 
{
private String screenName;
private int score;
private Image lastDrawing;
	
	public Client(Socket socket, KServer<?> server) throws IOException 
	{
		super(socket, server);		
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

}
