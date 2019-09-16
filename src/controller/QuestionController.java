package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Chapter;
import pojo.Question;
import pojo.Student;
import pojo.Teacher;
import service.ChapterService;
import service.QuestionService;
import service.StudentService;
import service.TeacherService;

@Controller
public class QuestionController {
	@Autowired
	QuestionService questionService;
	@Autowired
	ChapterService chapterService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	StudentService studentService;
	@RequestMapping("insertquestion.do")                  //新增问题的相应方法(学生模块的功能)
	public String insertquestion(Question question,Model model,HttpServletResponse response,String type,HttpServletRequest request)throws IOException,ServletException{
		type=request.getParameter("type");
		int i=questionService.insertQuestion(question.getQ_id(),question.getTitle(),question.getC_id(),question.getQ_time(),type,question.getQ_username());
		if(i>0){
			List<Question> list=questionService.queryAllQuestions();
			model.addAttribute("list",list);
			return "WEB-INF/student/queryallquestions";
		}else{
			//request.getRequestDispatcher("/fail.jsp").forward(request,response);
			return "fail";
		}
	}
	//跳转至学生提出问题页面
	@RequestMapping("toinsertquestion.do")
	public String toinsertquestion(Model model,Question question,String c_id,HttpSession session){
		Random rd1 = new Random();
		 int question_id=999999%rd1.nextInt(900000)+100000;
		 String q_id=String.valueOf(question_id);
		 if((String.valueOf(q_id).equals(question.getQ_id()))){
			 question_id=999999%rd1.nextInt(900000)+100000;
			 q_id=String.valueOf(question_id);
		 }
		 model.addAttribute("q_id",q_id);
		session.setAttribute("c_id",c_id);
		return "WEB-INF/student/insertquestion";
	}
	//跳转至教师提出问题页面
	@RequestMapping("toteacherinsertquestion.do")
	public String toteacherinsertquestion(Model model,Question question,String c_id,HttpSession session,Chapter chapter){
		Random rd1 = new Random();
		 int question_id=999999%rd1.nextInt(900000)+100000;
		 String q_id=String.valueOf(question_id);
		 if((String.valueOf(question_id).equals(question.getQ_id()))){
			 question_id=999999%rd1.nextInt(900000)+100000;
			 q_id=String.valueOf(question_id);
		 }
		 model.addAttribute("q_id",q_id);
		session.setAttribute("c_id",chapter.getC_id());
		return "WEB-INF/teacher/teacherinsertquestion";
	}
	@RequestMapping("teacherinsertquestion.do")          //新增问题信息的响应方法(教师模块的功能)
	public String teacherinsertquestion(Question question,Model model,HttpServletResponse response,String type,HttpServletRequest request)throws IOException,ServletException{
		type=request.getParameter("type");
		int i=questionService.insertQuestion(question.getQ_id(),question.getTitle(),question.getC_id(),question.getQ_time(),type,question.getQ_username());
		if(i>0){
			List<Question> list=questionService.queryAllQuestions();
			request.setAttribute("list",list);
			return "WEB-INF/teacher/teacherqueryallquestions";
		}else{
			//request.getRequestDispatcher("/fail.jsp").forward(request,response);
			return "fail";
		}
	}
	@RequestMapping("searchquestion.do")                   //在遍历所有问题页面提交查询问题按钮后的响应方法(学生模块的功能)
	public String searchquestion(Question question,Model model,HttpSession session,String username) throws ParseException{
		List<Question> list=questionService.searchQuestion(question.getQ_id(),question.getTitle(),question.getC_id(),question.getQ_time(),question.getType(),question.getQ_username());
		session.setAttribute("title",question.getTitle());
		session.setAttribute("type",question.getType());
		session.setAttribute("username",username);
		System.out.println(username);
		model.addAttribute("list",list);
		return "WEB-INF/student/queryallquestions";
	}
	@RequestMapping("teachersearchquestion.do")            //在遍历所有问题页面点击查询问题按钮后的响应方法(教师模块的功能)
	public String teachersearchquestion(Question question,Model model,HttpSession session) throws ParseException{
		List<Question> list=questionService.searchQuestion(question.getQ_id(),question.getTitle(),question.getC_id(),question.getQ_time(),question.getType(),question.getQ_username());
		session.setAttribute("title",question.getTitle());
		session.setAttribute("type",question.getType());
		model.addAttribute("list",list);
		return "WEB-INF/teacher/teacherqueryallquestions";
	}
	@RequestMapping("queryallquestions.do")                 //遍历所有问题信息的相应方法(教师模块的功能)
	public String queryallquestions(HttpSession session,Teacher teacher,String username,Question question,Model model){
		List<Question> list=questionService.queryAllQuestions();
		teacher=teacherService.findByUsername(username);
		session.setAttribute("teacher",teacher);
		session.setAttribute("id",teacher.getT_id());
		model.addAttribute("list",list);
		return "WEB-INF/teacher/teacherqueryallquestions";
	}
	@RequestMapping("deletequestion.do")                     //删除问题信息的响应方法(教师模块的功能)
	public String deletequestion(Model model,Question question,HttpServletRequest request,String q_id){
		int i=questionService.deleteQuestion(question.getQ_id());
		if(i>0){
			List<Question> list=questionService.queryAllQuestions();
			request.setAttribute("list",list);
			return "WEB-INF/teacher/teacherqueryallquestions";
		}else{
			return "fail";
		}
	}
	//学生在学生模块遍历所有问题页面点击编辑问题链接后跳转至编辑问题页面的响应方法
	@RequestMapping("tostudentupdatequestion.do")
	public String tostudentupdatequestion(Model model,String q_username,String username,HttpSession session,String q_id,String title,String c_id,String type){
		session.setAttribute("q_id",q_id);
		session.setAttribute("title",title);
		session.setAttribute("c_id",c_id);
		session.setAttribute("type",type);
		if(username.equals(q_username)){
			session.setAttribute("username",username);
			session.setAttribute("q_username",q_username);
			return "WEB-INF/student/studentupdatequestion";
		}else{
			return "WEB-INF/student/studentupdatequestionfail";
		}
	}
	//教师在教师模块遍历所有问题页面点击编辑问题链接后跳转至编辑问题页面的响应方法
	@RequestMapping("toteacherupdatequestion.do")
	public String toteacherupdatequestion(String q_username,HttpSession session,String q_id,String title,String c_id,String type){
		session.setAttribute("q_id",q_id);
		session.setAttribute("title",title);
		session.setAttribute("c_id",c_id);
		session.setAttribute("type",type);
		session.setAttribute("q_username",q_username);
		return "WEB-INF/teacher/teacherupdatequestion";
	}
	//学生编辑问题的响应方法
	@RequestMapping("studentupdatequestion.do")
	public String studentupdatequestion(Model model,Question question){
		int i=questionService.updateQuestion(question.getQ_id(),question.getTitle(),question.getC_id(),question.getQ_time(),question.getType(),question.getQ_username());
		if(i>0){
			List<Question> list=questionService.queryAllQuestions();
			model.addAttribute("list",list);
			return "WEB-INF/student/queryallquestions";
		}
		return "fail";
	}
	//教师编辑问题的响应方法
		@RequestMapping("teacherupdatequestion.do")
		public String teacherupdatequestion(Model model,Question question){
			int i=questionService.updateQuestion(question.getQ_id(),question.getTitle(),question.getC_id(),question.getQ_time(),question.getType(),question.getQ_username());
			if(i>0){
				List<Question> list=questionService.queryAllQuestions();
				model.addAttribute("list",list);
				return "WEB-INF/teacher/teacherqueryallquestions";
			}
			return "fail";
		}
}
