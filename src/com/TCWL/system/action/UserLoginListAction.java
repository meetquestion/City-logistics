package com.TCWL.system.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.TCWL.system.entities.Userloginlist;
import com.TCWL.system.services.UserLoginListService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class UserLoginListAction extends ActionSupport implements RequestAware,SessionAware,
ModelDriven<Userloginlist>, Preparable{
	
	private static final long serialVersionUID = 1L;
	
	//连接services
	private UserLoginListService userLoginListService;
	
	public void setUserLoginListService(
			UserLoginListService userLoginListService) {
		this.userLoginListService = userLoginListService;
	}
	
	//获取传值
	
	private String username;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	private String password;
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	private String passwordCheck;
	
	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}
	//inputStream
	private InputStream inputStream;
		
	//public 类型
	public InputStream getInputStream(){
		return inputStream;
	}
	
	
	//跳转
	public String top(){
		
		return "top";
	}
	
	public String leftSide(){
		
		return "leftSide";
	}
	
	public String homePage(){
		
		return "homePage";
	}
	
	
	//判断用户信息是否正确***************************************************************		
	public String loginCheck(){
		
		List<Userloginlist> getValue = userLoginListService.loginCheck(username, password);
		
		if(getValue.size()>0){
			Integer userId = getValue.get(0).getUserId();
//			System.out.println("loginCheck():session:前：userId:"+userId);
			// 将登陆的用户信息存入session中
			session.put("userId", userId);
			
			/**
			 * 以下注释是测试从session中取出id
			 */
//			HttpServletRequest request;
//			request = ServletActionContext.getRequest();
//			Integer userId_session = (Integer) request.getSession().getAttribute("userId");
//			System.out.println("loginCheck():session:后：userId:"+userId_session);
//			System.out.println();
			
			return "loginSuccess";
		}
		else{
			return "loginError";
		}
		
	}
	
	//注册用户*********************************************************************
	public String registerSave(){
		System.out.println(password+" "+passwordCheck);
		if(password.equals(passwordCheck)){
			
			model.setRoleList("1");
			System.out.println(model);
			userLoginListService.saveOrUpdate(model);
			return "registerSuccess";
		}
		else{
			return "registerError";
		}
		
		
	}
	
	//判断用户的角色******************************************************************
		public String judgeRoleList(){
			
			//获取session中的user_Id
			HttpServletRequest req = ServletActionContext.getRequest();
			Object u_Id = req.getSession().getAttribute("userId");
			Integer userId = new Integer((Integer) u_Id);
			
			List<Userloginlist> getUserRole = userLoginListService.getRoleByUserId(userId);
			String getRole = getUserRole.get(0).getRoleList();
			System.out.println(getRole+"hh");
			if(getRole.equals("1")){
				
				try {
					inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(getRole.equals("2")){
				
				try {
					inputStream = new ByteArrayInputStream("2".getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(getRole.equals("3")){
				
				try {
					inputStream = new ByteArrayInputStream("3".getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(getRole.equals("4")){
				
				try {
					inputStream = new ByteArrayInputStream("4".getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			return "ajax-success";
		}
	
	public void prepareRegisterSave(){
		
		model = new Userloginlist();
	}
	
	public String orderAdd(){
		return "orderAdd";
	}



	
	
	//接口方法*********************************************************************
	public void prepare() throws Exception {}

	private Userloginlist model;

	public Userloginlist getModel() {
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
