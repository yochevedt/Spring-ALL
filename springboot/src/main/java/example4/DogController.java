package example4;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.access.InvalidInvocationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {

	@GetMapping("/sayHi")
	public ResponseEntity<DogAction> sayHello() {
		ResponseEntity<DogAction> result = new ResponseEntity<DogAction>(new DogAction(ActionType.BARK,1, true), HttpStatus.OK);
		return result;
	}
	
	@GetMapping("/doMeow")
	public ResponseEntity<DogAction> doMeow() {
		throw new InvalidInvocationException("I am not a dog");
	}
	

}
