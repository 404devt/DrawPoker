package com.flipturnapps.drawpoker.client;

import com.flipturnapps.kevinLibrary.sprite.SpritePanel;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.border.EtchedBorder;

public class DrawPanel extends SpritePanel 
{
	public DrawPanel() 
	{
		setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setLayout(new BorderLayout(0, 0));
	}
	public void paintComponent(Graphics g)
	{
		
	}

}
