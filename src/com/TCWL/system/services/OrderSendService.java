package com.TCWL.system.services;

import java.util.List;

import com.TCWL.system.dao.OrderSendDao;
import com.TCWL.system.entities.Ordersend;

public class OrderSendService {

	private OrderSendDao orderSendDao;
	public void setOrderSendDao(OrderSendDao orderSendDao) {
		this.orderSendDao = orderSendDao;
	}
	
	public void saveOrUpdate(Ordersend ordersend){
		
		orderSendDao.saveOrUpdate(ordersend);
	}
	
	public int getTodayNum(String date){
		return orderSendDao.getTodayNum(date);
	}
	
	public List<Ordersend> showAllForOneUser(){
		return orderSendDao.showAllForOneUser();
	}
	
	public void deleteOneOrder(String orderId){
		orderSendDao.deleteOneOrder(orderId);
	}
	public List<Ordersend> showOrderForOneType(String orderStatus){
		return orderSendDao.showOrderForOneType(orderStatus);
	}
	public Ordersend getOrdersendById(String orderId){
		return orderSendDao.getOrdersendById(orderId);
	}
	
	
	
	//服务商**********************************************************************
	//获取此服务商类型的未安排配送员订单信息 --scId
	public List<Ordersend> getNoDealById(Integer scId){
		
		return orderSendDao.getNoDealById(scId);
	}
	
	//获取订单的所有信息 根据订单编号 -- orderId
	public Ordersend getOrderById(String orderId){
		
		return orderSendDao.getOrderById(orderId);
	}
	
	//获取此服务商类型的未派送订单信息 --scId
	public List<Ordersend> getNoSendById(Integer scId){
		
		return orderSendDao.getNoSendById(scId);
	}
	
	//获取此服务商类型的未派送订单信息 --scId
	public List<Ordersend> getSendNowById(Integer scId){
		
		return orderSendDao.getSendNowById(scId);
	}
	
	//获取此服务商类型的已送达订单信息 --scId
	public List<Ordersend> getSendReadyById(Integer scId){
		
		return orderSendDao.getSendReadyById(scId);
	}
	
	//配送员**********************************************************************
	//获取此服务商的配送员的未派送订单信息 --scId senderId
	public List<Ordersend> getNoSendBySenderId(Integer scId,Integer senderId){
		
		return orderSendDao.getNoSendBySenderId(scId, senderId);
	}
	
	//获取此服务商的配送员的正在派送订单信息 --scId senderId
	public List<Ordersend> getsendNowBySenderId(Integer scId,Integer senderId){
		
		return orderSendDao.getsendNowBySenderId(scId, senderId);
				
	}
	
	//获取此服务商的配送员的已派送订单信息 --scId senderId
	public List<Ordersend> getsendReadyBySenderId(Integer scId,Integer senderId){
		
		return orderSendDao.getsendReadyBySenderId(scId, senderId);
	}
	
	//获取此服务商的配送员的已评价订单信息 --scId senderId
	public List<Ordersend> getsendJudgeBySenderId(Integer scId,Integer senderId){
		
		return orderSendDao.getsendJudgeBySenderId(scId, senderId);
	}

}
