package com.TCWL.system.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.TCWL.system.entities.Userloginlist;
import com.TCWL.system.entities.Usualuserinfolist;
import com.TCWL.system.services.UsualUserInfoListService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class UsualUserInfoListAction extends ActionSupport implements RequestAware,SessionAware,
ModelDriven<Usualuserinfolist>, Preparable{
	
	private static final long serialVersionUID = 1L;
	
	//连接service****************************************************************
	private UsualUserInfoListService usualInfoListService;
	
	public void setUsualInfoListService(
			UsualUserInfoListService usualInfoListService) {
		this.usualInfoListService = usualInfoListService;
	}
	
	//获取传值*********************************************************************
	private Integer userId;
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	private String usualName;
	
	public void setUsualName(String usualName) {
		this.usualName = usualName;
	}
	
	private String usualPhone;
	
	public void setUsualPhone(String usualPhone) {
		this.usualPhone = usualPhone;
	}
	
	private String usualEmail;
	
	public void setUsualEmail(String usualEmail) {
		this.usualEmail = usualEmail;
	}
	
	private Userloginlist userloginlist;
	
	public void setUserloginlist(Userloginlist userloginlist) {
		this.userloginlist = userloginlist;
	}

	//
	public String usualInputOrEdit(){
		
		return "usualInputOrEdit";
	}
	
	public void  prepareUsualInputOrEdit(){
		
		List<Usualuserinfolist> getValue = usualInfoListService.getAllById(userId);
		if(getValue.size()>0){
			model = usualInfoListService.get(userId);
			session.put("usualUserId", "exit");
		}
		else{
			System.out.println("h1");
			session.put("usualUserId", null);
		}
	}
	
	//普通用户基础信息添加保存
	public String usualInputOrEditSave(){
		System.out.println(model+"hh");
		usualInfoListService.saveOrUpdate(model);
		return "usualInputOrEditSave";
	}
	
	public void prepareUsualInputOrEditSave(){
		System.out.println("prepare");
		List<Usualuserinfolist> getValue = usualInfoListService.getAllById(userId);
		if(getValue.size()>0){
			model = usualInfoListService.get(userId);
		}
		else{
			
			model = new Usualuserinfolist();
		}
		
	}
	
	//用户信息显示--try
	public String usualShow(){
		
		request.put("usualAllInfos", usualInfoListService.getAllById(userId));
		return "usualShow";
	}
	

	
	
	//接口方法*********************************************************************
	public void prepare() throws Exception {}
	
	private Usualuserinfolist model;
	
	public Usualuserinfolist getModel() {
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
