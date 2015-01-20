package com.flipturnapps.drawpoker.client;

public class DownCommandGetValue extends DownCommand {

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
	protected void downCommandExecute(String[] params, ClientCommandData data) 
	{
		//todo
	}

}
