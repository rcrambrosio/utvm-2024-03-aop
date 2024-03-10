package io.rcrambrosio.aop.vo;

import java.io.Serializable;

/**
 * @apiNote Clase VO para la recepción de datos vía HttpRequest
 * @author rcrambrosio
 * @since 1.0.0
 */
public class AuthVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5197128731174222703L;

	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
