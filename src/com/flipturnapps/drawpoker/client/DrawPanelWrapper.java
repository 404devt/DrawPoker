package com.flipturnapps.drawpoker.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;

import com.flipturnapps.drawpoker.main.Main;
import com.flipturnapps.kevinLibrary.helper.Numbers;

import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class DrawPanelWrapper extends JPanel
{

	private static final int BRUSH_SLIDER_MIN = 5;
	private static final int BRUSH_SLIDER_MAX = 40;
	private static final int SLIDER_TICK_COUNT = 6;
	private JSlider slider;
	private DrawPanel draw;
	public DrawPanelWrapper() 
	{
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		
		
		JPanel panel_option = new JPanel();
		panel_option.setBorder(new TitledBorder(null, "Tools", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_option.setBackground(Color.WHITE);
		add(panel_option, BorderLayout.NORTH);
		
		
		int sliderWidth = BRUSH_SLIDER_MAX - BRUSH_SLIDER_MIN;
		slider = new JSlider();
		slider.setBackground(Color.WHITE);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMaximum(BRUSH_SLIDER_MAX);
		slider.setMinimum(BRUSH_SLIDER_MIN);
		slider.setMajorTickSpacing((int) ((sliderWidth+0.0)/(SLIDER_TICK_COUNT)));
		slider.setValue((int) ((sliderWidth+0.0)/2+BRUSH_SLIDER_MIN));
		draw = new DrawPanel(slider);
		this.add(draw);
		
		JLabel lblBrushWidth = new JLabel("Brush Width");
		lblBrushWidth.setFont(new Font("Comic Neue", Font.BOLD, 14));
		panel_option.add(lblBrushWidth);
		panel_option.add(slider);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				draw.undo();
			}
		});
		btnUndo.setFont(new Font("Comic Neue", Font.BOLD, 14));
		panel_option.add(btnUndo);
		
		JPanel panel_color = new JPanel();
		panel_color.setBorder(new TitledBorder(null, "Color Selection", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_color.setBackground(Color.WHITE);
		add(panel_color, BorderLayout.SOUTH);
		
		for(int i = 0; i < Main.ALLOWED_COLORS.length; i++)
		{
			ColoredRadioButton btn = new ColoredRadioButton(Main.ALLOWED_COLORS[i],draw);
	
			panel_color.add(btn);
			if(Numbers.random(0,5) == 1)
				btn.getRadioButton().setEnabled(false);
			else
			{
				btn.getRadioButton().setSelected(true);
			}
		}
		
		

	}
	public void stopAll() 
	{
		draw.stopAll();		
	}
	
	

}
