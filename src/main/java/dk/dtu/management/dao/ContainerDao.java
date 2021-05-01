package dk.dtu.management.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dk.dtu.management.model.Container;
import dk.dtu.management.util.HibernateUtil;

public class ContainerDao {
	public void save(Container container) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			
			// save student object
			session.save(container);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public void update(Container container) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			
			// update student object
			session.saveOrUpdate(container);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public Container getById(int id) {
		Transaction transaction = null;
		Container container = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			
			// get student object
			container = session.get(Container.class, id);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return container;
	}
	
//	@SuppressWarnings("unchecked")
//	public List<Container> getAll() {
//		Transaction transaction = null;
//		List<Container> containers = null;
//		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
//			// start the transaction
//			transaction = session.beginTransaction();
//			
//			// get students
//			containers = session.createQuery("from Container").list();
//			
//			// commit the transaction
//			transaction.commit();
//		} catch (Exception e) {
//			if(transaction != null) {
//				transaction.rollback();
//			}
//		}
//		return containers;
//	}
	
	public void delete(int id) {
		Transaction transaction = null;
		Container container = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			
			container = session.get(Container.class, id);
			// delete student object
			session.remove(container);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
}
