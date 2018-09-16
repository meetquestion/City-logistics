package com.TCWL.system.services;

import java.util.List;

import com.TCWL.system.dao.SenderDao;
import com.TCWL.system.entities.Sender;

public class SenderService {
	
	private SenderDao senderDao;
	
	public void setSenderDao(SenderDao senderDao) {
		this.senderDao = senderDao;
	}
	
	public List<Sender> getForOneServicecompany(String scId){
		return senderDao.getForOneServicecompany(scId);
	}
	
	public Sender getOneById(Integer senderId){
		return senderDao.getOneById(senderId);
	}
	//获取此服务商的所有配送员 --scId
	public List<Sender> getSenderInfosById(Integer scId){
		
		return senderDao.getSenderInfosById(scId);
	}
	
	//保存修改
	public void saveOrUpdate(Sender sender){
		
		senderDao.saveOrUpdate(sender);
	}
	
	//获取一个配送员的所有信息 --senderId
	public Sender getOneSenderById(Integer senderId){
		
		return senderDao.getOneSenderById(senderId);
	}

}
