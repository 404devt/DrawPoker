package com.flipturnapps.drawpoker.client;

import java.util.HashMap;

public class ClientCommandData 
{
	private Client client;
	private HashMap<String,String> valuesMap;
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public HashMap<String,String> getValuesMap() {
		return valuesMap;
	}
	public void setValuesMap(HashMap<String,String> valuesMap) {
		this.valuesMap = valuesMap;
	}
}
