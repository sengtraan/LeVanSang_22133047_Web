package LapTrinhWeb_Cha.controllers;

import java.io.IOException;

import LapTrinhWeb_Cha.models.UserModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/waiting")
public class WaitingController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    HttpSession session= req.getSession();
	    if(session != null && session.getAttribute("account") != null) {
	        UserModel u=(UserModel) session.getAttribute("account");
	        req.setAttribute("username", u.getUsername());
	        session.setAttribute("account", u);
	        req.setAttribute("account", u);
	        if(u.getRoleid()==1) {
//	        resp.sendRedirect(req.getContextPath()+"/admin/home");
	        RequestDispatcher rd =req.getRequestDispatcher("/views/login_success.jsp");
	        rd.forward(req, resp);
	        }else if(u.getRoleid()==2) {
	        resp.sendRedirect(req.getContextPath()+"/manager/home");
	        }else {
	        resp.sendRedirect(req.getContextPath()+"/home");
	        }
	    }else {
	        resp.sendRedirect(req.getContextPath()+"/login");
	        }
	    }

}
