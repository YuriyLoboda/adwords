package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import dao.ContentDao;
import dao.ContentDaoImpl;
import domain.Content;
import domain.User;
import service.ContentServ;
import service.ContentServImpl;


public class CabinetController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		ContentDao conDao = new ContentDaoImpl();
		ContentServ cServ = new ContentServImpl(conDao);
		Long id = user.getId();
		List<Content> list = cServ.findByUser(id);

		session.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/Cabinet.jsp");
		dispatcher.forward(req, resp);

	}

}
