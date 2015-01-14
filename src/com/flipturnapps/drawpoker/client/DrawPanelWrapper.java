package com.flipturnapps.drawpoker.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;

import com.flipturnapps.drawpoker.main.Main;
import com.flipturnapps.kevinLibrary.helper.Numbers;

public class DrawPanelWrapper extends JPanel {

	private static final int BRUSH_SLIDER_MIN = 5;
	private static final int BRUSH_SLIDER_MAX = 30;
	private static final int SLIDER_TICK_COUNT = 4;
	private JSlider slider;
	public DrawPanelWrapper() 
	{
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_option = new JPanel();
		add(panel_option, BorderLayout.NORTH);
		
		
		int sliderWidth = BRUSH_SLIDER_MAX - BRUSH_SLIDER_MIN;
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMaximum(BRUSH_SLIDER_MAX);
		slider.setMinimum(BRUSH_SLIDER_MIN);
		slider.setMajorTickSpacing((int) ((sliderWidth+0.0)/(SLIDER_TICK_COUNT)));
		slider.setValue((int) ((sliderWidth+0.0)/2+BRUSH_SLIDER_MIN));
		
		
		JLabel lblBrushWidth = new JLabel("Brush Width");
		lblBrushWidth.setFont(new Font("Comic Neue", Font.BOLD, 14));
		panel_option.add(lblBrushWidth);
		panel_option.add(slider);
		
		JPanel panel_color = new JPanel();
		add(panel_color, BorderLayout.SOUTH);
		
		for(int i = 0; i < Main.ALLOWED_COLORS.length; i++)
		{
			ColoredRadioButton btn = new ColoredRadioButton(Main.ALLOWED_COLORS[i]);
			
			panel_color.add(btn);
			if(Math.random() < 0.6)
				btn.setEnabled(false);
			else
				btn.setEnabled(true);
		}
		
		

	}
	

}
