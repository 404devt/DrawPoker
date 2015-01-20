package com.flipturnapps.drawpoker.server;

import com.flipturnapps.drawpoker.client.DownCommandSetValue;

public class UpCommandGetValue extends UpCommand {

	public static final String CALL_NAME = "getvalue";
	@Override
	public String getName() 
	{
		return CALL_NAME;
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
		data.getServer().runDownCommandAll(DownCommandSetValue.CALL_NAME, params[0], data.getClient().getClientValuesMap().get(params[0]));
	}

	

}
