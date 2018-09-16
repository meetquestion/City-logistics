package com.TCWL.system.dao;

import java.util.List;

import com.TCWL.system.entities.Userloginlist;

public class UserLoginListDao extends BaseDao {
	
	//判断用户信息是否正确
	public List<Userloginlist> loginCheck(String username,String password){
		
		String hql = "from Userloginlist u where u.username = ? and u.password = ? ";
		return getSession().createQuery(hql).setString(0, username).setString(1, password).list();
	}
	
	//保存修改
	public void saveOrUpdate(Userloginlist userloginlist){
		
		getSession().saveOrUpdate(userloginlist);
	}
	
	public Userloginlist getOneUser(Integer userId){
		return (Userloginlist) getSession().get(Userloginlist.class, userId);
	}
	
	/**
	 * 判断用户的角色 
	 * @param UserId
	 * @return
	 */	
	public List<Userloginlist> getRoleByUserId(Integer UserId){
		
		String hql = "from Userloginlist u where u.userId = ? ";
		
		return getSession().createQuery(hql).setInteger(0, UserId).list();
	}
}
