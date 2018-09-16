package com.TCWL.system.services;

import java.util.List;

import com.TCWL.system.dao.GeterDao;
import com.TCWL.system.entities.Geter;

public class GeterServices {
	
	private GeterDao geterDao;
	
	public void setGeterDao(GeterDao geterDao) {
		this.geterDao = geterDao;
	}
	
	public void saveOrUpdate(Geter geter){
		geterDao.saveOrUpdate(geter);
	}
	
	public List<Geter> getAllForOneUser(){
		return geterDao.getAllForOneUser();
	}
	
//	public Integer getGeterId(String geterName){
//		return geterDao.getGeterId(geterName);
//	}
	
	public Geter getGeter(String geterName){
		return geterDao.getGeter(geterName);
	}

}
