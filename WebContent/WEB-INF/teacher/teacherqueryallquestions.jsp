<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎使用课堂交流系统！</title>
<style type="text/css">
body{background-image:url(upload/background/background8.jpg);
     background-repeat:no-repeat;
     background-size:cover;
     background-position-x:50%;
     }
</style>
</head>
<div align="center" class="div1"><h1>欢迎使用课堂交流系统！</h1></div>
<body>
<div class="div1">您好,<a href="queryteachermessage.do?username=${username}">${username}</a>老师!
<a href="logout.do">注销</a><br>
请选择您的操作：<input type="button" value="返回"  onclick="history.back()"/><br></div>
<br><br>
<div align="center">
<form method="post" action="teachersearchquestion.do">
<table border="1" id="查询问题表">
	<tr>
		<td><div align="center" class="div1">按标题查询</div></td>
		<td><div align="center" class="div1">按章节编号查询</div></td>
		<td><div align="center" class="div1">按提问时间查询</div></td>
	</tr>
	<tr>
		<td><div align="center"><input type="text" name="title"></div></td>
		<td> <input type="text" name="c_id"></td>
		<td><div align="center"><input type="date" name="q_time" style="width:150px"></div></td>
	</tr>
	<tr>
		<td><div align="center" class="div1">按问题类型查询</div></td>
		<td><div align="center" class="div1">按提问账户查询</div></td>
		<td><div align="center" class="div1">点击搜索问题</div></td>
	</tr>
	<tr>
		<td><input type="text" name="type"></td>
		<td><div align="center"><input type="text" name="q_username"></div></td>
		<td><div align="center"><input type="submit" value="搜索问题" style="width:150px;height:23px"></div></td>
	</tr>
</table>
</form>
<br><br>
<table border="1" id="问题表">
	<tr>
		<td><div class="div1" align="center">问题编号</div></td>
		<td><div class="div1" align="center">问题题目</div></td>
		<td><div class="div1" align="center">章节编号</div></td>
		<td><div class="div1" align="center">提问账户名</div></td>
		<td><div class="div1" align="center">提问时间</div></td>
		<td><div class="div1" align="center">问题类型</div></td>
		<td><div class="div1" align="center">查找答案</div></td>
		<td><div class="div1" align="center">答疑解惑</div></td>
		<td><div class="div1" align="center">编辑问题</div></td>
		<td><div class="div1" align="center">删除问题</div></td>
	</tr>
	<c:forEach items="${list}" var="t_question">
		<tr>
			<td><div class="div1" align="center">${t_question.q_id}</div></td>
			<td><div class="div2" align="center">${t_question.title}</div></td>
			<td><div class="div1" align="center">${t_question.c_id}</div></td>
			<td><div class="div1" align="center">${t_question.q_username}</div></td>
			<td><div class="div2" align="center">${t_question.q_time}</div></td>
			<td><div class="div2" align="center">${t_question.type}</div></td>
			<td><div class="div1" align="center"><a href="teachersearchanswer.do?type=${t_question.getType()}&&title=${t_question.title}&&user_id=${user_id}">查找答案</a></div></td>
			<td><div class="div1" align="center"><a href="toteacherinsertanswer.do?type=${t_question.type}&&title=${t_question.title}&&q_id=${t_question.q_id}&&c_id=${t_question.c_id}">答疑解惑</a></div></td>
			<td><div class="div1" align="center"><a href="toteacherupdatequestion.do?type=${t_question.getType()}&&title=${t_question.title}&&q_id=${t_question.q_id}&&c_id=${t_question.c_id}&&q_username=${t_question.q_username}">编辑问题</a></div></td>
			<td><div class="div1"><a href="deletequestion.do?q_id=${t_question.q_id}">删除问题</a></div></td>
		</tr>
	</c:forEach>
</table>
</div>
<style>
.div1{
	font-family:KaiTi;
        color:black;
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
    input[type="submit"]{
    width:95px;
    height:25px;
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