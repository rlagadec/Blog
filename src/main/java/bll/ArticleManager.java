package bll;

import java.util.List;

import bll.Exception.BLLException;
import bo.Article;
import dal.DaoFactory;


public class ArticleManager { // Singleton
	
	/** start Singleton */	
		// étape 1
		private static ArticleManager instance;
		// étape 2
		private ArticleManager() {}
		// étape 3
		public static ArticleManager getInstance() {		
			if( instance == null) {
				instance = new ArticleManager();
			}
			return instance;
		}
	/** end Singleton */
	
	/**  get all articles  **/
	public List<Article> getAllArticles(){
		return DaoFactory.getArticleDao().selectAll();
	}
	
	/** recup un article **/
	public Article getArticle(int id) {
		return DaoFactory.getArticleDao().selectOne(id);
	}	
	
	public void addArticle(Article article) throws BLLException {
		checkArticle(article);
		DaoFactory.getArticleDao().insert(article);
	}
	
	public void checkArticle(Article article) throws BLLException {
		BLLException bll = new BLLException();
		checkFiled(article.getTitle(), "Titre",bll);
		checkFiled(article.getContent(), "Contenu",bll);
		checkFiled(article.getAuthor(), "Auteur",bll);
		if(bll.getErreurs().size()>0) {			
			throw bll;
		}
	}
	
	private void checkFiled(String field,String name,BLLException bll ) {
		if(field.isBlank()) {
			bll.ajouterErreur("Le champs %s ne peut pas etre vide!".formatted(name));
		}
	}
	public void deleteArticle(int id) {
		DaoFactory.getArticleDao().deleteArticle(id);
		
	}
	public void updateArticle(Article article) throws BLLException {
		checkArticle(article);
		DaoFactory.getArticleDao().update(article);
	}
	
}
