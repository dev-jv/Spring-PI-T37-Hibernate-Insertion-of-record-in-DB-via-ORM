package connectionhibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveClient {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class).buildSessionFactory();
		
		// create session
		Session mySession = myFactory.openSession();
		
		try {
			
			// create a client object
			Client client1 = new Client("Samuel", "Sloan", "Av. Kaede Tree, Somewhere City");
			
			// start a transaction
			mySession.beginTransaction();
			
			// save the object
			mySession.save(client1);
			
			// commit transaction
			mySession.getTransaction().commit();
			
			System.out.println("Registration correctly inserted in the DB");
			
			mySession.close();
			
		} finally {
			
			myFactory.close();
		}
	}
}
