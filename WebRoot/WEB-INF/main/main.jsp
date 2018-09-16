<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
    
	

  </head>
  	<frameset rows="9%,*" cols="*" frameborder="yes" framespacing="1" border="1" >
    		<frame name="topfrm" src="userLoginList-top" noresize="noresize" scrolling="no"/>
    		<frameset cols="15%,*" frameborder="yes" framespacing="1" >
    			<frame name="leftfrm" src="userLoginList-leftSide" noresize="noresize" scrolling="auto"/>
    			<frame name="rightfrm" src="userLoginList-homePage" noresize="noresize" scrolling="auto"/>
    		</frameset>
    	</frameset>
  <body>
    	
  </body>
</html>
