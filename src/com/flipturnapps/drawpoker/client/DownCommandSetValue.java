package com.flipturnapps.drawpoker.client;

public class DownCommandSetValue extends DownCommand {

	public static final String CALL_NAME = "setvalue";
	@Override
	public String getName() 
	{
		return CALL_NAME;
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
