package com.example.rcpdemo.bindings;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.swt.graphics.Color;

public class ColorToStringConverter implements IConverter {

	public Object convert(Object fromObject) {
		Color color = (Color) fromObject;
		return color.getRed() + "," + color.getGreen() + "," + color.getBlue();
	}

	public Object getFromType() {
		return Color.class;
	}

	public Object getToType() {
		return String.class;
	}

}
