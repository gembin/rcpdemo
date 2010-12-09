package com.example.rcpdemo.sandbox;

import java.util.ArrayList;
import java.util.List;

public class Person {

	public static enum Salutation {
		MR, MRS
	}

	private int id;
	private String name, vorname;
	private Salutation salutation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Salutation getSalutation() {
		return salutation;
	}

	public void setSalutation(Salutation salutation) {
		this.salutation = salutation;
	}

	public Person(int id, Salutation salutation, String name, String vorname) {
		super();
		this.id = id;
		this.salutation = salutation;
		this.name = name;
		this.vorname = vorname;
	}

	public static List<Person> findAll() {
		List<Person> personen = new ArrayList<Person>();
		personen.add(new Person(11, Salutation.MR, "Ebert", "Ralf"));
		return personen;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", vorname=" + vorname + "]";
	}

}
