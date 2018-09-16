package com.TCWL.system.services;

import java.util.List;

import com.TCWL.system.dao.UserLoginListDao;
import com.TCWL.system.entities.Userloginlist;

public class UserLoginListService {
	
	//连接dao
	private UserLoginListDao userLoginListDao;
	
	public void setUserLoginListDao(UserLoginListDao userLoginListDao) {
		this.userLoginListDao = userLoginListDao;
	}
	
	//判断用户信息是否正确
	public List<Userloginlist> loginCheck(String username,String password){
		
		return userLoginListDao.loginCheck(username, password);
	}
	
	//保存修改
	public void saveOrUpdate(Userloginlist userloginlist){
		
		userLoginListDao.saveOrUpdate(userloginlist);
	}
	
	public Userloginlist getOneUser(Integer userId){
		return userLoginListDao.getOneUser(userId);
	}
	
	/**
	 * 判断用户的角色
	 * @param UserId
	 * @return
	 */
	public List<Userloginlist> getRoleByUserId(Integer UserId){
		
		return userLoginListDao.getRoleByUserId(UserId);
	}
}
