package com.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.utils.DBUtil;
import com.utils.HibernateUtils;

public class UserDao {
	Log log = LogFactory.getLog(UserDao.class);

	public boolean validateEmployeeNumber(String empnum) {
		StringBuffer qryString = new StringBuffer(100);
		String employee_number = "";
		Transaction tx = null;
		qryString
				.append("select employee_number from users  where employee_number='"
						+ empnum + "'");
		// qryString.append("select employee_number from users where userid='"+userid+"'");
		Session session = null;
		try {
			SessionFactory sf = HibernateUtils.getSessionFactory();
			session = sf.openSession();
			tx = session.beginTransaction();
			Query query = session.createSQLQuery(qryString.toString());
			// query.setString("userName",userName);
			Object obj = query.uniqueResult();
			if (obj != null)
				employee_number = obj.toString();
			else
				employee_number = null;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				log.info("before rollback");
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			DBUtil.closeSession(session);
			qryString = null;
		}
		if (employee_number == null)
			return false;
		else
			return true;
	}




public int updateStatus(String empnum, Integer status) {
	StringBuffer qryString = new StringBuffer(100);
	String employee_number = "";
	Transaction tx = null;
	int result = 0;
	qryString
			.append("update users set user_status_id="+status+" where  employee_number='"+ empnum + "'");
	// qryString.append("select employee_number from users where userid='"+userid+"'");
	Session session = null;
	try {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		session = sf.openSession();
		tx = session.beginTransaction();
		Query query = session.createSQLQuery(qryString.toString());
		// query.setString("userName",userName);
		result = query.executeUpdate();
		
		tx.commit();
	} catch (Exception e) {
		if (tx != null) {
			log.info("before rollback");
			tx.rollback();
		}
		e.printStackTrace();
	} finally {
		DBUtil.closeSession(session);
		qryString = null;
		return result;
	}
	
}
}
