
public class Account {

	private String username;
	private String password;
	private String bio;
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
		bio = "";
	}

	
	// Encapsulation
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
	// Functions
	public void changePass(String newPass) {
		password = newPass;
	}
	
	public void editBio(String newBio) {
		bio = newBio;
	}
	
	public String getInfo() {
		return "username: " + username + "\npassword: " + password + "\nbio: " + bio;
	}
}
