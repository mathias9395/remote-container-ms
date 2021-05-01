package dk.dtu.management.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dk.dtu.management.model.Client;
import dk.dtu.management.util.HibernateUtil;

public class ClientDao {
	public void save(Client client) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			
			// save student object
			session.save(client);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public void update(Client client) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			
			// update student object
			session.saveOrUpdate(client);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public Client getById(int id) {
		Transaction transaction = null;
		Client client = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			
			// get student object
			client = session.get(Client.class, id);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return client;
	}
	
//	@SuppressWarnings("unchecked")
//	public List<Client> getAll() {
//		Transaction transaction = null;
//		List<Client> clients = null;
//		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
//			// start the transaction
//			transaction = session.beginTransaction();
//			
//			// get students
//			clients = session.createQuery("from Client").list();
//			
//			// commit the transaction
//			transaction.commit();
//		} catch (Exception e) {
//			if(transaction != null) {
//				transaction.rollback();
//			}
//		}
//		return clients;
//	}
	
	public void delete(int id) {
		Transaction transaction = null;
		Client client = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			
			client = session.get(Client.class, id);
			// delete student object
			session.remove(client);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
}
