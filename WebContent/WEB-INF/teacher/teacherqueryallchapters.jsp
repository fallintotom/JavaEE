<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎使用课堂交流系统！</title>
<style type="text/css">
body{background-image:url(upload/background/background11.jpg);
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
请选择您的操作：</div>
<br><br><br><br>
<div align="center">
<form method="post" action="searchchapter.do">
<table border="1" id="查询章节表">
	<tr>
		<td><div align="center" class="div1">请输入账户名</div></td>
		<td><div align="center" class="div1">请点击查询按钮查询</div></td>
	</tr>
	<tr>
		<td><div align="center"><input type="text" name="c_name"></div></td>
		<td><div align="center"><input type="submit" value="查询章节信息" style="width:154px;height:23px"></div></td>
</tr>
</table>
</form>
</div>
<br><br>
<div align="center">
<table border="1" id="章节表">
	<tr>
		<td><div align="center" class="div1">章节编号</div></td>
		<td><div align="center" class="div1">章节主题</div></td>
		<td><div align="center" class="div1">提出问题</div></td>
		<td><div align="center" class="div1">编辑章节</div></td>
		<td><div align="center" class="div1">删除章节</div></td>
	</tr>
	<c:forEach items="${listqt}" var="t_chapter">
		<tr>
			<td><div align="center" class="div2">${t_chapter.c_id}</div></td>
			<td><div align="center" class="div2">${t_chapter.c_name}</div></td>
			<td><div align="center" class="div1"><a href="toteacherinsertquestion.do?c_id=${t_chapter.c_id}">提出问题</a></div></td>
			<td><div align="center" class="div1"><a href="toteacherupdatechapter.do?c_id=${t_chapter.c_id}&&c_name=${t_chapter.c_name}">编辑章节</a></div></td>
			<td><div align="center" class="div1"><a href="teacherdeletechapter.do?c_id=${t_chapter.c_id}">删除章节</a></div></td>
		</tr>
	</c:forEach>
</table>
</div>
<br>
<div align="center">
<input type="button" value="新增章节信息" onclick="window.location.href='toteacherinsertchapter.do';" style="margin-right:60px;" />
<input type="button" value="返回"  onclick="history.back()" style="margin-right:20px;"/><br><br>
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