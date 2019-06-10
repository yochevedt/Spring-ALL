package example7;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class DemoApplication7 {

	public static void main(String[] args) {
		String localHost = "http://localhost:8081";
		String uri = localHost + "/sayHi";
		RestTemplate restTemplate = new RestTemplate();

		String result = restTemplate.getForObject(uri, String.class);
		System.out.println(uri + " : " + result);

		uri = localHost + "/echo?message={message}";
		Map<String, String> params = new HashMap<String, String>();
		params.put("message", "some good echo");

		result = restTemplate.getForObject(uri, String.class, params);
		System.out.println(uri + " : " + result);

		uri = localHost + "/dog/sayHi";
		DogAction dogResult = restTemplate.getForObject(uri, DogAction.class);
		System.out.println(uri + " : " + dogResult);

		try {
			Dog friend = new Dog("Bill");
			uri = localHost + "/dog/meetFriend";
			RequestEntity<Dog> request = RequestEntity.post(new URI(uri)).accept(MediaType.APPLICATION_JSON)
					.body(friend);
			ResponseEntity<DogAction> response = restTemplate.exchange(request, DogAction.class);

			System.out.println(uri + " : " + response);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
