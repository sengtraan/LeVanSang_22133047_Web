package LapTrinhWeb_Cha.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DefaultController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Kiểm tra nếu người dùng đã ở trang home thì không chuyển hướng nữa
        String currentPath = request.getRequestURI();
        if (!currentPath.endsWith("/home")) {
            response.sendRedirect("home");
        } else {
            // Nếu đã ở trang home, tiến hành xử lý logic hoặc hiển thị trang home
            request.getRequestDispatcher("/views/home.jsp").forward(request, response);
        }
    }
}