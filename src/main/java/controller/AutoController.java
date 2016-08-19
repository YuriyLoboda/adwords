package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import dao.CatalogDao;
import dao.CatalogDaoImpl;
import dao.ContentDao;
import dao.ContentDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import domain.Content;
import domain.User;
import service.CatalogServ;
import service.CatalogServImpl;
import service.ContentServ;
import service.ContentServImpl;
import service.UserServ;
import service.UserServImpl;

public class AutoController extends HttpServlet {
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException{
		 doPost(req,resp);
	 }
	 
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException{
		 HttpSession session = req.getSession();
		 
	
		 
		 String btnType=req.getParameter("btnType");
		 
		 System.out.println(btnType);
		 JSONObject myJson = new JSONObject();
		 
		 
		 ContentDao conDao = new ContentDaoImpl();
		 ContentServ cServ = new ContentServImpl(conDao);
		 UserDao userDao = new UserDaoImpl();
		 UserServ uServ = new UserServImpl(userDao);
		 CatalogDao catDao = new CatalogDaoImpl();
		 CatalogServ catServ = new CatalogServImpl(catDao);
		 
		 if(btnType.equals("add")){
		 int price =Integer.parseInt(req.getParameter("price")); 
		 String date = req.getParameter("date");
		 String discription =req.getParameter("discription");
		 Long selectType =Long.parseLong(req.getParameter("selectType"));
		 User user = (User) session.getAttribute("user");
		 Long id = user.getId();
		
		Content newElement =new Content();
		newElement.setPrice(price);
		newElement.setDate(date);
		newElement.setText(discription);
		newElement.setUser(id);
		newElement.setCatalog(selectType);
		cServ.addNewContent(newElement);
		myJson.append("object", newElement);
		myJson.append("id",newElement.getId());
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(myJson.toString());
		
		}
		 
		if(btnType.equals("delete")){
		Long id=Long.parseLong(req.getParameter("checked"));
		//System.out.println("id - "+id);
		Content checkedContent = cServ.findContent(id);
		cServ.deleteContent(checkedContent);
		} 
		
		if(btnType.equals("edit")){
			Long id=Long.parseLong(req.getParameter("checked"));
			Content content=cServ.findContent(id);
			Integer price=content.getPrice();
			String date=content.getDate();
			String discription=content.getText();
			System.err.println("price= "+price+" date= "+date+" discription= "+discription);
			myJson.append("price", price.toString());
			myJson.append("date", date);
			myJson.append("discription",discription );
			
			
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(myJson.toString());
			
			
		}
		if(btnType.equals("commit")){
			System.out.println("I'm in commit");
			Long id=Long.parseLong(req.getParameter("checked"));
			Content content=cServ.findContent(id);
			int price1 =Integer.parseInt(req.getParameter("price")); 
			 String date1 = req.getParameter("date");
			 String discription1 =req.getParameter("discription");
			 Long selectType =Long.parseLong(req.getParameter("selectType"));
			 
			 content.setPrice(price1);
			 content.setDate(date1);
			 content.setText(discription1);
			 content.setCatalog(selectType);
			 cServ.updateContent(content);
			 
		}
		if(btnType.equals("review")){
			Long id =Long.parseLong(req.getParameter("checked"));
			Content con =cServ.findContent(id);
			Long user_id=con.getUser();
			String userName = uServ.findUser(user_id).getName();
			Long catalog_id = con.getCatalog();
			String catalogName = catServ.findCatalog(catalog_id).getName();
			
			
			
			
			myJson.append("userName", userName);
			myJson.append("catalogName", catalogName);
			myJson.append("date", con.getDate());
			myJson.append("price", con.getPrice());
			myJson.append("text", con.getText());
			
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(myJson.toString());
			
		}
		
	 }

}
