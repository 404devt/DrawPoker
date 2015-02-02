package com.flipturnapps.drawpoker.client;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.border.EtchedBorder;

import com.flipturnapps.kevinLibrary.helper.ThreadHelper;
import com.flipturnapps.kevinLibrary.sprite.SpritePanel;

public class DrawPanel extends SpritePanel implements MouseListener, Runnable
{
	
	private static final int SIZE_INIT = 15;
	private BackgroundImageSprite background;
	private RadioButtonConstraints paintColorConstraints;
	private int brushSize;
	private boolean mouseDown;
	private JSlider slider;
	private Color paintColor;
	private boolean notStop;
	public DrawPanel(JSlider slider) 
	{
		notStop = true;
		setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setLayout(new FlowLayout());
		brushSize = SIZE_INIT;
		background = new BackgroundImageSprite();
		this.addMouseListener(this);
		this.slider = slider;
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
		long count = 0;
		while(notStop)
		{
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.refresh();
			if(mouseDown&&!((int)this.getMouseX()<15&&(int)this.getMouseY()<15))
			{
				this.add(new PaintballSprite((int)this.getMouseX(),(int)this.getMouseY(),brushSize,paintColor));
			}
			if(this.paintColorConstraints.getText().equals("Rainbow"))
			{
				paintColor = new Color(Color.HSBtoRGB((float) (count % ((360*1000)+0.0)/1000), 1, 1));
				if(mouseDown)
				count++;
			}
			this.setBrushSize(slider.getValue());
		}
		
	}


	public void setPaintColorConstraints(RadioButtonConstraints constraints) {
		this.paintColorConstraints = constraints;
		this.paintColor = this.paintColorConstraints.getMainColor();
		
	}

	public void undo() {
		background.undo();
		
	}

	public void stopAll() 
	{
		notStop = false;		
	}

	
	

}
