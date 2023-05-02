package ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import at.favre.lib.crypto.bcrypt.BCrypt;
import config.ConnectionProvider;



@WebServlet("")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//String password = "Pa$$w0rd";
		//String passwordHashed = BCrypt.withDefaults().hashToString(12,password.toCharArray());
		//BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(),passwordHashed);
		//System.out.println(result.verified);
		//request.setAttribute("passwordHashed",passwordHashed);
		
		request.getRequestDispatcher("/WEB-INF/jsp/home.jsp")
		.forward(request, response);
		
	}
}
