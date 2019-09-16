<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎使用课堂交流系统！</title>
<style type="text/css">
body{background-image:url(upload/background/background4.jpg);
     background-repeat:no-repeat;
     background-size:cover;
     background-position-x:50%;
     }
</style> 
</head>
<div align="center" class="div1"><h1>欢迎使用课堂交流系统！</h1></div>
<body>
<br><br><br><br><br>
<div align="center" class="div1">
密码重置失败，可能是您输入的信息有误，请点击<input type="button" value="重新填写密码" onclick="window.location.href='inputpasswordagain.do?idnumber=${idnumber}';"/>重新填写，感谢您的配合。。。<br>
</div>
<style>
.div1{
	font-family:KaiTi;
        color:black;
        font-size:20px;
}
input[type="button"]{
    width:100px;
    height:25px;
    border-width:1px;
    border-radius:5px;
    background: gainsboro;
    font-family:KaiTi;
    color:black;
    front-size:10px;
    }
</style>
</body>
</html>