package application.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import application.model.UserRoles;
import application.util.HIbernateUtil;

public class UserRolesServices {



	public void Save(UserRoles roles) {
		
		Transaction transaction = null;
		try(Session  session = HIbernateUtil.getSessionFactory().openSession()){
		
			transaction = session.beginTransaction();
			session.save(roles);
			transaction.commit();
			session.close();
		}catch(Exception e) {
			if(transaction==null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
	}
	public void Update(UserRoles roles) {
		Transaction transaction = null;
		
		try(Session  session = HIbernateUtil.getSessionFactory().openSession()){
		
			transaction = session.beginTransaction();
			session.saveOrUpdate(roles);
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
		UserRoles role = new UserRoles();
		Transaction transaction = null;
		try(Session  session = HIbernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			role = session.load(UserRoles.class, id);
			session.delete(role);
			transaction.commit();
		}catch(Exception e) {
			if(transaction==null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public UserRoles GetById(long id) {
		UserRoles role = new UserRoles();
		Transaction transaction = null;
		try(Session  session = HIbernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			role = session.load(UserRoles.class, id);
			transaction.commit();
		}catch(Exception e) {
			if(transaction==null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return role;
	}
	
	public List<UserRoles> GetAll(){
		List<UserRoles> listRoles = new ArrayList<UserRoles>();

		Transaction transaction = null;
		try(Session  session = HIbernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			listRoles = session.createQuery("from User").getResultList();
			transaction.commit();
		}catch(Exception e) {
			if(transaction==null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		return listRoles;
	}
}
