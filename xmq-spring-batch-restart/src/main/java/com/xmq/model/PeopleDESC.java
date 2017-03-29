package com.xmq.model;

public class PeopleDESC {
	private int id;
	private String lastName;
	private String firstName;
	private String desc;

	public PeopleDESC(String lastName, String firstName, String desc) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.desc = desc;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "firstName: " + this.firstName + ", lastName: " + this.lastName;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
