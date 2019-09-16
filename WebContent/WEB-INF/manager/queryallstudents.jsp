<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎使用课堂交流系统！</title>
<style type="text/css">
body{background-image:url(upload/background/background14.jpg);
     background-repeat:no-repeat;
     background-size:cover;
     background-position-x:50%;
     }
</style>
</head>
<div align="center" class="div1"><h1>欢迎使用课堂交流系统！</h1><br></div>
<body>
<div class="div1">您好,${username}!
<a href="logout.do">注销</a><br>
请选择您的操作：</div>
<br><br><br>
<div align="center">
<form method="post" action="searchstudent.do">
<table border="1" id="查询学生表">
	<tr>
		<td><div align="center" class="div1">按账户名查询</div></td>
		<td><div align="center" class="div1">按真实姓名查询</div></td>
		<td><div align="center" class="div1">按学生性别查询</div></td>
		
	</tr>
	<tr>
		<td><div align="center"><input type="text" name="username"></div></td>
		<td><div align="center"><input type="text" name="realname"></div></td>
		<td><div align="center"><input type="text" name="gender"></div></td>
		
	</tr>
	<tr>
		<td><div align="center" class="div1">按电话/手机查询</div></td>
		<td><div align="center" class="div1">按电子邮箱查询</div></td>
		<td><div align="center" class="div1">请点击查询按钮</div></td>
	</tr>
	<tr>
		<td><div align="center"><input type="text" name="phone"></div></td>
		<td><div align="center"><input type="text" name="mail"></div></td>
		<td><input type="submit" value="查询学生信息" style="width:154px;height:23px"></td>
	</tr>
</table>
</form>
</div>
<br><br>
<div align="center">
<table border="1" id="学生表">
	<tr>
		<td><div class="div1" align="center">学生编号</div></td>
		<td><div class="div1" align="center">账/用户名</div></td>
		<td><div class="div1" align="center">真实姓名</div></td>
		<td><div class="div1" align="center">学生性别</div></td>
		<td><div class="div1" align="center">电话/手机</div></td>
		<td><div class="div1" align="center">电子邮箱</div></td>
		<td><div class="div1" align="center">身份证号码</div></td>
		<td><div class="div1" align="center">证件照</div></td>
		<td><div class="div1" align="center">编辑</div></td>
		<td><div class="div1" align="center">删除</div></td>
	</tr>
	<c:forEach items="${list}" var="t_student">
		<tr>
			<td><div class="div1" align="center">${t_student.s_id}</div></td>
			<td><div class="div1" align="center">${t_student.username}</div></td>
			<td><div class="div2" align="center">${t_student.realname}</div></td>
			<td><div class="div2" align="center">${t_student.gender}</div></td>
			<td><div class="div1" align="center">${t_student.phone}</div></td>
			<td><div class="div2" align="center">${t_student.mail}</div></td>
			<td><div class="div1" align="center">${t_student.idnumber}</div></td>
			<td><img src="<%=request.getContextPath()%>${t_student.picturepath}"  alt="" width="80" height="80"/></td>
			<td><div class="div1" align="center"><a href="toupdatestudent.do?s_id=${t_student.s_id}">编辑</a></div></td>
			<td><div class="div1" align="center"><a href="deletestudent.do?username=${t_student.username}">删除</a></div></td>
		</tr>
	</c:forEach>
</table>
</div>
<br>
<div align="center">
		<input type="button" value="新增学生信息" onclick="window.location.href='toinsertstudent.do';" style="margin-right:120px;"/>
		<input type="button" value="返回"  onclick="history.back()" style="margin-right:50px;"/><br>
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
    width:95px;
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