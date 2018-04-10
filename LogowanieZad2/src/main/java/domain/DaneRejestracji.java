package domain;

public class DaneRejestracji {
	String username;
	String password;
	String confPassword;
	String email;
	boolean uprPremium;
	boolean uprAdmin;
	
	public boolean isUprAdmin() {
		return uprAdmin;
	}
	public void setUprAdmin(boolean uprAdmin) {
		this.uprAdmin = uprAdmin;
	}
	public boolean isUprPremium() {
		return uprPremium;
	}
	public void setUprPremium(boolean uprPremium) {
		this.uprPremium = uprPremium;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfPassword() {
		return confPassword;
	}
	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
