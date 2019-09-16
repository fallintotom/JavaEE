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
<form method="post" action="teacherupdateanswer.do" enctype="multipart/form-data">
<div id="div1">
答案编号：<input type="text" name="a_id" value="${a_id}" readonly><br>  
问题编号：<input type="text" name="q_id" value="${q_id}" readonly><br>
教工/学生编号：<input type="text" name="user_id" value="${user_id}" style="margin-right:40px;"><br>
问题题目：${title}<br>
答案内容：<input type="text" name="content" placeholder="答案内容中不能包含中文字符"><br>
回答时间：<input type="date" name="a_time" style="width:141px"><br>
题目类型：<select name="type" size="${type}" id="type" style="width:147px">
		<option value="${type}">${type}</option>
        <option value="Radio">Radio</option>
        <option value="Content">Content</option>
        <option value="Checkbox">Checkbox</option>
        <option value="Judge">Judge</option>
        </select><br>
请选择要更新的答案图片：<input type="file" name="img" id="picturepath"><br><br>
<input type="submit" value="提交答案" style="margin-right:40px;"> <input type="button" value="返回"  onclick="history.back()"/>
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