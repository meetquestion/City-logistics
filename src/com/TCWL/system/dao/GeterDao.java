package com.TCWL.system.dao;

import java.util.List;

import com.TCWL.system.entities.Geter;
import com.TCWL.system.util.GetSessionId;

/**
 * 
 * @author WY
 *
 */
public class GeterDao extends BaseDao{

	/**
	 * 
	 * @param geter
	 */
	public void saveOrUpdate(Geter geter){
		getSession().saveOrUpdate(geter);
	}
	
	// 获取当前用户的所有geter
	@SuppressWarnings("unchecked")
	public List<Geter> getAllForOneUser(){
		
		Integer userId = GetSessionId.getSessionID();
		System.out.println("GeterDao:getAllForOneUser():userId:"+userId);
		String hql = "From Geter g where g.geterSenderId = '" + userId + "'";
		List<Geter> geters = getSession().createQuery(hql).list();
//		System.out.println("GeterDao:getAllForOneUser():输出geter开始");
//		System.out.println("geters.size:"+geters.size());
//		for (Geter geter : geters) {
//			System.out.println("GeterDao:getAllForOneUser():"+geter);
//		}
//		System.out.println("GeterDao:getAllForOneUser():输出geter结束");
		return geters;
		
	}
	
	/**
	 * 获取某个geterName为“ ”的geterId
	 * 此方法暂时未用
	 * @param geterName:传来的geterName值，用来做查询条件
	 * @return
	 */
	public Integer getGeterId(String geterName){
		
		String hql = "Select geterId From Geter g where g.geterName = '" + geterName + "'";
		Integer geterId = (Integer) getSession().createQuery(hql).list().get(0);
		return geterId;
	}
	
	/**
	 * 根据geterName获取geter
	 * @param geterName:传来的geterName值，用来做查询条件
	 * @return
	 */
	public Geter getGeter(String geterName){
		String hql = "Select geterId From Geter g where g.geterName = '" + geterName + "'";
		Geter geter = (Geter) getSession().createQuery(hql).list().get(0);
		return geter;
	}
}
