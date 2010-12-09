package com.example.rcpdemo.bindings;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DemoDataObject {

	public static final String F_NUMBER = "number";

	private final PropertyChangeSupport changes = new PropertyChangeSupport(
			this);

	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		System.out.println("setNumber(" + number + ")");
		changes.firePropertyChange(F_NUMBER, this.number, this.number = number);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		changes.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		changes.removePropertyChangeListener(listener);
	}
}
