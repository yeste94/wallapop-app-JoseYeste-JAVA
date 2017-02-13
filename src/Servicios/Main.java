package Servicios;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Main {

	public static void main(String[] args) {
		SessionFactory sessionFactory;
	
		Configuration configuration = new Configuration().configure();
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		/*
		 * Guardar usuario
		Usuario user=new Usuario("jose@gmail.com","1234");
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		*/
		
		/*
		Usuario user=(Usuario)session.get(Usuario.class, "prueba@gmail.com");
		System.out.println(user.getMail());
		*/
		
		
		Query query = session.createQuery("SELECT p FROM Articulo p");
		
		 List<Articulo> listDatos = query.list();
		//System.out.println(listDatos.size());
		 for (Articulo datos : listDatos) {
		     System.out.println(datos.getNombre());
		     
		 }
		 
	}
}
