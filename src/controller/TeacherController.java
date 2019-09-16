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
import pojo.Question;
import pojo.Student;
import pojo.Teacher;
import service.QuestionService;
import service.TeacherService;

@Controller
public class TeacherController {
	@Autowired
	TeacherService teacherService;
	@Autowired
	QuestionService questionService;
	@RequestMapping("teacherlogin.do")        //验证教师登录的响应方法(教师模块的功能)
	public String CheckLogin(Teacher teacher,HttpSession session,Model model){
		session.setAttribute("username", teacher.getUsername());
		teacher=teacherService.checkLogin(teacher.getUsername(), teacher.getPassword());
		if(teacher!=null){
			session.setAttribute("loginUserName", teacher.getUsername());
			return "WEB-INF/teacher/teacherindex";
		}else {
			return "fail";
		}
	}
	@RequestMapping("queryallteachers.do")      //遍历所有教师信息的响应方法(管理员模块的功能)
	public void queryAllTeachers(Model model,HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		List<Teacher> list=teacherService.queryAllTeachers();
		request.setAttribute("list",list);
		try {
			request.getRequestDispatcher("/WEB-INF/manager/queryallteachers.jsp").forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "redirect:queryallteachers.jsp";
	}
	@RequestMapping("updateteacher.do")               //提交更新教师信息表单后的响应方法(管理员模块的功能)
	public void updateteacher(String t_id,String username,Teacher teacher,Model model,HttpServletRequest request,HttpServletResponse response,@RequestParam MultipartFile img)throws ServletException,IOException{
		String path=request.getRealPath("/upload/teacher");
    	//model.addAttribute("filename",path+"\\"+img.getOriginalFilename());
		model.addAttribute("filename","/upload/teacher/"+img.getOriginalFilename());
		if(t_id.equals(teacher.getT_id()))
		{
			String picturepath="/upload/teacher/"+img.getOriginalFilename();
			teacher.setT_id(t_id);
			teacher.setUsername(username);
			teacher.setPicturepath(picturepath);
		}
		try {
			IOUtils.copy(img.getInputStream(),new FileOutputStream(path+"/"+img.getOriginalFilename()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=teacherService.updateTeacher(teacher.getT_id(),teacher.getUsername(),teacher.getPicturepath(),teacher.getIdnumber());
		if(i>0){
			List<Teacher> list=teacherService.queryAllTeachers();
			request.setAttribute("list",list);
			request.getRequestDispatcher("/WEB-INF/manager/queryallteachers.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("/fail.jsp").forward(request,response);
		}
	}
	@RequestMapping("toupdateteacher.do")                //跳转至更新教师信息页面的响应方法
	public String toupdateteacher(Teacher teacher,String t_id,HttpSession session){
		session.setAttribute("t_id",teacher.getT_id());
		return "WEB-INF/manager/updateteacher";
	}
	@RequestMapping("deleteteacher.do")                  //删除教师信息的相应方法(管理员模块的功能)
	public void deleteteacher(Teacher teacher,Model model,HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		int i=teacherService.deleteTeacher(teacher.getUsername());
		if(i>0){
			List<Teacher> list=teacherService.queryAllTeachers();
			request.setAttribute("list",list);
			request.getRequestDispatcher("/WEB-INF/manager/queryallteachers.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("/fail.jsp").forward(request,response);
		}
	}
	@RequestMapping("searchteacher.do")            //在遍历所有教师信息点击查询按钮后的相应方法(管理员模块的功能)
	public void searchteacher(Teacher teacher,Model model,HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		List<Teacher> list=teacherService.searchTeacher(teacher.getUsername());
		request.setAttribute("list",list);
		try {
			request.getRequestDispatcher("/WEB-INF/manager/queryallteachers.jsp").forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "queryallteachers";
	}
	@RequestMapping("insertteacher.do")               //新增教师信息的相应方法(管理员模块的功能)
	public void insertteacher(String t_id,String username,String password,Teacher teacher,Model model,HttpServletRequest request,HttpServletResponse response,@RequestParam MultipartFile img)throws ServletException,IOException{
		String path=request.getRealPath("/upload/teacher");
    	//model.addAttribute("filename",path+"\\"+img.getOriginalFilename());
		model.addAttribute("filename","/upload/teacher/"+img.getOriginalFilename());
		if(t_id.equals(teacher.getT_id())){
			String picturepath="/upload/teacher/"+img.getOriginalFilename();
			teacher.setPicturepath(picturepath);
		}
		IOUtils.copy(img.getInputStream(),new FileOutputStream(path+"/"+img.getOriginalFilename()));
		int i=teacherService.insertTeacher(teacher.getT_id(),teacher.getUsername(),teacher.getPassword(),teacher.getPicturepath(),teacher.getIdnumber());
		if(i>0){
			List<Teacher> list=teacherService.queryAllTeachers();
			request.setAttribute("list",list);
			request.getRequestDispatcher("/WEB-INF/manager/queryallteachers.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("/fail.jsp").forward(request,response);
		}
	}
	@RequestMapping("toinsertteacher.do")               //跳转至新增教师信息的页面(属于管理员的功能)
	public String toinsertteacher(Model model,Student student,Teacher teacher){
		 Random rd1 = new Random();
		 int user_id=9999%rd1.nextInt(9000)+1000;
		 String t_id=String.valueOf(user_id);
		 if((String.valueOf(user_id).equals(student.getUsername())) && (String.valueOf(user_id).equals(teacher.getUsername()))){
			 user_id=9999%rd1.nextInt(9000)+1000;
			 t_id=String.valueOf(user_id);
		 }
		 model.addAttribute("t_id",t_id);
		return "WEB-INF/manager/insertteacher";
	}
	@RequestMapping("teacherreturn.do")                 //在教师遍历所有答案页面点击“返回”键后的响应方法
	public String teacherreturn(Question question,HttpServletRequest request,HttpSession session,Model model,HttpServletResponse response)throws IOException,ServletException{
		List<Question> list=questionService.queryAllQuestions();
		request.setAttribute("list",list);
		return "WEB-INF/teacher/teacherqueryallquestions";
	}
	@RequestMapping("queryteachermessage.do")           //跳转至编辑教师个人信息表页面(教师模块的功能)
	public String queryteachermessage(HttpSession session,String t_id,Teacher teacher,String username,String password,String picturepath,String idnumber,String realname,String gender,String phone,String mail,String textarea1,String textarea2,String textarea3){
		session.setAttribute("username",teacher.getUsername());
		teacher=teacherService.findByUsername(username);
		if(teacher!=null){
			session.setAttribute("teacher",teacher);
			session.setAttribute("t_id",teacher.getT_id());
			session.setAttribute("password",teacher.getPassword());
			session.setAttribute("picturepath",teacher.getPicturepath());
			session.setAttribute("idnumber",teacher.getIdnumber());
			session.setAttribute("realname",teacher.getRealname());
			session.setAttribute("gender",teacher.getGender());
			session.setAttribute("phone",teacher.getPhone());
			session.setAttribute("mail",teacher.getMail());
			session.setAttribute("textarea1",teacher.getTextarea1());
			session.setAttribute("textarea2",teacher.getTextarea2());
			session.setAttribute("textarea3",teacher.getTextarea3());
			return "WEB-INF/teacher/teacherpersonalmessage";
		}else {
		return "fail";
		}
	} 
	@RequestMapping("teachersave.do")             //在教师个人信息表点击提交保存按钮后的响应方法
	public String teachersave(String t_id,String gender,String phone,String realname,String mail,String textarea1,String password,String textarea2,String textarea3,String s_id,Teacher teacher,HttpSession session){
		teacherService.editTeacher(teacher.getT_id(),teacher.getUsername(),teacher.getPassword(),teacher.getIdnumber(),teacher.getRealname(),teacher.getGender(),teacher.getPhone(),teacher.getMail()
				,teacher.getTextarea1(),teacher.getTextarea2(),teacher.getTextarea3());
		session.setAttribute("s_id",teacher.getT_id());
		session.setAttribute("password",teacher.getPassword());
		session.setAttribute("realname",realname);
		session.setAttribute("gender",gender);
		session.setAttribute("phone",phone);
		session.setAttribute("mail",mail);
		session.setAttribute("idnumber",teacher.getIdnumber());
		session.setAttribute("textarea1",textarea1);
		session.setAttribute("textarea2",textarea2);
		session.setAttribute("textarea3",textarea3);
		return "WEB-INF/teacher/teacherpersonalmessage";
	}
}
