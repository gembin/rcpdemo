package com.example.rcpdemo;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;


public class DemoPerspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		layout.addView(DemoPluginConstants.VIEW_ID_UPDATE, IPageLayout.TOP, 1.0f, layout.getEditorArea());
	}
	
}
