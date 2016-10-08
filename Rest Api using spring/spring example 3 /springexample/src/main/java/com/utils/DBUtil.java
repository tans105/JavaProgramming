/*******************************************************************************
 *    
 * 	
 * 	  Project Epaisa, all source code and data files except images,
 * 	  Copyright 2008-2015 Grit-Innovation Software Pvt. Ltd., India
 * 	
 * 	
 *******************************************************************************/
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