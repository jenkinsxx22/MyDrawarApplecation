package application.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import application.model.Roles;
import application.util.HIbernateUtil;

public class RoleServices {



	public void Save(Roles roles) {
		
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
	public void Update(Roles roles) {
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
		Roles role = new Roles();
		Transaction transaction = null;
		try(Session  session = HIbernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			role = session.load(Roles.class, id);
			session.delete(role);
			transaction.commit();
		}catch(Exception e) {
			if(transaction==null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Roles GetById(long id) {
		Roles role = new Roles();
		Transaction transaction = null;
		try(Session  session = HIbernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			role = session.load(Roles.class, id);
			transaction.commit();
		}catch(Exception e) {
			if(transaction==null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return role;
	}
	
	public List<Roles> GetAll(){
		List<Roles> listRoles = new ArrayList<Roles>();

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
