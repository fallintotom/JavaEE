package pojo;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Answer {                                   //答案实体类
	private String a_id;
	private String q_id;
	private String user_id;
	private String content;
	@DateTimeFormat(pattern="yyyy-MM-dd")               //这里注意对数据库有关时间字段类型格式的转换,以便之后对表的操作
	private Date a_time;
	private String type;
	private String picturepath;
	public String getPicturepath() {
		return picturepath;
	}
	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getQ_id() {
		return q_id;
	}
	public void setQ_id(String q_id) {
		this.q_id = q_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getA_time() {
		return a_time;
	}
	public void setA_time(Date a_time) {
		this.a_time = a_time;
	}
	@Override
	public String toString() {
		return "Answer [a_id=" + a_id + ", q_id=" + q_id + ", user_id=" + user_id + ", content=" + content + ", a_time="
				+ a_time + ", type=" + type + ", picturepath=" + picturepath + "]";
	}
}
