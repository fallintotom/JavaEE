/*教师表的业务逻辑层*/

package service;

import java.util.List;
import pojo.Teacher;

public interface TeacherService {
	public List<Teacher> queryAllTeachers();
	public Teacher checkLogin(String username,String password);
	public int insertTeacher(String t_id,String username,String password,String picturepath,String idnumner);
	public int deleteTeacher(String username);
	public List<Teacher> searchTeacher(String username);
	public int updateTeacher(String t_id,String username,String picturepath,String idnumber);
	public Teacher CheckTeacherExist(String username,String idnumber);
	public int teacherfindpassword(String idnumber,String password);
	public Teacher findByUsername(String username);
	public int editTeacher(String t_id,String username,String password,String idnumber,String realname,String gender,String phone,String mail,String textarea1,String textarea2,String textarea3);
}
