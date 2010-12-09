package com.example.rcpdemo.sandbox;

import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.part.ViewPart;

public class TableViewPart extends ViewPart {

	@Override
	public void createPartControl(final Composite parent) {
		List<Person> allPersonen = Person.findAll();

		TableViewer tableViewer = new TableViewer(parent);
		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		tableViewer.setContentProvider(new ArrayContentProvider());

		TableViewerColumn column1 = new TableViewerColumn(tableViewer, SWT.NONE);
		column1.getColumn().setText("Vorname");
		column1.getColumn().setWidth(200);
		column1.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				Person person = (Person) element;
				return person.getVorname();
			}

		});

		TableViewerColumn column2 = new TableViewerColumn(tableViewer, SWT.NONE);
		column2.getColumn().setText("Name");
		column2.getColumn().setWidth(200);
		column2.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				Person person = (Person) element;
				return person.getName();
			}

		});

		tableViewer.setInput(allPersonen);
	}

	@Override
	public void setFocus() {

	}

}
