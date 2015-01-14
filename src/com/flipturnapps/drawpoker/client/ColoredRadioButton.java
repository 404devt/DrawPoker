package com.flipturnapps.drawpoker.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class ColoredRadioButton extends JPanel
{
	private RadioButtonConstraints constraints;
	private static ButtonGroup ourGroup;
	public ColoredRadioButton(RadioButtonConstraints constraints)
	{
		this.constraints = constraints;
		this.setBorder(new LineBorder(constraints.getTextColor(), 3));
		this.setLayout(new BorderLayout(0, 0));

		JRadioButton rdbtn = new JRadioButton(constraints.getText());
		this.add(rdbtn);
		rdbtn.setFont(new Font("Comic Neue", Font.BOLD, 14));
		if(!(constraints.getTextColor().equals(constraints.getMainColor())))
			rdbtn.setForeground(constraints.getTextColor());
		else
			rdbtn.setForeground(Color.WHITE);
		rdbtn.setBackground(constraints.getMainColor());
		if(ourGroup == null)
			ourGroup = new ButtonGroup();
		ourGroup.add(rdbtn);
	}
}
