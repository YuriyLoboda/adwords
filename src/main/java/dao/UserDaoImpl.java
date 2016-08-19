package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.Content;
import domain.User;
import util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	public Long create(User user) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Long id = null;
		try{
			session.getTransaction().begin();
			id=(Long) session.save(user);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
			
		}finally{
			session.close();
		}
	return id;
	}

	public User read(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		User u=null;
		try{
			session.getTransaction().begin();
			u=(User) session.get(User.class, id);
			session.getTransaction().commit();
		}catch(HibernateException e){
			System.out.println("I cant read this order");
		}finally{
			session.close();
		}
		return u;
	}

	public void update(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.getTransaction().begin();
			session.update(user);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
			System.out.println("no sucsess");
		}finally{
			session.close();
		}
	}

	public void delete(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();	
		try{
			session.getTransaction().begin();
			session.delete(user);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
			System.out.println("no sucsess");
		}finally{
			session.close();
		}
		
		
	}

	public List<User> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = null;
		try{
			query=session.createSQLQuery("select * from users").addEntity(User.class);
			return query.list();
			}catch(HibernateException e){
				e.printStackTrace();
			}finally{
				session.close();
			}
		
		return query.list();
	}

	public User findByLoginAndPassword(String login, String pass) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query=null;
		try{
			query = session.createSQLQuery("select * from users where users.login = :a and users.pass=:b").addEntity(User.class);
			query.setParameter("a", login);
			query.setParameter("b", pass);
			User user= (User) query.list().get(0);
			if(user!=null){
				return user;
			}
			}catch(HibernateException ex){
				ex.printStackTrace();
			}catch(IndexOutOfBoundsException ex){
				System.out.println("такого пользователь нет");
			}
			finally{
				session.close();
			}
		return null;
		}
	
	}
	


