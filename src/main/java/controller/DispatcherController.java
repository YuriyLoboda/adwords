package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import dao.ContentDao;
import dao.ContentDaoImpl;
import domain.Content;
import service.ContentServ;
import service.ContentServImpl;

public class DispatcherController extends HttpServlet {
	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
		        {
		
		        }
	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
		    {
		 
		 String type= req.getParameter("type");
		 ContentDao cDao = new ContentDaoImpl();
		 ContentServ cServ= new ContentServImpl(cDao);
		 HttpSession session = req.getSession();
		 session.setAttribute("catalog", type);
		 
		 if (type.equals("1")){
			
			 List<Content> listA= cServ.findByType(type);
			 req.setAttribute("list", listA);
			 RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/AutoHendler.jsp");
			 dispatcher.forward(req, resp);
			 	
		 }
		 if (type.equals("2")){
			 List<Content> listW= cServ.findByType(type);
			 req.setAttribute("list", listW);
			 RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/WorkHendler.jsp");
			 dispatcher.forward(req, resp);
			 	
		 }
		 if (type.equals("3")){
			 List<Content> listR= cServ.findByType(type);
			 req.setAttribute("list", listR);
			 RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/RealtyHendler.jsp");
			 dispatcher.forward(req, resp);
			 	
		 }
		 
		    }
}
