<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false" %> 
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
    
    <script type="text/javascript" src="<%=path %>/js/public.js"></script>
    
	<script type="text/javascript">
	    $(document).ready(function() 
	    {
	      $('ul.sf-menu').sooperfish();
	      $('.top').click(function() {$('html, body').animate({scrollTop:0}, 'fast'); return false;});
	    });
	    
	    function down1(fujianPath,fujianYuashiMing)
        {
            var url="<%=path %>/updown/updown.jsp?fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
            url=encodeURI(url); 
            url=encodeURI(url); 
            window.open(url,"_self");
        }
        
        function shipinBofang(fujian)
        {
              var url="<%=path %>/bofang/bofang.jsp?fujian="+fujian;
              var n="";
              var w="700px";
              var h="600px";
              var s="resizable:no;help:no;status:no;scroll:yes";
	          openWin(url,n,w,h,s);
        }
	</script>
	
	<style type="text/css">
		.c1-bline{border-bottom:#999 1px dashed;border-top:1px;}
		.f-right{float:right}
		.f-left{float:left}
		.clear{clear:both}
	</style>
  </head>
   
  <body>
  <div id="main">
      <header>
	      <div id="logo">
	        <div id="logo_text">
	          <br/><br/><br/>
	          <h1 style="width: 700px;"><a href="#" style="font-size: 30px;color: blue">《Java程序设计》在线学习平台</a></h1>
	        </div>
	      </div>
          <div id="menu_container">
	          <jsp:include flush="true" page="/qiantai/top.jsp"></jsp:include>
          </div>
      </header>
      
      
      
      
      <div id="site_content">
	      <jsp:include flush="true" page="/qiantai/right.jsp"></jsp:include>
	      <div class="content">
	          <!-- <h1 style="font-size: 22px;">新闻喜讯</h1>
	          <p>
		           This simple, fixed width website template is released under a Creative Commons Attribution 3.0 Licence
		           This means you are free to download and use it for personal and commercial proj
	          </p>
	          <p>1111</p>
	          <p>2222</p> -->
	          <!-- <h1 style="font-size: 22px;">
	              &nbsp;
	          </h1> -->
	          <div>
					<table width="100%" border="0">
					    <tr>
					       <td align="center">视频名称：${requestScope.shipin.shipinName }<hr/></td>
					    </tr>
					    <tr>
					       <td align="center" style="word-break:break-all;">视频介绍：<c:out value="${requestScope.shipin.shipinJianjie }" escapeXml="false"></c:out><hr/></td>
					    </tr>
					    <tr>
					       <td align="center">
					            <a href="#" onclick="down1('${requestScope.shipin.fujian }','${requestScope.shipin.fujianYuanshiming }')" style="font-size: 13px;color: red">${requestScope.shipin.fujianYuanshiming }</a>
					            &nbsp;&nbsp;&nbsp;
					            <a href="#" onclick="shipinBofang('${requestScope.shipin.fujian }')" class="pn-loperator" style="color: red">播放</a>
					            <hr/>
					       </td>
					    </tr>
					    <tr>
					       <td align="center">发布时间:${requestScope.shipin.shijian }<hr/></td>
					    </tr>
					</table>
	          </div>
	      </div>
      </div>
      
      
      
      
      
      <footer>
          <p><a href="<%=path %>/login.jsp">系统后台</a></p>
      </footer>
  </div>
</body>
</html>
