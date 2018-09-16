package com.TCWL.system.dao;

import com.TCWL.system.entities.Judge;

public class JudgeDao extends BaseDao{
	
	public void saveOrUpdate(Judge judge){
		getSession().saveOrUpdate(judge);
	}
	
	public Judge getOneByOrderId(String orderId){
		String hql = "From Judge j where j.ordersend.orderId = '"+ orderId +"'";
		Judge judge = (Judge) getSession().createQuery(hql).list().get(0);
		return judge;
	}

}
