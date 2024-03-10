package io.rcrambrosio.aop.vo;

import java.io.Serializable;
import java.time.LocalDate;

public class UserDataVO extends AuthVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3368296419403769972L;

	private String firstName;
	private String lastName;
	private String email;
	private LocalDate bornDate;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBornDate() {
		return bornDate;
	}

	public void setBornDate(LocalDate bornDate) {
		this.bornDate = bornDate;
	}

}
