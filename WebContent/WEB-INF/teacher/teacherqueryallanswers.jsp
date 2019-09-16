<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎使用课堂交流系统！</title>
<style type="text/css">
body{background-image:url(upload/background/background12.jpg);
     background-repeat:no-repeat;
     background-size:cover;
     background-position-x:50%;
     }
</style>
</head>
<div align="center" class="div1"><h1>欢迎使用课堂交流系统！</h1></div>
<body>
<br><br><br><br><br>
<div class="div1" style="margin-left:35px;">您好,<a href="queryteachermessage.do?username=${username}">${username}</a>老师!
<a href="logout.do">注销</a><br>
请选择您的操作：<input type="button" value="返回"  onclick="window.location.href='teacherreturn.do';"/><br></div>
<br><br><br><br>
<div align="center">
<table border="1" id="答案表">
	<tr>
		<td><div align="center" class="div1">答案编号</div></td>
		<td><div align="center" class="div1">问题编号</div></td>
		<td><div align="center" class="div1">学生/教工编号</div></td>
		<td><div align="center" class="div1">答案内容</div></td>
		<td><div align="center" class="div1">回答时间</div></td>
		<td><div align="center" class="div1">问题类型</div></td>
		<td><div align="center" class="div1">答案图片</div></td>
		<td><div align="center" class="div1">重新编辑</div></td>
		<td><div align="center" class="div1">删除答案</div></td>
	</tr>
	<c:forEach items="${listpt}" var="t_answer">
		<tr>
			<td><div align="center" class="div2">${t_answer.a_id}</div></td>
			<td><div align="center" class="div2">${t_answer.q_id}</div></td>
			<td><div align="center" class="div2">${t_answer.user_id}</div></td>
			<td><div align="center" class="div2">${t_answer.content}</div></td>
			<td><div align="center" class="div2">${t_answer.a_time}</div></td>
			<td><div align="center" class="div2">${t_answer.type}</div></td>
			<td><img src="<%=request.getContextPath()%>${t_answer.picturepath}"  alt="" width="100" height="100"/></td>
			<td><div align="center" class="div1"><a href="toteacherupdateanswer.do?a_id=${t_answer.a_id}&&q_id=${t_answer.q_id}&&user_id=${t_answer.user_id}&&type=${t_answer.type}&&title=${title}">重新编辑</a></div></td>
			<td><div align="center" class="div1"><a href="deleteanswer.do?a_id=${t_answer.a_id}">删除答案</a></div></td>
		</tr>
	</c:forEach>
</table>
</div>
<style>
.div1{
	font-family:KaiTi;
}
.div2{
	font-family:STFangsong;
}
input[type="button"]{
    width:50px;
    height:20px;
    border-width:1px;
    border-radius:5px;
    background: gainsboro;
    font-family:KaiTi;
    color:darksaltegray;
    front-size:10px;
    }
</style>
</body>
</html>