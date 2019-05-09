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
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
           function zuoyesDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/zuoyesDel.action?id="+id;
               }
           }
           function down1(fujianPath,fujianYuashiMing)
           {
               var url="<%=path %>/updown/updown.jsp?fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
		       url=encodeURI(url); 
               url=encodeURI(url); 
               window.open(url,"_self");
           }
           
           function zuoyesHuifu(id)
           {
               var strUrl="<%=path %>/admin/zuoyes/zuoyesHuifu.jsp?id="+id;
               var ret = window.showModalDialog(strUrl,"","dialogWidth:600px; dialogHeight:300px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
               window.location.reload();
           }
           
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="100" background="<%=path %>/images/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
				    <td width="5%">序号</td>
					<td width="15%">作业名称</td>
					<td width="10%">附件下载</td>
					<td width="10%">提交时间</td>
					
					<td width="10%">老师批语</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.zuoyesList}" var="zuoyes" varStatus="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${ss.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${zuoyes.mingcheng}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="down1('${zuoyes.fujian}','${zuoyes.fujian}')" style="font-size: 10px;color: red">附件下载</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${zuoyes.tijiaoshi}
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						${zuoyes.huifu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="zuoyesDel(${zuoyes.id})"/>
						<input type="button" value="添加评语" onclick="zuoyesHuifu(${zuoyes.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
			
	</body>
</html>
