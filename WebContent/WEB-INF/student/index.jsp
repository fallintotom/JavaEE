<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎使用课堂交流系统！</title>
<style type="text/css">
body{background-image:url(upload/background/background7.jpg);
     background-repeat:no-repeat;
     background-size:cover;
     background-position-x:50%;
     }
</style>
</head>
<div align="center" id="div2"><h1>欢迎使用课堂交流系统！</h1></div>
<body>
<div id="div1">您好,<a href="querystudentmessage.do?username=${username}">${username}</a>同学!
<a href="logout.do">注销</a><br>
请选择您的操作：<input type="button" value="返回"  onclick="history.back()" style="width:50px;height:20px;"/><br></div>
<br><br><br><br>
<div align="center">
<table border="1">
<tr>
<td><div class="div3" align="center">搜索问题</div></td>
<td><div class="div3" align="center">查询所有章节</div></td>
</tr>
<tr>
<td><input type="button" value="搜索问题" onclick="window.location.href='searchquestion.do?username=${username}';"/></td>
<td><input type="button" value="查询所有章节" onclick="window.location.href='queryallchapters.do';"/></td>
</tr>
</table>
</div>
<style>
#div1{
	font-family:KaiTi;
        color:black;
}
#div2{
	font-family:KaiTi;
        color:dimgray;
}
.div3{
	font-family:KaiTi;
}
input[type="button"]{
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