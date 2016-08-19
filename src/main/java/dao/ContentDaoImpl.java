package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.Catalog;
import domain.Content;
import util.HibernateUtil;

public class ContentDaoImpl implements ContentDao {

	public Long create(Content content) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Long id = null;
		try{
			session.getTransaction().begin();
			id=(Long) session.save(content);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
	return id;
	}

	public Content read(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Content c=null;
		try{
			session.getTransaction().begin();
			c=(Content) session.get(Content.class, id);
			session.getTransaction().commit();
		}catch(HibernateException e){
			System.out.println("I cant read this order");
		}finally{
			session.close();
		}
		return c;
	}

	public void update(Content content) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.getTransaction().begin();
			session.update(content);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
			System.out.println("no sucsess");
		}finally{
			session.close();
		}
		
	}

	public void delete(Content content) {
		Session session = HibernateUtil.getSessionFactory().openSession();	
		try{
			session.getTransaction().begin();
			session.delete(content);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
			System.out.println("no sucsess");
		}finally{
			session.close();
		}
		
		
	}

	public List<Content> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = null;
		try{
			query=session.createSQLQuery("select * from contents").addEntity(Content.class);
			return query.list();
			}catch(HibernateException e){
				e.printStackTrace();
			}finally{
				session.close();
			}
		
		return query.list();
	}

	public List<Content> findBySmthString(String str) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = null;
		List<Content> list=null;
		try{
			query = session.createSQLQuery("select * from contents where contents.discription like (:a)").addEntity(Content.class);
			query.setParameter("a","%"+str+"%");	
			list=query.list();
			
			return list;
		}catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
		session.close();	
		}
	
	return list;
}

	public List<Content> findByTypeOfCatalog(String type) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query=null;
		try{
			query = session.createSQLQuery("select * from contents where contents.catalog_id =:a").addEntity(Content.class);
			query.setParameter("a", type);
			return query.list();
		}catch(HibernateException ex){
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return query.list();
	}

	public List<Content> findByUser_id(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = null;
		try{
			query = session.createSQLQuery("select * from contents where contents.user_id =:a").addEntity(Content.class);
			query.setParameter("a", id);
			return query.list();
		}catch(HibernateException ex){
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}

	public List<Content> findByCatalogAndWord(Long catalog_id, String searched) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = null;
		try{
			query = session.createSQLQuery("select * from contents where contents.catalog_id =:a and contents.discription like(:b)").addEntity(Content.class);
			query.setParameter("a", catalog_id);
			query.setParameter("b", "%"+searched+"%");
			return query.list();
		}catch(HibernateException ex){
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
}
	
