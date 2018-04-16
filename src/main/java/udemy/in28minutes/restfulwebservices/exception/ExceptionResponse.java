package udemy.in28minutes.restfulwebservices.exception;


import java.util.Date;

/**
 * General exception handling
 * Created : 16.04.2018
 *
 * @author : usauerbrei
 */

public class ExceptionResponse {

	private Date timestamp;
	private String message;
	private String details;

	public ExceptionResponse(Date timestamp, String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}
