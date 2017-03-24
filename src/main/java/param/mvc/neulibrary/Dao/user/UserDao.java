package param.mvc.neulibrary.Dao.user;

import java.util.List;

import param.mvc.neulibrary.model.user.User;

public interface UserDao {

	List<User> findAllUsers();

	void saveUser(User user);
	
	void updateUser(User user);

	User findById(String id);

	User findByUsername(String username);

	List<User> findUsersByUserName(String userName);

	List<User> listAllUsers(Integer offset, Integer maxResults);
	    
	Long countAllUsers();
}