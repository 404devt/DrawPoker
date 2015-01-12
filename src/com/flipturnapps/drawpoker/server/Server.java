package com.flipturnapps.drawpoker.server;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import com.flipturnapps.kevinLibrary.command.Command;
import com.flipturnapps.kevinLibrary.net.KServer;
import com.flipturnapps.kevinLibrary.net.LightKCommandServer;

public class Server extends LightKCommandServer<Client> 
{
	public Server(int port, ArrayList<Command> up) throws IOException {
		super(port, up);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Client getNewClientData(Socket socket, KServer<Client> kServer) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void newClient(Client data) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object makeUpCommandData(Client clientData) {
		// TODO Auto-generated method stub
		return null;
	}

}
