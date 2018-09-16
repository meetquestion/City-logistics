package com.TCWL.system.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.TCWL.system.entities.Sender;
import com.TCWL.system.entities.Servicecompany;
import com.TCWL.system.services.SenderService;
import com.TCWL.system.services.ServiceCompanyService;
import com.TCWL.system.util.Cout;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class SenderAction extends ActionSupport 
	implements  RequestAware,SessionAware,ModelDriven<Sender>, Preparable{
	
	private SenderService senderService;
	
	public void setSenderService(SenderService senderService) {
		this.senderService = senderService;
	}
	
	private ServiceCompanyService serviceCompanyService;
	
	public void setServiceCompanyService(
			ServiceCompanyService serviceCompanyService) {
		this.serviceCompanyService = serviceCompanyService;
	}

	
	public String getForOneServicecompany() throws IOException{
		System.out.println(scId);
		List<Sender> list = senderService.getForOneServicecompany(scId);
		
		List<Sender> listToJson = new ArrayList<Sender>();
		for (int i = 0; i < list.size(); i++) {
			Sender sender = new Sender();
			Sender senderForList = list.get(i);
			
			sender.setSenderId(senderForList.getSenderId());
			sender.setSenderName(senderForList.getSenderName());
			
			listToJson.add(sender);
		}
		String json = JSON.toJSONString(listToJson);
		Cout.out().print(json);
		return null;
	}
	
	
	private String scId;

	public String getScId() {
		return scId;
	}
	public void setScId(String scId) {
		this.scId = scId;
	}
	
	
	
	
	//获取传值
	private String senderName;
	
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
	private String senderPhone;
	
	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}
	
	private Integer senderId;
	
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	
	
	//inputStream**************************************************************
	private InputStream inputStream;
	
	//public 类型
	public InputStream getInputStream(){
		return inputStream;
	}
	
	
	//服务商添加派送员*****************************************************************
	public String addSender(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer scId = new Integer((Integer) u_Id);
				
		request.put("senderOfCompanyName", serviceCompanyService.getSCompanyInfosById(scId).getScName());
		return "addSender";
	}
	
	public String addSenderSave(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer scId = new Integer((Integer) u_Id);
				
		Servicecompany servicecompany = new Servicecompany();
		servicecompany.setScId(scId);
		model.setServicecompany(servicecompany);
		model.setSenderStatus("true");
		senderService.saveOrUpdate(model);
		
		
		
		return "addSenderSave";
	}
	
	public void  prepareAddSenderSave(){
		
		model = new Sender();
	}
	
	//管理配送员********************************************************************
	public String manageSender(){
		
		//获取session中的user_Id
		HttpServletRequest req = ServletActionContext.getRequest();
		Object u_Id = req.getSession().getAttribute("userId");
		Integer scId = new Integer((Integer) u_Id);
		
		request.put("manageSenderInfos", senderService.getSenderInfosById(scId));
		return "manageSender";
	}
	
	//删除该服务商的配送员 --将状态有true 改为 false
	public String deleteSender(){
		
		try {

			model.setSenderStatus("false");
			senderService.saveOrUpdate(model);
			
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return "ajax-success";
	}
	
	public void prepareDeleteSender(){
		
		model = senderService.getOneSenderById(senderId);
	}
	
	//编辑配送员信息
	public String editSender(){
		
		//request.put("senderId", senderService.getOneSenderById(senderId).getSenderId());
		return "editSender";
	}
	
	public void prepareEditSender(){
		
		model = senderService.getOneSenderById(senderId);
	}
	
	//保存编辑的配送员信息 
	public String editSenderSave(){
				
		senderService.saveOrUpdate(model);
		return "editSenderSave";
	}
	
	public void prepareEditSenderSave(){
		
		model = senderService.getOneSenderById(senderId);
	}
	
	
	//接口方法*********************************************************************
	public void prepare() throws Exception {}
	
	
	private Sender model;	
	
	public Sender getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	private Map<String, Object> session;
	
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}
	
	private Map<String, Object> request;
	
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	
}
