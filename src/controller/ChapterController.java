package controller;

import java.io.IOException;
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
import service.ChapterService;

@Controller
public class ChapterController {
	@Autowired
	ChapterService chapterService;
	@RequestMapping("queryallchapters.do")           //遍历所有章节信息的响应方法(学生模块的功能)
	public void QueryAllChapters(Chapter chapter,Model model,HttpServletResponse response,HttpServletRequest request)throws IOException,ServletException{
		List<Chapter> listqt=chapterService.queryAllChapters();
		request.setAttribute("listqt", listqt);
		try {
			request.getRequestDispatcher("/WEB-INF/student/queryallchapters.jsp").forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("teacherqueryallchapters.do")    //遍历所有章节信息的响应方法(教师模块的功能)
	public void TeacherQueryAllChapters(Chapter chapter,Model model,HttpServletResponse response,HttpServletRequest request)throws IOException,ServletException{
		List<Chapter> listqt=chapterService.queryAllChapters();
		request.setAttribute("listqt", listqt);
		try {
			request.getRequestDispatcher("/WEB-INF/teacher/teacherqueryallchapters.jsp").forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("toteacherupdatechapter.do")
	public String Toupdatechapter(HttpSession session,Chapter chapter,Model model,String c_id,String c_name) {
		session.setAttribute("c_id", c_id);
		session.setAttribute("c_name", c_name);
		return "WEB-INF/teacher/teacherupdatechapter";
	}
	@RequestMapping("teacherupdatechapter.do")
	public String Updatechapter(Model model,Chapter chapter) {
		int i=chapterService.updatechapter(chapter.getC_id(),chapter.getC_name());
		if(i>0){
			List<Chapter> listqt=chapterService.queryAllChapters();
			model.addAttribute("listqt",listqt);
			return "WEB-INF/teacher/teacherqueryallchapters";
		}
		return "fail";
	}
	@RequestMapping("teacherdeletechapter.do")
	public String Deletechapter(Model model,Chapter chapter,String c_id){
		int i=chapterService.deletechapter(c_id);
		if(i>0){
			List<Chapter> listqt=chapterService.queryAllChapters();
			model.addAttribute("listqt",listqt);
			return "WEB-INF/teacher/teacherqueryallchapters";
		}
		return "fail";
	}
	@RequestMapping("searchchapter.do")
	public String Searchchapter(Chapter chapter,Model model,String c_name){
		List<Chapter> listqt=chapterService.searchchapter(c_name);
		model.addAttribute("listqt",listqt);
		return "WEB-INF/teacher/teacherqueryallchapters";
	}
	@RequestMapping("toteacherinsertchapter.do")
	public String Toinsertchapter(Model model,Chapter chapter,String c_id){
		Random rd1 = new Random();
		 int chapter_id=19%rd1.nextInt(10)+10;
		  c_id=String.valueOf(chapter_id);
		 if((String.valueOf(chapter_id).equals(chapter.getC_id()))){
			 chapter_id=19%rd1.nextInt(10)+10;
			 c_id=String.valueOf(chapter_id);
		 }
		 model.addAttribute("c_id",c_id);
		return "WEB-INF/teacher/teacherinsertchapter";
	}
	@RequestMapping("teacherinsertchapter.do")
	public String Insertchapter(Chapter chapter,Model model){
		int i=chapterService.insertchapter(chapter.getC_id(),chapter.getC_name());
		if(i>0){
			List<Chapter> listqt=chapterService.queryAllChapters();
			model.addAttribute("listqt",listqt);
			return "WEB-INF/teacher/teacherqueryallchapters";
		}
		return "fail";
	}
}
