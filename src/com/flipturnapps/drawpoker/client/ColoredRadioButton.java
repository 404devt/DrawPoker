package com.flipturnapps.drawpoker.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class ColoredRadioButton extends JPanel
{
	private RadioButtonConstraints constraints;
	private JRadioButton radioButton;
	private DrawPanel draw;
	private static ButtonGroup ourGroup;
	public ColoredRadioButton(RadioButtonConstraints constraints, DrawPanel draw)
	{
		this.setConstraints(constraints);
		this.draw = draw;
		this.setLayout(new BorderLayout(0, 0));

		RB rdbtn = new RB();
		rdbtn.setText(constraints.getText());
		this.add(rdbtn);
		rdbtn.setFont(new Font("Comic Neue", Font.BOLD, 14));
		if(ourGroup == null)
			ourGroup = new ButtonGroup();
		ourGroup.add(rdbtn);
		setRadioButton(rdbtn);
		recolor(constraints.getMainColor(), constraints.getTextColor(), constraints.getTextColor());

	}
	private void recolor(Color mc, Color tc, Color bc)
	{
		if(!(constraints.getTextColor().equals(mc)))
			radioButton.setForeground(tc);
		else
			radioButton.setForeground(Color.WHITE);
		radioButton.setBackground(mc);
		this.setBorder(new LineBorder(bc, 3));
	}
	public JRadioButton getRadioButton() {
		return radioButton;
	}
	public void setRadioButton(JRadioButton radioButton) {
		this.radioButton = radioButton;
	}
	public RadioButtonConstraints getConstraints() {
		return constraints;
	}
	public void setConstraints(RadioButtonConstraints constraints) {
		this.constraints = constraints;
	}
	private JPanel getPanel()
	{
		return this;
	}
	private class RB extends JRadioButton implements ItemListener
	{
		private boolean drawRainbow;

		public RB()
		{
			this.addItemListener(this);
			drawRainbow = constraints.getText().equals("Rainbow");
		}
		public void paintComponent(Graphics g)
		{
			
			 if(drawRainbow)
			 {
				 this.setBackground(new Color(0,0,0,0));
		        Graphics2D g2d = (Graphics2D) g;
		        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		        int w = getWidth();
		        int h = getHeight();
		        GradientPaint gp = new GradientPaint(0, 0, Color.red, (float) ((w+0.0)/2), 0, Color.orange);
		        g2d.setPaint(gp);
		        g2d.fillRect(0, 0, w, h);
			 }
		     super.paintComponent(g);
		}
		public void setEnabled(boolean b)
		{
			//this code is somewhat obsolete because the panels are hidden when disabled
			
			super.setEnabled(b);
			/*
			if(b)
				recolor(constraints.getMainColor(), constraints.getTextColor(), constraints.getTextColor());
			else
				recolor(KevinColor.mix(constraints.getMainColor(),Color.DARK_GRAY,0.6),
						constraints.getTextColor(),						
						Color.DARK_GRAY);
			*/
			//end of obsolete code
			getPanel().setVisible(b);
			

		}

		@Override
		public void itemStateChanged(ItemEvent arg0) 
		{
			boolean b = this.isSelected();
			if(b)
			{
				recolor(constraints.getMainColor(), constraints.getTextColor(), constraints.getMainColor());
				draw.setPaintColorConstraints(constraints);
			}
			else
				recolor(constraints.getMainColor(), constraints.getTextColor(), constraints.getTextColor());


		}

	}
}
