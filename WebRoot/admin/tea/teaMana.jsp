<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
           function teaDel(teaId)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/teaDel.action?teaId="+teaId;
               }
           }
           
           function teaAdd()
           {
                 var url="<%=path %>/admin/tea/teaAdd.jsp";
				 window.location.href=url;
           }
           function dayin()
           {
              window.print();
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="17" background="<%=path %>/images/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
				    <td width="4%">序号</td>
				    <td width="10%">编号</td>
					<td width="10%">姓名</td>
					<td width="10%">性别</td>
					
					<td width="10%">年龄</td>
					<td width="10%">账号</td>
					<td width="10%">密码</td>
					<td width="10%">操作</td>
		        </tr>	
				<s:iterator value="#request.teaList" id="tea" status="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#ss.index+1"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#tea.teaBianhao"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#tea.teaRealname"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#tea.teaSex"/>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#tea.teaAge"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#tea.loginName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#tea.loginPw"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="teaDel(<s:property value="#tea.teaId"/>)" class="pn-loperator">删除</a>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 8px;">
			  <tr>
			    <td>
			      <input type="button" value="添加老师" style="width: 80px;" onclick="teaAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
