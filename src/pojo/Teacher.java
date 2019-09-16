package pojo;

public class Teacher {                                   //教师实体类
	private String t_id;
	private String username;
	private String password;
	private String picturepath;
	private String idnumber;
	private String realname;
	private String gender;
	private String phone;
	private String mail;
	private String textarea1;
	private String textarea2;
	private String textarea3;
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTextarea1() {
		return textarea1;
	}
	public void setTextarea1(String textarea1) {
		this.textarea1 = textarea1;
	}
	public String getTextarea2() {
		return textarea2;
	}
	public void setTextarea2(String textarea2) {
		this.textarea2 = textarea2;
	}
	public String getTextarea3() {
		return textarea3;
	}
	public void setTextarea3(String textarea3) {
		this.textarea3 = textarea3;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getPicturepath() {
		return picturepath;
	}
	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
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
	@Override
	public String toString() {
		return "Teacher [t_id=" + t_id + ", username=" + username + ", password=" + password + ", picturepath="
				+ picturepath + ", idnumber=" + idnumber + ", realname=" + realname + ", gender=" + gender + ", phone="
				+ phone + ", mail=" + mail + ", textarea1=" + textarea1 + ", textarea2=" + textarea2 + ", textarea3="
				+ textarea3 + "]";
	}
}
