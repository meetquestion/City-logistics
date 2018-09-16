package com.TCWL.system.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.TCWL.system.entities.Geter;
import com.TCWL.system.entities.Ordersend;
import com.TCWL.system.entities.Sender;
import com.TCWL.system.entities.Servicecompany;
import com.TCWL.system.services.GeterServices;
import com.TCWL.system.services.OrderSendService;
import com.TCWL.system.services.SenderService;
import com.TCWL.system.services.ServiceCompanyService;
import com.TCWL.system.services.UserLoginListService;
import com.TCWL.system.util.GetDate;
import com.TCWL.system.util.GetSessionId;
import com.TCWL.system.util.ZxingUtil;
import com.alibaba.fastjson.JSON;
import com.google.zxing.WriterException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class OrderSendAction extends ActionSupport 
	implements ModelDriven<Ordersend>,Preparable,RequestAware{

	private OrderSendService orderSendService;
	private GeterServices geterServices;
	private ServiceCompanyService serviceCompanyService;
	private SenderService senderService;
	private UserLoginListService userLoginListService;
	
	public void setUserLoginListService(
			UserLoginListService userLoginListService) {
		this.userLoginListService = userLoginListService;
	}
	public void setOrderSendService(OrderSendService orderSendService) {
		this.orderSendService = orderSendService;
	}
	
	public void setGeterServices(GeterServices geterServices) {
		this.geterServices = geterServices;
	}
	
	public void setServiceCompanyService(
			ServiceCompanyService serviceCompanyService) {
		this.serviceCompanyService = serviceCompanyService;
	}
	
	public void setSenderService(SenderService senderService) {
		this.senderService = senderService;
	}
	
	public String add(){
		//附表单号 ： 000+yyyy+mm+dd+00000
		//设置ID
		String date = GetDate.getDate();
		//System.out.println(date);
		int size = orderSendService.getTodayNum(date);
		size = size + 1;
//		System.out.println("size:"+size);
		String orderId = date + String.format("%05d", size);
//		SimpleDateFormat simpleDateFormat
//		System.out.println(orderId);
		orderModel.setOrderId(orderId);
		//设置日期
		Date NowDate = new Date();
		Timestamp nousedate = new Timestamp(NowDate.getTime());
		orderModel.setOrderSendDate(nousedate);
		//设置状态
			// 先获取填单页面是否选择配送员
		Integer senderId = orderModel.getSender().getSenderId();//配送员ID
		Integer scId = orderModel.getServicecompany().getScId();//服务商ID
		System.out.println("senderId:"+senderId+" scId:"+scId);
			// 填充null的服务商
		if(0 == scId){
//			System.out.println("if:scId:"+scId);
			orderModel.setServicecompany(null);
		}
			// 填充状态
		if(0 == senderId){
//			System.out.println("if:senderId:"+senderId);
			orderModel.setSender(null);
			orderModel.setOrderStatus("未安排");
		}else{
			orderModel.setOrderStatus("未派送");
		}
		
		//添加配送员
		if(!"".equals(geterName)){
			//给geter set值
			geter.setGeterName(geterName);
			geter.setGeterPhone(geterPhone);
			geter.setGeterAddress(geterAddress);
			geter.setGeterSenderId(GetSessionId.getSessionID().toString());
			//保存新添的geter
			geterServices.saveOrUpdate(geter);
			//根据geterName获取geter
			orderModel.setGeter(geterServices.getGeter(geterName));
		}
		
//		System.out.println();
		//保存订单
		System.out.println(orderModel);
		Integer userId = GetSessionId.getSessionID();
		
		orderModel.setUserloginlist(userLoginListService.getOneUser(userId));
		orderSendService.saveOrUpdate(orderModel);
		
		request.put("orderForOneUser", orderSendService.showAllForOneUser());
		return "allordersend";
	}

	public void prepareAdd(){
		orderModel = new Ordersend();
		geter = new Geter();
	}
	
	// 显示当前用户的所有订单
	public String showAllForOneUser(){
		List<Ordersend> list = orderSendService.showAllForOneUser();
		for (Ordersend ordersend : list) {
			System.out.println("action:showAllForOneUser():"+ordersend);
		}
		
		request.put("orderForOneUser", list);
		return "showAllForOneUser";
	}
	
	// 删除订单
	public String deleteOneOrder(){
		try {
			orderSendService.deleteOneOrder(orderId);
			inputStream = new ByteArrayInputStream("1".getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("utf-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return "deleteOneOrder";
	}
	
	// 显示不同状态的订单
	public String showOrderForOneType(){
		String orderStatus = "";
//		System.out.println("action:showOrderForOneType():"+type);
		switch (type) {
		case "0":
			orderStatus = "未安排";
			break;
		case "1":
			orderStatus = "未派送";
			break;
		case "2":
			orderStatus = "正派送";
			break;
		case "3":
			orderStatus = "已送达";
			break;
		case "4":
			orderStatus = "已评价";
			break;
		default:
			break;
		}
		List<Ordersend> list = orderSendService.showOrderForOneType(orderStatus);
		request.put("showOrderForOneType", list);
		return "showOrderForOneType";
//		return null;
	}
	
	//添加服务商及配送员
	public String addServicecompanyAndSender(){
		System.out.println("addServicecompanyAndSender():"+orderId);
		ordersend = orderSendService.getOrdersendById(orderId);
//		request.put("Ordersend", ordersend);
		
		return "addServicecompanyAndSender";
	}
	
	//添加添加服务商及配送员确定按钮
	public String addSCAndSender(){
		System.out.println("action: addSCAndSender():orderId:"+orderId);
		Ordersend ordersend = orderSendService.getOrderById(orderId);
		Integer scId1 = Integer.valueOf(selectSC1);
		Integer senderId1 = Integer.valueOf(selectSender);
		
		System.out.println("orderId:"+orderId+" selectSC1:"+selectSC1+" selectSender:"+selectSender);
		System.out.println("");
		
		Servicecompany servicecompany = serviceCompanyService.getOneById(scId1);
		Sender sender = senderService.getOneById(senderId1);
		
		ordersend.setServicecompany(servicecompany);
		ordersend.setSender(sender);
		ordersend.setOrderStatus("未派送");
		
		orderSendService.saveOrUpdate(ordersend);
		
		request.put("showOrderForOneType", orderSendService.showOrderForOneType("未派送"));
		return "showAllForOneUser";
	}
	
	public String createImgQRCode() throws WriterException, IOException{
		System.out.println("2222222222222");
		Ordersend ordersend = orderSendService.getOrdersendById(orderId);
		Ordersend ordersend2 = new Ordersend();
		
		ordersend2.setOrderId(ordersend.getOrderId());
		ordersend2.setOrderDescribe(ordersend.getOrderDescribe());
		ordersend2.setOrderSize(ordersend.getOrderSize());
		ordersend2.setOrderSendDate(ordersend.getOrderSendDate());
		ordersend2.setOrderStatus(ordersend.getOrderStatus());
		ordersend2.setOrderType(ordersend.getOrderType());
		
		String json = JSON.toJSONString(ordersend2);
		System.out.println(json);
		ZxingUtil.createQRCode(json, new File("E:\\eclipse\\tomcat\\tomcat7.0\\webapps\\TCWL1\\ImgQRCode\\",orderId+".png"));
		
		return "createImgQRCode";
	}
	
	// 参数+geter seter 属性
	public void prepare() throws Exception {}

	private Ordersend orderModel;
	
	public Ordersend getModel() {
		return orderModel;
	}
	
	private Ordersend ordersend;
	
	public void setOrdersend(Ordersend ordersend) {
		this.ordersend = ordersend;
	}
	
	public Ordersend getOrdersend() {
		return ordersend;
	}

	private Geter geter;
	private String geterName;
	private String geterPhone;
	private String geterAddress;
	private String geterId;
	
	public String getGeterName() {
		return geterName;
	}

	public void setGeterName(String geterName) {
		this.geterName = geterName;
	}

	public String getGeterPhone() {
		return geterPhone;
	}

	public void setGeterPhone(String geterPhone) {
		this.geterPhone = geterPhone;
	}

	public String getGeterAddress() {
		return geterAddress;
	}

	public void setGeterAddress(String geterAddress) {
		this.geterAddress = geterAddress;
	}

	public String getGeterId() {
		return geterId;
	}

	public void setGeterId(String geterId) {
		this.geterId = geterId;
	}

	private String orderId;
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	private Map<String, Object> request;
	
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
	
	private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	private String selectSC1;
	private String selectSender;

	public String getSelectSC1() {
		return selectSC1;
	}

	public void setSelectSC1(String selectSC1) {
		this.selectSC1 = selectSC1;
	}

	public String getSelectSender() {
		return selectSender;
	}

	public void setSelectSender(String selectSender) {
		this.selectSender = selectSender;
	}
	
	
	/**
	 * by hzx
	 */
	
	//获取传值*********************************************************************	
	private Integer senderId;
	
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	
	// 未安排的订单******************************************************************
	public String noDeal(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer scId = new Integer((Integer) u_Id);
		//System.out.println(scId+"s1");
		//System.out.println(orderSendService.getNoDealById(scId)+"s2");
		request.put("noDealInfos", orderSendService.getNoDealById(scId));
		return "noDeal";
	}
	
	// 为未安排的订单添加配送人员
	public String addSender(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer scId = new Integer((Integer) u_Id);
				
		request.put("senderInfos", senderService.getSenderInfosById(scId));
		request.put("orderId", orderId);//当前订单的id
		return "addSender";
	}
	
	public String addSenderSave(){
		
		/*try {
			Sender sender = new Sender();
			orderModel.setSender(sender.setSenderId(senderId));
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			e.printStackTrace();
		}*/
		Sender sender = new Sender();
		sender.setSenderId(senderId);
		orderModel.setSender(sender);
		orderModel.setOrderStatus("未派送");
		//System.out.println(orderModel);
		orderSendService.saveOrUpdate(orderModel);
		return "addSenderSave";
	}
	
	public void prepareAddSenderSave(){
		
		orderModel = orderSendService.getOrderById(orderId);
	}
	
	// 未派送的订单******************************************************************
	public String noSend(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer scId = new Integer((Integer) u_Id);
		
		request.put("noSendInfos", orderSendService.getNoSendById(scId));
						
		return "noSend";
	}
	
	
	// 正在派送的订单*****************************************************************
	public String sendNow(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer scId = new Integer((Integer) u_Id);
		
		request.put("sendNowInfos", orderSendService.getSendNowById(scId));
				
		return "sendNow";
	}
	
	
	// 已送达的订单******************************************************************
	public String sendReady(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer scId = new Integer((Integer) u_Id);
				
		request.put("sendReadyInfos", orderSendService.getSendReadyById(scId));
		return "sendReady";
	}
	
	//配送员**********************************************************************
	
	// 未派送的订单 --配送员
	public String noSendBySender(){
		
		//获取session中的user_Id
//		HttpServletRequest req = ServletActionContext.getRequest();
//		Object u_Id = req.getSession().getAttribute("userId");
//		Integer user_Id = new Integer((Integer) u_Id);
		System.out.println("!");
		Integer user_Id = GetSessionId.getSessionID();
		System.out.println("AAA:"+user_Id);
		
		//获取userSenderId
		String userSenderId = userLoginListService.getRoleByUserId(user_Id).get(0).getUserSenderId();
		Integer senderId = Integer.valueOf(userSenderId);
		System.out.println("BBB:"+senderId+"sss");
		
		//获取配送员所属的服务商id	
		Integer scId = senderService.getOneSenderById(senderId).getServicecompany().getScId();
		//System.out.println(scId+"ss"+senderId);
		request.put("noSendInfosBySender", orderSendService.getNoSendBySenderId(scId, senderId));
		return "noSendBySender";
	}
	
	//确认接受订单
	public String  acceptOrder(){
		
		orderModel = orderSendService.getOrderById(orderId);
		orderModel.setOrderStatus("正派送");
		//System.out.println(orderModel);
		orderSendService.saveOrUpdate(orderModel);
		return "acceptOrder";
	}
	
	//正在派送的订单
	public String sendNowBySender(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer user_Id = new Integer((Integer) u_Id);
		
		//获取userSenderId
		String userSenderId = userLoginListService.getRoleByUserId(user_Id).get(0).getUserSenderId();
		Integer senderId = Integer.valueOf(userSenderId);
		
		//获取配送员所属的服务商id	
		Integer scId = senderService.getOneSenderById(senderId).getServicecompany().getScId();
		//System.out.println(scId+"ss"+senderId);
		request.put("sendNowInfosBySender", orderSendService.getsendNowBySenderId(scId, senderId));
		return "sendNowBySender";
	}
	
	//确认已送达
	public String overOrder(){
		
		orderModel = orderSendService.getOrderById(orderId);
		orderModel.setOrderStatus("已送达");
		orderSendService.saveOrUpdate(orderModel);
		return "overOrder";
	}
	
	//已送达订单
	public String sendReadyBySender(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer user_Id = new Integer((Integer) u_Id);
		
		//获取userSenderId
		String userSenderId = userLoginListService.getRoleByUserId(user_Id).get(0).getUserSenderId();
		Integer senderId = Integer.valueOf(userSenderId);
		
		//获取配送员所属的服务商id	
		Integer scId = senderService.getOneSenderById(senderId).getServicecompany().getScId();
		//System.out.println(scId+"ss"+senderId);
		request.put("sendReadyInfosBySender", orderSendService.getsendReadyBySenderId(scId, senderId));
		
		return "sendReadyBySender";
	}
	
	//已评价订单
	public String sendJudgeBySender(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer user_Id = new Integer((Integer) u_Id);
		
		//获取userSenderId
		String userSenderId = userLoginListService.getRoleByUserId(user_Id).get(0).getUserSenderId();
		Integer senderId = Integer.valueOf(userSenderId);
		
		//获取配送员所属的服务商id	
		Integer scId = senderService.getOneSenderById(senderId).getServicecompany().getScId();
		//System.out.println(scId+"ss"+senderId);
		request.put("sendJudgeInfosBySender", orderSendService.getsendJudgeBySenderId(scId, senderId));
		
		return "sendJudgeBySender";
	}


}
