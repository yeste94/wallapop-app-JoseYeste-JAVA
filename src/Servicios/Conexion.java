package Servicios;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Conexion {
	private  static SessionFactory sessionFactory;
	private static Session session;
	
	public Conexion(){
		
		
		Configuration configuration = new Configuration().configure();
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		 session = sessionFactory.openSession();
		session.beginTransaction();
	}
	
	public Session getSession(){
		return session;
	}
	
	
}
