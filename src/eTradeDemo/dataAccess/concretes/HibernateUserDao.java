package eTradeDemo.dataAccess.concretes;

import java.util.List;

import eTradeDemo.dataAccess.abstracts.UserDao;
import eTradeDemo.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public void register(User user) {
		System.out.println(user.getFirstName() + " your account registered");
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(int id) {
		
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserByEmail(User user) {
		
		return user.getEmail();
	}

	@Override
	public String userPassword(User user) {
	 var result= user.getPassword();
		return result;
	}

}
