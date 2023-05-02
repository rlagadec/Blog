package ihm.article;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import bll.ArticleManager;
import bo.Article;
/**
 * 
 * liste articles => /tutos
 * detail d'un article => /tutos/detail
 * ajouter un article => /tutos/ajouter
 * modifier un article => /tutos/modifier
 * supprimer un article => /tutos/supprimer
 *
 */
@WebServlet("/tutos")
public class ListeArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Article> articles = ArticleManager.getInstance().getAllArticles();
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("/WEB-INF/jsp/article/list.jsp")
		.forward(request, response);
	}

}
