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
                            	 <small>填写评价</small>
                            	 
                        </h1>
                    </div>
                    <form action="judge-addForOneOrdersend" method="post">
<!--                     <input type="hidden" value="${orderId }" name="ordersend.orderId"> -->
                    <input type="hidden" value="${orderId }" name="orderId">
                    <table border="0" class="tablecss">
                    	<tr>
                    	
                    		<td>服务商:</td>
                    	</tr>
                    	<tr>
                    		<td>打分</td>
                    		<td>
                    			<select name="scNum"  class="form-control">
                    				<option value="1">&nbsp;&nbsp;1</option>
                    				<option value="1">&nbsp;&nbsp;2</option>
                    				<option value="1">&nbsp;&nbsp;3</option>
                    				<option value="1">&nbsp;&nbsp;4</option>
                    				<option value="1">&nbsp;&nbsp;5</option>
                    			</select>
                    		</td>
                    	</tr>
                    	<tr>
                    		<td>评价及建议（200）</td>
                    		<td>
                    			<textarea class="form-control" rows="3" style="width:275px" id="scCon" name="scCon"></textarea>
                    		</td>
                    	</tr>
                    	<tr>
                    		<td>配送员:</td>
                    	</tr>
                    	<tr>
                    		<td>打分</td>
                    		<td>
                    			<select name="senderNum"  class="form-control">
                    				<option value="1">&nbsp;&nbsp;1</option>
                    				<option value="1">&nbsp;&nbsp;2</option>
                    				<option value="1">&nbsp;&nbsp;3</option>
                    				<option value="1">&nbsp;&nbsp;4</option>
                    				<option value="1">&nbsp;&nbsp;5</option>
                    			</select>
                    		</td>
                    	</tr>
                    	<tr>
                    		<td>评价及建议（200）</td>
                    		<td>
                    			<textarea class="form-control" rows="3" style="width:275px" id="senderCon" name="senderCon"></textarea>
                    		</td>
                    	</tr>
                    	<tr>
                    		<td></td>
                    		<td>
                    			<input type="submit" class="btn btn-primary" id="addordersend" value="确定" />
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
