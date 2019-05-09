<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<meta http-equiv="X-UA-Compatible" content="IE=8" />
	
	<link rel="stylesheet" href="<%=path %>/css/leftMenu.css" type="text/css"></link>
  
    <script type="text/javascript" src="<%=path %>/js/jquery-1.4.1.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery-common.js"></script>
	
    <script type="text/javascript">
        var state = 0;
        $(document).ready(function () {
            /********* 菜单收缩效果***********/
            $(".navcontent").hide();
            $(".navhead").click(function () {
                $(".navcontent").not($(this).next()).hide();
                $(this).next().slideToggle(200);
                $("a[type='Module']").not($(this)).attr("class", "navhead");
                if ($(this).attr("class") == "navhead") {
                    $(this).attr("class", "navheadOpen");
                }
                else {
                    $(this).attr("class", "navhead");
                }
            });
            $(".navhead").first().click();
        });
    </script>
    
    <style type="text/css">
        html
        {
            _overflow-x: hidden;
            height: 100%;
        }
        body
        {
            background-color: #D9F3FF;
            padding: 0px;
            margin: 0px;
            height: 100%;
        }
        ul
        {
            margin: 0px;
            padding: 0px;
        }
        li
        {
            list-style: none;
            margin: 0px;
            padding: 0px;
        }
    </style>
  </head>
  <c:if test="${sessionScope.userType==0}">
  <body style="margin: 0px;">
        <div id="Menu" style="width: 190px; float: left; margin: 2px 0px 0px 2px; _margin-left: 2.5px;overflow: hidden;">
            <div style="margin-left: 2px; width: 180px; height: 25px; vertical-align: middle;line-height: 25px; font-size: 16px; font-weight: bold; color: White;font-family: 微软雅黑; background-image: url('<%=path %>/images/menutop.png')"> <!-- 管理菜单 -->
            </div>
            <ul id="identifier">
                <li><a class="navhead" type='Module' style="font-family: 微软雅黑;">
                <img style='vertical-align:middle' src="<%=path %>/images/group.png" />&nbsp;修改登陆密码</a>
                    <ul class="navcontent">
						<li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />&nbsp;
						<a target="main" href="<%=path %>/admin/userinfo/userPw.jsp" style="font-family: 微软雅黑;">修改登陆密码</a></li>
	                </ul>
                </li>
				<li><a class="navhead" type='Module' style="font-family: 微软雅黑;">
				<img style='vertical-align:middle' src="<%=path %>/images/group.png" />&nbsp;老师信息管理</a>
				    <ul class="navcontent">
						<li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />&nbsp;
						<a target="main" href="<%=path %>/teaMana.action" style="font-family: 微软雅黑;">老师信息管理</a></li>
						<li><img  style='vertical-align:middle' src="<%=path %>/images/table.png" />&nbsp;
						<a target="main" href="<%=path %>/admin/tea/teaAdd.jsp" style="font-family: 微软雅黑;">添加老师信息</a></li>
				    </ul>
				</li>
				<li><a class="navhead" type='Module' style="font-family: 微软雅黑;">
				<img style='vertical-align:middle' src="<%=path %>/images/group.png" />&nbsp;学生信息管理</a>
				    <ul class="navcontent">
						<li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />&nbsp;
						<a target="main" href="<%=path %>/stuMana.action" style="font-family: 微软雅黑;">学生信息管理</a></li>
						<li><img  style='vertical-align:middle' src="<%=path %>/images/table.png" />&nbsp;
						<a target="main" href="<%=path %>/admin/stu/stuAdd.jsp" style="font-family: 微软雅黑;">学生信息添加</a></li>
				    </ul>
				</li>
				<li><a class="navhead" type='Module' style="font-family: 微软雅黑;">
				<img style='vertical-align:middle' src="<%=path %>/images/group.png" />&nbsp系统公告管理</a>
				    <ul class="navcontent">
						<li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />&nbsp;
						<a target="main" href="<%=path %>/gonggaoMana.action" style="font-family: 微软雅黑;">系统公告管理</a></li>
						<li><img  style='vertical-align:middle' src="<%=path %>/images/table.png" />&nbsp;
						<a target="main" href="<%=path %>/admin/gonggao/gonggaoAdd.jsp" style="font-family: 微软雅黑;">添加系统公告</a></li>
				    </ul>
				</li>
            </ul>
            <div style="margin-left: 2px; width: 180px; height: 28px; background-image: url('<%=path %>/images/foot.png')"></div>
        </div>
</body>
</c:if>






