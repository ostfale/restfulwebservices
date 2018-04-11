package udemy.in28minutes.restfulwebservices.domain;

/**
 * Simple bean which has been converted to JSon after a request
 * Created : 11.04.2018
 *
 * @author : usauerbrei
 */
public class HelloWorldBean {

	private String message;

	public HelloWorldBean(String message) {
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean{" +
				"message='" + message + '\'' +
				'}';
	}
}
