package ihm.article;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import bll.ArticleManager;

@WebServlet("/tutos/supprimer/*")
public class SupprimerArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String params = request.getPathInfo();		
		int id = Integer.parseInt(params.substring(1));
		ArticleManager.getInstance().deleteArticle(id);
		response.sendRedirect(request.getContextPath()+"/tutos");
	}


}
