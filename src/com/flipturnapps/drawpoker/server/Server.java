package com.flipturnapps.drawpoker.server;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import com.flipturnapps.kevinLibrary.command.Command;
import com.flipturnapps.kevinLibrary.net.KServer;
import com.flipturnapps.kevinLibrary.net.LightKCommandServer;

public class Server extends LightKCommandServer<ServerClient> 
{
	public Server(int port, ArrayList<Command> up) throws IOException 
	{
		super(port, up);
	}

	@Override
	protected ServerClient getNewClientData(Socket socket, KServer<ServerClient> kServer) 
	{
		try {
			return new ServerClient(socket,kServer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("IO exception forced server to pass a null ServerClient to KServer!");
		return null;
	}

	@Override
	protected void newClient(ServerClient data) 
	{
		System.out.println("New client.");
	}

	@Override
	public Object makeUpCommandData(ServerClient clientData) 
	{
		ServerCommandData data = new ServerCommandData();
		data.setClient(clientData);
		data.setServer(this);
		return data;
	}

}
