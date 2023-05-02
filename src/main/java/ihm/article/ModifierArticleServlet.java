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
// wildcard
@WebServlet("/tutos/modifier/*")
public class ModifierArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get id
		String [] params = request.getPathInfo().split("/");
		int id = Integer.parseInt(params[1]);
		// get Article
		Article article = ArticleManager.getInstance().getArticle(id);
		if(article == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);	
			return;
		}
		request.setAttribute("article", article);
		request.getRequestDispatcher("/WEB-INF/jsp/article/edit.jsp")
			   .forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {			
			// get id
			String [] params = request.getPathInfo().split("/");
			int id = Integer.parseInt(params[1]);
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String author = request.getParameter("author");
			Article article = new Article(title, content, author);
			article.setId(id);
			ArticleManager.getInstance().updateArticle(article);
			response.sendRedirect(request.getContextPath()+"/tutos/detail/"+article.getId());
		}catch(BLLException e) {
			request.setAttribute("erreurs", e.getErreurs());
			doGet(request, response);
		}
	}

}
