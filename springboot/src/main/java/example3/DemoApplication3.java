package example3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "example3" })
public class DemoApplication3 {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication3.class, args);
	}
	
	

}
