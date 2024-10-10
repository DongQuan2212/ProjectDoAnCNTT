package vn.project.Model;

import java.io.Serializable;

public class UserModel implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private int id;
	private String username;
	private String password;
	private String email;
	private String images;
	private String fullname;
	private int roleid;
	public UserModel() {
		super();
	}
	
	public UserModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public UserModel(String username, String password, String email, String fullname) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.fullname = fullname;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", images=" + images + ", fullname=" + fullname + ", roleid=" + roleid + "]";
	}
		
	
	
	
	
	
}
