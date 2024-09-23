package LapTrinhWeb_Cha.controllers;

import java.io.IOException;

import LapTrinhWeb_Cha.utils.Constant;
import LapTrinhWeb_Cha.dao.impl.UserDaoImpl;
import LapTrinhWeb_Cha.dao.impl.UserServiceImpl;
import LapTrinhWeb_Cha.models.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
		}

//		String username = null;
//		Cookie[] cookies = req.getCookies();
//		if (cookies != null) {
//			for (Cookie cookie : cookies) {
//				if (cookie.getName().equals(Constant.COOKIE_REMEMBER)) {
//					username = cookie.getValue();
//					session = req.getSession(true);
//	                session.setAttribute("username", cookie.getValue());
//					break;
//				}
//			}
//		}
//
//		req.setAttribute("username", username); // Set username attribute
		req.getRequestDispatcher("views/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
//		boolean isRememberMe = false;
//		String remember = req.getParameter("remember");
		Boolean isRememberMe = "on".equals(req.getParameter("remember"));

//		if ("on".equals(remember)) {
//			isRememberMe = true;
//		}
		String alertMsg = "";

		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}

		UserServiceImpl service = new UserServiceImpl();
		UserDaoImpl userDAO = new UserDaoImpl();
		UserModel user = service.login(username, password);

		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			session.setAttribute("userId", user.getId());

			if (isRememberMe) {
				saveRemeberMe(resp, username);
				req.setAttribute("remember", isRememberMe);
			} else {
				deleteRememberMe(resp);
			}

			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}
	}

	private void saveRemeberMe(HttpServletResponse response, String username) {
//		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
		Cookie cookie = new Cookie("username", username);
		cookie.setMaxAge(30);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	private void deleteRememberMe(HttpServletResponse response) {
		Cookie cookie = new Cookie("username", "");
		cookie.setMaxAge(0); // Xóa cookie ngay lập tức
		cookie.setPath("/");
		response.addCookie(cookie);
	}
}
