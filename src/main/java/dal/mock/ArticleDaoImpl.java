package dal.mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bo.Article;
import dal.ArticleDao;

public class ArticleDaoImpl implements ArticleDao {

	private List<Article> articles = new ArrayList<>();
	
	
	public ArticleDaoImpl() {
		articles.add( new Article(1, "Tuto Java POO",
				"Blbalbalabalb 1", "Adel", LocalDate.now(), true) );
		articles.add( new Article(2, "Tuto Java Se",
				"Blbalbalabalb 2", "Adel", LocalDate.now(), true) );
		articles.add( new Article(3, "Tuto Java EE",
				"Blbalbalabalb 3", "Adel", LocalDate.now(), true) );
		articles.add( new Article(4, "Tuto Symfony",
				"Blbalbalabalb 4", "Adel", LocalDate.now(), true) );
		articles.add( new Article(5, "Tuto Python",
				"Blbalbalabalb 5", "Adel", LocalDate.now(), true) );
		articles.add( new Article(6, "Tuto Spring",
				"Blbalbalabalb 6", "Adel", LocalDate.now(), true) );
		articles.add( new Article(6, "Tuto Spring",
				"Blbalbalabalb 7", "Adel", LocalDate.now(), true) );
		articles.add( new Article(6, "Tuto Spring",
				"Blbalbalabalb 8", "Adel", LocalDate.now(), true) );		
	}
	
	@Override
	public List<Article> selectAll() {
		return articles;
	}

	@Override
	public Article selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Article article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticle(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Article article) {
		// TODO Auto-generated method stub
		
	}

}
