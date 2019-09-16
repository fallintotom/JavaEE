package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Manager;
import pojo.Student;
import pojo.Teacher;
import service.ChapterService;
import service.ManagerService;
import service.QuestionService;
import service.StudentService;
import service.TeacherService;

@Controller
public class LoginController {
	@Autowired
	QuestionService questionService;
	@Autowired
	ChapterService chapterService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	StudentService studentService;
	@Autowired
	ManagerService managerService;
	@RequestMapping("login.do")               //��ʦ��ѧ��������Ա���ߵĵ�¼���ܵ�ʵ��
	public String login(String username,String password,HttpSession session,Student student,Teacher teacher,Manager manager,String id){
		if(id.equals("student")){
			session.setAttribute("username", student.getUsername());
			student=studentService.checkLogin(student.getUsername(), student.getPassword());
			if(student!=null){
				session.setAttribute("loginUserName", student.getUsername());
				return "WEB-INF/student/index";
			}else {
				return "fail";
			}
		}else if(id.equals("teacher")){
			session.setAttribute("username", teacher.getUsername());
			teacher=teacherService.checkLogin(teacher.getUsername(), teacher.getPassword());
			if(teacher!=null){
				session.setAttribute("loginUserName", teacher.getUsername());
				return "WEB-INF/teacher/teacherindex";
			}else {
				return "fail";
			}
		}else if(id.equals("manager")){
			session.setAttribute("username",manager.getUsername());
			manager=managerService.CheckLogin(manager.getUsername(),manager.getPassword());
			if(manager!=null){
				session.setAttribute("manager",manager);
				session.setAttribute("LoginUserName",manager.getUsername());
				return "WEB-INF/manager/manager";
			}else{
				return "fail";
			}
		}
		else if(((id.equals(null)) && (id.equals(""))) || ((username.equals(null)) && username.equals("")) || ((password.equals(null)) && (password.equals("")))){
			return "fail";
		}
		System.out.println(username+"...");
		System.out.println(password+"...");
		return "fail";
	}
	@RequestMapping("logout.do")                   //ע�����ܵ���Ӧ����
	public String tologout(Student student,HttpSession session,HttpServletRequest request,Teacher teacher){
		request.getSession().removeAttribute("loginUserName");
		session.invalidate();
		return "logout";
	}
	@RequestMapping("key.do")               //�ڵ�¼ҳ���������������Ӻ����Ӧ����
	public String studentkey(String username,HttpSession session,Student student,Teacher teacher){
		username=(String)session.getAttribute(username);
		session.setAttribute("username",username);
		return "WEB-INF/forgetpassword/checkmessage";
	}
	@RequestMapping("checkmessage.do")        //��֤�����Լ�������֮ǰ��������Ϣ��ȷ������Ӧ����(�����ܱ���������Ϊѧ���ĸ������֤��)
	public String findpassword(String id,Model model,Manager manager,Teacher teacher,String password,HttpSession session,String username,Student student,String idnumber,HttpServletRequest request){
		student=studentService.findByUsername(username);
		teacher=teacherService.findByUsername(username);
		manager=managerService.findByUsername(username);
		model.addAttribute("student",student);
		model.addAttribute("teacher",teacher);
		model.addAttribute("manager",manager);
		if((student!=null) && (username.equals(student.getUsername()))){
			session.setAttribute("username",username);
			student=studentService.CheckStudentExist(student.getUsername(),student.getIdnumber());
			if(student!=null && student.getIdnumber().equals(idnumber)){
				session.setAttribute("student", student);
				session.setAttribute("idnumber",student.getIdnumber());
				return "WEB-INF/forgetpassword/findpassword";
				}else{
					return "WEB-INF/forgetpassword/checkmessagefail";
				}
		}else if((teacher!=null) &&(username.equals(teacher.getUsername()))){
			session.setAttribute("username",username);
			teacher=teacherService.CheckTeacherExist(teacher.getUsername(),teacher.getIdnumber());
			if(teacher!=null && teacher.getIdnumber().equals(idnumber)){
				session.setAttribute("teacher",teacher);
				session.setAttribute("idnumber",teacher.getIdnumber());
				return "WEB-INF/forgetpassword/findpassword";
			}
			else{
				return "WEB-INF/forgetpassword/checkmessagefail";
			}
		}else if((manager!=null) &&(username.equals(manager.getUsername()))){
			session.setAttribute("username",username);
			manager=managerService.CheckManagerExist(manager.getUsername(),manager.getIdnumber());
			if(manager!=null && manager.getIdnumber().equals(idnumber)){
				session.setAttribute("manager",manager);
				session.setAttribute("idnumber",manager.getIdnumber());
				return "WEB-INF/forgetpassword/findpassword";
			}
			else{
				return "WEB-INF/forgetpassword/checkmessagefail";
			}
		}
			return "WEB-INF/forgetpassword/checkmessagefail";
	}
	@RequestMapping("inputpasswordagain.do")        //ѧ������������ʧ�ܺ�����������ʧ��ҳ����������д���밴ť�����Ӧ����
	public String studentinputpasswordagain(String idnumber,Student student,HttpSession session){
		session.getAttribute(idnumber);
		session.setAttribute("idnumber",student.getIdnumber());
		return "WEB-INF/forgetpassword/findpassword";
	}
	@RequestMapping("findpassword.do")              //��ѧ���ύ��������������Ӧ����
	public String studentfindpassword(Model model,String username,Student student,Teacher teacher,Manager manager,String password1,String idnumber,String password,HttpSession session){
		session.setAttribute("idnumber",student.getIdnumber());
		student=studentService.findByUsername(username);
		teacher=teacherService.findByUsername(username);
		manager=managerService.findByUsername(username);
		model.addAttribute("student",student);
		model.addAttribute("teacher",teacher);
		model.addAttribute("manager",manager);
		if(student!=null) {
		if((!student.getPassword().equals(null)) && (!student.getPassword().equals("")) && (password.equals(password1))){
		int i=studentService.studentfindpassword(idnumber,password);
		if(i>0){
			return "WEB-INF/forgetpassword/findpasswordsuccess";
		}else{
			return "WEB-INF/forgetpassword/findpasswordfail";
		}
		}else{
			return "WEB-INF/forgetpassword/findpasswordfail";
		}
		}else if(teacher!=null){
		if((!teacher.getPassword().equals(null)) && (!teacher.getPassword().equals("")) && (password.equals(password1))){
		int i=teacherService.teacherfindpassword(idnumber,password);
		if(i>0){
			return "WEB-INF/forgetpassword/findpasswordsuccess";
		}else{
			return "WEB-INF/forgetpassword/findpasswordfail";
		}
		}else{
			return "WEB-INF/forgetpassword/findpasswordfail";
		}
		}else if(manager!=null){
			    if((!manager.getPassword().equals(null)) && (!manager.getPassword().equals("")) && (password.equals(password1))){
				int i=managerService.managerfindpassword(idnumber,password);
				if(i>0){
					return "WEB-INF/forgetpassword/findpasswordsuccess";
					}else{
						return "WEB-INF/forgetpassword/findpasswordfail";
					}
					}else{
						return "WEB-INF/forgetpassword/findpasswordfail";
					}
			   }
			return "WEB-INF/forgetpassword/findpasswordfail";
	}
	@RequestMapping("returnteacherindex.do")           //�ڽ�ʦ������Ϣ��ҳ����ȡ�����ذ�ť�����Ӧ����
	public String returnteacherindex(){
		return "WEB-INF/teacher/teacherindex";
	}
	@RequestMapping("returnstudentindex.do")          //��ѧ��������Ϣ��ҳ����ȡ�����ذ�ť�����Ӧ����
	public String returnstudentindex(){
		return "WEB-INF/student/index";
	}
}
