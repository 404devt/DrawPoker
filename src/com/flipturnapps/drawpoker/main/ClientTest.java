package com.flipturnapps.drawpoker.main;

import com.flipturnapps.drawpoker.client.Client;
import com.flipturnapps.kevinLibrary.helper.ThreadHelper;

public class ClientTest implements Runnable
{

	private Client client;

	public ClientTest(Client c) 
	{
		this.client = c;
	}

	@Override
	public void run() 
	{
		while(true)
		{
			ThreadHelper.sleep(1000);
		System.out.println(Main.createHashmapTable(client.getValuesMap()));
		System.out.println();
		}
		
	}

}
