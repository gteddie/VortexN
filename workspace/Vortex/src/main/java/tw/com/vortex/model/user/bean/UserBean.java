package tw.com.vortex.model.user.bean;

import java.sql.Date;

public class UserBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int userId;
	private String username;
	private String password;
	private String email;
	private String image;
	private Date regDay;
	private String gender;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getRegDay() {
		return regDay;
	}

	public void setRegDay(Date regDay) {
		this.regDay = regDay;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}