package ihm.article;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import bll.ArticleManager;
import bo.Article;
// /tutos/detail?id=1
@WebServlet("/tutos/detail/*")
public class DetailArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int id = Integer.parseInt(request.getParameter("id"));
		String params = request.getPathInfo();		
		int id = Integer.parseInt(params.substring(1));
		Article article = ArticleManager.getInstance().getArticle(id);
		request.setAttribute("article", article);
		request.getRequestDispatcher("/WEB-INF/jsp/article/detail.jsp")
		.forward(request, response);
	}

}
