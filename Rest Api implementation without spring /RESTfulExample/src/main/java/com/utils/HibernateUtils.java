
package com.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionFactory = getSessionFactory();

	public static SessionFactory getSessionFactory() {

		try {
			if (sessionFactory == null) {
//				System.out.println("in getSessionFactory");
				sessionFactory = new Configuration().configure(
						"com/mcms/entities/Hibernate.cfg.xml")
						.buildSessionFactory();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}
}