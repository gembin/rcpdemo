package com.example.rcpdemo.bindings;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class BindingDemoViewPart extends ViewPart {

	@Override
	public void createPartControl(Composite parent) {

		// GridLayoutFactory.fillDefaults().numColumns(2).spacing(5,
		// 5).margins(10, 10).applyTo(parent);
		//		
		// Label label1 = new Label(parent, SWT.NONE);
		// label1.setText("Text 1:");
		// Label label2 = new Label(parent, SWT.NONE);
		// label2.setText("Text 2:");
		//		
		// Text text1 = new Text(parent, SWT.BORDER | SWT.MULTI | SWT.WRAP);
		// text1.setText("Text 1");
		//
		// Text text2 = new Text(parent, SWT.BORDER | SWT.MULTI | SWT.WRAP);
		// text2.setText("Text 2");
		//		
		// GridDataFactory gdText = GridDataFactory.fillDefaults().grab(true,
		// true).align(SWT.FILL, SWT.FILL);
		// gdText.applyTo(text1);
		// gdText.applyTo(text2);

		GridLayoutFactory.fillDefaults().numColumns(2).spacing(5, 5).margins(
				10, 10).applyTo(parent);

		Label modelLabel = new Label(parent, SWT.NONE);
		modelLabel.setText("Model:");
		Label targetLabel = new Label(parent, SWT.NONE);
		targetLabel.setText("Target:");

		Text modelText = new Text(parent, SWT.BORDER | SWT.MULTI | SWT.WRAP);
		modelText.setText("Text Model");

		Text targetText = new Text(parent, SWT.BORDER | SWT.MULTI | SWT.WRAP);
		targetText.setText("Text Target");

		GridDataFactory gdText = GridDataFactory.fillDefaults()
				.grab(true, true).align(SWT.FILL, SWT.FILL);
		gdText.applyTo(modelText);
		gdText.applyTo(targetText);

		final DataBindingContext bindingContext = new DataBindingContext();

		IObservableValue modelObservable = SWTObservables
				.observeBackground(modelText);
		IObservableValue targetObservable = SWTObservables.observeText(
				modelText, SWT.Modify);
		UpdateValueStrategy targetToModel = new UpdateValueStrategy();
		UpdateValueStrategy modelToTarget = new UpdateValueStrategy();
		targetToModel.setConverter(new StringToColorConverter(parent));
		modelToTarget.setConverter(new ColorToStringConverter());
		bindingContext.bindValue(targetObservable, modelObservable,
				targetToModel, modelToTarget);

		modelObservable = SWTObservables.observeText(modelText, SWT.Modify);
		targetObservable = SWTObservables.observeText(targetText, SWT.Modify);
		bindingContext.bindValue(targetObservable, modelObservable);

	}

	@Override
	public void setFocus() {

	}

}
