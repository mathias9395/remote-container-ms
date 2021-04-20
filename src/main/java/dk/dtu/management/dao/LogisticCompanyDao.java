package dk.dtu.management.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mysql.cj.Query;

import dk.dtu.management.model.LogisticCompany;
import dk.dtu.management.util.HibernateUtil;

public class LogisticCompanyDao {
	public void save(LogisticCompany company) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			
			// save student object
			session.save(company);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public void update(LogisticCompany company) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			
			// update student object
			session.saveOrUpdate(company);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public LogisticCompany getById(int id) {
		Transaction transaction = null;
		LogisticCompany company = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			
			// get student object
			company = session.get(LogisticCompany.class, id);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return company;
	}
	
	@SuppressWarnings("unchecked")
	public List<LogisticCompany> getAll() {
//		Transaction transaction = null;
//		List<LogisticCompany> companies = null;
//		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
//			// start the transaction
//			transaction = session.beginTransaction();
//			
//			// get students
//			TypedQuery<LogisticCompany> tq = session.createQuery("SELECT c FROM Company c WHERE c.id IS NOT NULL", LogisticCompany.class);
//			 try {
//				 companies = tq.getResultList();
//				 
//			 }
//			 catch (NoResultException ex) {
//				 ex.printStackTrace();
//			 }
//			// commit the transaction
//			transaction.commit();
//		} catch (Exception e) {
//			if(transaction != null) {
//				transaction.rollback();
//			}
//		}
//		return companies;
		
		Transaction transaction = null;
		List<LogisticCompany> companies = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			
			companies = session.createQuery("from company").list();
			
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return companies;
	}
	
	public void delete(int id) {
		Transaction transaction = null;
		LogisticCompany company = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			
			company = session.get(LogisticCompany.class, id);
			// delete student object
			session.remove(company);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
}
