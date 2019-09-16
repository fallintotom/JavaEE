<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎使用课堂交流系统！</title>
<style type="text/css">
body{background-image:url(upload/background/background2.jpg);
     background-repeat:no-repeat;
     background-size:cover;
     background-position-x:50%;
     }
</style>
</head>
<div id="title" align="center"><h1>欢迎使用课堂交流系统！</h1><br></div>
<body>
<br><br><br>
<div align="center">
<br>
<form action="checkmessage.do" method="post">
<div id="div1">
请输入您的账户名：<input type="text" name="username" style="margin-left:16px;"><br>
请输入您的身份证号：<input type="text" name="idnumber"><br><br>
</div>
<input type="submit" value="提交" style="margin-right:35px;">
<input type="button" value="返回"  onclick="history.back()"/>
</form>
</div>
<style type="text/css">
 #title{
        font-family:KaiTi;
        color:darkblue;
 }
  #div1{
        font-family:KaiTi;
        color:darkblue;
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