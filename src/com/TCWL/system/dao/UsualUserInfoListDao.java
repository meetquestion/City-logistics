package com.TCWL.system.dao;

import java.util.List;

import com.TCWL.system.entities.Usualuserinfolist;

public class UsualUserInfoListDao extends BaseDao {
	
	//获取普通用户基本信息--userId
	public Usualuserinfolist get(Integer userId){
		
		return (Usualuserinfolist) getSession().get(Usualuserinfolist.class, userId);
	}
	
	//获取获取普通用户基本信息--userId
	public List<Usualuserinfolist> getAllById(Integer userId ){
		String hql = "from Usualuserinfolist u left outer join fetch u.userloginlist where u.userId = ?";
		return getSession().createQuery(hql).setInteger(0, userId).list();
	}
	
	//保存修改
	public void saveOrUpdate(Usualuserinfolist usualuserinfolist){
		
		getSession().saveOrUpdate(usualuserinfolist);
	}
}
