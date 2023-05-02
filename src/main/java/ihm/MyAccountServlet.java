package ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import bo.User;

@WebServlet("/moncompte")
public class MyAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// GUARD
		if(user == null) {
			response.sendRedirect(request.getContextPath()+"/connexion");
			return;
		}
		response.getWriter().append("Bonjour " +user.getFirstname()+" "+user.getLastname());
	}

}
