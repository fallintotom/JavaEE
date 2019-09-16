/*学生表的业务逻辑层*/

package service;

import java.util.List;
import pojo.Student;

public interface StudentService {
	public List<Student> queryAllStudents();
	public Student checkLogin(String username,String password);
	public int insertStudent(String s_id,String username,String password,String realname,String gender,String phone,String mail,String picturepath,String idnumber);
	public int deleteStudent(String username);
	public List<Student> searchStudent(String username,String realname,String gender,String phone,String mail);
	public int updateStudent(String s_id,String username,String realname,String gender,String phone,String mail,String picturepath,String idnumber);
	public int studentfindpassword(String idnumber,String password);
	public Student CheckStudentExist(String username,String idnumber);
	public Student findByUsername(String username);
	public int editStudent(String s_id,String username,String password,String realname,String gender,String phone,String mail,String idnumber,String textarea4,String textarea5,String textarea6);
}
