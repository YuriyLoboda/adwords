package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.json.JSONObject;

import dao.ContentDao;
import dao.ContentDaoImpl;
import service.ContentServ;
import service.ContentServImpl;
import domain.Content;
import domain.User;

public class SearchController extends HttpServlet {
	
	ContentDao conDao = new ContentDaoImpl();
	ContentServ cServ = new ContentServImpl(conDao);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	{
		HttpSession session = req.getSession();
		
		String searched = req.getParameter("searched");
		List<Content> list = cServ.findByString(searched);
		JSONObject myJsonObj = new JSONObject();
		
		
		
		myJsonObj.append("result", "ok");
		for(int i=0;i<list.size();i++){
		myJsonObj.append("list","<div >"+"<input type=\"radio\" name=\"searched\" value="+list.get(i).getId()+" id="+i+">"+ list.get(i)+"</div>");
		}
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(myJsonObj.toString());	
		
	}
	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
		        {
		System.out.println("ajax doGet");
		super.doGet(req, resp);
		 
		        }
	

}
