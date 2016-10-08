
package com.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;


import org.hibernate.Session;
import org.hibernate.Transaction;



public class DBUtil {


	public static void closeSession(Session session) {
		if (session != null) {
			session.flush();
			session.close();
		}
	}


}