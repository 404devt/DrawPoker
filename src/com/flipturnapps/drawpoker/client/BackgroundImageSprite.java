package com.flipturnapps.drawpoker.client;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.flipturnapps.drawpoker.main.Main;
import com.flipturnapps.kevinLibrary.helper.FileHelper;
import com.flipturnapps.kevinLibrary.sprite.Sprite;
import com.flipturnapps.kevinLibrary.sprite.SpritePanel;

public class BackgroundImageSprite extends Sprite
{
	private BufferedImage currImage;
	private int flushCount;
	
	public BackgroundImageSprite() 
	{
		this.setLayer(0);
	}

	public void updateImage(BufferedImage newImage)
	{
		if(currImage != null)
		{
			File imagePath = new File(FileHelper.getAppDataDir(Main.DEV_NAME, Main.APP_NAME)+"imageCache/");
			imagePath.mkdirs();
			imagePath = new File(imagePath.getAbsolutePath() + "img"+ flushCount+".png");
			try {
				ImageIO.write(currImage, "png", imagePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flushCount++;
		}
		newImage = currImage;
	}
	
	public void undo()
	{
		
	}
	
	@Override
	protected void display(Graphics g, SpritePanel s) 
	{
		if(currImage != null)
		g.drawImage(currImage,0,0,s.getWidth(),s.getHeight(),null);	
	}
	

}
