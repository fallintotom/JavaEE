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
请选择您的操作：<br></div>
<br><br><br>
<div align="center">
<form method="post" action="searchteacher.do">
<table border="1" id="查询教师表">
	<tr>
		<td><div align="center" class="div1">请输入账户名</div></td>
		<td><div align="center" class="div1">请点击查询按钮查询</div></td>
	</tr>
	<tr>
		<td><div align="center"><input type="text" name="username"></div></td>
		<td><div align="center"><input type="submit" value="查询教师信息" style="width:154px;height:23px"></div></td>
</tr>
</table>
</form>
</div>
<br><br>
<div align="center">
<table border="1" id="教师表">
	<tr>
		<td><div class="div1" align="center">教师编号</div></td>
		<td><div class="div1" align="center">账户名</div></td>
		<td><div class="div1" align="center">身份证号</div></td>
		<td><div class="div1" align="center">证件照</div></td>
		<td><div class="div1" align="center">编辑</div></td>
		<td><div class="div1" align="center">删除</div></td>
	</tr>
	<c:forEach items="${list}" var="t_teacher">
		<tr>
			<td><div class="div1" align="center">${t_teacher.t_id}</div></td>
			<td><div class="div2" align="center">${t_teacher.username}</div></td>
			<td><div class="div1" align="center">${t_teacher.idnumber}</div></td>
			<td><img src="<%=request.getContextPath() %>${t_teacher.picturepath}"  alt="" width="80" height="80"/></td>
			<td><div class="div1" align="center"><a href="toupdateteacher.do?t_id=${t_teacher.t_id}">编辑</a></div></td>
			<td><div class="div1" align="center"><a href="deleteteacher.do?username=${t_teacher.username}">删除</a></div></td>
		</tr>
	</c:forEach>
</table>
</div>
<br>
<div align="center">
<input type="button" value="新增教师信息" onclick="window.location.href='toinsertteacher.do';" style="margin-right:60px;" />
<input type="button" value="返回"  onclick="history.back()" style="margin-right:30px;"/><br><br>
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