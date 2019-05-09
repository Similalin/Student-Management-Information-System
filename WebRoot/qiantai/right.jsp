<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
  String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
      <div id="sidebar_container">
          <!-- <div class="sidebar">
	          <h3 style="font-size: 17px;">系aaa统广告信息</h3>
	          <h4 style="margin-top: 10px;">44444444444</h4>
	          <h4 style="margin-top: 6px;">55555555555</h4>
          </div> -->
          <div class="sidebar">
	          <h4 style="margin-top: 10px;">
	             <jsp:include flush="true" page="/qiantai/userlogin/userlogin.jsp"></jsp:include>
	          </h4>
          </div>
          <div class="sidebar">
	          <h3 style="font-size: 11px;">系统公告信息</h3>
	          <s:iterator value="#session.gonggaoList" id="gonggao">
	          <h4 style="margin-top: 10px;"><img src="<%=path %>/img/head-mark4.gif" align="middle" class="img-vm" border="0"/> <a href="<%=path %>/gonggaoDetailQian.action?gonggaoId=<s:property value="#gonggao.gonggaoId"/>" title=""><s:property value="#gonggao.gonggaoTitle"/></a></h4>
	          </s:iterator>
          </div>
          <div class="sidebar">
	          <h4 style="margin-top: 10px;">
	             <jsp:include flush="true" page="/qiantai/rili/rili.jsp"></jsp:include>
	          </h4>
          </div>
	  </div>
  </body>
</html>
