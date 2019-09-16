/*以下是拦截器的配置,将之后我们需要访问的jsp页面放行*/

package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		String url=request.getRequestURI();
		if((url.indexOf("/returnteacherindex")>0) || (url.indexOf("/managerlogin")>0) || (url.indexOf("/studentlogin")>0) || (url.indexOf("/teacherlogin")>0) || (url.indexOf("/queryallteachers")>0) || (url.indexOf("/queryallstudents")>0)
		|| (url.indexOf("/queryallquestions")>0) || (url.indexOf("/insertanswer")>0)  || (url.indexOf("/teacherinsertanswer")>0) || (url.indexOf("/updateanswer")>0) || (url.indexOf("/teacherupdateanswer")>0) || (url.indexOf("/deleteanswer")>0)
		|| (url.indexOf("/deleteteacher")>0) || (url.indexOf("/deletestudent")>0) || (url.indexOf("/insertstudent")>0)  || (url.indexOf("/insertteacher")>0)  || (url.indexOf("/searchteacher")>0)  || (url.indexOf("/searchstudent")>0)
		|| (url.indexOf("/updateteacher")>0) || (url.indexOf("/updatestudent")>0) || (url.indexOf("/toinsertteacher.do")>0) || (url.indexOf("/toinsertstudent.do")>0) || (url.indexOf("/toupdateteacher.do")>0) || (url.indexOf("/toupdatestudent.do")>0)
		|| (url.indexOf("/logout.do")>0) || (url.indexOf("/key.do")>0) || (url.indexOf("/findpassword.do")>0) || (url.indexOf("/inputpasswordagain.do")>0) || (url.indexOf("/teacherfindpassword.do")>0)
		|| (url.indexOf("/managerfindpassword.do")>0) || (url.indexOf("/checkmessage.do")>0)|| (url.indexOf("/studentsave.do")>0) || (url.indexOf("/returnstudentindex")>0) || (url.indexOf("/login.do")>0)){
			return true;
		}
		else if((url.indexOf("/index")>0) || (url.indexOf("/teacherindex")>0) || (url.indexOf("/manager")>0))
		{
			return false;
		}
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("loginUserName");
		if(!username.equals("")&&username!=null){
			return true;	
		}
		request.setAttribute("msg","还没有登录，请先登录");
		request.getRequestDispatcher("login.jsp").forward(request,response);
		return false;
	}
}