<c:if test="${sessionScope.userType==1}">
<body style="margin: 0px;">
        <div id="Menu" style="width: 190px; float: left; margin: 2px 0px 0px 2px; _margin-left: 2.5px;overflow: hidden;">
            <div style="margin-left: 2px; width: 180px; height: 25px; vertical-align: middle;line-height: 25px; font-size: 16px; font-weight: bold; color: White;font-family: 微软雅黑; background-image: url('<%=path %>/images/menutop.png')"> <!-- 管理菜单 -->
            </div>
            <ul id="identifier">
                <li><a class="navhead" type='Module' style="font-family: 微软雅黑;">
                    <img style='vertical-align:middle' src="<%=path %>/images/group.png" />&nbsp;修改个人信息</a>
                    <ul class="navcontent">
						<li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />&nbsp;
						<a target="main" href="<%=path %>/admin/userinfo/teainfo.jsp" style="font-family: 微软雅黑;">修改个人信息</a></li>
	                </ul>
                </li>
				<li><a class="navhead" type='Module' style="font-family: 微软雅黑;">
				<img style='vertical-align:middle' src="<%=path %>/images/group.png" />&nbsp;教学资料管理</a>
				    <ul class="navcontent">
						<li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />&nbsp;
						<a target="main" href="<%=path %>/admin/doc/docAdd.jsp" style="font-family: 微软雅黑;">添加教学资料</a></li>
						<li><img  style='vertical-align:middle' src="<%=path %>/images/table.png" />&nbsp;
						<a target="main" href="<%=path %>/docMana.action" style="font-family: 微软雅黑;">教学资料管理</a></li>
				    </ul>
				</li>
				<li><a class="navhead" type='Module' style="font-family: 微软雅黑;">
				<img style='vertical-align:middle' src="<%=path %>/images/group.png" />&nbsp;教学视频管理</a>
				    <ul class="navcontent">
						<li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />&nbsp;
						<a target="main" href="<%=path %>/shipinMana.action" style="font-family: 微软雅黑;">教学视频管理</a></li>
						<li><img  style='vertical-align:middle' src="<%=path %>/images/table.png" />&nbsp;
						<a target="main" href="<%=path %>/admin/shipin/shipinAdd.jsp" style="font-family: 微软雅黑;">视频信息添加</a></li>
				    </ul>
				</li>
				
				<li><a class="navhead" type='Module' style="font-family: 微软雅黑;">
				<img style='vertical-align:middle' src="<%=path %>/images/group.png" />&nbsp;信息交流模块</a>
				    <ul class="navcontent">
						<li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />&nbsp;
						<a target="main" href="<%=path %>/liuyanMana.action" style="font-family: 微软雅黑;">信息交流模块</a></li>
				    </ul>
				</li>
				
				<li><a class="navhead" type='Module' style="font-family: 微软雅黑;">
				<img style='vertical-align:middle' src="<%=path %>/images/group.png" />&nbsp;布置作业管理</a>
				    <ul class="navcontent">
						<li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />&nbsp;
						<a target="main" href="<%=path %>/zuoyetMine.action" style="font-family: 微软雅黑;">布置作业管理</a></li>
						<li><img  style='vertical-align:middle' src="<%=path %>/images/table.png" />&nbsp;
						<a target="main" href="<%=path %>/admin/zuoyet/zuoyetAdd.jsp" style="font-family: 微软雅黑;">发布作业信息</a></li>
				    </ul>
				</li>
            </ul>
            <div style="margin-left: 2px; width: 180px; height: 28px; background-image: url('<%=path %>/images/foot.png')"></div>
        </div>
</body>
</c:if>










<c:if test="${sessionScope.userType==2}">
<body style="margin: 0px;">
        <div id="Menu" style="width: 190px; float: left; margin: 2px 0px 0px 2px; _margin-left: 2.5px;overflow: hidden;">
            <div style="margin-left: 2px; width: 180px; height: 25px; vertical-align: middle;line-height: 25px; font-size: 16px; font-weight: bold; color: White;font-family: 微软雅黑; background-image: url('<%=path %>/images/menutop.png')"> <!-- 管理菜单 -->
            </div>
            <ul id="identifier">
                <%-- <li><a class="navhead" type='Module' style="font-family: 微软雅黑;">
                <img style='vertical-align:middle' src="<%=path %>/images/group.png" />&nbsp;修改我的信息</a>
                    <ul class="navcontent">
						<li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />&nbsp;
						<a target="main" href="<%=path %>/admin/userinfo/userPw.jsp" style="font-family: 微软雅黑;">修改我的信息</a></li>
	                </ul>
                </li> --%>
				<li><a class="navhead" type='Module' style="font-family: 微软雅黑;">
				<img style='vertical-align:middle' src="<%=path %>/images/group.png" />&nbsp;作业下载模块</a>
				    <ul class="navcontent">
						<li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />&nbsp;
						<a target="main" href="<%=path %>/zuoyetAll.action" style="font-family: 微软雅黑;">作业下载模块</a></li>
				    </ul>
				</li>
				<li><a class="navhead" type='Module' style="font-family: 微软雅黑;">
				<img style='vertical-align:middle' src="<%=path %>/images/group.png" />&nbsp;我的作业管理</a>
				    <ul class="navcontent">
						<li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />&nbsp;
						<a target="main" href="<%=path %>/zuoyesMine.action" style="font-family: 微软雅黑;">我的作业管理</a></li>
				    </ul>
				</li>
            </ul>
            <div style="margin-left: 2px; width: 180px; height: 28px; background-image: url('<%=path %>/images/foot.png')"></div>
        </div>
</body>
</c:if>





</html>
