package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


import domain.Catalog;
import util.HibernateUtil;

public class CatalogDaoImpl implements CatalogDao {

	public Long create(Catalog catalog) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Long id = null;
		try{
			session.getTransaction().begin();
			id=(Long) session.save(catalog);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
	return id;
	}
	

	public Catalog read(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Catalog c=null;
		try{
			session.getTransaction().begin();
			c=(Catalog) session.get(Catalog.class, id);
			session.getTransaction().commit();
		}catch(HibernateException e){
			System.out.println("I cant read this order");
		}finally{
			session.close();
		}
		return c;
	}

	

	public void update(Catalog catalog) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.getTransaction().begin();
			session.update(catalog);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
			System.out.println("no sucsess");
		}finally{
			session.close();
		}
		
		
	}

	public void delete(Catalog catalog) {
		Session session = HibernateUtil.getSessionFactory().openSession();	
		try{
			session.getTransaction().begin();
			session.delete(catalog);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
			System.out.println("no sucsess");
		}finally{
			session.close();
		}
		
		
		
	}

	public List<Catalog> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = null;
		try{
			query=session.createSQLQuery("select * from catalogs").addEntity(Catalog.class);
			return query.list();
			}catch(HibernateException e){
				e.printStackTrace();
			}finally{
				session.close();
			}
		
		return query.list();

	}
	}


