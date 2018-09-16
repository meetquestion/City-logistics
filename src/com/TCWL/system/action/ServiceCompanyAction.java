package com.TCWL.system.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.TCWL.system.entities.Servicecompany;
import com.TCWL.system.services.ServiceCompanyService;
import com.TCWL.system.util.Cout;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class ServiceCompanyAction extends ActionSupport{
	
	private ServiceCompanyService serviceCompanyService;
	
	public void setServiceCompanyService(
			ServiceCompanyService serviceCompanyService) {
		this.serviceCompanyService = serviceCompanyService;
	}
	
	public String getAll() throws IOException{
		List<Servicecompany> list = serviceCompanyService.getAll();
		List<Servicecompany> listToJson = new ArrayList<Servicecompany>();
		for(int i=0;i<list.size();i++){
			Servicecompany servicecompany = new Servicecompany();
			Servicecompany servicecompanyForList = list.get(i);
			//
			servicecompany.setScId(servicecompanyForList.getScId());
			servicecompany.setScName(servicecompanyForList.getScName());
			
			listToJson.add(servicecompany);
			
		}
		String json = JSON.toJSONString(listToJson);
		System.out.println(json);
		Cout.out().print(json);
		
		return null;
	}
	
}
