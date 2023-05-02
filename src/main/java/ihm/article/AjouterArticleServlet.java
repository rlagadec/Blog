package ihm.article;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import bll.ArticleManager;
import bll.Exception.BLLException;
import bo.Article;
import helpers.Flash;

@WebServlet("/tutos/ajouter")
public class AjouterArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/article/add.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String author = request.getParameter("author");
			Article article = new Article(title, content, author);
			ArticleManager.getInstance().addArticle(article);
			if(article.getId()>0) {		
				Flash.send("success","L'article a bien été ajouté", request.getSession());
				response.sendRedirect(request.getContextPath()+"/tutos/detail/"+article.getId());
			}
		} catch (BLLException e) {
			request.setAttribute("erreurs", e.getErreurs());
			doGet(request, response);
		}
	}

}
