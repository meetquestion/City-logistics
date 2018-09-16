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
        <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
     <!-- Google Fonts-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
	<style type="text/css">
		.tablecss{
			margin-left: 50px;
		}
		.tablecss tr{
			height:50px;
		}
		.tablecss td{
			width:75px;
		}
	</style>
	
</head>
  
  <body style="background-color: #E5EBF2 ">
  		<div >
            <div id="page-inner">
			<div class="row">
            	<div class="col-md-12">
                	<h1 class="page-header">
                      	编辑配送员    
                      	<small>当前配送员：</small>
                    </h1>
                </div>
            </div> 
                 <!-- /. ROW  -->
             <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                    
                        
                        
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <s:form action="sender-editSenderSave" method="post">
                                        <div class="form-group" >
                                        	<table class="tablecss">                                        		                                        		
	                                            
	                                            <tr>
	                                            	 <tr>
	                                            	<td><label style="width:100px">配送员ID：</label></td>
	                                            	<td><s:textfield name="senderId"  cssClass="form-control" style="width:275px" disabled="true" /></td>
	                                            	
	                                        	</tr>	
	                                        	
	                                        	<tr>
	                                            	 <tr>
	                                            	<td><label style="width:100px">配送员姓名：</label></td>
	                                            	<td><s:textfield name="senderName" cssClass="form-control" style="width:275px" /></td>
	                                            	
	                                        	</tr>	
		                                        <tr>
	                                            	 <tr> 
	                                            	<td><label style="width:100px">配送员电话：</label></td>
	                                            	<td><s:textfield name="senderPhone" cssClass="form-control" style="width:275px" /></td>
	                                            	
	                                        	</tr>	
		                                        	
	                                        	
	                                        	
	                                        	
                                        	</table>
                                        </div>
										
                                        	<s:submit cssClass="btn btn-default" value="确定" style="margin-left: 100px;"/>
                                       
                                    </s:form>
                                </div>
                               
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
			</div>
             <!-- /. PAGE INNER  -->
            </div>
            
            
            <!-- JS Scripts-->
		    <!-- jQuery Js -->
		    <script src="assets/js/jquery-1.10.2.js"></script>
		      <!-- Bootstrap Js -->
		    <script src="assets/js/bootstrap.min.js"></script>
		    <!-- Metis Menu Js -->
		    <script src="assets/js/jquery.metisMenu.js"></script>
		      <!-- Custom Js -->
		    <script src="assets/js/custom-scripts.js"></script>
  </body>
</html>
