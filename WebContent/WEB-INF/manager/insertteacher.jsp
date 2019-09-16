<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="pojo.Teacher"%>
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
<div align="center" id="div1"><h1>欢迎使用课堂交流系统！</h1><br></div>
<body>
<div id="div2">您好,${username}!
<a href="logout.do">注销</a><br>
请在下方选择您的操作：<br></div>
<br><br><br>
<div align="center">
<form method="post" action="insertteacher.do" enctype="multipart/form-data">
<div id="div1">
教工编号：<input type="text" name="t_id" value="${t_id}"><br>  
账户名：<input type="text" name="username" style="margin-left:16px;"><br>
账户密码：<input type="password" name="password" value="000" readonly="readonly"><br>
 请选择要上传的证件：<input type="file" name="img" id="picturepath"><br>
 身份证号：<input type="text" name="idnumber"><br><br>
<input type="submit" value="提交信息" style="margin-right:40px;"> <input type="button" value="返回"  onclick="history.back()"/>
</div>
</form>
</div>
<style type="text/css">
  #div1{
        font-family:KaiTi;
        color:darkblue;
 }
  #div2{
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