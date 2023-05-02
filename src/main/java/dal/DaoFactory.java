package dal;

import dal.jdbc.ArticleDaoImpl;
import dal.jdbc.UserDaoImpl;

public class DaoFactory {


	public static UserDao getUserDao() {
		return new UserDaoImpl();
	}

	public static ArticleDao getArticleDao() {
		return  new ArticleDaoImpl();
	}
	
}
