package lyme.domain;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFac {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getFactory() {
		if(sessionFactory == null) {
			ServiceRegistry serviceRegistry;
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		                          configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			return sessionFactory;
			
		}
		else {
			return sessionFactory;
		}
	}
	
}
