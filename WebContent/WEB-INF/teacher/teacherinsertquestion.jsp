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
<div align="center" id="div1"><h1>欢迎使用课堂交流系统！</h1></div>
<body>
<div id="div2">您好,<a href="queryteachermessage.do?username=${username}">${username}</a>老师!
<a href="logout.do">注销</a><br>
请选择您的操作：<br></div>
<br><br><br>
<div align="center">
<form method="post" action="teacherinsertquestion.do">
<div id="div1">
问题编号：<input type="text" name="q_id" value="${q_id}"><br>  
标题：<input type="text" name="title" placeholder="问题中最好不要包含中文字符" style="margin-left:31px;"><br>
章节编号：<input type="text" name="c_id" value="${c_id}" readonly><br>
题目类型：<select name="type" size="Radio" id="type" style="width:147px">
        <option value="Radio">Radio</option>
        <option value="Content">Content</option>
        <option value="Checkbox">Checkbox</option>
        <option value="Judge">Judge</option>
        </select><br>
提问时间：<input type="date" name="q_time" style="width:141px"><br><br>
<input type="submit" value="提出问题" style="margin-right:40px;"><input type="button" value="返回"  onclick="history.back()"/><br><br>
</div>
</form>
<br>
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