package com.example.rcpdemo.sandbox;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class SandboxViewPart extends ViewPart {

	@Override
	public void createPartControl(final Composite parent) {

		Button button = new Button(parent, SWT.NONE);
		button.setText("Action");

		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});

	}

	@Override
	public void setFocus() {

	}

}
