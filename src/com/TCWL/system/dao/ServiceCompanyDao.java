package com.TCWL.system.dao;

import java.util.List;

import com.TCWL.system.entities.Servicecompany;

public class ServiceCompanyDao extends BaseDao{
	
	public List<Servicecompany> getAll(){
		
		String hql = "From Servicecompany";
		List<Servicecompany> list = getSession().createQuery(hql).list();
		return list;
	}
	
	public Servicecompany getOneById(Integer scId){
		return (Servicecompany) getSession().get(Servicecompany.class, scId);
	}
	
	//获取服务商所有信息  --scId
	public Servicecompany getSCompanyInfosById(Integer scId){
			
		return (Servicecompany) getSession().get(Servicecompany.class, scId);
	}

}
