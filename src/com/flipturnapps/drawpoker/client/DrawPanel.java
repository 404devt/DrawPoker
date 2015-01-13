package com.flipturnapps.drawpoker.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.border.EtchedBorder;

import com.flipturnapps.kevinLibrary.helper.ThreadHelper;
import com.flipturnapps.kevinLibrary.sprite.SpritePanel;

public class DrawPanel extends SpritePanel implements MouseListener, Runnable
{
	private BackgroundImageSprite background;
	private Color paintColor;
	private int brushSize;
	private boolean mouseDown;
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
	public void mousePressed(MouseEvent arg0) 
	{
		mouseDown = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		mouseDown = false;
		compressAll();		
	}

	@Override
	public void run() 
	{
		while(true)
		{
			ThreadHelper.sleep(10);
			this.refresh();
			if(mouseDown)
			{
				this.add(new PaintballSprite((int)this.getMouseX(),(int)this.getMouseY(),brushSize,paintColor));
			}
		}
		
	}
	

}
