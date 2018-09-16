<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'showImg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="assets/js/jquery-1.10.2.js"></script>
	<script type="text/javascript">
		$(function(){
// 			alert("1");
			var orderId = document.getElementById("orderId").value;
			document.getElementById("img").src = "<%=path %>/ImgQRCode/"+orderId+".png";
// 			alert(document.getElementById("img").src);
		});
	</script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  <center>
  <input type="hidden" value="${orderId }" id="orderId">
  <br>
  	<div>
  		<img alt="" id="img" style="width: 200px;height: 200px">
  	</div>
  </center>
  </body>
</html>
