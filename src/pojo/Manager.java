package pojo;

public class Manager {                                  //管理员实体类
	private String m_id;
	private String username;
	private String password;
	private String idnumber;
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
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
		return "Manager [m_id=" + m_id + ", username=" + username + ", password=" + password + ", idnumber=" + idnumber
				+ "]";
	}
}
