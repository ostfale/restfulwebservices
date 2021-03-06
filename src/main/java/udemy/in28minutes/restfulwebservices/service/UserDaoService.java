package udemy.in28minutes.restfulwebservices.service;

import org.springframework.stereotype.Component;
import udemy.in28minutes.restfulwebservices.domain.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Provide some bootstrap functions
 * Created : 13.04.2018
 *
 * @author : usauerbrei
 */
@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;

	static {
		users.add(new User(1L, "Eva", new Date()));
		users.add(new User(2L, "Louis", new Date()));
		users.add(new User(3L, "Laura", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User saveUser(User user) {
		if (user.getId() == null) {
			user.setId((long) ++usersCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(Long id) {
		for (User user : users) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

	public User deleteById(Long id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
