package com.flipturnapps.drawpoker.client;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import com.flipturnapps.kevinLibrary.helper.ThreadHelper;
import com.flipturnapps.kevinLibrary.sprite.SpritePanel;

public class DrawPanel extends SpritePanel implements MouseListener, Runnable, ActionListener
{
	private static final Color COLOR_INIT = Color.blue;
	private static final int SIZE_INIT = 15;
	private BackgroundImageSprite background;
	private Color paintColor;
	private int brushSize;
	private boolean mouseDown;
	public DrawPanel() 
	{
		setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setLayout(new FlowLayout());		
		paintColor = COLOR_INIT;
		brushSize = SIZE_INIT;
		background = new BackgroundImageSprite();
		this.addMouseListener(this);
		JButton b = new JButton("undo");
		b.addActionListener(this);
		this.add(b);
		new Thread(this).start();
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
	
	public void setColor(Color c)
	{
		paintColor = c;
	}
	
	public void setBrushSize(int i)
	{
		brushSize = i;
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
		ThreadHelper.sleep(500);
		this.add(background);
		while(true)
		{
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.refresh();
			if(mouseDown)
			{
				this.add(new PaintballSprite((int)this.getMouseX(),(int)this.getMouseY(),brushSize,paintColor));
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		background.undo();
		
	}
	

}
