package com.flipturnapps.drawpoker.server;

import com.flipturnapps.drawpoker.client.DownCommandSetValue;

public class UpCommandGetValue extends UpCommand {


	public String getName() 
	{
		return UpCommandGetValue.class.getSimpleName();
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
	protected void upCommandExecute(String[] params, ServerCommandData data) 
	{
		data.getServer().runDownCommandAll(DownCommandSetValue.class.getSimpleName(), params[0], data.getClient().getClientValuesMap().get(params[0]));
	}

	

}
