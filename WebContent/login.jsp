<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用课堂交流系统！</title>
<link href="css/style.css" rel='stylesheet' type='text/css' />
<style type="text/css">
body{background-image:url(upload/background/background5.jpg);
     background-repeat:no-repeat;
     background-size:cover;
     background-position-x:50%;
     }
</style>
</head>
<div id="title" align="center"><h1>欢迎使用课堂交流系统！</h1><br></div>
<body>
<br><br><br><br><br>
<div align="center">
<table border="1" id="用户登录表">
<form action="login.do" method="post">
<div id="div1">
账 户:<input id="username" name="username" type="text" placeholder="请输入您的账户名" style="width:185px;hight:50px"><br>
密 码:<input id="password" name="password" type="password" style="margin-left:2px;width:185px"><br>
<a href="key.do">忘记密码？</a><br><br>
</div>
<table border="1" id="身份选择表">

<tr>
 <td colspan="3"><div id="div5" align="center">请选择您的登录身份(必填)</div></td>
</tr>
<tr>
 <td><div id="div2" align="center"><input name="id" type="radio" id="id" value="student">学生</div></td>
 <td><div id="div3" align="center"><input name="id" type="radio" id="id" value="teacher">老师</div></td>
 <td><div id="div4" align="center"><input name="id" type="radio" id="id" value="manager">管理员</div></td>
</tr>
</table>
<br>
<input type="submit" value="登录" style="margin-right:35px;">
<input type="button" value="退出"  onclick="system.exit(0)"/><br><br>
</form>
</table>

<style type="text/css">
 #title{
        font-family:KaiTi;
        color:darkblue;
 }
 #div1{
        font-family:KaiTi;
        color:black; 
 }
 #div2{
        font-family: KaiTi;
        color:dodgerblue; 
 }
 #div3{
        font-family: KaiTi;
        color:dodgerblue; 
 }
 #div4{
        font-family: KaiTi;
        color:dodgerblue; 
 }
 #div5{
        font-family: KaiTi;
        color:maroon; 
 }
 input[type="button"]{
    width:80px;
    height:25px;
    border-width:1px;
    border-radius:8px;
    background: lightgrey;
    font-family:KaiTi;
    color:black;
    front-size:10px;
    }
    input[type="submit"]{
    width:80px;
    height:25px;
    border-width:1px;
    border-radius:8px;
    background: lightgrey;
    font-family:KaiTi;
    color:black;
    front-size:10px;
    }
</style>
</body>
</html>