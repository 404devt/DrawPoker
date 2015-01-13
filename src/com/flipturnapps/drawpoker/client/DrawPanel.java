package com.flipturnapps.drawpoker.client;

import com.flipturnapps.kevinLibrary.sprite.SpritePanel;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.border.EtchedBorder;

public class DrawPanel extends SpritePanel implements MouseListener
{
	private BackgroundImageSprite background;
	public DrawPanel() 
	{
		setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setLayout(new BorderLayout(0, 0));
		this.add(background);
	}
	
	private void compressAll()
	{
		BufferedImage newImage = new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics g = newImage.createGraphics();
		this.refresh();
		this.paintComponent(g);
		background.updateImage(newImage);
		this.getSprites().clear();
		this.add(background);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
