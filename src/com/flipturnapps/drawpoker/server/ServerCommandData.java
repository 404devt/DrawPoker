package com.flipturnapps.drawpoker.server;

public class ServerCommandData 
{
	private Server server;
	private ServerClient client;
	public Server getServer() {
		return server;
	}
	public void setServer(Server server) {
		this.server = server;
	}
	public ServerClient getClient() {
		return client;
	}
	public void setClient(ServerClient client) {
		this.client = client;
	}
}
