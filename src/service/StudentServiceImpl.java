/*业务逻辑层学生表的继承实现类*/

package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.StudentDao;
import pojo.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
    StudentDao studentDao;
	@Override
	public List<Student> queryAllStudents() {
		// TODO Auto-generated method stub
		return studentDao.queryAllStudents();
	}
	@Override
	public Student checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		Student student=studentDao.findByUsername(username);
		if(student != null && student.getPassword().equals(password)){	
			return student;
		}
		return null;
	}
	@Override
	public int insertStudent(String s_id, String username, String password, String realname, String gender,
			String phone, String mail,String picturepath,String idnumber) {
		// TODO Auto-generated method stub
		return studentDao.insertStudent(s_id, username, password, realname, gender, phone, mail,picturepath,idnumber);
	}
	@Override
	public int deleteStudent(String username) {
		// TODO Auto-generated method stub
		return studentDao.deleteStudent(username);
	}
	@Override
	public List<Student> searchStudent(String username, String realname, String gender, String phone, String mail) {
		// TODO Auto-generated method stub
		return studentDao.searchStudent(username, realname, gender, phone, mail);
	}
	@Override
	public int updateStudent(String s_id,String username,String realname,String gender,String phone,String mail,
			String picturepath,String idnumber){
		// TODO Auto-generated method stub
		return studentDao.updateStudent(s_id,username,realname,gender,phone,mail,picturepath,idnumber);
	}
	@Override
	public int studentfindpassword(String idnumber,String password) {
		// TODO Auto-generated method stub
		return studentDao.studentfindpassword(idnumber,password);
	}
	@Override
	public Student CheckStudentExist(String username, String idnumber){
		// TODO Auto-generated method stub
		Student student=studentDao.findByUsername(username);
		if(student != null && student.getIdnumber().equals(idnumber)){	
			return student;
		}
		return null;
	}
	@Override
	public Student findByUsername(String username) {
		// TODO Auto-generated method stub
		Student student=studentDao.findByUsername(username);
				if(student != null){	
					return student;
				}
				return null;
	}
	@Override
	public int editStudent(String s_id, String username, String password, String realname, String gender, String phone,
			String mail, String idnumber,String textarea4,String textarea5,String textarea6) {
		// TODO Auto-generated method stub
		return studentDao.editStudent(s_id, username, password, realname, gender, phone, mail, idnumber,textarea4,textarea5,textarea6);
	}
}
