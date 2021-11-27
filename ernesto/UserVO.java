package es.unizar.sisinf.grp1.model;

import java.util.Date;

/**
 * tabla usuarioRegistrado
 * @author sisinf
 *
 */
public class UserVO {
	
	private String userName;
	private String password;
	private Date lastLogin;
	private boolean esAdmin;
	
	/**
	 * Constructor
	 * @param userName
	 * @param password
	 */
	public UserVO(String userName, String password) {
		this.userName = userName;
		this.password = password;
		this.esAdmin = false;
	}
	
	public UserVO(String userName, String password, boolean esAdmin) {
		this.userName = userName;
		this.password = password;
		this.esAdmin = esAdmin;
	}

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

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public boolean isEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}
	
}