package eu.plumbr.sizeof.test;


public class NonRedundantPerson {

	private long id;
	private String forename;
	private String surname;

	public NonRedundantPerson() {
	}

	public NonRedundantPerson(long id, String forename, String surname) {
		this.id = id;
		this.forename = forename;
		this.surname = surname;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
