package com.example.rcpdemo.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

public class LayoutViewPart extends ViewPart {

	@Override
	public void createPartControl(final Composite parent) {
				
		Label label1 = createLabel(parent, "Label 1", SWT.COLOR_RED);
		Label label2 = createLabel(parent, "Label 2", SWT.COLOR_GREEN);
		Label label3 = createLabel(parent, "Label 3", SWT.COLOR_BLUE);
		Label label4 = createLabel(parent, "Label 4", SWT.COLOR_CYAN);
		Label label5 = createLabel(parent, "Label 5", SWT.COLOR_MAGENTA);
		
	}

	private Label createLabel(Composite parent, String text, int color) {
		Label label = new Label(parent, SWT.NONE);
		label.setText(text);
		label.setBackground(parent.getDisplay().getSystemColor(color));
		return label;
		
	}

	@Override
	public void setFocus() {

	}

}
