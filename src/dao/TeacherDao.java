/*以下是对教师表的基本方法声明*/

package dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Teacher;

public interface TeacherDao {
	public List<Teacher> queryAllTeachers();
	public Teacher findByUsername(@Param("username")String username);
	public int insertTeacher(@Param("t_id")String t_id,@Param("username")String username,@Param("password")String password,@Param("picturepath")String picturepath,@Param("idnumber")String idnumber);
	public int deleteTeacher(@Param("username")String username);
	public List<Teacher> searchTeacher(@Param("username")String username);
	public int updateTeacher(@Param("t_id")String t_id,@Param("username")String username,@Param("picturepath")String picturepath,@Param("idnumber")String idnumber);
	public int teacherfindpassword(@Param("idnumber")String idnumber,@Param("password")String password);
	//当教师表内用户忘记密码时重置密码。
	public int editTeacher(@Param("t_id")String t_id,@Param("username")String username,@Param("password")String password,@Param("idnumber")String idnumber,@Param("realname")String realname,@Param("gender")String gender,@Param("phone")String phone,@Param("mail")String mail,@Param("textarea1")String textarea1,@Param("textarea2")String textarea2,@Param("textarea3")String textarea3);
}
