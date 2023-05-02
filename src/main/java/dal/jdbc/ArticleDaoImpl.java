package dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bo.Article;
import config.ConnectionProvider;
import dal.ArticleDao;

public class ArticleDaoImpl implements ArticleDao {

	private final static String SELECT_ALL_ARTICLE = "SELECT * FROM articles";
	private final static String SELECT_ONE_ARTICLE = "SELECT * FROM articles WHERE id = ?";
	private final static String UPDATE_ARTICLE = "UPDATE articles SET title = ?, content = ?, author = ?  WHERE id = ?";
	private final static String INSERT_ARTICLE = "INSERT INTO articles (title,content,author,date_creation,is_published) VALUES (?,?,?,?,?)";
	private final static String DELETE_ARTICLE = "DELETE FROM articles WHERE id = ?";
	
	@Override
	public List<Article> selectAll() {
		
		try(Connection connection = ConnectionProvider.getConnection()){
			List<Article> articles = new ArrayList<>();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_ARTICLE);
			while(rs.next()) {
				articles.add( new Article(rs.getInt("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("author"),
						rs.getDate("date_creation").toLocalDate(),
						rs.getBoolean("is_published")) );
			}
			return articles;
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public Article selectOne(int id) {
		try(Connection connection = ConnectionProvider.getConnection()){
			
			PreparedStatement  stmt = connection.prepareStatement(SELECT_ONE_ARTICLE);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return new Article(rs.getInt("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("author"),
						rs.getDate("date_creation").toLocalDate(),
						rs.getBoolean("is_published"));
			}		
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public void insert(Article article) { // passage par ref
		
		try(Connection connection = ConnectionProvider.getConnection()){
			
			PreparedStatement  stmt = connection.prepareStatement(
											INSERT_ARTICLE,
											PreparedStatement.RETURN_GENERATED_KEYS
										);
			stmt.setString(1, article.getTitle());
			stmt.setString(2, article.getContent());
			stmt.setString(3, article.getAuthor());
			stmt.setDate(4,Date.valueOf(LocalDate.now()));
			stmt.setBoolean(5, true);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				article.setId(rs.getInt(1));// pour la redirection
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteArticle(int id) {
		try(Connection connection = ConnectionProvider.getConnection()){					
			PreparedStatement  stmt = connection.prepareStatement(DELETE_ARTICLE);
			stmt.setInt(1, id);
			stmt.executeUpdate();		
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void update(Article article) {
		try(Connection connection = ConnectionProvider.getConnection()){
			PreparedStatement stmt = connection.prepareStatement(UPDATE_ARTICLE);
			stmt.setString(1,article.getTitle());
			stmt.setString(2,article.getContent());
			stmt.setString(3,article.getAuthor());
			stmt.setInt(4,article.getId());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();// levee DAL Exception
		}
		
	}

}
