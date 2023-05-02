package ihm.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

import bll.SecurityService;
import bll.Exception.BLLException;
import bo.User;
import dal.DaoFactory;

@WebServlet("/connexion")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/security/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nomUti = request.getParameter("username");
			String password = request.getParameter("password");
			User user =  SecurityService.getInstance().login(nomUti,password);
			//creation de la session
			HttpSession session = request.getSession();
			session.setAttribute("user",user);
			response.sendRedirect(request.getContextPath()+"/moncompte");
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

}
