package com.pioneercoders.hibernate.curd;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibenateUtils {

	static SessionFactory sessionFactory = null;
	
	static final HibenateUtils hibenateUtils= new HibenateUtils();
	
	private HibenateUtils(){
		if(sessionFactory == null){
			sessionFactory = configureUsingHibernateConfigXMLFile();
			if(sessionFactory == null){
				sessionFactory = configureUsingHibernatePropertiesFile();
			}
		}
	}
	
	public static SessionFactory getSessionFactory(){
		
		return sessionFactory;
	}
	

	public  SessionFactory configureUsingHibernateConfigXMLFile() {
		// Create configuration instance
		Configuration configuration = new Configuration();

		// Pass hibernate configuration file
		configuration.configure("hibernate.cfg.xml");

		// Since version 4.x, service registry is being used
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		// Create session factory instance
		SessionFactory factory = configuration
				.buildSessionFactory(serviceRegistry);

		// Get current session
		//Session session = factory.getCurrentSession();

		// Begin transaction
		//session.getTransaction().begin();

		// Print out all req;uired information
		//System.out.println("Session Is Opened :: " + session.isOpen());
		//System.out.println("Session Is Connected :: " + session.isConnected());

		// Commit transaction
		//session.getTransaction().commit();

		//System.exit(0);
		return factory;
	}

	public SessionFactory configureUsingHibernatePropertiesFile() {
		// Create configuration instance
		Configuration configuration = new Configuration();

		// Create properties file
		Properties properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("hibernate.properties"));
		} catch (IOException e) {
			System.out.println("[PioneerCoders] HibenateUtils.configureUsingHibernatePropertiesFile() hibernate.properties is not found");
			e.printStackTrace();
		}
		// Pass hibernate properties file
		configuration.setProperties(properties);
		// Since version 4.x, service registry is being used
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		// Create session factory instance
		SessionFactory factory = configuration
				.buildSessionFactory(serviceRegistry);

		// Get current session
		//Session session = factory.getCurrentSession();

		// Begin transaction
		//session.getTransaction().begin();

		// Print out all required information
		//System.out.println("Session Is Opened :: " + session.isOpen());
		//System.out.println("Session Is Connected :: " + session.isConnected());

		// Commit transaction
		//session.getTransaction().commit();

		//System.exit(0);
		
		return factory;
	}
	
	
}
