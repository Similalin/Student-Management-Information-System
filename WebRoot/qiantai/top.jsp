<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
   String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
      <ul class="sf-menu" id="nav">
          <li><a href="<%=path %>/qiantai/default.jsp">网站首页</a></li>
          <li><a href="<%=path %>/docAll.action">教学资料</a></li>
          <li><a href="<%=path %>/shipinAll.action">教学视频</a></li>
          <li><a href="<%=path %>/liuyanAll.action">信息交流</a></li>
          <!-- <li><a href="#">444</a>
              <ul>
                  <li><a href="#">555</a></li>
                  <li><a href="#">555</a></li>
              </ul>
          </li> -->
      </ul>
  </body>
</html>
