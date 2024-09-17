package LapTrinhWeb_Cha.controllers;

import java.io.IOException;

import LapTrinhWeb_Cha.dao.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/forgotPassword")
public class ForgotPasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String newPassword = req.getParameter("newPassword");
        String confirmnewPassword = req.getParameter("confirmnewPassword");
        String alertMsg = "";

        // Kiểm tra xem user có tồn tại không
        if (userService.existsByUsername(username)) {
            // Cập nhật mật khẩu mới cho user
            if (newPassword != null && newPassword.equals(confirmnewPassword)) {
            	userService.updatePassword(username, newPassword);
            	alertMsg = "Password updated successfully";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
                resp.sendRedirect(req.getContextPath() + "/login?message=Password updated successfully");
            }
            else if (newPassword == null) {
            	alertMsg = "Newpassword can not null bro!!!";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
            }
            else {
            	alertMsg = "Newpassword does not match confirmpassword";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
            }
        } else {
        	alertMsg = "Username does not exist";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
            return;
        }
    }
}