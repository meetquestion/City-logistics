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
            	<s:if test="type == 0">
            		待安排订单信息
            	</s:if>
            	<s:elseif test="type == 1">
            		待派送订单显示
            	</s:elseif>
            	<s:elseif test="type == 2">待收货订单显示</s:elseif>
            	<s:elseif test="type == 3">待评价订单显示</s:elseif>
            	<s:else>历史订单显示</s:else>
                 	
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr>
                                <th>订单编号</th>
                                <th>物品名称</th>
                                <th>物品规格</th>
                                <th>派件类型</th>
                                <th>寄送时间</th>
                                <th>到达时间</th>
                                <th>当前状态</th>
                                <th>服务商</th>
                                <th>配送员</th>
                                <th>收件人</th>
                                <th>操作</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                        	<s:iterator value="#request.showOrderForOneType">
                           <tr>
                                <td>${orderId }</td>
                                <td>${orderDescribe }</td>
                                <td>${orderSize }</td>
                                <td>${orderType }</td>
                                <td>
                                	<s:date name="orderSendDate" format="yyyy-MM-dd"/>
<!--                                 	${orderSendDate } -->
                                </td>
                                <td>
                                	<s:date name="orderGetDate" format="yyyy-MM-dd"/>
<!--                                 	${orderGetDate } -->
                                </td>
                                <td>${orderStatus }</td>
                                <td>${servicecompany.scName }</td>
                                <td>${sender.senderName }</td>
                                <td>${geter.geterName }</td>
                                <td>
                                	<s:if test="orderStatus == '未安排'">
                                		<a href="orderSend-addServicecompanyAndSender?orderId=${orderId }" style="color: blue;font-size: 12px">选择服务商及配送员</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                	</s:if>
                                	<s:elseif test="orderStatus == '未派送'">
                                		<a href="" style="color: blue;font-size: 12px" id="hurry">催促派送</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                	</s:elseif>
                                	<s:elseif test="orderStatus == '正派送'">
                                		<a href="" style="color: blue;font-size: 12px">查看物流</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                	</s:elseif>
                                	<s:elseif test="orderStatus == '已送达'">
                                		<a href="judge-showJudgeJsp?orderId=${orderId }" style="color: blue;font-size: 12px">评价</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                	</s:elseif>
                                	<s:else>
                                		<a href="judge-showOneByOrdersend?orderId=${orderId }" style="color: blue;font-size: 12px">查看评价</a>&nbsp;&nbsp;&nbsp;&nbsp;
	                                	<a href="orderSend-deleteOneOrder?orderId=${orderId }" style="color: blue;font-size: 12px" id="delete">删除订单</a>
	                                	<input type="hidden" value="${orderId }">
                                	</s:else>
                                </td>
                                
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
				                $("#delete").click(function(){
				                	var orderId = $(this).next(":hidden").val();
// 				                	alert(orderId);
				                	var flag = confirm("确定要删除编号为" + orderId + "的信息吗？");
				                	if(flag){
				                		var $tr = $(this).parent().parent();
				                		//
				                		var url = this.href;
				                		var args = {};
				                		$.post(url,args,function(data){
				                			if(data == "1"){
				                				alert("删除成功！");
				                				$tr.remove();
				                			}else{
				                				alert("删除失败！")
				                			}
				                			
				                		});
				                	}
				                	return false;
				                });
				                $("#hurry").click(function(){
				                	alert("催单成功！");
				                });
				            });
				    </script>
				         <!-- Custom Js -->
				    <script src="assets/js/custom-scripts.js"></script>
  </body>
</html>
