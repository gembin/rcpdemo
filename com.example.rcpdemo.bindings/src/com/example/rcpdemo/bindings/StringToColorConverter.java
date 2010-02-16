package com.example.rcpdemo.bindings;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Control;

public class StringToColorConverter implements IConverter {

	private final ResourceManager resources;
	
	public StringToColorConverter(Control resourceOwner) {
		resources = new LocalResourceManager(JFaceResources.getResources(), resourceOwner);
	}

	public Object convert(Object fromObject) {
		String str = String.valueOf(fromObject);
		String[] parts = str.split(",");
		if (parts.length != 3)
			throw new RuntimeException("Invalid color: " + fromObject);
		int[] intParts = new int[3];
		for (int i = 0; i < parts.length; i++) {
			intParts[i] = Integer.parseInt(parts[i].trim());
		}
		return resources.createColor(new RGB(intParts[0], intParts[1], intParts[2]));
	}

	public Object getFromType() {
		return String.class;
	}

	public Object getToType() {
		return Color.class;
	}

}