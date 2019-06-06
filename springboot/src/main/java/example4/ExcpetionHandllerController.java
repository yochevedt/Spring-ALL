package example4;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.access.InvalidInvocationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import example3.ActionType;
import example3.DogAction;

@ControllerAdvice
@RestController
public class ExcpetionHandllerController {

	@ExceptionHandler(InvalidInvocationException.class)
	//@ResponseStatus(HttpStatus.BAD_REQUEST)
	public final ResponseEntity<DogAction> handleUserNotFoundException(InvalidInvocationException ex, WebRequest req) {
		HttpHeaders responseHeaders = new HttpHeaders(); 	responseHeaders.set("DogAnswer", "I am not a cat!!!!"); 
		ResponseEntity<DogAction> result = new ResponseEntity<DogAction>(new DogAction(ActionType.BARK,3, false), responseHeaders, HttpStatus.BAD_REQUEST);
		return result;
	}

}
