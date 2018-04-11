package udemy.in28minutes.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple Controller
 *
 * // GET
 * // URI - /hello-world
 * // method - "Hello World"
 * Created : 11.04.2018
 *
 * @author : usauerbrei
 */
@RestController
public class HelloWorldController {

	// alternative: @RequestMapping(method="RequestMethod.GET, path="/hello-world")
	@GetMapping({"/hello-world"})
	public String helloWorld() {
		return "Hello cruel world....!";
	}
}
