package com.TCWL.system.services;

import java.util.List;

import com.TCWL.system.dao.ServiceCompanyDao;
import com.TCWL.system.entities.Servicecompany;

public class ServiceCompanyService {
	
	private ServiceCompanyDao serviceCompanyDao;
	
	public void setServiceCompanyDao(ServiceCompanyDao serviceCompanyDao) {
		this.serviceCompanyDao = serviceCompanyDao;
	}
	
	public List<Servicecompany> getAll(){
		return serviceCompanyDao.getAll();
	}
	
	public Servicecompany getOneById(Integer scId){
		return serviceCompanyDao.getOneById(scId);
	}
	
	//获取服务商所有信息  --scId
	public Servicecompany getSCompanyInfosById(Integer scId){
			
		return serviceCompanyDao.getSCompanyInfosById(scId);
	}

}
