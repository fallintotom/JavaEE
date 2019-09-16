/*业务逻辑层教师表的继承实现类*/

package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.TeacherDao;
import pojo.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	TeacherDao teacherDao;
	@Override
	public List<Teacher> queryAllTeachers() {
		// TODO Auto-generated method stub
		return teacherDao.queryAllTeachers();
	}
	@Override
	public Teacher checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		Teacher teacher=teacherDao.findByUsername(username);
		if(teacher != null && teacher.getPassword().equals(password)){	
			return teacher;
		}
		return null;
	}
	@Override
	public int insertTeacher(String t_id, String username, String password,String picturepath,String idnumber){
		// TODO Auto-generated method stub
		return teacherDao.insertTeacher(t_id, username, password,picturepath,idnumber);
	}
	@Override
	public int deleteTeacher(String username) {
		// TODO Auto-generated method stub
		return teacherDao.deleteTeacher(username);
	}
	@Override
	public List<Teacher> searchTeacher(String username) {
		// TODO Auto-generated method stub
		return teacherDao.searchTeacher(username);
	}
	@Override
	public int updateTeacher(String t_id, String username,String picturepath,String idnumber) {
		// TODO Auto-generated method stub
		return teacherDao.updateTeacher(t_id, username,picturepath,idnumber);
	}
	@Override
	public Teacher CheckTeacherExist(String username, String idnumber) {
		// TODO Auto-generated method stub
		Teacher teacher=teacherDao.findByUsername(username);
		if(teacher != null && teacher.getIdnumber().equals(idnumber)){	
			return teacher;
		}
		return null;
	}
	@Override
	public int teacherfindpassword(String idnumber, String password) {
		// TODO Auto-generated method stub
		return teacherDao.teacherfindpassword(idnumber, password);
	}
	@Override
	public Teacher findByUsername(String username) {
		// TODO Auto-generated method stub
		Teacher teacher=teacherDao.findByUsername(username);
		if(teacher != null){	
			return teacher;
		}
		return null;
	}
	@Override
	public int editTeacher(String t_id, String username, String password, String idnumber,String realname,String gender,
			String phone,String mail,String textarea1,String textarea2,String textarea3) {
		// TODO Auto-generated method stub
		return teacherDao.editTeacher(t_id, username, password, idnumber,realname,gender,phone,mail,textarea1,textarea2,textarea3);
	}

}
