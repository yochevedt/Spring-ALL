package example2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "example2" })
public class DemoApplication2 {

	public static void main(String[] args) {
		System.out.println("Demo app is running");
		SpringApplication.run(DemoApplication2.class, args);
	}

}
