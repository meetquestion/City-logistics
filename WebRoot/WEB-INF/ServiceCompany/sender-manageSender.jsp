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
    <title>配送员管理</title>
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
    <!-- 遮盖层 -->
    <link href="MyCss/fade.css" rel="stylesheet" />
    
    <script type="text/javascript" src="MyJs/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
    	
    	$(function(){
    		
    		/* $("#addSender").click(function(){
    		
    			alert("hhhh");
    		}); */
    		$("#deleteSender").click(function(){
    			
    			var $tr = $(this).parent().parent();//当前行 
    			var senderId = $(this).next(":input").val();
    			var flag = confirm("确定需要删除编号为  ' "+senderId+" ' 的配送员吗?");
    			if(flag){
    				
    				var url = this.href;
    				var args = {"time":new Date()};
    				$.post(url,args,function(data){
    					alert(data);
    					if(data=="1"){
    						alert("删除成功！");
    						$tr.remove();//删除当前行
    					}
    					else{
    						alert("删除失败！");
    					}
    				
    				});
    			}
    			
    			return false;
    		});
    	});
    	
    </script>
</head>
  
  <body>
  		<!-- Advanced Tables -->
        <div class="panel panel-default">
            <div class="panel-heading" >
                 	配送员管理
            </div>
            
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr>
                                <th>配送员ID</th>
                                <th>配送员姓名</th>
                                <th>配送员电话</th>
                                <th>操作</th>
                                
                                
                            </tr>
                        </thead>
                        <tbody>
                        	<s:iterator value="#request.manageSenderInfos">
                           <tr>
                                <td>${senderId }</td>
                                <td>${senderName }</td>
                                <td>${senderPhone }</td>                                
                                <td>
                                	<a href="sender-editSender?senderId=${senderId }">编辑</a>
                                	<a id="deleteSender" href="sender-deleteSender?senderId=${senderId }">删除</a>  
                                	<input type="hidden" value="${senderId }">                          	
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
	            });
	    </script>
	         <!-- Custom Js -->
	    <script src="assets/js/custom-scripts.js"></script>
  </body>
</html>
