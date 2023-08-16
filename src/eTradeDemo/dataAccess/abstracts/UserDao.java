package eTradeDemo.dataAccess.abstracts;

import java.util.List;

import eTradeDemo.entities.concretes.User;

public interface UserDao {
	
	void register(User user);
	void update(User user);
	void delete (User user);
	User get(int id);
	List<User> getAll();
	String getUserByEmail(User user);
	String userPassword(User user);

}
