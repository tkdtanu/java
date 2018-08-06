package com.tkd.hibernate.util;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.tkd.hibernate.model.Stock;
import com.tkd.hibernate.model.StockDailyRecord;
import com.tkd.hibernate.model.StockDetail;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = null;
	
	static {
		try {
			Properties prop = new Properties();
			prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/local");
			prop.setProperty("hibernate.connection.username", "root");
			prop.setProperty("hibernate.connection.password", "root");
			prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			prop.setProperty("show_sql", "true");
			prop.setProperty("hibernate.hbm2ddl.auto", "create-update");
			
			
			sessionFactory = new AnnotationConfiguration().addPackage("com.tkd.hibernate.model")
							.addProperties(prop).addAnnotatedClass(Stock.class).addAnnotatedClass(StockDetail.class)
							.addAnnotatedClass(StockDailyRecord.class)
							.buildSessionFactory();
							
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Session getSession() {
		return sessionFactory.openSession();
	}

}
