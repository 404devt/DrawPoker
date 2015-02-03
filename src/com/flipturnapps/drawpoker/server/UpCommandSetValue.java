package com.flipturnapps.drawpoker.server;

public class UpCommandSetValue extends UpCommand {

	
	public String getName() 
	{
		return UpCommandSetValue.class.getSimpleName();
	}

	@Override
	public int getMaximumParams() 
	{
		return 2;
	}

	@Override
	public int getMinimumParams() 
	{
		return 2;
	}

	@Override
	protected void upCommandExecute(String[] params, ServerCommandData data) 
	{
		data.getClient().getClientValuesMap().put(params[0], params[1]);
	}

	

}
