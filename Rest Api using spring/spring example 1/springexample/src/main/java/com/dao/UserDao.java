package com.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.controller.HelloWorldController;
import com.utils.DBUtil;
import com.utils.HibernateUtils;




public class UserDao{
	Log log = LogFactory.getLog(UserDao.class);
	public boolean validateEmployeeNumber(String empnum)
	{
		StringBuffer qryString = new StringBuffer(100);
		String employee_number ="";
		Transaction tx = null;
		qryString.append("select usr.employeeNumber from com.mcms.entities.Users as usr where usr.employeeNumber='"+empnum+"'");
//		qryString.append("select employee_number from users where userid='"+userid+"'");
		Session session = null;
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory();
			session = sf.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(qryString.toString());
		//	query.setString("userName",userName);
			Object obj = query.uniqueResult();
			if(obj!=null)
				employee_number = obj.toString();
			else
				employee_number = null;
			tx.commit();	
		} catch (Exception e) {
			if(tx!=null)
			{
				log.info("before rollback");
				tx.rollback();
			}
			e.printStackTrace();			
		} finally {
			DBUtil.closeSession(session);
			qryString = null;
		}
		if(employee_number==null)
		return false;
		else
			return true;
	}
}