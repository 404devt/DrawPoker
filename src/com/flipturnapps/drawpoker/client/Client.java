package com.flipturnapps.drawpoker.client;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import com.flipturnapps.kevinLibrary.command.Command;
import com.flipturnapps.kevinLibrary.helper.ThreadHelper;
import com.flipturnapps.kevinLibrary.net.LightKCommandClient;
import com.flipturnapps.kevinLibrary.newgui.KDialog;

public class Client extends LightKCommandClient
{
	private HashMap<String,String> values;
	public Client(String ip, int port, ArrayList<Command> down)
			throws UnknownHostException, IOException 
	{
		super(ip, port, down);
		values = new HashMap<String,String>();
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
		ClientCommandData data = new ClientCommandData();
		data.setClient(this);
		data.setValuesMap(getValuesMap());
		return data;
	}

	public HashMap<String,String> getValuesMap()
	{
		return values;
	}

	public void setValuesMap(HashMap<String,String> values) 
	{
		this.values = values;
	}

	public void sendCommand(String...strings) 
	{
		String commandString=strings[0];
		for(int i = 1; i < strings.length; i++)
		{
			commandString += "~";
			commandString += strings[i];
		}
		this.sendMessage(commandString);		
	}

}
