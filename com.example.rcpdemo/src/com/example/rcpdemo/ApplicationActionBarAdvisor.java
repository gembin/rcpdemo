package com.example.rcpdemo;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
    	// See https://bugs.eclipse.org/bugs/show_bug.cgi?id=270007
    	register(ActionFactory.SAVE.create(window));
		register(ActionFactory.HELP_CONTENTS.create(window));
		register(ActionFactory.HELP_SEARCH.create(window));
		register(ActionFactory.DYNAMIC_HELP.create(window));
		register(ActionFactory.RESET_PERSPECTIVE.create(window));
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    }
    
}
