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
		
		Articulo user=(Articulo)session.get(Articulo.class, 1);
		System.out.println(user.getNombre());
		*/
		
		//Query query = session.createQuery("SELECT c FROM Categoria c WHERE c.id=(SELECT s.id FROM SubCategoria s WHERE s.nombre='teclados')");
		

		 
		 
		 
		 Query query = session.createQuery("SELECT c FROM Articulo c WHERE c.subCategoria.id='2'");
		 List<Articulo> listDatos1 = query.list();
		 
		 for (Articulo datos : listDatos1) {
				 System.out.println(datos.getNombre()); 
		 }
		 
		 
	}
}
