package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pojo.Student;
import pojo.Teacher;
import service.QuestionService;
import service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	@Autowired
	QuestionService questionService;
	@RequestMapping("queryallstudents.do")     //遍历所有学生信息(管理员模块功能)
	public String queryallstudents(Student student,Model model,HttpServletRequest request){
		List<Student> list=studentService.queryAllStudents();
		request.setAttribute("list",list);
		request.setAttribute("picturepath", student.getPicturepath());
		return "WEB-INF/manager/queryallstudents";
	}
	@RequestMapping("searchstudent.do")        //管理员填写学生信息后提交查询学生表单后的响应方法
	public void searchstudent(Student student,Model model,HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		List<Student> list=studentService.searchStudent(student.getUsername(),student.getRealname(),student.getGender(),student.getPhone(),student.getMail());
		request.setAttribute("list",list);
		request.getRequestDispatcher("/WEB-INF/manager/queryallstudents.jsp").forward(request,response);
	}
	@RequestMapping("updatestudent.do")        //更新学生信息的控制器方法(管理员模块的功能)
	public String updatestudent(String s_id,String username,String realname,Student student,Model model,HttpServletRequest request,String gender,@RequestParam MultipartFile img)throws ServletException,IOException{
		String path=request.getRealPath("/upload/student");
    	//model.addAttribute("filename",path+"\\"+img.getOriginalFilename());
		model.addAttribute("filename","/upload/student/"+img.getOriginalFilename());
		if(s_id.equals(student.getS_id()))
		{
			String picturepath="/upload/student/"+img.getOriginalFilename();
			student.setS_id(s_id);
			student.setUsername(username);
			student.setPicturepath(picturepath);
		}
		try {
			IOUtils.copy(img.getInputStream(),new FileOutputStream(path+"/"+img.getOriginalFilename()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=studentService.updateStudent(student.getS_id(),student.getUsername(),student.getRealname(),student.getGender(),student.getPhone(),student.getMail(),student.getPicturepath(),student.getIdnumber());
		if(i>0){
			List<Student> list=studentService.queryAllStudents();
			request.setAttribute("list",list);
			return "WEB-INF/manager/queryallstudents";
		}else{
			return "fail";
		}
	}
	@RequestMapping("toinsertstudent.do")              //跳转到新增学生信息的页面(管理员模块的功能)
	public String toinsertstudent(Model model,Teacher teacher,Student student){
		Random rd1 = new Random();
		 int user_id=999999%rd1.nextInt(900000)+100000;
		 String s_id=String.valueOf(user_id);
		 if((String.valueOf(user_id).equals(student.getUsername())) && (String.valueOf(user_id).equals(teacher.getUsername()))){
			 user_id=999999%rd1.nextInt(900000)+100000;
			 s_id=String.valueOf(user_id);
		 }
		 model.addAttribute("s_id",s_id);
		return "WEB-INF/manager/insertstudent";
	}
	@RequestMapping("insertstudent.do")                //提交新增学生信息表单后的响应方法
	public String insertstudent(String s_id,Student student,Model model,HttpServletRequest request,@RequestParam MultipartFile img)throws ServletException,IOException{
		String path=request.getRealPath("/upload/student");
    	//model.addAttribute("filename",path+"\\"+img.getOriginalFilename());
		model.addAttribute("filename","/upload/student/"+img.getOriginalFilename());
		if(s_id.equals(student.getS_id())){
			String picturepath="/upload/student/"+img.getOriginalFilename();
			student.setPicturepath(picturepath);
		}
		IOUtils.copy(img.getInputStream(),new FileOutputStream(path+"/"+img.getOriginalFilename()));
		int i=studentService.insertStudent(student.getS_id(),student.getUsername(),student.getPassword(),student.getRealname(),student.getGender(),student.getPhone(),student.getMail(),student.getPicturepath(),student.getIdnumber());
		if(i>0){
			List<Student> list=studentService.queryAllStudents();
			request.setAttribute("list",list);
			return "WEB-INF/manager/queryallstudents";
		}else{
			return "fail";
		}
	}
	@RequestMapping("deletestudent.do")              //删除学生信息的相应方法(管理员模块的功能)
	public String deletestudent(Student student,Model model,HttpServletRequest request){
		int i=studentService.deleteStudent(student.getUsername());
		if(i>0){
			List<Student> list=studentService.queryAllStudents();
			request.setAttribute("list",list);
			return "WEB-INF/manager/queryallstudents";
		}else{
			return "fail";
		}
	}
	@RequestMapping("toupdatestudent.do")              //跳转至更新学生信息的页面(管理员模块的功能)
	public String toupdatestudent(String s_id,HttpSession session){
		session.setAttribute("s_id",s_id);
		return "WEB-INF/manager/updatestudent";
	}
	@RequestMapping("querystudentmessage.do")           //跳转至编辑学生个人信息表的页面(学生模块的功能)
	public String querystudentmessage(HttpSession session,Student student,String username,String s_id,String password,String realname,String gender,String phone,String mail,String picturepath,String idnumber,
			String textarea4,String textarea5,String textarea6){
		session.setAttribute("username",student.getUsername());
		student=studentService.findByUsername(username);
		if(student!=null){
			session.setAttribute("student",student);
			session.setAttribute("s_id",student.getS_id());
			session.setAttribute("password",student.getPassword());
			session.setAttribute("realname",student.getRealname());
			session.setAttribute("gender",student.getGender());
			session.setAttribute("phone",student.getPhone());
			session.setAttribute("mail",student.getMail());
			session.setAttribute("picturepath",student.getPicturepath());
			session.setAttribute("idnumber",student.getIdnumber());
			session.setAttribute("textarea4",student.getTextarea4());
			session.setAttribute("textarea5",student.getTextarea5());
			session.setAttribute("textarea6",student.getTextarea6());
			return "WEB-INF/student/studentpersonalmessage";
		}
		return "fail";
	}
	@RequestMapping("studentsave.do")                 //在学生个人信息表点击提交保存按钮后的响应方法
	public String studentsavemessage(String textarea4,HttpServletRequest request,String password,String textarea5,String textarea6,String s_id,Student student,HttpSession session){
		studentService.editStudent(student.getS_id(),student.getUsername(),student.getPassword(),student.getRealname(),student.getGender(),student.getPhone(),student.getMail(),student.getIdnumber(),
				student.getTextarea4(),student.getTextarea5(),student.getTextarea6());
		session.setAttribute("s_id",student.getS_id());
		session.setAttribute("password",student.getPassword());
		session.setAttribute("realname",student.getRealname());
		session.setAttribute("gender",student.getGender());
		session.setAttribute("phone",student.getPhone());
		session.setAttribute("mail",student.getMail());
		session.setAttribute("idnumber",student.getIdnumber());
		session.setAttribute("textarea4",textarea4);
		session.setAttribute("textarea5",textarea5);
		session.setAttribute("textarea6",textarea6);
		return "WEB-INF/student/studentpersonalmessage";
	}
}
