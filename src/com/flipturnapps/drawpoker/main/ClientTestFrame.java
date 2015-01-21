package com.flipturnapps.drawpoker.main;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.flipturnapps.drawpoker.client.Client;
import com.flipturnapps.kevinLibrary.newgui.UserIOFrame;

public class ClientTestFrame extends UserIOFrame implements Runnable 
{

	private Client client;
	private Thread thread;

	public ClientTestFrame(Client client) 
	{
		super("client");
		this.client = client;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() 
	{
		while(true)
		{
			String input = this.getInputTypeText();
			if(input.equalsIgnoreCase("print"))
			{
				this.println("----START PRINT----");
				
					this.println("User values: ");
					Map<String,String> map = client.getValuesMap();
					Set<String> keys = map.keySet();
					Iterator<String> it = keys.iterator();
					int count = 0;
					while(it.hasNext())
					{
						String next = it.next();
						this.println(next+"--"+map.get(next));
						count++;
					}
				
				this.println("-----END  PRINT----");
			}
			else
			{
				client.sendMessage(input);
			}
		}		
	}
	
}
