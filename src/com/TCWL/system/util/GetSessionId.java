package com.TCWL.system.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

/**
 * 取出session的ID，供action、service、dao层代码调用
 * @author WY
 *
 */
public class GetSessionId {

	//取出session的ID，
	public static Integer getSessionID(){
		HttpServletRequest request;
		request = ServletActionContext.getRequest();
		Integer userId = (Integer) request.getSession().getAttribute("userId");
//		Integer ID = Integer.parseInt(String.valueOf(userId));
					
		return userId;
	}

}
