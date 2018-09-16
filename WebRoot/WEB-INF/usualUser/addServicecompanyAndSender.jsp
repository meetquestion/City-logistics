<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
	<script type="text/javascript">
			$(document).ready(function () {
// 				alert("1");
				var scName = document.getElementById("hiddenScName").value;
				var scId = document.getElementById("hiddenScId").value;
// 				alert(scName);
				if(scName == ""||scName == null){
					$("#scDiv").append("<select  class='form-control' id='selectSC1' name='selectSC1'><option>请选择</option></select>");
					var url = "servicecompany-getAll";
					var args = {};
					$.getJSON(url,args,function(data){
						for(var i=0;i<data.length;i++){
							var scname = data[i].scName;
							var scid = data[i].scId;
							//填充服务商
							$("#selectSC1").append("<option value='"+ scid +"'>"+ scname +"</option>");
						}
					});
					
					$("#selectSC1").change(function(){
						$("#selectSender option:not(:first)").remove();
						var id = $(this).val();
						var url_Sender = "sender-getForOneServicecompany";
						var args1 = {
							"scId" : id	
						};
						$.getJSON(url_Sender,args1,function(data){
							for(var i=0;i<data.length;i++){
								var senderName = data[i].senderName;
								var senderId = data[i].senderId;
								//填充配送员
								$("#selectSender").append("<option value='"+ senderId +"'>"+ senderName +"</option>");
							}
						});
					
					});
					
// 					$("#scDiv").append("</select>");
				}else{
					$("#scDiv").append("<input value='${ordersend.servicecompany.scName }' class='form-control' style='width:275px' id='orderSize' name='selectSC2' disabled='disabled'>")
							   .append("<input value='${ordersend.servicecompany.scId }' type='hidden' name='selectSC1'>");
					var url_Sender = "sender-getForOneServicecompany";
						var args1 = {
							"scId" : scId	
						};
						$.getJSON(url_Sender,args1,function(data){
							for(var i=0;i<data.length;i++){
								var senderName = data[i].senderName;
								var senderId = data[i].senderId;
								//填充配送员
								$("#selectSender").append("<option value='"+ senderId +"'>"+ senderName +"</option>");
							}
						});
				}
				
		
			});
			
		</script>
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
                            	 <small>添加服务商及配送员 </small>
                        </h1>
                    </div>
                    <form action="orderSend-addSCAndSender" method="post">
                    <input type="hidden" value="${ordersend.orderId }" name="orderId">
                    <table border="0" class="tablecss">
                    	<tr>
                    		<td>订单编号:</td>
                    		<td>
                    			<input value="${ordersend.orderId }" class="form-control" style="width:275px" id="orderDescribe" name="orderId1" disabled="disabled">
                    		
                    		</td>
                    	</tr>
                    	<tr>
                    		<td>物品描述:</td>
                    		<td><input value="${ordersend.orderDescribe }" class="form-control" style="width:275px" id="orderSize" name="orderDescribe1" disabled="disabled"></td>
                    		
                    	</tr>
                    	<tr>
                    		<td>选择服务商</td>
                    		<td>
                    			<input id="hiddenScName" type="hidden" value="${ordersend.servicecompany.scName }">
                    			<input id="hiddenScId" type="hidden" value="${ordersend.servicecompany.scId }">
                    			<div id="scDiv">
                    			
                    			</div>
                    		</td>
                    	</tr>
                    	<tr>
                    		<td>选择配送员</td>
                    		<td>
                    			<select class="form-control" id="selectSender" style="width:275px" name="selectSender">
                    				<option value="0" style="color: #b6b6b6">请选择</option>
		                        </select>
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
