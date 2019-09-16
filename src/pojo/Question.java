package pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
public class Question {                                   //问题实体类
	private String q_id;
	private String title;
	private String c_id;
	@DateTimeFormat(pattern="yyyy-MM-dd")                 //这里要注意对数据库时间字段类型的转换,以便之后的对应操作
	private Date q_time;
	private String type;
	private String q_username;
	public String getQ_username() {
		return q_username;
	}
	public void setQ_username(String q_username) {
		this.q_username = q_username;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQ_id() {
		return q_id;
	}
	public void setQ_id(String q_id) {
		this.q_id = q_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public Date getQ_time() {
		return q_time;
	}
	public void setQ_time(Date q_time) {
		this.q_time = q_time;
	}
	@Override
	public String toString() {
		return "Question [q_id=" + q_id + ", title=" + title + ", c_id=" + c_id + ", q_time=" + q_time + ", type="
				+ type + ", q_username=" + q_username + "]";
	}
}
