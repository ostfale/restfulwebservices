package udemy.in28minutes.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import udemy.in28minutes.restfulwebservices.domain.HelloWorldBean;

/**
 * Simple Controller
 * <p>
 * Annotation @RestController contains @ResponseBody which automatically converts the response bean into JSON using the integrated Jackson lib
 * <p>
 *
 * @author : usauerbrei
 * Created : 11.04.2018
 */
@RestController
public class HelloWorldController {

	// alternative: @RequestMapping(method="RequestMethod.GET, path="/hello-world")
	@GetMapping({"/hello-world"})
	public String helloWorld() {
		return "Hello cruel world....!";
	}

	// hello-world-bean
	@GetMapping({"/hello-world-bean"})
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello Huxleys World...");
	}
}
