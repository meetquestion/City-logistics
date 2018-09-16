package com.TCWL.system.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.TCWL.system.entities.Geter;
import com.TCWL.system.services.GeterServices;
import com.TCWL.system.util.Cout;
import com.TCWL.system.util.GetSessionId;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 
 * @author WY
 *
 */

public class GeterAction extends ActionSupport 
	implements ModelDriven<Geter>,Preparable,RequestAware{
	
	private GeterServices geterServices;
	
	public void setGeterServices(GeterServices geterServices) {
		this.geterServices = geterServices;
	}
	
	// 展示“添加收件人”页面 ************************************************************
	public String addShow(){
		
		return "addShow";
	}
	
	// 添加配送员操作 ****************************************************************
	public String addForOneUser(){
		String userId = String.valueOf(GetSessionId.getSessionID());
		geter.setGeterSenderId(userId);
//		System.out.println("addForOneUser():"+geter);
		geterServices.saveOrUpdate(geter);
		
//		return "addForOneUser";
		return null;
	}
	
	public void prepareAddForOneUser(){
		geter = new Geter();
	}
	
	// geter下拉菜单
	public String getAllForOneUser() throws IOException{
		
//		System.out.println("getAllForOneUser()");
		List<Geter> geters = geterServices.getAllForOneUser();
		List<Geter> listToJson = new ArrayList<Geter>();
		for(int i=0;i<geters.size();i++){
			Geter geter = new Geter();
			Geter geterForListGeters = geters.get(i);//取出第i+1条geter
			// 填充新定义的geter
			geter.setGeterId(geterForListGeters.getGeterId());
			geter.setGeterName(geterForListGeters.getGeterName());
			geter.setGeterAddress(geterForListGeters.getGeterAddress());
			// 将新定义的geter填充到listToJson中
			listToJson.add(geter);
		}
		// 转换成json格式数据
		String json = JSON.toJSONString(listToJson);
//		System.out.println(json);
		Cout.out().print(json);
		return null;
	}
	
	public String showGeterForOneUser(){
		List<Geter> geters = geterServices.getAllForOneUser();
		request.put("geterForOneUser", geters);
		return "showGeterForOneUser";
	}

	public void prepare() throws Exception {}

	//定义geter实体类对象model
	private Geter geter;
	
	public Geter getModel() {
		return geter;
	}
	
	private Map<String, Object> request;
	
	public void setRequest(Map<String, Object> arg0) {

		this.request = arg0;
	}

}
