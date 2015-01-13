package com.flipturnapps.drawpoker.client;

import java.awt.Color;
import java.awt.Graphics;

import com.flipturnapps.kevinLibrary.sprite.PositionSprite;
import com.flipturnapps.kevinLibrary.sprite.SpritePanel;

public class PaintballSprite extends PositionSprite 
{


	private Color c;

	public PaintballSprite(int x, int y, int bushwidth, Color color) 
	{
		super();
		this.setHeight(bushwidth);
		this.setWidth(bushwidth);
		this.setCenterX(x);
		this.setCenterY(y);
		this.c = color;
	}


	@Override
	protected void drawShape(Graphics g, SpritePanel s, int x, int y, int width, int height)
	{
		g.setColor(c);
		g.fillOval(x, y, width, height);

	}

}
