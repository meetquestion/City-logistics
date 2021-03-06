<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>开始派单</title>
    <!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
	<script type="text/javascript" src="<%=path %>/MyJs/jquery-1.9.1.min.js"></script>
	<style type="text/css">
		.tablecss{
			margin-left: 50px;
		}
		.tablecss tr{
			height:50px;
		}
		.tablecss td{
			width:175px;
		}
	</style>
  </head>
  
  <body>
  	<!-- 右侧栏开始 -->
        <div>
                    <div class="col-md-12" style="margin-top: 20px">
                        <h1 class="page-header">
                            	 <small>添加收件人</small>
                        </h1>
                    </div>
                    <form name="orderSendAddForm" action="geter-addForOneUser" method="post">
                    <table border="0" class="tablecss">
                    	<tr> 
<!--                     	<tr> -->
                    		<td>收件人姓名:</td>
                    		<td><input class="form-control" style="width:275px" id="geterName" name="geterName"></td>
                    	</tr>
                    	<tr class="trDisplay">
                    		<td>收件人电话:</td>
                    		<td><input class="form-control" style="width:275px" id="geterPhone" name="geterPhone"></td>
                    	</tr>
                    	<tr class="trDisplay">
                    		<td>收件人地址:</td>
                    		<td><textarea class="form-control" rows="3" style="width:275px" id="geterAddress" name="geterAddress"></textarea></td>
                    	</tr>
                    	<tr>
                    		<td></td>
                    		<td>
                    			<input type="submit" class="btn btn-primary" id="addordersend" value="添加" />
                    		</td>
                    	</tr>
                    </table>
					</form>
				
        </div>
        <!-- 右侧栏结束 -->

    	<!-- JS Scripts-->
	    <!-- jQuery Js -->
	    <script src="assets/js/jquery-1.10.2.js"></script>
	    <!-- Bootstrap Js -->
	    <script src="assets/js/bootstrap.min.js"></script>
	    <!-- Metis Menu Js -->
	    <script src="assets/js/jquery.metisMenu.js"></script>
	    <!-- Morris Chart Js -->
	    <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
	    <script src="assets/js/morris/morris.js"></script>
	    <!-- Custom Js -->
	    <script src="assets/js/custom-scripts.js"></script>

  </body>
</html>
