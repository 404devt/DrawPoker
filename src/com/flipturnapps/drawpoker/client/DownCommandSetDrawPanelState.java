package com.flipturnapps.drawpoker.client;

public class DownCommandSetDrawPanelState extends DownCommand 
{

	@Override
	public String getName()
	{
		return DownCommandSetDrawPanelState.class.getSimpleName();
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
		boolean state = Boolean.parseBoolean(params[0]);
		if(state)
		{
			DrawPanelFrame frame = new DrawPanelFrame();
			frame.startSelf(data.getClient(),data.getValuesMap());
		}
	}

}
