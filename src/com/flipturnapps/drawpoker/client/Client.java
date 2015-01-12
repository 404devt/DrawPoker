package com.flipturnapps.drawpoker.client;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.flipturnapps.kevinLibrary.command.Command;
import com.flipturnapps.kevinLibrary.helper.ThreadHelper;
import com.flipturnapps.kevinLibrary.net.KClient;
import com.flipturnapps.kevinLibrary.net.LightKCommandClient;
import com.flipturnapps.kevinLibrary.newgui.KDialog;

public class Client extends LightKCommandClient
{

	public Client(String ip, int port, ArrayList<Command> down)
			throws UnknownHostException, IOException 
	{
		super(ip, port, down);
	}

	@Override
	protected void disconnectedFromServer()
	{
		KDialog.showMessage("You have been disconnected from the server.");
		ThreadHelper.sleep(5000);
		System.exit(-1);
	}

	@Override
	public Object makeDownCommandData(String message) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
