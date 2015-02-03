package com.flipturnapps.drawpoker.main;

import com.flipturnapps.drawpoker.server.Server;
import com.flipturnapps.kevinLibrary.helper.ThreadHelper;

public class ServerTest implements Runnable
{

	private Server server;

	public ServerTest(Server s) 
	{
		this.server = s;
	}

	@Override
	public void run() 
	{
		while(server.getClientCount()<1)
		{
			ThreadHelper.sleep(100);
		}
		server.runDownCommandAll("setvalue~hi~hi2");
		server.runDownCommandAll("setvalue~david~bad");
		server.runDownCommandAll("setvalue~dicksddddd~good");
		
	}

}
