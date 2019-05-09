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
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/style.css" />
    <script type="text/javascript" src="<%=path %>/js/modernizr-1.5.min.js"></script>
   
    <script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery.easing-sooper.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery.sooperfish.js"></script>
	<script type="text/javascript">
	    $(document).ready(function() 
	    {
	      $('ul.sf-menu').sooperfish();
	      $('.top').click(function() {$('html, body').animate({scrollTop:0}, 'fast'); return false;});
	    });
	    
	    var url="<%=path %>/liuyanAll.action"
        window.location.href=url;
	</script>
	
  </head>
   
  <body>
  <div id="main">
      <header>
	      <div id="logo">
	        <div id="logo_text">
	          <br/><br/><br/>
	          <h1><a href="#" style="font-size: 30px;">111</a></h1>
	        </div>
	      </div>
          <div id="menu_container">
	          <ul class="sf-menu" id="nav">
		            <li><a href="#">222</a></li>
		            <li><a href="#">333</a></li>
		            <li><a href="#">444</a>
		              <ul>
		                <li><a href="#">555</a></li>
		                <li><a href="#">555</a></li>
		              </ul>
		            </li>
		            <li><a href="#">联系我们</a></li>
	          </ul>
          </div>
      </header>
      
      
      
      
      <div id="site_content">
	      <div id="sidebar_container">
	          <div class="sidebar">
		          <h3 style="font-size: 17px;">系统广告信息</h3>
		          <h4 style="margin-top: 10px;">44444444444</h4>
		          <h4 style="margin-top: 6px;">55555555555</h4>
	          </div>
	          <div class="sidebar">
		          <h3 style="font-size: 17px;">系统广告信息</h3>
		          <h4 style="margin-top: 10px;">44444444444</h4>
		          <h4 style="margin-top: 6px;">55555555555</h4>
	          </div>
	          <div class="sidebar">
		          <h3 style="font-size: 17px;">系统广告信息</h3>
		          <h4 style="margin-top: 10px;">44444444444</h4>
		          <h4 style="margin-top: 6px;">55555555555</h4>
	          </div>
	      </div>
	      <div class="content">
	          <h1 style="font-size: 22px;">新闻喜讯</h1>
	          <p>
		           This simple, fixed width website template is released under a Creative Commons Attribution 3.0 Licence
		           This means you are free to download and use it for personal and commercial proj
	          </p>
	          <p>1111</p>
	          <p>2222</p>
	        
	          <h1 style="font-size: 22px;">公告信息</h1>
		      <p>4444</p>
		      <p>5555</p>
	      </div>
      </div>
      
      
      
      
      
      <footer>
          <p>欢迎使用Java学习系统!*******  版权所有：Java EE架构设计与开发实践————2016</p>
		  <p> <a href="<%=path %>/login.jsp">系统后台管理</a></p>
      </footer>
  </div>
</body>
</html>
