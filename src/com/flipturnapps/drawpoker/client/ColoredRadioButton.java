package com.flipturnapps.drawpoker.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

import com.flipturnapps.kevinLibrary.helper.KevinColor;

public class ColoredRadioButton extends JPanel
{
	private RadioButtonConstraints constraints;
	private JRadioButton radioButton;
	private DrawPanel draw;
	private static ButtonGroup ourGroup;
	private static final int DISABLED_BAR_COUNT = 3;
	private static final int DISABLED_BAR_GIRTH = 10;
	private static final Color DISABLED_BAR_COLOR = Color.BLACK;
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
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int width = this.getWidth();
		int slices = (int) ((width+0.0)/DISABLED_BAR_COUNT);
		int last = (int) (slices - (DISABLED_BAR_GIRTH+0.0)/2);
		g.setColor(DISABLED_BAR_COLOR);
		for(int i = 0; i < DISABLED_BAR_COUNT; i++)
		{
			System.out.println(last);
			g.fillRect(last,0, DISABLED_BAR_GIRTH, this.getHeight());
			last += slices;
		}
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
	private class RB extends JRadioButton implements ItemListener
	{
		public RB()
		{
			this.addItemListener(this);
		}
		public void setEnabled(boolean b)
		{
			super.setEnabled(b);
			if(b)
				recolor(constraints.getMainColor(), constraints.getTextColor(), constraints.getTextColor());
			else
				recolor(KevinColor.mix(constraints.getMainColor(),Color.DARK_GRAY,0.6),
						constraints.getTextColor(),						
						Color.DARK_GRAY);

		}

		@Override
		public void itemStateChanged(ItemEvent arg0) 
		{
			boolean b = this.isSelected();
			if(b)
			{
				recolor(constraints.getMainColor(), constraints.getTextColor(), constraints.getMainColor());
				draw.setPaintColor(constraints.getMainColor());
			}
			else
				recolor(constraints.getMainColor(), constraints.getTextColor(), constraints.getTextColor());


		}

	}
}
