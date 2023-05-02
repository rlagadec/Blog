package dal;

import java.time.LocalDate;
import java.util.List;

import bo.Article;

public interface ArticleDao {

	// crud
	public List<Article> selectAll();
	public Article selectOne(int id);
	public void insert(Article article);
	public void deleteArticle(int id);
	public void update(Article article);
}
