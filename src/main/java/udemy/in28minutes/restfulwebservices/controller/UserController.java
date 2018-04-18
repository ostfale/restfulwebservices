package udemy.in28minutes.restfulwebservices.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import udemy.in28minutes.restfulwebservices.domain.User;
import udemy.in28minutes.restfulwebservices.exception.UserNotFoundException;
import udemy.in28minutes.restfulwebservices.service.UserDaoService;

import javax.validation.Valid;
import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
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
		User user = userDaoService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}
		return user;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		User user = userDaoService.deleteById(id);
		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}
	}


	/**
	 * Create a new user with status CREATED and return user and the URI. Status 201 created for ResponseEntity and the path will be extended
	 * by the id of the new object.
	 */
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.saveUser(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
