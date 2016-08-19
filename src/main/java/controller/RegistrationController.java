package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;
import service.UserServ;
import service.UserServImpl;

public class RegistrationController extends HttpServlet{
	
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
		    {
		  doPost(req,resp);
		  
		    }
	  
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
		    {
		  	UserDao uDao = new UserDaoImpl();
			UserServ uServ= new UserServImpl(uDao);
			HttpSession session = req.getSession();
		  
		    String name = req.getParameter("nameR");
			String loginR= req.getParameter("loginR");
			String passR = req.getParameter("passR");
			String passRConfirm= req.getParameter("passRConfirm");
			System.out.println("nane= "+name);
			if(passR.length()<3){
				session.setAttribute("Error1","count of pass may be bigger 2 symbols" );
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/ErrorPage.jsp");
				dispatcher.forward(req, resp);
				
				return;
			}
			if(!passR.equals(passRConfirm)){
				session.setAttribute("Error1", " input passwords must be equel");
				RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/ErrorPage.jsp");
				dispatcher.forward(req, resp);
				return;
			}
			User user=new User();
			user.setName(name);
			user.setLogin(loginR);
			user.setPassword(passR);
			uServ.addNewUser(user);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/Success.jsp");
			dispatcher.forward(req, resp);
		}
			 
			 
 }
		    
	
	

