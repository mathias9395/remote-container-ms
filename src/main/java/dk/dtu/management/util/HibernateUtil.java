package dk.dtu.management.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.Container;
import dk.dtu.management.model.ContainerStatus;
import dk.dtu.management.model.Journey;
import dk.dtu.management.model.LogisticCompany;
import dk.dtu.management.model.Message;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
 			
				
				
				settings.put(Environment.DRIVER, "org.h2.Driver");
				settings.put(Environment.URL, "jdbc:h2:~/management_db");
				settings.put(Environment.USER, "sa");
				settings.put(Environment.PASS, "");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
				settings.put(Environment.POOL_SIZE, "1");
				
				
				
				

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				
				//settings.put(Environment.HBM2DDL_AUTO, "create-drop");
				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				
				configuration.addAnnotatedClass(Client.class);
				configuration.addAnnotatedClass(LogisticCompany.class);
				configuration.addAnnotatedClass(Journey.class);
				configuration.addAnnotatedClass(Container.class);
				configuration.addAnnotatedClass(ContainerStatus.class);
				configuration.addAnnotatedClass(Message.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
		
	}
}
