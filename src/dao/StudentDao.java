/*以下是对学生表的基本操作方法声明*/

package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import pojo.Student;


public interface StudentDao {
	public List<Student> queryAllStudents();
	public Student findByUsername(@Param("username")String username);
	public int insertStudent(@Param("s_id")String s_id,@Param("username")String username,@Param("password")String password,@Param("realname")String realname,@Param("gender")String gender,@Param("phone")String phone,@Param("mail")String mail,@Param("picturepath")String picturepath,@Param("idnumber")String idnumber);
	public int deleteStudent(@Param("username")String username);
	public List<Student> searchStudent(@Param("username")String username,@Param("realname")String realname,@Param("gender")String gender,@Param("phone")String phone,@Param("mail")String mail);
	public int updateStudent(@Param("s_id")String s_id,@Param("username")String username,@Param("realname")String realname,@Param("gender")String gender,@Param("phone")String phone,@Param("mail")String mail,@Param("picturepath")String picturepath,@Param("idnumber")String idnumber);
	public int studentfindpassword(@Param("idnumber")String idnumber,@Param("password")String password);
	//当学生表内用户忘记密码时重置密码。
	public int editStudent(@Param("s_id")String s_id,@Param("username")String username,@Param("password")String password,@Param("realname")String realname,@Param("gender")String gender,@Param("phone")String phone,@Param("mail")String mail,@Param("idnumber")String idnumber,@Param("textarea4")String textarea4,@Param("textarea5")String textarea5,@Param("textarea6")String textarea6);
}
