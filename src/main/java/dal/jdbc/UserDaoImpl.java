package dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bo.User;
import config.ConnectionProvider;
import dal.UserDao;

public class UserDaoImpl implements UserDao {

	private static final String INSERT_USER = "INSERT INTO users(username,email,password,firstname,lastname,dateCreated) VALUES(?,?,?,?,?,?);";
	private static final String SELECT_BY_USERNAME = "SELECT * FROM users WHERE username=?;";

	@Override
	public void insert(User user) {
		try(Connection connection = ConnectionProvider.getConnection()){
			PreparedStatement pStmt = connection.prepareStatement(INSERT_USER);
			pStmt.setString(1,user.getUsername());
			pStmt.setString(2,user.getEmail());
			pStmt.setString(3,user.getPassword());
			pStmt.setString(4,user.getFirstname());
			pStmt.setString(5,user.getLastname());
			pStmt.setDate(6, Date.valueOf(user.getDateCreated()));
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public User selectByUsername(String nomUti) {
		try(Connection connection = ConnectionProvider.getConnection()){
			PreparedStatement pStmt = connection.prepareStatement(SELECT_BY_USERNAME);
			pStmt.setString(1,nomUti);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				return new User(rs.getInt("id"),
								rs.getString("username"),	
								rs.getString("email"),
								rs.getString("password"),
								rs.getString("firstname"),
								rs.getString("lastname"),
								rs.getDate("dateCreated").toLocalDate()
						);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
