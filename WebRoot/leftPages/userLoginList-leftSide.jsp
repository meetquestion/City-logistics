<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    
    <style type="text/css" > 
        html{            
            background-color:#ADD9E6; 
		    color:#000000; 
		    font-size:12px; 
		    font-family:SimSun; 
		    border-left:#ECF1F4 0px solid; 
		    border-right:#ECF1F4 0px solid; 
		    margin:0;                              /*控制滚动条左右侧实线颜色*/ 
            overflow-x:hidden;                      /*隐藏底部的横向滚动条*/ 
            scrollbar-arrow-color:#034079;          /*三角箭头的颜色*/ 
            scrollbar-3dlight-color:#ADD9E6;        /*立体滚动条亮边的颜色*/ 
            scrollbar-highlight-color:#89C4D5;      /*滚动条空白部分的颜色*/ 
            scrollbar-shadow-color:#89C4D5;        /*立体滚动条阴影的颜色*/ 
            scrollbar-darkshadow-color:#ADD9E6;    /*滚动条强阴影颜色*/ 
            scrollbar-track-color:#ADD9E6;          /*立体滚动条背景颜色*/ 
            scrollbar-base-color:#ADD9E6;          /*滚动条的基本颜色*/ 
      } 
    </style> 
    
    <script type="text/javascript" src="MyJs/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
    	
    	$("#leftReady").ready(function(){
    	
    		var url = "userLoginList-judgeRoleList";
    		var args = {"time":new Date()};
    		
    		$.post(url,args,function(data){
    			if(data=="1"){
    				//普通用户
    				$("#usualOne").show();
    				$("#usualTwo").show(); 
    				$("#usualThree").show();
    				$("#usualFour").show(); 
    				$("#usualFive").show(); 
    				$("#usualSix").show();    				
    			}
    			else if(data=="2"){
    				//服务商
    				//$("#serviceOne").show();
    				$("#serviceTwo").show();
    				$("#serviceThree").show();
    				//$("#serviceFour").show();
    			}
    			else if(data=="3"){
    				//配送员
    				$("#senderOne").show();
    				
    			}
    			else if(data=="4"){
    				//管理员
    				$("#manageOne").show();
    				
    			}
    		})
    	});
    	
    </script>
</head>
  
  <body id="leftReady">
  
  		<!-- BY HZX hahaha-->
  		
    	<div id="wrapper">
    	
    		<!-- 左侧栏开始 -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
					
					<!-- 共有的 -->
                    <li>
                        <a class="active-menu" href="userLoginList-homePage" target="rightfrm" ><i class="fa fa-dashboard"></i> 首页</a>
                    </li>
                    
                   <%--  <li>
                        <a href="usualUserInfoList-usualShow?userId=${userId }" target="rightfrm"><i class="fa fa-bar-chart-o"></i> 用户信息显示</a>
                    </li> --%>
                    
                    <!-- 普通用户 -->
                    <li id="usualOne" style="display: none;">
                        <a href="userLoginList-orderAdd" target="rightfrm"><i class="fa fa-desktop"></i>填写订单</a>
                    </li>
