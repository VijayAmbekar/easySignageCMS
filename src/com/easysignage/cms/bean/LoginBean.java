/**
 * 
 */
package com.easysignage.cms.bean;

/**
 * @author Owner
 * 
 */
public class LoginBean {

	private String username;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	private String password;

	public LoginBean(String username, String passwd) {
		this.username = username;
		this.password = passwd;
	}
}
