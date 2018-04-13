package udemy.in28minutes.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import udemy.in28minutes.restfulwebservices.domain.User;
import udemy.in28minutes.restfulwebservices.service.UserDaoService;

import java.util.List;

/**
 * User controller
 * Created : 13.04.2018
 *
 * @author : usauerbrei
 */
@RestController
public class UserController {

	private final UserDaoService userDaoService;

	public UserController(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userDaoService.findAll();
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable Long id) {
		return userDaoService.findOne(id);
	}
}
