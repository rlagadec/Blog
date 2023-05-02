package dal;

import java.util.List;

import bo.User;

public interface UserDao {

		public void insert(User user);

		public User selectByUsername(String username);

}
