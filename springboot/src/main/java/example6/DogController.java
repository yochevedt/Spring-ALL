package example6;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dog")
public class DogController {

	@GetMapping("/sayHi")
	public ResponseEntity<DogAction> sayHello() {
		ResponseEntity<DogAction> result = new ResponseEntity<DogAction>(new DogAction(ActionType.BARK,1, true), HttpStatus.OK);
		return result;
	}
	
	@GetMapping("/doMeow")
	public ResponseEntity<DogAction> doMeow() {
		HttpHeaders responseHeaders = new HttpHeaders(); 	responseHeaders.set("DogAnswer", "I am not a cat!!!!"); 
		ResponseEntity<DogAction> result = new ResponseEntity<DogAction>(new DogAction(ActionType.BARK,3, false), responseHeaders, HttpStatus.BAD_REQUEST);
		return result;
	}
	
	@PostMapping("/meetFriend")
	public ResponseEntity<DogAction> meetFriend(Dog friend) {
		
		ResponseEntity<DogAction> result = new ResponseEntity<DogAction>(new DogAction(ActionType.MOVE_TAIL,10, true), HttpStatus.OK);
		return result;
	}
	

}
