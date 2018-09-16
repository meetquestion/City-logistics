package com.TCWL.system.dao;

import java.util.List;

import com.TCWL.system.entities.Sender;

public class SenderDao extends BaseDao{
	
	@SuppressWarnings("unchecked")
	public List<Sender> getForOneServicecompany(String scId){
		String hql = "From Sender s where s.servicecompany.scId = '" + scId + "'";
		List<Sender> list = getSession().createQuery(hql).list();
		return list;
	}
	
	public Sender getOneById(Integer senderId){
		return (Sender) getSession().get(Sender.class, senderId);
	}
	//获取此服务商的所有配送员 --scId
	public List<Sender> getSenderInfosById(Integer scId){
		
		String hql = "from Sender s where s.servicecompany.scId = ? and s.senderStatus = 'true'  ";
		return getSession().createQuery(hql).setInteger(0, scId).list();
	}
	
	//保存修改
	public void saveOrUpdate(Sender sender){
		
		getSession().saveOrUpdate(sender);
	}
	
	//获取一个配送员的所有信息 --senderId
	public Sender getOneSenderById(Integer senderId){
				
		return (Sender) getSession().get(Sender.class, senderId );
	}
}
