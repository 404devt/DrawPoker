package com.flipturnapps.drawpoker.client;

public class DownCommandSetValue extends DownCommand {

	
	@Override
	public String getName() 
	{
		return DownCommandSetValue.class.getSimpleName();
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
	protected void downCommandExecute(String[] params, ClientCommandData data)
	{
		data.getValuesMap().put(params[0], params[1]);
	}

}
