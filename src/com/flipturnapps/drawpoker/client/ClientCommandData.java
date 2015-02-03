package com.flipturnapps.drawpoker.client;

import java.util.HashMap;

public class ClientCommandData 
{
	private Client client;
	private HashMap<String,String> valuesMap;
	
	public ClientCommandData(Client c,HashMap<String,String> values)
	{
		setClient(c);
		setValuesMap(values);
	}
	
	public Client getClient() 
	{
		return client;
	}
	private void setClient(Client client) {
		this.client = client;
	}
	public HashMap<String,String> getValuesMap() {
		return valuesMap;
	}
	private void setValuesMap(HashMap<String,String> valuesMap) {
		this.valuesMap = valuesMap;
	}
}
