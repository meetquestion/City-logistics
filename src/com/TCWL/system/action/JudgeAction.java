package com.TCWL.system.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.TCWL.system.entities.Judge;
import com.TCWL.system.entities.Ordersend;
import com.TCWL.system.services.JudgeService;
import com.TCWL.system.services.OrderSendService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class JudgeAction extends ActionSupport 
	implements ModelDriven<Judge>,Preparable,RequestAware{
	
	private JudgeService judgeService;
	private OrderSendService orderSendService;
	
	public void setJudgeService(JudgeService judgeService) {
		this.judgeService = judgeService;
	}
	
	public void setOrderSendService(OrderSendService orderSendService) {
		this.orderSendService = orderSendService;
	}
	
	public String showJudgeJsp(){
		
		
		return "showJudgeJsp";
	}
	
	public String addForOneOrdersend(){
		System.out.println("action::addForOneOrdersend():"+orderId);
		Ordersend ordersend = orderSendService.getOrdersendById(orderId);
		
		model.setOrdersend(ordersend);
		System.out.println("action:addForOneOrdersend():"+model);
		judgeService.saveOrUpdate(model);
		ordersend.setOrderStatus("已评价");
		System.out.println("action:addForOneOrdersend():"+ordersend);
		orderSendService.saveOrUpdate(ordersend);
		request.put("showOrderForOneType", orderSendService.showOrderForOneType("已评价"));
		return "addForOneOrdersend";
	}
	
	public void prepareAddForOneOrdersend(){
		model = new Judge();
	}
	
	public String showOneByOrdersend(){
		judge = judgeService.getOneByOrderId(orderId);
		System.out.println();
		return "showOneByOrdersend";
	}
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	private String orderId;

	@Override
	public void prepare() throws Exception {}

	private Judge model;
	
	@Override
	public Judge getModel() {
		return model;
	}
	
	private Judge judge;

	public Judge getJudge() {
		return judge;
	}

	public void setJudge(Judge judge) {
		this.judge = judge;
	}
	
	private Map<String, Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
	
	

}
