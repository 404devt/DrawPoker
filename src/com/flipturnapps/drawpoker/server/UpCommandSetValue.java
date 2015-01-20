package com.flipturnapps.drawpoker.server;

public class UpCommandSetValue extends UpCommand {

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
	protected void upCommandExecute(String[] params, ServerCommandData data) 
	{
		data.getClient().getClientValuesMap().put(params[0], params[1]);
	}

	

}
