package dk.dtu.management.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dk.dtu.management.model.ContainerStatus;
import dk.dtu.management.util.HibernateUtil;

public class ContainerStatusDao {
	public void save(ContainerStatus status) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			
			// save student object
			session.save(status);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public void update(ContainerStatus status) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			
			// update student object
			session.saveOrUpdate(status);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public ContainerStatus getById(int id) {
		Transaction transaction = null;
		ContainerStatus status = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			
			// get student object
			status = session.get(ContainerStatus.class, id);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return status;
	}
	
	public void delete(int id) {
		Transaction transaction = null;
		ContainerStatus status = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			
			status = session.get(ContainerStatus.class, id);
			// delete student object
			session.remove(status);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
}
