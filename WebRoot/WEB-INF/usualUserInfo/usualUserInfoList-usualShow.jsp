<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Free Bootstrap Admin Template : Dream</title>
	<!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
     <!-- Morris Chart Styles-->
   
        <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
     <!-- Google Fonts-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
     <!-- TABLE STYLES-->
    <link href="assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
</head>
  
  <body>
  		<!-- Advanced Tables -->
        <div class="panel panel-default">
            <div class="panel-heading">
                 	用户信息显示
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr>
                                <th>姓名</th>
                                <th>电话</th>
                                <th>邮箱</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                        	<s:iterator value="#request.usualAllInfos">
                           <tr >
                                <td>${usualName }</td>
                                <td>${usualPhone }</td>
                                <td>${usualEmail }</td>
                                
                            </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                </div>
                
            </div>
        </div>
        <!--End Advanced Tables -->
    	<!-- JS Scripts-->
				    <!-- jQuery Js -->
				    <script src="assets/js/jquery-1.10.2.js"></script>
				      <!-- Bootstrap Js -->
				    <script src="assets/js/bootstrap.min.js"></script>
				    <!-- Metis Menu Js -->
				    <script src="assets/js/jquery.metisMenu.js"></script>
				     <!-- DATA TABLE SCRIPTS -->
				    <script src="assets/js/dataTables/jquery.dataTables.js"></script>
				    <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
				        <script>
				            $(document).ready(function () {
				                $('#dataTables-example').dataTable();
				            });
				    </script>
				         <!-- Custom Js -->
				    <script src="assets/js/custom-scripts.js"></script>
  </body>
</html>
