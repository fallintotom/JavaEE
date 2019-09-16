<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎使用课堂交流系统！</title>
<style type="text/css">
body{background-image:url(upload/background/background3.jpg);
     background-repeat:no-repeat;
     background-size:cover;
     background-position-x:50%;
     }
</style>
</head>
<div id="div2" align="center"><h1>欢迎使用课堂交流系统！</h1><br></div>
<div id="div2" align="center"><h3>教师个人信息表</h3><br></div>
<body>
<div id="div1" align="center" style="margin-right:750px;">您好,${username}老师!
请在下方编辑您的个人信息。
</div>
<br><br>
<div align="center">
<form action="teachersave.do" method="post">
<table border="2" id="教师个人信息表">
	<tr>
		<td><div align="center" class="div3">教工编号</div></td>
		<td><div align="center" class="div3">账/用户名</div></td>
		<td><div align="center" class="div3">账户密码</div></td>
		<td><div align="center" class="div3">真实姓名</div></td>
		<td><div align="center" class="div3">证件照</div></td>
	</tr>
		<tr>
			<td><div align="center"><input type="text" name="t_id" value="${t_id}"  size=3 readonly></div></td>
			<td><div align="center"><input type="text" name="username" value="${username}"  size=12 readonly></div></td>
			<td><div align="center" id="password"><input type="text" name="password" value="${password}"  size=20 id="password"></div></td>
			<td><div align="center"><input type="text" name="realname" value="${realname}"  size=10></div></td>
			<td rowspan="3"><img src="<%=request.getContextPath()%>${picturepath}"  alt="" width="80" height="100"/></td>
		</tr>
		<tr>
		<td><div align="center" class="div3">性别</div></td>
		<td><div align="center" class="div3">电话/手机</div></td>
		<td><div align="center" class="div3">电子邮箱</div></td>
		<td><div align="center" class="div3">身份证号码</div></td>
		</tr>
		<tr>
		<td><div align="center"><select name="gender" size="${gender}" id="gender" style="width:85px;hight:55px;">
        <option value="${gender}">${gender}</option>
        <option value="M">M</option>
        <option value="F">F</option>
        </select></div></td>
			<td><div align="center"><input type="text" name="phone" value="${phone}"  size=13></div></td>
			<td><div align="center"><input type="text" name="mail" value="${mail}"  size=20></div></td>
			<td><div align="center"><input type="text" name="idnumber" value="${idnumber}"  size=20 readonly></div></td>
		</tr>
</table>
<table border="2" id="任教经历表">
	<tr>
		<td colspan="20"><div align="center" class="div3">任教经历</div></td>
	</tr>
	<tr>
		<td rowspan="6" colspan="59"><textarea rows="6" cols="69" name="textarea1" id="textarea1">${textarea1}</textarea></td>
	</tr>
</table>
<table border="2" id="获奖情况表">
	<tr>
		<td colspan="20"><div align="center" class="div3">获奖情况</div></td>
	</tr>
	<tr>
		<td rowspan="6" colspan="59"><textarea rows="6" cols="69" name="textarea2" id="textarea2">${textarea2}</textarea></td>
	</tr>
</table>
<table border="2" id="备注表">
	<tr>
		<td colspan="2"><div align="center" class="div3">备注</div></td>
	</tr>
	<tr>
		<td rowspan="6" colspan="59"><textarea rows="6" cols="69" name="textarea3" id="textarea3">${textarea3}</textarea></td>
	</tr>
</table>
<br>
<input type="submit" value="提交保存" style="margin-right:55px;">
<input type="button" value="取消返回"  onclick="window.location.href='returnteacherindex.do';" style="margin-right:30px;"/><br><br>
</form>
</div>
<style>
 #div1{
        font-family:KaiTi;
        color:dimgray;
        font-size:18px;
 }
 #div2{
        font-family:KaiTi;
        color:dimgray;
 } 
 .div3{
        font-family:KaiTi;
        color:dimgray;
 }
  input[type="button"]{
    width:80px;
    height:25px;
    border-width:1px;
    border-radius:5px;
    background: gainsboro;
    font-family:KaiTi;
    color:darksaltegray;
    front-size:10px;
    }
    input[type="submit"]{
    width:80px;
    height:25px;
    border-width:1px;
    border-radius:5px;
    background: gainsboro;
    font-family:KaiTi;
    color:darkslategray;
    front-size:10px;
    }
</style>
</body>
</html>