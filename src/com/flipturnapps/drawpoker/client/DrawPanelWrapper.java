package com.flipturnapps.drawpoker.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import java.awt.Font;

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
		Hashtable<Integer,JLabel> labelTable = new Hashtable<Integer,JLabel>();
		labelTable.put( new Integer( BRUSH_SLIDER_MIN ), new JLabel("Thin") );
		labelTable.put( new Integer( BRUSH_SLIDER_MAX ), new JLabel("Thick") );
		labelTable.put( new Integer( slider.getValue() ), new JLabel("Medium") );
		slider.setLabelTable(labelTable);
		
		JLabel lblBrushWidth = new JLabel("Brush Width");
		lblBrushWidth.setFont(new Font("Comic Neue", Font.BOLD, 14));
		panel_option.add(lblBrushWidth);
		panel_option.add(slider);

	}

}
