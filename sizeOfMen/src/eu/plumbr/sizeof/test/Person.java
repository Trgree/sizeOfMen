package eu.plumbr.sizeof.test;

import java.util.Date;

public class Person {

	private String id;
	private Date dateOfBirth;
	private String forename;
	private String surname;
		
	public Person() {	
	}
	
	public Person(String id, Date dateOfBirth, String forename, String surname) {
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.forename = forename;
		this.surname = surname;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

}
