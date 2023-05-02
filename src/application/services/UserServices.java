package application.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import application.model.Roles;
import application.model.User;
import application.util.HIbernateUtil;

public class UserServices {

	public void Save(User user) {
		
		Transaction transaction = null;
		try(Session  session = HIbernateUtil.getSessionFactory().openSession()){
		
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			session.close();
		}catch(Exception e) {
			if(transaction==null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
	}
	public void Update(User user) {
		Transaction transaction = null;
		
		try(Session  session = HIbernateUtil.getSessionFactory().openSession()){
		
			transaction = session.beginTransaction();
			session.saveOrUpdate(user);
			transaction.commit();
			session.close();
		}catch(Exception e) {
			if(transaction==null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	public void Delete(long id) {
		User user = new User();
		Transaction transaction = null;
		try(Session  session = HIbernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			user = session.load(User.class, id);
			session.delete(user);
			transaction.commit();
		}catch(Exception e) {
			if(transaction==null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public User GetById(long id) {
		User student = new User();
		Transaction transaction = null;
		try(Session  session = HIbernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			student = session.load(User.class, id);
			transaction.commit();
		}catch(Exception e) {
			if(transaction==null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return student;
	}
	
	public List<User> GetAll(){
		List<User> listUsers = new ArrayList<User>();

		Transaction transaction = null;
		try(Session  session = HIbernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			listUsers = session.createQuery("from User").getResultList();
			transaction.commit();
		}catch(Exception e) {
			if(transaction==null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		return listUsers;
	}
//	public long GetCount() {
//
//		long cnt=0;
//		List<User> listUsers = new ArrayList<User>();
//
//		Transaction transaction = null;
//		try(Session  session = HIbernateUtil.getSessionFactory().openSession()){
//			
//			transaction = session.beginTransaction();
//			listUsers = session.createQuery("from User").getResultList();
//			transaction.commit();
//		}catch(Exception e) {
//			if(transaction==null) {
//				transaction.rollback();
//			}
//			e.printStackTrace();
//		}
//		listUsers.forEach(U->cnt+=1);
//		return cnt;
//	}
}
