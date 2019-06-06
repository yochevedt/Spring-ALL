package example2;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/echowithheaders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String echoWithHeaders(String message) {
		return message + " nice on";
	}
	@RequestMapping(value = "/echowithheaders", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public String echoWithHeaders2(Dog dog, @RequestHeader String dogAction) {
		return dog + " nice on post " + "with docAction:"+ dogAction ;
	}
}
