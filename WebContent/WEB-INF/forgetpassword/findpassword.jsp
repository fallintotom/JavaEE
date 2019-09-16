<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎使用课堂交流系统！</title>
<style type="text/css">
body{background-image:url(upload/background/background13.jpg);
     background-repeat:no-repeat;
     background-size:cover;
     background-position-x:50%;
     }
</style>
</head>
<div  class="div1" align="center"><h1>欢迎使用课堂交流系统！</h1><br></div>
<body>
<br><br><br>
<div align="center">
<form action="findpassword.do" method="post">
<input type="hidden" name="username" value="${username}"><br>
<div  class="div2">
您的身份证号：<input name="idnumber" type="text" value="${idnumber}" style="margin-left:31px;" size="20"><br>
请输入您的新密码：<input name="password" type="password"><br>
请确认您的新密码：<input name="password1" type="password"><br><br>
<input type="submit" value="提交" style="margin-right:35px;">
<input type="button" value="返回"  onclick="history.back()"/>
</div>
</form>
</div>
<style type="text/css">
  .div1{
        font-family:KaiTi;
        color:darkblue;
 }
  .div2{
        font-family: KaiTi; 
 }
  input[type="button"]{
    width:80px;
    height:25px;
    border-width:1px;
    border-radius:5px;
    background: lightblue;
    font-family:KaiTi;
    color:black;
    front-size:10px;
    }
    input[type="submit"]{
    width:80px;
    height:25px;
    border-width:1px;
    border-radius:5px;
    background: lightblue;
    font-family:KaiTi;
    color:black;
    front-size:10px;
    }
 </style>
</body>
</html>