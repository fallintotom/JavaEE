package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
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

import pojo.Answer;
import pojo.Student;
import service.AnswerService;
import service.QuestionService;

@Controller
public class AnswerController {
	@Autowired
	AnswerService answerService;
	@Autowired
	QuestionService questionService;
	@RequestMapping("searchanswer.do")            //在遍历所有问题界面点击查询答案链接后的响应方法(学生模块的功能)
	public String searchanswer(Answer answer,Model model,String type,HttpSession session,HttpServletRequest request,HttpServletResponse response,String title)throws IOException,ServletException{
		session.getAttribute(type);
		session.getAttribute(title);
		List<Answer> listpt=answerService.searchAnswer(answer.getA_id(),answer.getQ_id(),answer.getUser_id(),answer.getContent(),answer.getA_time(),type);
		model.addAttribute("listpt", listpt);
		session.setAttribute("user_id",answer.getUser_id());
		try {
			session.setAttribute("title",title);
			session.setAttribute("type",type);
			//request.getRequestDispatcher("/WEB-INF/teacher/teacherqueryallanswers.jsp").forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "WEB-INF/student/queryallanswers";
	}
	@RequestMapping("toinsertanswer.do")            //在学生遍历所有问题界面点击答疑解惑链接后根据问题类型跳转至相应新增答案页面的响应方法(学生模块的功能)
	public String toinsertanswer(Model model,Answer answer,String type,String title,HttpSession session,String q_id,String c_id) {
		Random rd1 = new Random();
		 int answer_id=999999%rd1.nextInt(900000)+100000;
		 String a_id=String.valueOf(answer_id);
		 if((String.valueOf(answer_id).equals(answer.getA_id()))){
			 answer_id=999999%rd1.nextInt(900000)+100000;
			 a_id=String.valueOf(answer_id);
		 }
		 model.addAttribute("a_id",a_id);
		if(type.equals("Radio")){
			session.setAttribute("q_id",q_id);
			session.setAttribute("c_id",c_id);
			session.setAttribute("type",type);
			session.setAttribute("title",title);
			 model.addAttribute("a_id",a_id);
			return "WEB-INF/student/insertanswerradio";
		}else if(type.equals("Checkbox")){
			session.setAttribute("q_id",q_id);
			session.setAttribute("c_id",c_id);
			session.setAttribute("type",type);
			session.setAttribute("title",title);
			 model.addAttribute("a_id",a_id);
			return "WEB-INF/student/insertanswercheckbox";
		}else if(type.equals("Content")){
			session.setAttribute("q_id",q_id);
			session.setAttribute("c_id",c_id);
			session.setAttribute("type",type);
			session.setAttribute("title",title);
			 model.addAttribute("a_id",a_id);
			return "WEB-INF/student/insertanswercontent";
		}else if(type.equals("Judge")){
			session.setAttribute("q_id",q_id);
			session.setAttribute("c_id",c_id);
			session.setAttribute("type",type);
			session.setAttribute("title",title);
			 model.addAttribute("a_id",a_id);
			return "WEB-INF/student/insertanswerjudge";
		}else{
			return "fail";
		}
	}
	@RequestMapping("toteacherinsertanswer.do")         //在教师遍历所有问题界面点击答疑解惑链接后根据问题类型跳转至相应新增答案页面的响应方法(教师模块的功能)
	public String toteacherinsertanswer(Model model,Answer answer,String type,String title,HttpSession session,String q_id,String c_id) {
		Random rd1 = new Random();
		 int answer_id=999999%rd1.nextInt(900000)+100000;
		 String a_id=String.valueOf(answer_id);
		 if((String.valueOf(answer_id).equals(answer.getA_id()))){
			 answer_id=999999%rd1.nextInt(900000)+100000;
			 a_id=String.valueOf(answer_id);
		 }
		 model.addAttribute("a_id",a_id);
		if(type.equals("Radio")){
			session.setAttribute("q_id",q_id);
			session.setAttribute("c_id",c_id);
			session.setAttribute("type",type);
			session.setAttribute("title",title);
			return "WEB-INF/teacher/teacherinsertanswerradio";
		}else if(type.equals("Checkbox")){
			session.setAttribute("q_id",q_id);
			session.setAttribute("c_id",c_id);
			session.setAttribute("type",type);
			session.setAttribute("title",title);
			return "WEB-INF/teacher/teacherinsertanswercheckbox";
		}else if(type.equals("Content")){
			session.setAttribute("q_id",q_id);
			session.setAttribute("c_id",c_id);
			session.setAttribute("type",type);
			session.setAttribute("title",title);
			return "WEB-INF/teacher/teacherinsertanswercontent";
		}else if(type.equals("Judge")){
			session.setAttribute("q_id",q_id);
			session.setAttribute("c_id",c_id);
			session.setAttribute("type",type);
			session.setAttribute("title",title);
			return "WEB-INF/teacher/teacherinsertanswerjudge";
		}else{
			return "fail";
		}
	}
	@RequestMapping("insertanswer.do")        //学生新增答案信息的响应方法(当增加答案信息时如需要插入图片可以直接在此插入)
	public String insertanswer(String a_id,Answer answer,Model model,HttpSession session,String title,HttpServletRequest request,HttpServletResponse response,@RequestParam MultipartFile img)throws ServletException,IOException{
		String path=request.getRealPath("/upload/answer");
    	//model.addAttribute("filename",path+"\\"+img.getOriginalFilename());
		model.addAttribute("filename","/upload/answer/"+img.getOriginalFilename());
		if(a_id.equals(answer.getA_id())){
			String picturepath="/upload/answer/"+img.getOriginalFilename();
			answer.setPicturepath(picturepath);
		}
		IOUtils.copy(img.getInputStream(),new FileOutputStream(path+"/"+img.getOriginalFilename()));
		int i=answerService.insertAnswer(answer.getA_id(),answer.getQ_id(),answer.getUser_id(),answer.getContent(),answer.getA_time(),answer.getType(),answer.getPicturepath());
		if(i>0){
			List<Answer> listpt=answerService.searchAnswer(answer.getA_id(),answer.getQ_id(),answer.getUser_id(),answer.getContent(),answer.getA_time(),answer.getType());
			session.setAttribute("listpt",listpt);
			return "WEB-INF/student/queryallanswers";
		}else{
			return "fail";
		}
	}
	@RequestMapping("teacherinsertanswer.do")           //教师新增答案信息的响应方法(当增加答案信息时如需要插入图片可以直接在此插入)
	public String teacherinsertanswer(String a_id,Answer answer,Model model,HttpSession session,String title,HttpServletRequest request,HttpServletResponse response,@RequestParam MultipartFile img)throws ServletException,IOException{
		String path=request.getRealPath("/upload/answer");
    	//model.addAttribute("filename",path+"\\"+img.getOriginalFilename());
		model.addAttribute("filename","/upload/answer/"+img.getOriginalFilename());
		if(a_id.equals(answer.getA_id())){
			String picturepath="/upload/answer/"+img.getOriginalFilename();
			answer.setPicturepath(picturepath);
		}
		IOUtils.copy(img.getInputStream(),new FileOutputStream(path+"/"+img.getOriginalFilename()));
		int i=answerService.insertAnswer(answer.getA_id(),answer.getQ_id(),answer.getUser_id(),answer.getContent(),answer.getA_time(),answer.getType(),answer.getPicturepath());
		if(i>0){
			List<Answer> listpt=answerService.queryAllAnswers();
			session.setAttribute("listpt",listpt);
			return "WEB-INF/teacher/teacherqueryallanswers";
		}else{
			return "fail";
		}
	}
	@RequestMapping("updateanswer.do")          //这里可以更新图片(学生模块的功能)
	public String updateanswer(String a_id,String q_id,String user_id,String content,String type,String a_time,Answer answer,HttpServletRequest request,HttpSession session,Model model,HttpServletResponse response,@RequestParam MultipartFile img)throws IOException,ServletException{
		String path=request.getRealPath("/upload/answer");
    	//model.addAttribute("filename",path+"\\"+img.getOriginalFilename());
		model.addAttribute("filename","/upload/answer/"+img.getOriginalFilename());
		if(a_id.equals(answer.getA_id()))
		{
			String picturepath="/upload/answer/"+img.getOriginalFilename();
			answer.setPicturepath(picturepath);
		}
		try {
			IOUtils.copy(img.getInputStream(),new FileOutputStream(path+"/"+img.getOriginalFilename()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getParameter(type);
		int i=answerService.updateAnswer(answer.getA_id(),answer.getQ_id(),answer.getUser_id(),answer.getContent(),answer.getA_time(),type,answer.getPicturepath());
		if(i>0){
			session.setAttribute("a_id",answer.getA_id());
			session.setAttribute("q_id",answer.getQ_id());
			session.setAttribute("user_id",answer.getUser_id());
			session.setAttribute("content",answer.getContent());
			session.setAttribute("type",answer.getType());
			session.setAttribute("picturepath",answer.getPicturepath());
			List<Answer> listpt=answerService.searchAnswer(answer.getA_id(),answer.getQ_id(),answer.getUser_id(),answer.getContent(),answer.getA_time(),answer.getType());
			model.addAttribute("listpt",listpt);
			//request.getRequestDispatcher("/queryallanswers.jsp").forward(request,response);
			return "WEB-INF/student/queryallanswers";
		}else{
			//request.getRequestDispatcher("/fail.jsp").forward(request,response);
			return "fail";
		}
	}
	@RequestMapping("teacherupdateanswer.do")       //这里可以更新图片(教师模块的功能)
	public String teacherupdateanswer(String a_id,String q_id,String user_id,String content,String a_time,Answer answer,HttpServletRequest request,String type,HttpSession session,Model model,HttpServletResponse response,@RequestParam MultipartFile img)throws IOException,ServletException{
		String path=request.getRealPath("/upload/student");
    	//model.addAttribute("filename",path+"\\"+img.getOriginalFilename());
		model.addAttribute("filename","/upload/student/"+img.getOriginalFilename());
		if(a_id.equals(answer.getA_id()))
		{
			String picturepath="/upload/student/"+img.getOriginalFilename();
			answer.setA_id(a_id);
			answer.setQ_id(q_id);
			answer.setUser_id(user_id);
			answer.setContent(content);
			//answer.setA_time(a_time);
			answer.setType(type);
			answer.setPicturepath(picturepath);
		}
		try {
			IOUtils.copy(img.getInputStream(),new FileOutputStream(path+"/"+img.getOriginalFilename()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=answerService.updateAnswer(answer.getA_id(),answer.getQ_id(),answer.getUser_id(),answer.getContent(),answer.getA_time(),answer.getType(),answer.getPicturepath());
		if(i>0){
			System.out.println(answer);
			System.out.println(answer.getContent());
			List<Answer> listpt=answerService.searchAnswer(answer.getA_id(),answer.getQ_id(),answer.getUser_id(),answer.getContent(),answer.getA_time(),answer.getType());
			request.setAttribute("listpt",listpt);
			return "WEB-INF/teacher/teacherqueryallanswers";
		}else{
			return "fail";
		}
	}
	@RequestMapping("toupdateanswer.do")      //在学生遍历所有答案界面点击编辑链接后根据问题类型跳转至相应编辑答案页面的响应方法(学生模块的功能)        
	public String toupdateanswer(String username,String type,String title,HttpSession session,String a_id,String q_id,String user_id){
		if((type.equals("Radio")) && (user_id.equals(username))){
			session.getAttribute(title);
			session.setAttribute("a_id",a_id);
			session.setAttribute("q_id",q_id);
			session.setAttribute("user_id",user_id);
			session.setAttribute("type",type);
			session.setAttribute("title",title);
			return "WEB-INF/student/updateanswerradio";
		}else if((type.equals("Content")) && (user_id.equals(username))){
			session.getAttribute(title);
			session.setAttribute("a_id",a_id);
			session.setAttribute("q_id",q_id);
			session.setAttribute("user_id",user_id);
			session.setAttribute("type",type);
			session.setAttribute("title",title);
			return "WEB-INF/student/updateanswercontent";
		}else if((type.equals("Checkbox")) && (user_id.equals(username))){
			session.getAttribute(title);
			session.setAttribute("a_id",a_id);
			session.setAttribute("q_id",q_id);
			session.setAttribute("user_id",user_id);
			session.setAttribute("type",type);
			session.setAttribute("title",title);
			return "WEB-INF/student/updateanswercheckbox";
		}else if((type.equals("Judge")) && (user_id.equals(username))){
			session.getAttribute(title);
			session.setAttribute("a_id",a_id);
			session.setAttribute("q_id",q_id);
			session.setAttribute("user_id",user_id);
			session.setAttribute("type",type);
			session.setAttribute("title",title);
			return "WEB-INF/student/updateanswerjudge";
		}else{
			return "WEB-INF/student/studentupdateanswerfail";
		}
	}
	@RequestMapping("toteacherupdateanswer.do")       //在教师遍历所有答案界面点击编辑链接后根据问题类型跳转至相应编辑答案页面的响应方法(教师模块的功能)
	public String toteacherupdateanswer(String type,String title,HttpSession session,String a_id,String q_id,String user_id){
		if(type.equals("Radio")){
			session.getAttribute(title);
			session.setAttribute("a_id",a_id);
			session.setAttribute("q_id",q_id);
			session.setAttribute("user_id",user_id);
			session.setAttribute("type",type);
			session.setAttribute("title",title);
			return "WEB-INF/teacher/teacherupdateanswerradio";
		}else if(type.equals("Content")){
			session.getAttribute(title);
			session.setAttribute("a_id",a_id);
			session.setAttribute("q_id",q_id);
			session.setAttribute("user_id",user_id);
			session.setAttribute("type",type);
			session.setAttribute("title",title);
			return "WEB-INF/teacher/teacherupdateanswercontent";
		}else if(type.equals("Checkbox")){
			session.getAttribute(title);
			session.setAttribute("a_id",a_id);
			session.setAttribute("q_id",q_id);
			session.setAttribute("user_id",user_id);
			session.setAttribute("type",type);
			session.setAttribute("title",title);
			return "WEB-INF/teacher/teacherupdateanswercheckbox";
		}else if(type.equals("Judge")){
			session.getAttribute(title);
			session.setAttribute("a_id",a_id);
			session.setAttribute("q_id",q_id);
			session.setAttribute("user_id",user_id);
			session.setAttribute("type",type);
			session.setAttribute("title",title);
			return "WEB-INF/teacher/teacherupdateanswerjudge";
		}else{
			return "fail";
		}
	}
	@RequestMapping("teachersearchanswer.do")          //在教师遍历所有问题页面点击查找答案链接后的响应方法(教师模块的功能)
	public String teachersearchanswer(String user_id,Answer answer,Model model,String type,HttpSession session,HttpServletRequest request,HttpServletResponse response,String title)throws IOException,ServletException{
		session.getAttribute(type);
		session.getAttribute(title);
		List<Answer> listpt=answerService.searchAnswer(answer.getA_id(),answer.getQ_id(),answer.getUser_id(),answer.getContent(),answer.getA_time(),type);
		model.addAttribute("listpt", listpt);
		session.setAttribute("user_id",answer.getUser_id());
		try {
			session.setAttribute("title",title);
			session.setAttribute("type",type);
			//request.getRequestDispatcher("/WEB-INF/teacher/teacherqueryallanswers.jsp").forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "WEB-INF/teacher/teacherqueryallanswers";
	}
	@RequestMapping("deleteanswer.do")            //在教师遍历所有问题页面点击删除问题链接后的响应方法(教师模块的功能)
	public String deleteanswer(String a_id,HttpSession session,Model model,Answer answer,HttpServletRequest request,HttpServletResponse response,String title)throws IOException,ServletException{
		int i=answerService.deleteAnswer(answer.getA_id());
		if(i>0){
			List<Answer> listpt=answerService.queryAllAnswers();
			session.setAttribute("listpt",listpt);
			//request.getRequestDispatcher("/teacherqueryallanswers.jsp").forward(request,response);
			return "WEB-INF/teacher/teacherqueryallanswers";
		}else{
			//request.getRequestDispatcher("/fail.jsp").forward(request,response);
			return "fail";
		}
	}
}
