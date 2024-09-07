package LapTrinhWeb_Cha.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String email;
	private String password;
	private String images;
	private String fullname;
	private String avatar;
    private int roleid;
    private String phone;
    private Date createdDate;

	public UserModel() {
		super();
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
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



	public String getAvatar() {
		return avatar;
	}



	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}



	public int getRoleid() {
		return roleid;
	}



	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Date getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public UserModel(int id, String username, String email, String password, String images, String fullname,
			String avatar, int roleid, String phone, Date createdDate) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.images = images;
		this.fullname = fullname;
		this.avatar = avatar;
		this.roleid = roleid;
		this.phone = phone;
		this.createdDate = createdDate;
	}


	public String getPassWord() {
		return this.password.toString();
	}

}
