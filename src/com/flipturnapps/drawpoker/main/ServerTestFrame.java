package com.flipturnapps.drawpoker.main;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.flipturnapps.drawpoker.server.Server;
import com.flipturnapps.kevinLibrary.newgui.UserIOFrame;

public class ServerTestFrame extends UserIOFrame implements Runnable 
{
	private Thread thread;
	private Server server;
	public ServerTestFrame(Server server) 
	{
		super("server");
		this.server = server;
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
				for(int x = 0; x < server.getClientCount(); x++)
				{
					this.println("User values: ");
					Map<String,String> map = server.getClient(x).getClientValuesMap();
					Set<String> keys = map.keySet();
					Iterator<String> it = keys.iterator();
					int count = 0;
					while(it.hasNext())
					{
						String next = it.next();
						this.println(next+"--"+map.get(next));
						count++;
					}
				}
				this.println("-----END  PRINT----");
			}
			else
			{
				server.sendAll(input);
			}
		}		
	}	
}
