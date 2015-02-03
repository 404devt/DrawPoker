package com.flipturnapps.drawpoker.client;

import com.flipturnapps.drawpoker.server.UpCommandSetValue;

public class DownCommandGetValue extends DownCommand {

	@Override
	public String getName() 
	{
		return DownCommandGetValue.class.getSimpleName();
	}

	@Override
	public int getMaximumParams() 
	{
		return 1;
	}

	@Override
	public int getMinimumParams() 
	{
		return 1;
	}

	@Override
	protected void downCommandExecute(String[] params, ClientCommandData data) 
	{
		data.getClient().sendCommand(UpCommandSetValue.class.getSimpleName(),params[0],data.getValuesMap().get(params[0]));
	}

}
