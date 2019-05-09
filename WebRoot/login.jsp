<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	
	<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
        
		<script language="javascript">
		function check1()
		{                                                                                         
		     if(document.loginForm.userName.value=="")
			 {
			 	alert("请输入用户名");
				document.loginForm.userName.focus();
				return false;
			 }
			 if(document.loginForm.userPw.value=="")
			 {
			 	alert("请输入密码");
				document.loginForm.userPw.focus();
				return false;
			 }
			 if(document.loginForm.userType.value==-1)
			 {
			 	alert("请选择登陆身份");
				return false;
			 }
			 document.getElementById("indicator").style.display="block";
			 loginService.login(document.loginForm.userName.value,document.loginForm.userPw.value,document.loginForm.userType.value,callback);
		}
		
		function callback(data)
		{
		    document.getElementById("indicator").style.display="none";
		    if(data=="no")
		    {
		        alert("用户名或密码错误");
		    }
		    if(data=="yes")
		    {
		        alert("通过验证,系统登录成功");
		        window.location.href="<%=path %>/loginSuccess.jsp";
		    }
		    
		}
	    </script>
	
	<style type="text/css">
		* {
			margin:0;
			padding:0;
		}
		html {
			width:100%;
			height:100%;
			overflow-x:hidden;
		}
		body {
			height:100%;
			margin:0;
			padding:0;
			font-size:10pt;
			background:#F1F1F1;
			color:#333;
			overflow:auto;
			overflow-x:hidden;
		}
		body#login {
			background:#0065AF;
		}
		body#index {
			border-left:200px solid #0065AF;
		}
		body#page {
			padding:20px;
			height:auto;
			border-top:60px solid #0065AF;
		}
		a {
			color:#0D324F;
		}
		
		textarea,select {
			background:#F4F4F4;
			border:1px solid #A5ACB2;
		}
		
		h1 {
			position:absolute;
			width:1000%;
			color:#FFF;
			font-size:12pt;
			top:0;
			left:0;
			padding:23px 0 16px 20px;
			background:#0065AF;
			border-bottom:3px solid #FFF;
		}
		h2 {
			font-size:12px;
			padding:8px;
			color:#333;
		}
		p {
			margin:10px auto;
		}
		/**/
		#loginForm {
			width:400px;
			height:250px;
			position:absolute;
			top:50%;
			left:50%;
			margin:-150px 0 0 -200px;
			background:#FFF;
			border:5px solid #999;
		}
		#loginForm h3 {
			background:#cc0099;
			color:#FFF;
			margin:0 0 30px 0;
			padding:14px 0 8px 20px;
		}
	</style>
	
  </head>
  
  <body id="login">
	<form action="<%=path %>/admin/index.jsp" id="loginForm" name="loginForm" method="post">
		<h3>基于SSH的《Java程序设计》在线学习平台</h3>
		<table align="center" border="0" cellpadding="9" cellspacing="9">
			<tr align='center'>
				<td style="width: 50px;font-family: 微软雅黑;" align="left">
					账号：										    
				</td>
				<td align="left">
					<input name="userName" type="text" style="width: 200px;height: 20px;"/>
				</td>
			</tr>
			<tr align='center'>
				<td style="width: 50px;font-family: 微软雅黑;" align="left">
					密码：										    
				</td>
				<td align="left">
					<input name="userPw" type="password" style="width: 200px;height: 20px;"/>
				</td>
			</tr>
			<tr align='center'>
				<td style="width: 50px;font-family: 微软雅黑;" align="left">
					类型：										    
				</td>
				<td align="left">
					<select name="userType" style="height:17px;width:204px; border:solid 1px #bbbbbb;height: 20px;">
						<option value="0">管理员</option>
						<option value="1">老&nbsp;&nbsp;&nbsp;师</option>	
					</select> 
				</td>
			</tr>
			<tr align='center'>
			   <td style="width: 50px;" align="left"></td>
			   <td align="left">
			      <input type="button" value="登陆" style="width: 80px;font-family: 微软雅黑;" onClick="check1()"/>&nbsp; 
			      <input type="reset" value="重置" style="width: 80px;font-family: 微软雅黑;"/>&nbsp;
			      <img id="indicator" src="<%=path %>/img/loading.gif" style="display:none"/>
			   </td>
			</tr>
		</table>
	</form>
  </body>
</html>
