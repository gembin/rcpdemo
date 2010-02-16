package com.example.rcpdemo;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class UpdateViewPart extends ViewPart {

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new RowLayout(SWT.VERTICAL));

		createUpdateButton(parent, "com.example.rcpdemo.bindings");
		createUpdateButton(parent, "com.example.rcpdemo.layout");
		createUpdateButton(parent, "com.example.rcpdemo.sandbox");
	}

	private void createUpdateButton(Composite parent, final String bundleId) {
		Button button = new Button(parent, SWT.NONE);
		button.setText("Update " + bundleId);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				try {
					Platform.getBundle(bundleId).update();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void setFocus() {

	}

}
