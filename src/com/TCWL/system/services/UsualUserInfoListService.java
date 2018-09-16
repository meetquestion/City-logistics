package com.TCWL.system.services;

import java.util.List;

import com.TCWL.system.dao.UsualUserInfoListDao;
import com.TCWL.system.entities.Usualuserinfolist;

public class UsualUserInfoListService {
	
	private UsualUserInfoListDao usualUserInfoListDao;
	
	public void setUsualUserInfoListDao(
			UsualUserInfoListDao usualUserInfoListDao) {
		this.usualUserInfoListDao = usualUserInfoListDao;
	}
	
	//获取普通用户基本信息--userId
	public Usualuserinfolist get(Integer userId){
		
		return usualUserInfoListDao.get(userId);
	}
	
	//获取获取普通用户基本信息--userId
	public List<Usualuserinfolist> getAllById(Integer userId ){
		
		return usualUserInfoListDao.getAllById(userId);
	}
	
	//保存修改
	public void saveOrUpdate(Usualuserinfolist usualuserinfolist){
		
		usualUserInfoListDao.saveOrUpdate(usualuserinfolist);
	}
	//
	
}
