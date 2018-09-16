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
	<script type="text/javascript" src="<%=path %>/MyJs/orderAdd_js.js"></script>
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
                            	 <small>填写派单</small>
                        </h1>
                    </div>
                    <form name="orderSendAddForm" action="orderSend-add" method="post">
                    <table border="0" class="tablecss">
                    	<tr>
                    		<td>物品内容简述:</td>
                    		<td><input class="form-control" style="width:275px" id="orderDescribe" name="orderDescribe"></td>
                    	</tr>
                    	<tr>
                    		<td>物品规格简述:</td>
                    		<td><input class="form-control" style="width:275px" id="orderSize" name="orderSize"></td>
                    		
                    	</tr>
                    	<tr>
                    		<td>派单寄送类型:</td>
                    		<td align="left">
                    			<label class="radio-inline">
                                   <input type="radio" name="orderType" id="orderType1" value="普通">普通
                                </label>
                                <label class="radio-inline">
                                   <input type="radio" name="orderType" id="orderType2" value="加急">加急
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="orderType" id="orderType3" value="可延缓">可延缓
                                </label>
                    		</td>
                    	</tr>
                    	<tr>
                    		<td>选择服务商</td>
                    		<td>
                    			<select class="form-control" id="selectSC" name="servicecompany.scId">
                    				<option value="0" style="color: #b6b6b6">系统分配服务商</option>
		                            
		                        </select>
                    		</td>
                    	</tr>
                    	<tr>
                    		<td>选择配送员</td>
                    		<td>
                    			<select class="form-control" id="selectSender" style="width:275px" name="sender.senderId">
                    				<option value="0" style="color: #b6b6b6">系统分配配送员</option>
		                        </select>
                    		</td>
<!--                     		<td> -->
<!--                     			<input type="button" class="btn btn-primary"  value="暂时不选择" id="noSelectSCAndSender"> -->
<!--                     		</td> -->
                    	</tr>
                    	<tr>
                    		<td>选择收件人</td>
                    		<td>
                    			<select class="form-control" id="selectGeter" name="geter.geterId">
		                            <option value="" style="color: #b6b6b6" disabled selected>请选择</option>
		                        </select>
		                        
                    		</td>
                    		<td>&nbsp;&nbsp;&nbsp;<input type="button" class="btn btn-default" id="addGeter" value="+" /></td>
                    	</tr>
                    	
                    	<tr style="display:none" class="trDisplay"> 
<!--                     	<tr> -->
                    		<td>收件人姓名:</td>
                    		<td><input class="form-control" style="width:275px" id="geterName" name="geterName"></td>
                    	</tr>
                    	<tr style="display:none" class="trDisplay">
                    		<td>收件人电话:</td>
                    		<td><input class="form-control" style="width:275px" id="geterPhone" name="geterPhone"></td>
                    	</tr>
                    	<tr style="display:none" class="trDisplay">
                    		<td>收件人地址:</td>
                    		<td><textarea class="form-control" rows="3" style="width:275px" id="geterAddress" name="geterAddress"></textarea></td>
                    	</tr>
                    	<tr>
                    		<td></td>
                    		<td>
                    			<input type="button" class="btn btn-primary" id="addordersend" value="马上寄快递" />
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
