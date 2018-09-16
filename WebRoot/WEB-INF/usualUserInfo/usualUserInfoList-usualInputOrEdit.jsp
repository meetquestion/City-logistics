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
                            	 <small>用户信息</small>
                    </h1>
                </div>
            </div> 
                 <!-- /. ROW  -->
             <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                    
                        <div class="panel-heading">
                        	<s:if test="#session.usualUserId==null">
                            	用户添加信息
                            </s:if>
                            <s:else>
                            	用户编辑信息
                            </s:else>
                        </div>
                        
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <s:form action="usualUserInfoList-usualInputOrEditSave" method="post">
                                        <div class="form-group" >
                                        	<table class="tablecss">
                                        		
                                        		<s:if test="#session.usualUserId==null">
		                                            <tr>
		                                            	<td><label>姓名：</label></td>
		                                            	<td><s:textfield name="usualName" cssClass="form-control" style="width:275px" /></td>
		                                            	
		                                        	</tr>
		                                        	<tr>
		                                            	<td><label>电话：</label></td>
		                                            	<td><s:textfield name="usualPhone" cssClass="form-control" style="width:275px" /></td>
		                                            	
		                                        	</tr>
		                                        	<tr>
		                                            	<td><label>邮箱：</label></td>
		                                            	<td><s:textfield name="usualEmail" cssClass="form-control" style="width:275px" /></td>
		                                            	<s:hidden name="userId" value="%{#session.userId}"></s:hidden>
		                                        	</tr>
	                                        	</s:if>
	                                        	
	                                        	<s:else>
	                                        		 <tr>
		                                            	<td><label>姓名：</label></td>
		                                            	<td><s:textfield name="usualName" cssClass="form-control" style="width:275px" /></td>
		                                            	
		                                        	</tr>
		                                        	<tr>
		                                            	<td><label>电话：</label></td>
		                                            	<td><s:textfield name="usualPhone" cssClass="form-control" style="width:275px" /></td>
		                                            	
		                                        	</tr>
		                                        	<tr>
		                                            	<td><label>邮箱：</label></td>
		                                            	<td><s:textfield name="usualEmail" cssClass="form-control" style="width:275px" /></td>
		                                            	<s:hidden name="userId" value="%{#session.userId}"></s:hidden>
		                                        	</tr>
	                                        	</s:else>
                                        	</table>
                                        </div>
										<s:if test="#session.usualUserId==null">
                                        	<s:submit cssClass="btn btn-default" value="提交" style="margin-left: 100px;"/>
                                        </s:if>
                                        <s:else>
                                        	<s:submit cssClass="btn btn-default" value="保存" style="margin-left: 100px;"/>
                                        </s:else>
                                        <s:reset  cssClass="btn btn-default" value="重置" style="margin-left: 100px;"/>
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
