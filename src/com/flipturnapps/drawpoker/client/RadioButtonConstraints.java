package com.flipturnapps.drawpoker.client;

import java.awt.Color;

public class RadioButtonConstraints
{
	private Color mainColor;
	private Color textColor;
	private String text;
	public RadioButtonConstraints(Color mainColor, Color textColor, String text)
	{
		this.setMainColor(mainColor);
		this.setTextColor(textColor);
		this.setText(text);
	}
	public Color getMainColor() {
		return mainColor;
	}
	public void setMainColor(Color mainColor) {
		this.mainColor = mainColor;
	}
	public Color getTextColor() {
		return textColor;
	}
	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
