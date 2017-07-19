package com.hardik.javaee.crud.model;

import java.io.Serializable;

/**
 * Student Model
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private int rlno;
	private String firstName;
	private String lastName;
	private String standard;
	private String division;
	private String email;

	public int getRlno() {
		return rlno;
	}

	public void setRlno(int rlno) {
		this.rlno = rlno;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [rlno=" + getRlno() + ", firstName=" + getFirstName() + ",lastName=" + getLastName()
				+ ", standard=" + getStandard() + ", division=" + getDivision() + ", email=" + getEmail() + "]";
	}
}