<!--                     <li> -->
<!--                         <a href="orderSend-showAllForOneUser" target="rightfrm"><i class="fa fa-desktop"></i>我的订单</a> -->
<!--                     </li> -->
                    <li id="usualTwo" style="display: none;">
                        <a href="orderSend-showAllForOneUser" id="hdOrder" target="rightfrm"><i class="fa fa-table"></i>我的订单<span class="fa arrow"></span></a>
                        <ul id="order" class="nav nav-second-level" >
                            <li>
                                <a href="orderSend-showOrderForOneType?type=0" target="rightfrm">待安排</a>
                            </li>
                            <li>
                                <a href="orderSend-showOrderForOneType?type=1" target="rightfrm">待派送</a>
                            </li>
                            <li>
                                <a href="orderSend-showOrderForOneType?type=2" target="rightfrm">待收货</a>
                            </li>
                            <li>
                                <a href="orderSend-showOrderForOneType?type=3" target="rightfrm">待评价</a>
                            </li>
                            <li>
                                <a href="orderSend-showOrderForOneType?type=4" target="rightfrm">历史订单</a>
                            </li>
                        </ul>
                    </li>
                    <li  id="usualThree" style="display: none;">
                        <a href="usualUserInfoList-usualInputOrEdit?userId=${userId }" target="rightfrm"><i class="fa fa-desktop"></i> 用户信息</a>
                    </li>
                    
					<li  id="usualFour" style="display: none;">
                        <a href="usualUserInfoList-usualShow?userId=${userId }" target="rightfrm"><i class="fa fa-bar-chart-o"></i> 用户信息显示</a>
                    </li>
                    
					<li  id="usualFive" style="display: none;">
                        <a href="map-showTry" target="rightfrm"><i class="fa fa-bar-chart-o"></i>查看地图</a>
                    </li>
                    
                    <li  id="usualSix" style="display: none;">
                        <a href="#" id="hdManage"><i class="fa fa-table"></i>管理<span class="fa arrow"></span></a>
                        <ul id="manage" class="nav nav-second-level" >
                            <li>
                                <a href="geter-addShow" target="rightfrm">添加收件人及地址</a>
                            </li>
                            <li>
                                <a href="geter-showGeterForOneUser" target="rightfrm">我的收件人</a>
                            </li>
                        </ul>
                    </li>
                    
                    
					<!-- 服务商 -->                   
					<li id="serviceOne" style="display: none;">
                        <a href="" target="rightfrm"><i class="fa fa-bar-chart-o"></i>服务商</a>
                    </li>
                    
                    <!-- <li>
                        <a href=""><i class="fa fa-qrcode"></i> Tabs & Panels</a>
                    </li> -->
                    
                    <li id="serviceTwo" style="display: none;">
                        <a href="#" id="hdData"><i class="fa fa-table"></i>订单管理<span class="fa arrow"></span></a>
                        <ul id="data" class="nav nav-second-level" >
                            <li>
                                <a href="orderSend-noDeal" target="rightfrm">未安排配送员</a>
                            </li>
                            <li>
                                <a href="orderSend-noSend" target="rightfrm">未派送</a>
                            </li>
                            <li>
                                <a href="orderSend-sendNow" target="rightfrm">正在派送</a>
                            </li>
                            <li>
                                <a href="orderSend-sendReady" target="rightfrm">已送达</a>
                            </li>
                            
                        </ul>
                    </li>
                    
                    <li id="serviceThree" style="display: none;">
                        <a href="#" id="senderManage"><i class="fa fa-table"></i>配送员管理<span class="fa arrow"></span></a>
                        <ul id="sender" class="nav nav-second-level" >
                            <li>
                                <a href="sender-addSender" target="rightfrm">添加配送员</a>
                            </li>
                            <li>
                                <a href="sender-manageSender" target="rightfrm">管理配送员</a>
                            </li>                            
                        </ul>
                    </li>
                    
                    <li id="serviceFour" style="display: none;">
                        <a href="#" id="dataAnalyse"><i class="fa fa-table"></i>数据分析<span class="fa arrow"></span></a>
                        <ul id="dataA" class="nav nav-second-level" >
                            <li>
                                <a href="#" target="rightfrm">年度分析</a>
                            </li>
                            <li>
                                <a href="#" target="rightfrm">配送员绩效分析</a>
                            </li>                            
                        </ul>
                    </li>
                    
                    <!-- <li>
                        <a href="form.html"><i class="fa fa-edit"></i> Forms </a>
                    </li> -->

					<!-- 配送员 -->
                    <li id="senderOne" style="display: none;">
                        <a href="#" id="hdFirst"><i class="fa fa-sitemap"></i> 配送员<span class="fa arrow" ></span></a>
                         <ul id="first" class="nav nav-second-level" >
                            
                            <li>
                                <a href="orderSend-noSendBySender" target="rightfrm">未派送</a>
                            </li>
                            <li>
                                <a href="orderSend-sendNowBySender" target="rightfrm">正在派送</a>
                            </li>
                            <li>
                                <a href="orderSend-sendReadyBySender" target="rightfrm">已送达</a>
                            </li>
                            <li>
                                <a href="orderSend-sendJudgeBySender" target="rightfrm">已评价</a>
                            </li>
                            
                        </ul>
                    </li>
                                     
                    <!-- 管理员 -->
                    <li id="manageOne" style="display: none;">
                        <a href="" target="rightfrm"><i class="fa fa-desktop"></i>管理员</a>
                        <ul id="" class="nav nav-second-level" >
                        
                            <li>
                                <a id="hdSecondOutput" href="#">销项发票分析<span class="fa arrow"></span></a>
                                <ul  id="secondOutput" class="nav nav-third-level">
                                    <li>
                                        <a href="#">客户地区分析</a>
                                    </li>                        
                                </ul>
                            </li>
                            
                            <li>
                                <a id="hdSecondInput" href="#">进项发票分析<span class="fa arrow"></span></a>
                                <ul  id="secondInput" class="nav nav-third-level">
                                    <li>
                                        <a href="dataInput-areaPieInput" target="rightfrm">供应商地区分析</a>
                                    </li>
                                    <li>
                                        <a href="#">季节性分布</a>
                                    </li>
                                    <li>
                                        <a href="dataInput-supplierPieInput" target="rightfrm">重点供应商</a>
                                    </li>
                                    <li>
                                        <a href="#">历史同比</a>
                                    </li>
                                    <li>
                                        <a href="#">环比增长率</a>
                                    </li>
                                </ul>
                            </li>
                            
                            <li>
                                <a id="hdSecondAll" href="#">进销结合分析<span class="fa arrow"></span></a>
                                <ul  id="secondAll" class="nav nav-third-level">
                                    <li>
                                        <a href="#">库存备货</a>
                                    </li>                                    

                                </ul>

                            </li>
                        </ul>
                    </li>
                    
                    
                    <!-- 共有的 -->
                    <li>
                        <a ><i class="fa" style="height: 500px;"></i> </a>
                    </li>
                   
                  
                </ul>
					
            </div>

        </nav>
        <!-- 左侧栏结束 -->
        
        <!-- /. NAV SIDE  -->
        
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
	    
	    <script type="text/javascript">
	    
			$(function(){
				
				$(document).ready(function(){
					$("#first").hide();
					$("#secondAll").hide();
					$("#secondOutput").hide();
					$("#secondInput").hide();
					$("#data").hide();
					
					$("#sender").hide();
					$("#dataA").hide();
					$("#order").hide();
					$("#manage").hide();
				});
				//点击隐藏
				$("#hdFirst").bind("click",function(){
					//alert("hhh");
					$("#first").slideToggle();
				});
				
				$("#hdSecondAll").bind("click",function(){
					//alert("hhh");
					$("#secondAll").slideToggle();
				});
				
				$("#hdSecondOutput").bind("click",function(){
					//alert("hhh");
					$("#secondOutput").slideToggle();
				});
				
				$("#hdSecondInput").bind("click",function(){
					//alert("hhh");
					$("#secondInput").slideToggle();
				});
				
				$("#hdData").bind("click",function(){
					//alert("hhh");
					$("#data").slideToggle();
				});
				
				$("#senderManage").bind("click",function(){
					//alert("hhh");
					$("#sender").slideToggle();
				});
				
				$("#dataAnalyse").bind("click",function(){
					//alert("hhh");
					$("#dataA").slideToggle();
				});
				$("#hdOrder").bind("click",function(){
					//alert("hhh");
					$("#order").slideToggle();
				});
				$("#hdManage").bind("click",function(){
					//alert("hhh");
					$("#manage").slideToggle();
				});
			});
	    
	    </script>
   
        
    	</div>
  </body>
</html>
