package example2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/sayHi")
	public String sayHello() {
		return "Hello";
	}
	@GetMapping("/echo")
	public String sayHello(String message) {
		return message + " nice on";
	}

}
