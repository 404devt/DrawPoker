package com.flipturnapps.drawpoker.main;

import java.awt.Color;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

import com.flipturnapps.drawpoker.client.Client;
import com.flipturnapps.drawpoker.client.DownCommandGetValue;
import com.flipturnapps.drawpoker.client.DownCommandSetValue;
import com.flipturnapps.drawpoker.client.RadioButtonConstraints;
import com.flipturnapps.drawpoker.server.Server;
import com.flipturnapps.drawpoker.server.UpCommandGetValue;
import com.flipturnapps.drawpoker.server.UpCommandSetValue;
import com.flipturnapps.kevinLibrary.command.Command;
import com.flipturnapps.kevinLibrary.helper.KevinColor;


public class Main 
{
	public static final String DEV_NAME = "FlipTurnApps";
	public static final String APP_NAME = "DrawPoker";
	public static final RadioButtonConstraints[] ALLOWED_COLORS;
	private static final ArrayList<Command> UP_COMMANDS;
	private static final ArrayList<Command> DOWN_COMMANDS;
	static
	{
		ALLOWED_COLORS = new RadioButtonConstraints[]{
				new RadioButtonConstraints(Color.RED,Color.BLACK,"Red"),
				new RadioButtonConstraints(Color.BLUE,Color.BLACK,"Blue"),
				new RadioButtonConstraints(KevinColor.kgreen,Color.BLACK,"Green"),
				new RadioButtonConstraints(Color.YELLOW,Color.BLACK,"Yellow"),
				new RadioButtonConstraints(KevinColor.kpink,Color.BLACK,"Pink"),
				new RadioButtonConstraints(KevinColor.kpurple,Color.BLACK,"Purple"),
				new RadioButtonConstraints(Color.BLACK,Color.BLACK,"Black"),
				//new RadioButtonConstraints(Color.RED,Color.BLACK,"Rainbow"),
				new RadioButtonConstraints(Color.CYAN,Color.BLACK,"Cyan")
		};
		
		UP_COMMANDS = new ArrayList<Command>();
		UP_COMMANDS.add(new UpCommandGetValue());
		UP_COMMANDS.add(new UpCommandSetValue());
		DOWN_COMMANDS = new ArrayList<Command>();
		DOWN_COMMANDS.add(new DownCommandGetValue());
		DOWN_COMMANDS.add(new DownCommandSetValue());
	}

	public static void main (String[] args)
	{
		/* Test DrawPanelWrapper
		KJFrame frame = new KJFrame();
		frame.getContentPane().add(new DrawPanelWrapper());
		frame.setSize(new Dimension(700,700));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		 */
		new Main().testServerAndClient();
		
	}
	private void testServerAndClient()
	{
		Scanner scan = new Scanner(System.in);
		JFrame frame;
		System.out.print("mode: ");
		if(scan.nextLine().equals("server"))
		{
			Server server = null;
			try {
				server = new Server(23456,UP_COMMANDS);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			frame = new ServerTestFrame(server);
		}
		else
		{
			Client client = null;
			try {
				client = new Client("127.0.0.1",23456,DOWN_COMMANDS);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			frame = new ClientTestFrame(client);
		}
		frame.setVisible(true);
		scan.close();
		System.out.println("end");
	}
}
