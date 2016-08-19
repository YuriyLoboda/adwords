package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.DispatcherServlet;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;
import service.UserServ;
import service.UserServImpl;

public class SignInController extends HttpServlet {
	
	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
		        {
					doPost(req,resp);
		        }
	
	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
		        {
						UserDao uDao = new UserDaoImpl();
						UserServ uServ= new UserServImpl(uDao);
						HttpSession session = req.getSession();
					
						String login = req.getParameter("login");
						String pass=req.getParameter("pass");
						User user=uServ.findByLoginAndPassword(login, pass);
						
						if(user!=null){		
							
							User userCheck = (User) session.getAttribute("user");
							if(userCheck == null){
								session.setAttribute("user", user);		
								RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/Search.jsp");
								dispatcher.forward(req, resp);
						}
						if(userCheck!=null){
							session.setAttribute("Error", "Sorry but  user is in the system");
							RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
							dispatcher.forward(req, resp);
						}
					}
						if(user==null){
							
							RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
							dispatcher.forward(req, resp);
					}
				
					
		        }
	
}
