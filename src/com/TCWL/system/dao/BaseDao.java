package com.TCWL.system.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.TCWL.system.util.GetSessionId;

public class BaseDao {

private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
		
	}
	
}
