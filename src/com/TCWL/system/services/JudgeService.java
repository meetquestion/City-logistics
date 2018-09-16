package com.TCWL.system.services;

import com.TCWL.system.dao.JudgeDao;
import com.TCWL.system.entities.Judge;

public class JudgeService {
	
	private JudgeDao judgeDao;
	
	public void setJudgeDao(JudgeDao judgeDao) {
		this.judgeDao = judgeDao;
	}
	
	public void saveOrUpdate(Judge judge){
		judgeDao.saveOrUpdate(judge);
	}
	
	public Judge getOneByOrderId(String orderId){
		return judgeDao.getOneByOrderId(orderId);
	}

}
