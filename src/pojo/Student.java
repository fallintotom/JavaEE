package pojo;

public class Student {                                //学生实体类
	private String s_id;
	private String username;
	private String password;
	private String realname;
	private String gender;
	private String phone;
	private String mail;
	private String picturepath;
	private String idnumber;
	private String textarea4;
	private String textarea5;
	private String textarea6;
	public String getTextarea4() {
		return textarea4;
	}
	public void setTextarea4(String textarea4) {
		this.textarea4 = textarea4;
	}
	public String getTextarea5() {
		return textarea5;
	}
	public void setTextarea5(String textarea5) {
		this.textarea5 = textarea5;
	}
	public String getTextarea6() {
		return textarea6;
	}
	public void setTextarea6(String textarea6) {
		this.textarea6 = textarea6;
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
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
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
	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", username=" + username + ", password=" + password + ", realname=" + realname
				+ ", gender=" + gender + ", phone=" + phone + ", mail=" + mail + ", picturepath=" + picturepath
				+ ", idnumber=" + idnumber + ", textarea4=" + textarea4 + ", textarea5=" + textarea5 + ", textarea6="
				+ textarea6 + "]";
	}
}
